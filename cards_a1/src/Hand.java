
//Creating a Hand Object
public class Hand {

	// Setting max cards in a deck
	public static final int MAX_CARDS = 52;

	// Private values
	private Card[] myCards;
	private int numOfCards;


	// Default Constructor
	public Hand() {
		myCards = new Card[MAX_CARDS];
		numOfCards = 0;
		for (int k = 0; k < MAX_CARDS; k++)
			myCards[k] = new Card();
	}

	// Reset the hand by setting numCards to 0
	public void resetHand() {
		numOfCards = 0;
	}

	// Boolean check for weather a card can be added to the players hand
	public boolean takeCard(Card card) {
		if (numOfCards >= MAX_CARDS)
			return false;

		if (!card.isErrorFlag()) {
			myCards[numOfCards] = card;
			++numOfCards;
		}
		return true;
	}

	// Not physically removing the card but just returning the references
	public Card playCard() {

		if (numOfCards > 0) {
			Card retPlayingCard = myCards[numOfCards - 1];
			myCards[numOfCards - 1] = null;
			numOfCards--;
			return retPlayingCard;
		} else {
			return new Card ('X',Card.Suit.spades);
		}
	}

	// toString stringizer
	public String toString() {
		if (numOfCards == 0) {
			return "Hand = ( )";
		}

		String retHand = myCards[0].toString();
		for (int i = 1; i < numOfCards; i++) {
			retHand = retHand + ", " + myCards[i].toString();
		}
		retHand = new String("Hand = ( " + retHand + " )");
		return retHand;
	}

	// numCard Assessor
	public int getNumCards() {
		return numOfCards;
	}

	// Checks if the card is in the deck
	public Card inspectCard(int k) {
		if (k < 0 || (k > numOfCards--) || k >= MAX_CARDS)
			return new Card('X', Card.Suit.spades);

		return myCards[k];
	}
}
