package controle;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela {
	private JFrame frame = new JFrame("Craftlandia Launcher");
	private JPanel painelBaixo = new Gradiente();
	private Imagem painelMeio = new Imagem("data/banner.jpg");
	private JPanel painelTopo = new JPanel();
	private JButton botaoJogar = new JButton("Jogar");
	private JButton botaoFechar = new JButton("Fechar");
	private JButton botaoServidores = new JButton("Servidores");
	private JButton botaoForum = new JButton("Fórum");
	private JButton botaoSite = new JButton("Site");
	private JCheckBox checkHG = new JCheckBox("Hunger Games");
	
	public Janela() {
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));//Organiza verticalmente
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//painelBaixo.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 5));
		painelBaixo.setBackground(Color.BLACK);
		//botaoJogar.setBackground(Color.BLACK);
		//botaoFechar.setBackground(Color.BLACK);
		checkHG.setOpaque(false);
		checkHG.setForeground(Color.WHITE);
		
		frame.add(painelTopo);
		frame.add(painelMeio);
		frame.add(painelBaixo);
		
		painelTopo.add(botaoSite);
		painelTopo.add(botaoServidores);
		painelTopo.add(botaoForum);
		
		painelMeio.setBorder(BorderFactory.createEmptyBorder(1, 1, painelMeio.getAltura()-5, painelMeio.getLargura()));
		
		painelBaixo.setLayout(new GridBagLayout());
		
		GridBagConstraints lay = new GridBagConstraints();
		lay.anchor = GridBagConstraints.WEST;
		lay.weightx = 1;
		lay.fill = GridBagConstraints.HORIZONTAL;
		lay.insets = new Insets(2, 0, 4, 4);
		
		
		painelBaixo.add(checkHG, lay);
		lay.anchor = GridBagConstraints.EAST;
		painelBaixo.add(botaoJogar, lay);
		painelBaixo.add(botaoFechar, lay);
		
//<Funções dos botões>
		botaoJogar.addActionListener(new ActionListener() {		//Inicia o jogo
			@Override
			public void actionPerformed(ActionEvent e) {
				String servidor = null;
				servidor = (checkHG.isSelected()) ? "data\\dataHG" : "data";
				
				String home = System.getProperty("java.class.path");
				home = home.substring(0, (home.lastIndexOf(File.separator) + 1));
				home = home.concat("bin" + File.separator + "craftlandia.jar");

				String caminho = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
				ProcessBuilder pb = new ProcessBuilder(caminho, "-jar", home);
				pb.environment().put("APPDATA", servidor);

				try {
					@SuppressWarnings("unused")
					Process p = pb.start();
				} catch (IOException f) {
					f.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		botaoFechar.addActionListener(new ActionListener() {	//Fecha o programa
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		botaoServidores.addActionListener(new ActionListener() {//Abre aba de Servidores
			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop linkServidores = java.awt.Desktop.getDesktop();
				try {
					linkServidores.browse(new java.net.URI("http://hgextremo.craftlandia.com.br/site/"));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		botaoForum.addActionListener(new ActionListener() {		//Abre aba Forum
			@Override
			public void actionPerformed(ActionEvent e) {
				Desktop linkForum = java.awt.Desktop.getDesktop();
				try {
					linkForum.browse(new java.net.URI("http://forum.craftlandia.com.br/ipb/"));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		botaoSite.addActionListener(new ActionListener() {		//Abre aba Site
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Desktop linkSite = java.awt.Desktop.getDesktop();
				try {
					linkSite.browse(new java.net.URI("http://craftlandia.com.br/"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//</Funções dos botões>
		
		frame.setVisible(true);
		frame.pack();
		frame.setPreferredSize(new Dimension(frame.getWidth() - 10, frame.getHeight() - 10));
		frame.setResizable(false);
		frame.pack();
		painelMeio.setLargura(frame.getContentPane().getWidth());
		frame.requestFocusInWindow();
		frame.setLocationRelativeTo(null);
	}
	
}
