package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	public static void main(String[] args) throws IOException, InterruptedException {
		
		MainWindow window = new MainWindow();	
		JPanel principal = new JPanel(new GridLayout(tamanhoMundo,tamanhoMundo));
		
		window.frame.setContentPane(principal);	
		
		Mundo mundo = inicializarMapa();		
		preencherMapa(mundo);		
        inicializarJanela(window, principal, mundo);              
        jogar(principal, mundo);
        
        
	}

	private static void preencherMapa(Mundo mundo) {
		mundo.InserirCelulaViva(new Posicao(3,1));
		mundo.InserirCelulaViva(new Posicao(3,2));
		mundo.InserirCelulaViva(new Posicao(3,3));
		mundo.InserirCelulaViva(new Posicao(2,3));
		mundo.InserirCelulaViva(new Posicao(1,2));
		
		mundo.InserirCelulaViva(new Posicao(15,1));
		mundo.InserirCelulaViva(new Posicao(15,2));
		mundo.InserirCelulaViva(new Posicao(15,3));
		mundo.InserirCelulaViva(new Posicao(17,2));
		mundo.InserirCelulaViva(new Posicao(16,3));
		
		mundo.InserirCelulaViva(new Posicao(5,16));
		mundo.InserirCelulaViva(new Posicao(5,17));
		mundo.InserirCelulaViva(new Posicao(5,18));
		
		mundo.InserirCelulaViva(new Posicao(10,16));
		mundo.InserirCelulaViva(new Posicao(10,17));
		mundo.InserirCelulaViva(new Posicao(10,18));
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
