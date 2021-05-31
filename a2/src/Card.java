
class Card {
	// suit enum for houses
	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	}

	// accessors
	public Suit getSuit() {
		return suit;
	}

	public char getValue() {
		return value;
	}

	public boolean getErrorFlag() {
		return errorFlag;
	}

	private char value;
	private Suit suit;
	private boolean errorFlag;

	// Default Constructor
	public Card() {
		value = 'A';
		suit = Suit.SPADES;
		errorFlag = false;
	}

	// Constructor Overloader
	public Card(char value, Suit suit) {
		set(value, suit);
	}
	
	public Card ( Card card) {
		this.value=card.value;
		this.suit=card.suit;
	}

	// boolean if/else check for valid parameters, if false it will trigger an
	// errorFlag
	public boolean set(char value, Suit suit) {
		if (isValid(value, suit)) {
			errorFlag = false;
			this.value = value;
			this.suit = suit;
			return true;
		}
		else {
			errorFlag = true;
			return false;
		}
	}

	// private boolean checks for ErrorFlag of Char value
	private static boolean isValid(char value, Suit suit) {
		// check for illegal characters
		if (!Character.isLetterOrDigit(value))
			return false;
		// upperVal checks
		value = Character.toUpperCase(value);
		if (value != 'A' && value != 'J' && value != 'Q' && value != 'K' && value != 'T'
				&& (value > '9' || value < '2'))
			return false;

		return true;
	}

	// toString stringizer
	public String toString() {
		if (errorFlag == true)
			return "ERRORFLAG: INVALID";

		String returnVal = Character.toString(value) + " of ";

		switch (suit) {
		case CLUBS:
			returnVal += "Clubs";
			break;
		case DIAMONDS:
			returnVal += "Diamonds";
			break;
		case HEARTS:
			returnVal += "Hearts";
			break;
		case SPADES:
			returnVal += "Spades";
			break;
		default:
			break;
		}
		return returnVal;
	}
	
	// boolean check returns true if the card is equal to the same
	public boolean equals(Card card) {
		if (this.suit == card.suit && this.errorFlag == card.errorFlag && this.value == card.value)
			return true;

		return false;
	}
}
