import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		String tabu = JOptionPane.showInputDialog("Tabuada que deseja acessar:");
		int iTabu;
		int[] res;
		
		res = new int[10];
		
		iTabu = Integer.parseInt(tabu);
		
		for(int i=1;i <= 10;i++){
			res[i-1] = i * iTabu;
		}
		//Exibição dos resultados muito longa. Descobrir forma reduzida
		JOptionPane.showMessageDialog(null, tabu + "x1=" + + res[0] + "\n" + tabu + "x2=" + res[1] + "\n" + tabu + "x3=" + res[2] + "\n" + tabu + "x4=" + res[3] + "\n" + tabu + "x5=" + res[4] + "\n" + tabu + "x6=" + res[5] + "\n" + tabu + "x7=" + res[6] + "\n" + tabu + "x8=" + res[7] + "\n" + tabu + "x9=" + res[8] + "\n" + tabu + "x10=" + res[9], "Tabuada", JOptionPane.ERROR_MESSAGE);
	}
}