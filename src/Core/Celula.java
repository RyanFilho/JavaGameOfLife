package Core;

import java.awt.Color;

public abstract class Celula{
	protected Color cor;
	public abstract Celula vive(int vizinhos);
	public Color getCor(){
		return cor;
	}
}
