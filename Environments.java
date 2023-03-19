package br.com.vener.blackjack;

import java.awt.Dimension;

/**
 * Classe de variaveis globais
 * @author Vener Fruet da Silveira
 * @version 2023-03-19
 */

public class Environments {
	public static final Dimension MAIN_FRAME_DIMENSION = new Dimension(800, 500);
	public static final Dimension PANEL_CARDS_DIMENSION = new Dimension(800, 440);
	public static final Dimension PANEL_COMMANDS_DIMENSION = new Dimension(800, 60);
	
	public static final String MAIN_FRAME_TITLE = "Blackjack Game";
	public static final String MAIN_FRAME_ICO = "resources/icon.png";
	public static final String IMAGE_SPRITE_SRC = "resources/spriteCards.png";
	public static final String IMAGE_TABLE_SRC = "resources/backgroud.png";
	public static final String IMAGE_BUTTON_PLUS = "resources/plus.png";
	public static final String IMAGE_BUTTON_STEP = "resources/step.png";
	public static final String IMAGE_BUTTON_REPLAY = "resources/replay.png";

	public static final int CARD_WIDTH = 84;// = 92;
	public static final int CARD_HEIGHT = 118;// = 134;
	public static final int MAX_CARDS = 11;
	public static final int MAX_TOTAL = 21;

	public static final int[][] CARDS_POSITION_DEALER = { { 38, 30 }, { 89, 30 }, { 140, 30 }, { 191, 30 }, { 242, 30 },
			{ 293, 30 }, { 344, 30 }, { 395, 30 }, { 446, 30 }, { 497, 30 }, { 548, 30 } };
	public static final int[][] CARDS_POSITION_PLAYER = { { 38, 272 }, { 89, 272 }, { 140, 272 }, { 191, 272 },
			{ 242, 272 }, { 293, 272 }, { 344, 272 }, { 395, 272 }, { 446, 272 }, { 497, 272 }, { 548, 272 } };

}
