package Core;

import java.util.ArrayList;

public class Posicao {
	private int x;
	private int y;
	public Posicao(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
    public ArrayList<Posicao> Vizinhos()
    {
        ArrayList<Posicao> vizinhos = new ArrayList<Posicao>();

        vizinhos.add(new Posicao(x - 1, y - 1));
        vizinhos.add(new Posicao(x, y - 1));
        vizinhos.add(new Posicao(x + 1, y - 1));
        vizinhos.add(new Posicao(x - 1, y));
        vizinhos.add(new Posicao(x + 1, y));
        vizinhos.add(new Posicao(x - 1, y + 1));
        vizinhos.add(new Posicao(x, y + 1));
        vizinhos.add(new Posicao(x + 1, y + 1));

        return vizinhos;
    }
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}	
}
