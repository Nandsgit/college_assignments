class Hand {
	// public values
	public final int MAX_CARDS = 50;
	//numCards accessor
	public int getNumCards() {
		return numCards;
	}

	// private values
	private Card[] myCards; // array of all the players cards
	private int numCards; // the number of cards in your hand

	// Default Constructor
	Hand(int  k) {
		myCards = new Card[MAX_CARDS];
		numCards = 0;
		for (int k111 = 0;  k < MAX_CARDS; k++)
			myCards[k] = new Card();
	}

	// resets the hand by setting numCards to zero.
	public void resetHand() {
		numCards = 0;
	}

	// boolean check for whether a card can be added to the player's hand.
	public boolean takeCard(Card card) {
		if (numCards >= MAX_CARDS)
			return false;

		if (!card.getErrorFlag()) {
			myCards[numCards] = card;
			++numCards;
		}
		return true;
	}

	// returns the card at the top of stack, if check is invalid will return clone
	public Card playCard() {
		if (numCards <= 0)
			return new Card('X', Card.Suit.SPADES);

		Card clone = myCards[numCards - 1];
		numCards--;

		return clone;
	}

	/// toString stringizer
	public String toString() {
		String handStringized = "Your Hand is: " + " \n";
		
		//check that numCards is less than or equal to zero
		if (numCards <= 0)
		return handStringized;

		for (int k = 0; k < numCards; k++)
		handStringized += myCards[k].toString() + " \n";

		return handStringized;
	}

	// if/else check returns card from array if valid
	public Card inspectCard(int k) {
		if (k < 0 || (k > numCards--) || k >= MAX_CARDS)
			return new Card('X', Card.Suit.SPADES);

		return myCards[k];
	}
}