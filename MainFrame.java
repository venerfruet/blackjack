package br.com.vener.blackjack;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

/**
 * Tela principal
 * 
 * @author Vener Fruet da Silveira
 * @version 2023-03-19
 */

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor da tela principal.
	 */
	public MainFrame() {
		// instancia o baralho
		Cheap cheap = new Cheap();

		// definição da tela
		Image ico = Toolkit.getDefaultToolkit().getImage(getClass().getResource(Environments.MAIN_FRAME_ICO));
		setIconImage(ico);
		setSize(Environments.MAIN_FRAME_DIMENSION);
		setTitle(Environments.MAIN_FRAME_TITLE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);

		// imagem da mesa do jogo
		ImagePanel imagePanel = new ImagePanel(Environments.IMAGE_TABLE_SRC, null, Environments.MAIN_FRAME_DIMENSION,
				null, true);
		imagePanel.setLayout(new BorderLayout());

		// container de cartas
		JPanel panelCards = new JPanel();
		panelCards.setPreferredSize(new Dimension(800, 440));
		panelCards.setOpaque(false);

		// container dos comandos
		JPanel panelCommands = new JPanel();
		panelCommands.setPreferredSize(new Dimension(800, 60));
		panelCommands.setOpaque(false);

		// botão mais carta
		Image icoPlus = Toolkit.getDefaultToolkit().getImage(getClass().getResource(Environments.IMAGE_BUTTON_PLUS));
		JButton buttonPlusCard = new JButton();
		buttonPlusCard.setIcon(new ImageIcon(icoPlus));
		//buttonPlusCard.setToolTipText("mais uma carta");
		buttonPlusCard.setEnabled(false);
		buttonPlusCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cheap.playerCard(panelCards);

				if (cheap.getCountPlayerCards() == Environments.MAX_CARDS)
					((JButton) e.getSource()).setEnabled(false);

			}
		});

		// botão passar
		Image icoStep = Toolkit.getDefaultToolkit().getImage(getClass().getResource(Environments.IMAGE_BUTTON_STEP));
		JButton buttonStep = new JButton();
		buttonStep.setIcon(new ImageIcon(icoStep));
		//buttonStep.setToolTipText("passar a vez");
		buttonStep.setEnabled(false);
		buttonStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		// botão jogar de novo
		Image icoReplay = Toolkit.getDefaultToolkit().getImage(getClass().getResource(Environments.IMAGE_BUTTON_REPLAY));
		JButton buttonReplay = new JButton();
		buttonReplay.setIcon(new ImageIcon(icoReplay));
		//buttonReplay.setToolTipText("nova partida");
		buttonReplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cheap.newGame(panelCards);
				buttonPlusCard.setEnabled(true);
				buttonStep.setEnabled(true);
			}
		});

		// adiciona os componentes a tela principal
		setContentPane(imagePanel);
		getContentPane().add(panelCards, BorderLayout.NORTH);
		getContentPane().add(panelCommands, BorderLayout.SOUTH);
		panelCommands.add(buttonPlusCard);
		panelCommands.add(buttonStep);
		panelCommands.add(buttonReplay);

	}

}
