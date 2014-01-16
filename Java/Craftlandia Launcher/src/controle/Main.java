package controle;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/* Desenvolvido por João Felipe Gonçalves & Fernando Concatto
 * Launcher para o servidor brasileiro de minecraft, Craftlandia
 * Substituindo launcher antigo em batch.
 */

public class Main {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Janela();
			}
		});
	}

}
