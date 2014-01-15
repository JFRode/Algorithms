package controle;

public abstract class Pessoa extends Mamifero{
	public String nome;
	public String cpf;
	public int idade;
	
	public void andar(){
		System.out.println("Andando");
	}
}
