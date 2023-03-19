package br.com.vener.blackjack;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Classe painel com imagem de fundo
 * @author Vener Fruet da Silveira
 * @version 2023-03-12
 */

public class ImagePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private String urlImage;

	public ImagePanel(String urlImg, LayoutManager layout, Dimension dimension, Rectangle rectangle, boolean visible) {

		this.urlImage = urlImg;

		setOpaque(false);
		setPreferredSize(dimension);
		setLayout(layout);
		setVisible(visible);

		if (rectangle != null)
			setBounds(rectangle);

	}

	@Override
	public void paintComponent(Graphics g) {
		try {

			InputStream inputStream = getClass().getResourceAsStream(urlImage);
			BufferedImage bufferedImage = ImageIO.read(inputStream);
			Image imageRedim = bufferedImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);

			g.drawImage(imageRedim, 0, 0, this);

		} catch (Exception e) {

			System.out.println("Imagem não encontrada!");

		}
	}
}
