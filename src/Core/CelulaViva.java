package Core;

import java.awt.Color;

public class CelulaViva extends Celula {

	public CelulaViva() {
		super();
		this.cor = Color.WHITE;		
	}
	@Override
	public Celula vive(int vizinhos) {
        if (vizinhos == 2 || vizinhos == 3)
            return new CelulaViva();            
        return new CelulaMorta();
	}	
}
