package br.com.vener.blackjack;

import java.awt.Component;
import java.awt.Container;
import java.util.Random;

/**
 * Classe Baralho
 * @author Vener Fruet da Silveira
 * @version 2023-03-19
 */
public class Cheap {

	private static int countPlayerCards; // total de cartas do jogador

	private boolean[] usedCards; // a posição dá por [valor]+[naipe] da carta
	private int countDealerCards; // total de cartas do distribuidor
	private int totalDealer; // total de pontos do distribuidor
	private int totalPalyer; // total de pontos do jogador
	private Random rnd; // randomizador

	/**
	 * newGame - Inicia um novo jogo.
	 * 
	 * @param container - Onde a representação gráfica das cartas será exibida.
	 */
	protected void newGame(Container container) {

		usedCards = new boolean[52];
		countPlayerCards = 0;
		countDealerCards = 0;
		totalDealer = 0;
		totalPalyer = 0;
		rnd = new Random();

		container.removeAll();
		container.removeAll();

		dialerCards(container);

	}

	/**
	 * dialerCards - Distribui as cartas para o distrinuidor.
	 * 
	 * @param container - Onde a representação gráfica das cartas será exibida.
	 */
	protected void dialerCards(Container container) {

		// sorteia uma carta
		int[] retDrawCard = drawCard();

		do {// continua sorteando em menor que o máximo total

			paintNewCard(retDrawCard[0], retDrawCard[1], container,
					Environments.CARDS_POSITION_DEALER[countDealerCards]);//
			setUsedCards(retDrawCard[0] + retDrawCard[1]);

			totalDealer += realValueCard(retDrawCard[0]);
			countDealerCards++;

			retDrawCard = drawCard();

			System.out.println("->" + totalDealer);
		} while (totalDealer + retDrawCard[0] <= Environments.MAX_TOTAL);

	}

	/**
	 * playerCard - Distribui as cartas para o jogador.
	 * 
	 * @param container - Onde a representação gráfica das cartas será exibida.
	 */
	protected void playerCard(Container container) {

		int[] retDrawCard = drawCard();

		paintNewCard(retDrawCard[0], retDrawCard[1], container, Environments.CARDS_POSITION_PLAYER[countPlayerCards]);
		setUsedCards(retDrawCard[0] + retDrawCard[1]);

		countPlayerCards++;
		totalPalyer += realValueCard(retDrawCard[0]);

		String message = "Deu empate";

		if (totalPalyer > Environments.MAX_TOTAL) {
			message = "Você pedeu!";
		} else if (totalPalyer < totalDealer) {
			message = "Você pedeu!";
		} else if (totalPalyer > totalDealer) {
			message = "Você ganhou!";
		}

		System.out.println(message + "->" + totalPalyer);
	}

	/**
	 * drawCard - Retira uma carta de qualquer lugar do baralho.
	 * 
	 * @return - Retorna o index e o naipe da carta.
	 */
	protected int[] drawCard() {
		int value = rnd.nextInt(13);
		int suit = rnd.nextInt(4);

		while (checkUsedCards(value + suit)) {
			value = rnd.nextInt(13);
			suit = rnd.nextInt(4);
		}

		return new int[] { value, suit };
	}

	/**
	 * paintNewCard - Representação visual da carta
	 * 
	 * @param value         - valor da carta
	 * @param suit          - naipe da carta
	 * @param container     - container da carta
	 * @param position_cads - posições das cartas
	 */
	protected void paintNewCard(int value, int suit, Container container, int[] position) {

		ImageCard imageCard = new ImageCard(position[0], position[1], value, suit);

		invertOrderComponents(container);
		container.add(imageCard);

		invertOrderComponents(container);
		container.repaint();

	}

	/**
	 * invertOrderComponents - Inverte a ordem de exibição compontes de um
	 * container, usado em sobreposições
	 * 
	 * @param container - Container
	 */
	protected void invertOrderComponents(Container container) {

		Component[] components = container.getComponents();

		for (int i = 0; i < components.length; i++) {
			container.setComponentZOrder(components[i], components.length - i - 1); // o primeiro fica com a posição do
																					// último
		}

	}

	/**
	 * realValueCard - Calcula o valor real da carta no jogo menor valor é 1 e o
	 * maior é 10, a figuras valem 10.
	 * 
	 * @param cardValue - Informa o indice daq carta na matriz.
	 * @return - Inteiro valor real da carta.
	 */
	protected static int realValueCard(int cardValue) {
		return (cardValue < 10 ? ++cardValue : 10);
	}

	/**
	 * checkUsedCards - Checa se a carta já foi usada.
	 * 
	 * @param position - Informa a posição da carta a ser checada na matriz de
	 *                 cartas usadas.
	 * @return - Verdadeiro se já foi usada.
	 */
	protected boolean checkUsedCards(int position) {
		return usedCards[position];
	}

	/**
	 * setUsedCards - Marca a carta como usada.
	 * 
	 * @param position - Informa a posição na matriz de cartas usadas.
	 */
	protected void setUsedCards(int position) {
		usedCards[position] = true;
	}

	/**
	 * getCountPlayerCards - Contagem de carta do jogador
	 * 
	 * @return - Número de cartas usadas pelo jogador
	 */
	public int getCountPlayerCards() {
		return countPlayerCards;
	}

}
