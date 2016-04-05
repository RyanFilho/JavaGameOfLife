package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

import Core.CelulaMorta;
import Core.Lugar;
import Core.Mundo;
import Core.Posicao;

public class Principal{		
	public static final int tamanhoMundo = 20;
	public static final int velocidade = 200;
	public static MainWindow window ;
	public static Mundo mundo;
	public static JPanel principal;
	public static boolean pause;
	public static void main(String[] args) throws IOException, InterruptedException {
		pause = true;
		window = new MainWindow();	
		principal = new JPanel(new GridLayout(tamanhoMundo,tamanhoMundo));
		
		window.frame.setContentPane(principal);
		
		principal.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent args){
				
				celulaClicked(args.getComponent().getMousePosition(), mundo);
			}			
		});
		window.frame.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e) {
		        if(e.getKeyChar() == 'p' || e.getKeyChar() == 'P')
		        	pause = !pause;
		    }
		});
		
		mundo = inicializarMapa();		
//		preencherMapa(mundo);		
        inicializarJanela(window, principal, mundo);             
        jogar(principal, mundo);        
        
	}
	
	private static void celulaClicked(Point point, Mundo mundo) {
		int x = point.x/(principal.getWidth()/tamanhoMundo);
		int y = point.y/(principal.getHeight()/tamanhoMundo);
		mundo.InverterCelula(new Posicao(y,x));
		
	}
	
	private static void preencherMapa(Mundo mundo) {
		mundo.InserirCelulaViva(new Posicao(3,1));
		mundo.InserirCelulaViva(new Posicao(3,2));
		mundo.InserirCelulaViva(new Posicao(3,3));
		mundo.InserirCelulaViva(new Posicao(2,3));
		mundo.InserirCelulaViva(new Posicao(1,2));
				
		mundo.InserirCelulaViva(new Posicao(5,16));
		mundo.InserirCelulaViva(new Posicao(5,17));
		mundo.InserirCelulaViva(new Posicao(5,18));
		
		mundo.InserirCelulaViva(new Posicao(10,16));
		mundo.InserirCelulaViva(new Posicao(10,17));
		mundo.InserirCelulaViva(new Posicao(10,18));
		
		mundo.InserirCelulaViva(new Posicao(12,1));
		mundo.InserirCelulaViva(new Posicao(12,2));
		mundo.InserirCelulaViva(new Posicao(13,1));
		mundo.InserirCelulaViva(new Posicao(13,2));
		mundo.InserirCelulaViva(new Posicao(14,3));
		mundo.InserirCelulaViva(new Posicao(14,4));
		mundo.InserirCelulaViva(new Posicao(15,3));
		mundo.InserirCelulaViva(new Posicao(15,4));
	}

	private static Mundo inicializarMapa() {
		ArrayList<Lugar> mapa = new ArrayList<Lugar>();		
		for(int i = 0; i < tamanhoMundo; i++)
			for(int j = 0; j < tamanhoMundo; j++)
				mapa.add(new Lugar(i, j, new CelulaMorta()));		
		Mundo mundo = new Mundo(mapa);
		return mundo;
	}

	private static void jogar(JPanel principal, Mundo mundo) {
		
		Timer timer = new Timer(velocidade, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {   
            	if(!pause)
            		mundo.Turn();             
                Component[] components = principal.getComponents();
                ArrayList<Lugar> map = mundo.getMapa();
                for(int i = 0; i < components.length; i++){
                	components[i].setBackground(map.get(i).getCelula().getCor());
                }                 
            }
        });
        timer.start();
	}
	
	private static void inicializarJanela(MainWindow window, JPanel principal, Mundo mundo) {
		
		for(int i = 0; i < mundo.getMapa().size(); i++){
        	JPanel panel = new JPanel();        	
        	panel.setBackground(mundo.getMapa().get(i).getCelula().getCor());
        	panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        	principal.add(panel); 
        }
        window.frame.setVisible(true);
	}
}
