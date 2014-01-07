
public class Copo {
	private double peso;
	private double altura;
	private double largura;
	private double capacidade;
	private boolean cheio;
	
	public Copo() {
	
	}
	
	public Copo(double pesoInicial, double alturaInicial, double larguraInicial, double capacidadeInicial) {
		this.peso = pesoInicial;
		this.altura = alturaInicial;
		this.largura = larguraInicial;
		this.capacidade = capacidadeInicial;
	}
	
	
	
	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}

	public double getLargura() {
		return largura;
	}

	public double getCapacidade() {
		return capacidade;
	}
	
	public boolean isCheio() {
		return cheio;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}

	public void setCapacidade(double capacidade) {
		this.capacidade = capacidade;
	}
	
	public void setCheio(boolean cheio) {
		this.cheio = cheio;
	}
	
}
