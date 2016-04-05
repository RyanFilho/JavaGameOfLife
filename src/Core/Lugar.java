package Core;

public class Lugar extends Posicao{
	private Celula celula;

	public Lugar(int x, int y, Celula celula) {
		super(x, y);
		this.celula = celula;
	}
	
    public boolean temUmaCelulaViva()
    {
        if (celula instanceof Celula)
            return true;
        return false;
    }    
    public Lugar ViveOuMorre(int vizinhos)
    {
        return new Lugar(this.getX(),this.getY(),celula.vive(vizinhos));
    }
	
	public Celula getCelula() {
		return celula;
	}
	
	public void setCelula(Celula celula){
		this.celula = celula;
	}
}
