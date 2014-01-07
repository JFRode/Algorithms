import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {
	
	/*	
	 * Crie um programa simples que grave os atributos de um copo. Depois, crie uma Mesa com dois copos. 
	 * Após criá-los, prepare uma função que encha o copo (apenas exiba que o copo foi enchido) e chame-a na Mesa.
	 */
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		Mesa mesa = new Mesa();
	}

}
