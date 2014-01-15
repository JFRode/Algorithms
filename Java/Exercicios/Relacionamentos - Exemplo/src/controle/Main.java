package controle;

public class Main {

	public static void main(String[] args) {
		Funcionario f = new Funcionario();
		f.cpf = "144141";
		f.idade = 19;
		f.nome = "Jorozinho trinta";
		f.matricula = 13131;
		f.peso = "50kg";
		
		f.andar();
		f.trabalha();
		
		
		Cliente c = new Cliente();
		c.cpf = "11111111";
		c.idade = 40;
		c.nome = "Jonas";
		c.numeroCliente = 258;
		
		
	}

}
