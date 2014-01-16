package controle;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Gradiente extends JPanel { 
	public Gradiente() {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		int w = getWidth();
		int h = getHeight();
		Color cor1 = Color.DARK_GRAY;
		Color cor2 = Color.BLACK;
		GradientPaint gp = new GradientPaint(new Point(0, 0), cor1, new Point(0, 80), cor2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, w, h);
	}
}