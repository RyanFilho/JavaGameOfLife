package Game;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Principal extends JFrame{
	
	public static void main(String[] args) {
		new Principal();
	}
	
	
	public Principal(){
		this.setSize(new Dimension(300,400));
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout());
		this.setVisible(true);
	}
	
	
	
	
	
	
	
	/*public static void main(String[] args) throws IOException, InterruptedException {
		ArrayList<Lugar> mapa = new ArrayList<Lugar>();
		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				mapa.add(new Lugar(i, j, new CelulaMorta()));
		
		Mundo mundo = new Mundo(mapa);
		
		mundo.InserirCelulaViva(new Posicao(2, 3));
		mundo.InserirCelulaViva(new Posicao(3, 3));
		mundo.InserirCelulaViva(new Posicao(4, 3));
		
        while(true)
        {                
        	boolean[] mapaVetor = getMapVetor(mundo.getMapa());
            int count = 0;
            for (int j = 0; j < 10; j++)
            {
                for (int k = 0; k < 10; k++)
                {
                    if (mapaVetor[count])
                        System.out.print('X');
                    else
                    	System.out.print(' ');
                    count++;
                }
                System.out.print("\n");
            }
            Thread.sleep(500);            
            mundo.Turn();
        }      
	}
	
	public static boolean[] getMapVetor(ArrayList<Lugar> mapa) {
		boolean[] vetor = new boolean[mapa.size()];
		int count = 0;

		for(Lugar l : mapa)
		{
			 if(l.getCelula() instanceof CelulaViva){
				 vetor[count] = true;
			 }else {
				 vetor[count] = false;
			 }
			count++;
		}
		return vetor;
	}*/

}
