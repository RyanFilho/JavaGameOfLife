package Core;

public class CelulaMorta extends Celula {

	@Override
	public Celula vive(int vizinhos) {
        if (vizinhos == 3)
            return new CelulaViva();
        return new CelulaMorta();
	}

}
