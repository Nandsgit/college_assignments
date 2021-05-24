
//Creating Card Object 
class Card {

	// Types of cards
	public enum Suit {
		clubs, diamonds, hearts, spades
	}
//private members
	
	static final char DEFAULT_VAL = 'A'; 
	static final Suit DEFAULT_SUIT = Card.Suit.spades;		
			
	private char value;
	private Suit suit = null;
	private boolean errorFlag;

	// Accessors
	public Suit getSuit() {
		return suit;
	}

	public char getValue() {
		return value;

	}

	public boolean isErrorFlag() {
		return errorFlag;

	}
	
	public void getErrorFlag() {
		errorFlag=true;
	}

	// Default Constructor
	public Card() {

		value= DEFAULT_VAL;
		suit= DEFAULT_SUIT;
		errorFlag=false;

	}
	
	//Constructor with one parameter
	public Card(char cha) {

		value= cha;
		suit= DEFAULT_SUIT;
		errorFlag=false;

	}

	// Constructor Overloader
	public Card(char value, Suit suit) {
		set(value, suit);
	}

	public void Card(Card card) {
		this.suit = card.suit;
		this.value = card.value;
		this.errorFlag = card.errorFlag;
	}

	// boolean check returns true if the card is equal to the same
	public boolean equals(Card card) {
		if (this.suit == card.suit && this.value == card.value && this.errorFlag == card.errorFlag) {
			return true;
		}
		return false;

	}

	// First checks for validity of the parameter passed
	// If false value and suit is given error flag is triggered
	public boolean set(char value, Suit suit) {

		char upVal;
		boolean isValid;

		this.suit = suit;
		upVal = Character.toUpperCase(value);

		isValid = isValid(upVal, suit);

		if (isValid == true) {
			this.value = upVal;
			this.errorFlag = false;
		} else {
			this.errorFlag = true;
			isValid = false;
			this.value = 'A';
		}
		return isValid;
	}

	// To checks cards if the values are valid
	private static boolean isValid(char upVal, Suit suit) {

		if (upVal == 'A' || upVal == 'K' || upVal == 'Q' || upVal == 'J' || upVal == 'T'
				|| (upVal >= '2' && upVal <= '9')) {
			return true;
		} else {
			return false;
		}
	}

	// toString method to display the output
	public String toString() {

		if (errorFlag == true)
			return "** illegal **";

		String returnVal = Character.toString(value) + " of ";

		switch (suit) {
		case clubs:
			returnVal += "clubs";
			break;
		case diamonds:
			returnVal += "diamonds";
			break;
		case hearts:
			returnVal += "hearts";
			break;
		case spades:
			returnVal += "spades";
			break;
		default:
			break;
		}
		return returnVal;
	}

}
