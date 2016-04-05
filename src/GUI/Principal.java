package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	public static void main(String[] args) throws IOException, InterruptedException {
		
		MainWindow window = new MainWindow();	
		JPanel principal = new JPanel();
		window.frame.setContentPane(principal);

		GridLayout layout = new GridLayout(10,10);		
		principal.setLayout(layout);
		
		ArrayList<Lugar> mapa = new ArrayList<Lugar>();		
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				mapa.add(new Lugar(i, j, new CelulaMorta()));
		
		Mundo mundo = new Mundo(mapa);
		mundo.InserirCelulaViva(new Posicao(3,1));
		mundo.InserirCelulaViva(new Posicao(3,2));
		mundo.InserirCelulaViva(new Posicao(3,3));
		
		
        for(int i = 0; i < mundo.getMapa().size(); i++){
        	JPanel panel = new JPanel();        	
        	panel.setBackground(mundo.getMapa().get(i).getCelula().getCor());
        	panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
//        	panel.add
        	principal.add(panel); 
        }
        window.frame.setVisible(true);
              
        Timer timer = new Timer(500, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//            	principal.getGraphics().clearRect(0, 0, 600, 600);
            	
                mundo.Turn();            
                Component[] components = principal.getComponents();
                ArrayList<Lugar> map = mundo.getMapa();
                for(int i = 0; i < components.length; i++){
                	components[i].setBackground(map.get(i).getCelula().getCor());
                	System.out.println(i+". "+components[i].toString());
                } 
//                System.out.println("Mudei!");
                
            }
        });
        timer.start();
	}
	
	class Input implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
}
