package fr.pch;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

public class AsteriskPrinter {
	private final AsteriskPrinterParams params;

	public AsteriskPrinter(AsteriskPrinterParams params) {
		this.params = params;
		this.print();
	}
	
	
	private void print() {
		
		int sizeX = this.params.getSize();
		int sizeY = this.params.getSize();
		if (this.params.getText().length() != 1) {
			sizeX = this.params.getSize() * this.params.getText().length();
		}

		Font font = new Font("Consolas", Font.PLAIN, 100);
		FontMetrics metrics = new JLabel(this.params.getText()).getFontMetrics(font);
		
		int width = metrics.stringWidth(this.params.getText());
		Rectangle2D rectangle = font.createGlyphVector(metrics.getFontRenderContext(), this.params.getText()).getVisualBounds();
		int height = (int) Math.round(rectangle.getHeight());
		
		double scaleX = sizeX / (double) width;
		double scaleY = sizeY / (double) height;
		
		
		
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D graphics = bi.createGraphics();
		graphics.setFont(font);
		
		AffineTransform tx = new AffineTransform();
		tx.scale(scaleX, scaleY);
		graphics.transform(tx);
		
		graphics.drawString(this.params.getText(), 0, height);
		graphics.dispose();
		
		
		//printer
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < sizeY; j++) {
			for (int i = 0; i < sizeX; i++) {
				sb.append(bi.getRGB(i, j) != 0 ? "*" : " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
