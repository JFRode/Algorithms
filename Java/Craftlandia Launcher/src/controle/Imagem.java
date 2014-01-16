package controle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Imagem extends JPanel {
	private String caminho;
	private int largura;
	private boolean teste = true;
	BufferedImage imagem = null;
	
	public Imagem(String caminho) {
		this.caminho = caminho;
		try {
			imagem = ImageIO.read(new File(caminho));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		if (teste) {
			largura = (largura - imagem.getWidth()) / 2;
			teste = false;
		}
		g.drawImage(imagem, largura, 0, null);
	}
	 
	public int getAltura() {
		return imagem.getHeight();
	}

	public int getLargura() {
		return imagem.getWidth();
	}
	
	public void setLargura(int largura) {
		this.largura = largura;
	}
}