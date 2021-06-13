
//cembodies the JPanel and Layout 
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

class CardTable extends JFrame {

	// static members
	static int MAX_CARDS_PER_HAND = 57;
	static int MAX_PLAYERS = 2;
	static int DEFAULT_CARDS_PER_HAND;
	static int DEFAULT_PLAYERS = 2;

	// private members
	private int numCardsPerHand;
	private int numPlayers;
	
	//JPanels
	public JPanel panelPlayerHand;
	public JPanel panelComputerHand;
	public JPanel panelTable;

	// constructor overloader
	public CardTable(String title, int numCardsPerHand, int numPlayers) {
		super(title);

		// set numCardsPerHand
		if (numCardsPerHand > MAX_CARDS_PER_HAND || numCardsPerHand < 0) {
			this.numCardsPerHand = DEFAULT_CARDS_PER_HAND;
		} else {
			this.numCardsPerHand = numCardsPerHand;
		}

		// set numPlayers
		if (numPlayers > MAX_PLAYERS || numPlayers <= 0) {
			this.numPlayers = DEFAULT_PLAYERS;
		} else {
			this.numPlayers = numPlayers;
		}
		
		// border layout
		setLayout(new BorderLayout(10, 10));

		// Player Hand Panel
		panelPlayerHand = new JPanel(new GridLayout(1, 21, 50, 11));
		add(panelPlayerHand, BorderLayout.SOUTH);
		panelPlayerHand.setBorder(new TitledBorder("Player's Hand"));

		// Computer Hand Panel
		panelComputerHand = new JPanel(new GridLayout(1, 1, 10, 10));
		add(panelComputerHand, BorderLayout.NORTH);
		panelComputerHand.setBorder(new TitledBorder("Computer's Hand"));

		// Table Panel
		panelTable = new JPanel(new GridLayout(2, 2, 20, 20));
		add(panelTable, BorderLayout.CENTER);
		panelTable.setBorder(new TitledBorder("Card Table"));

	}

	// accessors

	// numPlayers accessor
	public int getNumPlayers() {
		return numPlayers;
	}

	// numCardsPerHand accessor
	public int getNumCardsPerHand() {
		return numCardsPerHand;
	}

}
