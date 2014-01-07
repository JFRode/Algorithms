import javax.swing.JOptionPane;

public class Mesa {
	private float altura;
	private float largura;
	private float peso;
	private int quantidadePernas;
	private Copo copoUm;
	private Copo copoDois;
	
	public Mesa() {
		copoUm = new Copo(0.50, 0.30, 0.2, 0.2);
		copoDois = new Copo(1.2, 0.30, 0.10, 1.0);
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual copo deseja alterar"));
		
		if (opcao == 1) {
			testa(copoUm, opcao);
		} else if (opcao == 2) {
			testa(copoDois, opcao);
		} else {
			JOptionPane.showMessageDialog(null, "O copo não existe");
		}
	}
	
	
	private void testa(Copo copo, int id) {
		int opcao = JOptionPane.showConfirmDialog(null, "Voce deseja encher o copo " + id + "?");
		
		switch (opcao) {
		case JOptionPane.YES_OPTION:
			copo.setCheio(true);
			break;
		case JOptionPane.NO_OPTION:
			copo.setCheio(false);
			break;
		case JOptionPane.CANCEL_OPTION:
			System.out.println("Programa cancelado");
			break;
		}
		
		String status;
		if (copo.isCheio()){
			status = " esta cheio";
		} else {
			status = " não esta cheio";
		}
		
		JOptionPane.showMessageDialog(null, "O copo " + id + status, "Status copo", JOptionPane.INFORMATION_MESSAGE);

	}
	
}
