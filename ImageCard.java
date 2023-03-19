package br.com.vener.blackjack;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Classe imagem da carta
 * @author Vener Fruet da Silveira
 * @version 2023-03-15
 */

public class ImageCard extends JPanel {

	private static final long serialVersionUID = 1L;
	private int cardValue;
	private int cardSuit;

	public ImageCard(int inSpritPosX, int inSpritPosY, int cardValue, int cardSuit) {

		this.cardValue = cardValue;
		this.cardSuit = cardSuit;

		definePanel(inSpritPosX, inSpritPosY);

	}

	private void definePanel(int posX, int posY) {

		setOpaque(false);
		setPreferredSize(new Dimension(Environments.CARD_WIDTH, Environments.CARD_HEIGHT));

		setBounds(posX, posY, Environments.CARD_WIDTH, Environments.CARD_HEIGHT);

	}

	private int[] calculateCoords(int cardValue, int cardSuit) {
		return new int[]{ Environments.CARD_WIDTH * cardValue, Environments.CARD_HEIGHT * cardSuit };
	}

	@Override
	public void paintComponent(Graphics g) {

		int[] coords = calculateCoords(cardValue, cardSuit);
		
		try {

			InputStream inputStream = getClass().getResourceAsStream(Environments.IMAGE_SPRITE_SRC);
			BufferedImage bufferedImage = ImageIO.read(inputStream);

			g.drawImage(bufferedImage, coords[0]*-1, coords[1]*-1, this);

		} catch (Exception e) {

			System.out.println("Imagem não encontrada!");

		}
	}
}
