package Core;

import java.util.ArrayList;
import java.util.List;

public class Mundo {
	private ArrayList<Lugar> mapa;
	private ArrayList<Lugar> novoMapa;
	
	public Mundo(ArrayList<Lugar> mapa) {
		super();
		this.mapa = mapa;
	}

	public void Turn() {
		novoMapa = new ArrayList<Lugar>();
		for(Lugar item : mapa)
		{
			int liveNeighbors = ContarVizinhosVivos(item);
			novoMapa.add(item.ViveOuMorre(liveNeighbors));
		}
		mapa = novoMapa;
	}

	private int ContarVizinhosVivos(Lugar place) {
		List<Posicao> vizinhos = place.Vizinhos();
		int count = 0;

		for(Lugar item : mapa)
		{
			for(Posicao posicao : vizinhos){
				if(item.getX() == posicao.getX() && item.getY() == posicao.getY() && item.getCelula() instanceof CelulaViva)
					count++;				
			}
		}

		return count;
	}
	
	public void InserirCelulaViva(Posicao posicao) {
		for(Lugar lugar : mapa)
		{
			if(lugar.getX() == posicao.getX() && lugar.getY() == posicao.getY())
				lugar.setCelula(new CelulaViva());
		}
	}
	
	public void InverterCelula(Posicao posicao) {
		for(Lugar lugar : mapa)
		{
			if(lugar.getX() == posicao.getX() && lugar.getY() == posicao.getY()){
				if(lugar.getCelula() instanceof CelulaViva){
					lugar.setCelula(new CelulaMorta());
				}else{
					lugar.setCelula(new CelulaViva());
				}
			}			
		}
	}

	public ArrayList<Lugar> getMapa() {
		return mapa;
	}
}
