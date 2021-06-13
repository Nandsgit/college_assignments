import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
//phase 2
public class Foothill {
	static int NUM_CARDS_PER_HAND = 7;
	static int NUM_PLAYERS = 2;
	static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
	static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];
	static JLabel[] playedCardLabels = new JLabel[NUM_PLAYERS];
	static JLabel[] playLabelText = new JLabel[NUM_PLAYERS];

	public static void main(String[] args) {
		int k;
		ImageIcon tempIcon;
		GUICard.loadCardIcons();
		// establish main frame in which program will run
		CardTable myCardTable = new CardTable("CS 1B CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
		myCardTable.setName("CS 1B CardTable");
		myCardTable.setSize(800, 600);
		myCardTable.setLocationRelativeTo(null);
		myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 //show everything to the user
		 myCardTable.setVisible(true);

		// CREATE LABELS ----------------------------------------------------
		for (k = 0; k < NUM_CARDS_PER_HAND; k++) {
			
			tempIcon = GUICard.getIcon(generateRandomCard());
			humanLabels[k] = new JLabel(tempIcon);
			computerLabels[k] = new JLabel(GUICard.getBackCardIcon());
			myCardTable.panelComputerHand.add(computerLabels[k]);
			myCardTable.panelPlayerHand.add(humanLabels[k]);
			
		}
		// create player labels
		for (k = 0; k < NUM_PLAYERS; k++) {
			tempIcon = GUICard.getIcon(generateRandomCard());
			GUICard.loadCardIcons();
			// set played card labels
			playedCardLabels[k] = new JLabel(tempIcon);

			if (k > 0) {
				playLabelText[k] = new JLabel("Your cards:", JLabel.CENTER);
			} else {
				playLabelText[k] = new JLabel("The cards of player " + (k + 1), JLabel.CENTER);
			}
		}

		// ADD LABELS TO PANELS -----------------------------------------
		for (k = 0; k < NUM_PLAYERS; k++) {

			// adds computer's labels
			myCardTable.panelComputerHand.add(computerLabels[k]);

			// adds player's labels
			myCardTable.panelPlayerHand.add(humanLabels[k]);
		}

		// and two random cards in the play region (simulating a computer/hum ply)
		for (k = 0; k < (NUM_PLAYERS * 2); k++) {
			if (k < NUM_PLAYERS) {
				myCardTable.panelTable.add(playedCardLabels[k]);
			} else {
				myCardTable.panelTable.add(playLabelText[k - NUM_PLAYERS]);
			}
		}
		// show everything to the user
		myCardTable.setVisible(true);
	}

	// generate random card
	public static Card generateRandomCard() {
		Card gen = new Card();
		int value;
		int suit;
		value = (int) (Math.random() * 1000 % GUICard.MAX_VALUE);
		suit = (int) (Math.random() * 1000 % GUICard.MAX_SUITS);

		// set random gen values
		gen.set(GUICard.turnIntIntoCardValueChar(value), GUICard.turnIntIntoSuit(suit));
		System.out.println("Gen" + gen); 
		return gen;
		
	}
}