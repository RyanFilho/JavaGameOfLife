package Core;

public class CelulaViva extends Celula {

	@Override
	public Celula vive(int vizinhos) {
        if (vizinhos == 2 || vizinhos == 3)
            return new CelulaViva();            
        return new CelulaMorta();
	}

}
