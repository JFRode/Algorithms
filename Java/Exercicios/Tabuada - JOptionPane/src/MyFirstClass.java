import javax.swing.JOptionPane;


public class MyFirstClass {

	public static void main(String[] args) {
		String opcaoTabuada = JOptionPane.showInputDialog("Tabuada que deseja acessar:");
		int indiceTabuada;
		int[] res;
		
		res = new int[10];
		
		indiceTabu = Integer.parseInt(opcaoTabuada);
		
		for(int i = 0;i < res.length; i++){
			res[i] = (i + 1) * indiceTabuada;
		}
		//Exibi��o dos resultados muito longa. Descobrir forma reduzida
		JOptionPane.showMessageDialog(null,
			opcaoTabuada + "x1=" + res[0]+ "\n"
			+ opcaoTabuada + "x2=" + res[1] + "\n"
			+ opcaoTabuada + "x3=" + res[2] + "\n"
			+ opcaoTabuada + "x4=" + res[3] + "\n"
			+ opcaoTabuada + "x5=" + res[4] + "\n"
			+ opcaoTabuada + "x6=" + res[5] + "\n"
			+ opcaoTabuada + "x7=" + res[6] + "\n"
			+ opcaoTabuada + "x8=" + res[7] + "\n"
			+ opcaoTabuada + "x9=" + res[8] + "\n"
			+ opcaoTabuada + "x10=" + res[9],
			"Tabuada", JOptionPane.ERROR_MESSAGE
		);
	}
}
