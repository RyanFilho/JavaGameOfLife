package Core;

import java.awt.Color;

public class CelulaMorta extends Celula {

	public CelulaMorta() {
		super();		
		this.cor = Color.BLACK;
	}
	
	@Override
	public Celula vive(int vizinhos) {
        if (vizinhos == 3)
            return new CelulaViva();
        return new CelulaMorta();
	}
}
