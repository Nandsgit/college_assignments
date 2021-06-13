import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GUICard {

	public static final int MAX_SUITS = 4;
	public static final int MAX_VALUE = 14;

	// private members
	private static ImageIcon[][] iconCards = new ImageIcon[MAX_VALUE][MAX_SUITS];
	private static Icon iconBack;
	private static boolean iconsLoaded = false;

	private static String cardlValsConvertAssist = "23456789TJQKAX";
	private static String suitValsConvertAssist = "CDHS";
	private static Card.Suit suitConvertAssist[] = { Card.Suit.clubs, Card.Suit.diamonds, Card.Suit.hearts,
			Card.Suit.spades };

	public static void loadCardIcons() {
		if (iconsLoaded == true) {
			return;
		}
		int suit;
		int value;
		String cardImageLocationString;

		// nested for-loops to generate 2-D icon index
		for (suit = 0; suit < MAX_SUITS; suit++) {
			for (value = 0; value < MAX_VALUE; value++) {
				// set card filepath
				cardImageLocationString = "images/";
				cardImageLocationString += turnIntIntoCardValueChar(value);
				cardImageLocationString += turnIntIntoCardSuitChar(suit);
				cardImageLocationString += ".gif";
		
				iconCards[value][suit]= new ImageIcon(cardImageLocationString);
			}
		}
		
			cardImageLocationString = "images/BK.gif";
		// set iconBack for iconCards index
		iconBack = iconCards[MAX_VALUE - 1][MAX_SUITS - 1] = new ImageIcon(cardImageLocationString);

		// set icons as loaded
		iconsLoaded = true;
	}

	//iconBack accessor
	static public Icon getBackCardIcon() {
		return iconBack;
	}

	public static char turnIntIntoCardValueChar(int c) {
		if (c < 0 || c > 13) {
			return '?';
		}
		return cardlValsConvertAssist.charAt(c);
	}

	public static char turnIntIntoCardSuitChar(int s) {
		if (s < 0 || s > 3) {
			return '?';
		}
		return suitValsConvertAssist.charAt(s);
	}

	public static Card.Suit turnIntIntoSuit(int cs) {
		if (cs < 0 || cs > 3) 
			return Card.Suit.clubs;
		
		return suitConvertAssist[cs];
	}

	static public ImageIcon getIcon(Card card) {
		loadCardIcons(); // will not load twice, so no worries.
		return iconCards[valueAsInt(card)][suitAsInt(card)];
	}

	public static int valueAsInt(Card card) {
		return cardlValsConvertAssist.indexOf(card.getValue());
	}

	public static int suitAsInt(Card card) {
		for (int i = 0; i < MAX_SUITS; i++) {
			if (card.getSuit() == suitConvertAssist[i]) {
				System.out.println("suitConvertAssist: " + suitConvertAssist[i]);
				return i;
				
			}
		}
		return 0;
	}
}