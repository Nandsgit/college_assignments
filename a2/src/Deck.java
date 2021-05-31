import java.util.Random;

public class Deck {
	// Private Static Class Constants
	private static final int MAX_PACKS = 6, NUM_CARDS_PER_PACK = 52,
			MAX_CARDS_PER_DECK = MAX_PACKS * NUM_CARDS_PER_PACK;

	// private instance variables

	// private static member, Card array , containing exactly 52 card references,
	// which point to all the standard cards
	private static Card[] masterPack;

	// Private Member Data
	private Card[] cards;
	private int topCard, numPacks, numCards;

	// Public Methods
	// a constructor that populates the arrays and assigns initial values to
	// members.
	public Deck(int numPacks) {
		this.numPacks = numPacks;
		cards = new Card[numPacks * NUM_CARDS_PER_PACK];
		numCards = numPacks * NUM_CARDS_PER_PACK;
		topCard = numPacks * NUM_CARDS_PER_PACK;
		for (int i = 1; i <= numPacks; i++)
			Deck.allocateMasterPack();

	}

	public Deck() {
		this.numPacks = 1;
		cards = new Card[numPacks * NUM_CARDS_PER_PACK];
		numCards = numPacks * NUM_CARDS_PER_PACK;
		topCard = numPacks * NUM_CARDS_PER_PACK;
		for (int i = 1; i <= numPacks; i++)
			Deck.allocateMasterPack();
	}

	/*
	 * helper, a private static methods, a method that will be called by the
	 * constructor Since masterPack[] is a static, unchanging, entity, it need not
	 * be built every time a new Deck is instantiated.
	 */
	private static void allocateMasterPack() {
		// instantiate the array elements
		masterPack = new Card[NUM_CARDS_PER_PACK];

		char val;
		Card.Suit suit;
		int k;
		for (k = 0; k < 4; k++) {
			// set the suit for this loop pass
			switch (k) {
			case 0:
				suit = Card.Suit.CLUBS;
				masterPack[13 * k] = new Card('A', suit);
				int j;
				for (val = '2', j = 1; val <= '9'; val++, j++) {
					masterPack[13 * k + j] = new Card(val, suit);

					masterPack[13 * k + j].set(val, suit);
				}
				masterPack[13 * k + 9] = new Card(val, suit);
				masterPack[13 * k + 9].set('T', suit);
				masterPack[13 * k + 10] = new Card(val, suit);
				masterPack[13 * k + 10].set('J', suit);
				masterPack[13 * k + 11] = new Card(val, suit);
				masterPack[13 * k + 11].set('Q', suit);
				masterPack[13 * k + 12] = new Card(val, suit);
				masterPack[13 * k + 12].set('K', suit);
				break;
			case 1:
				suit = Card.Suit.DIAMONDS;
				masterPack[13 * k] = new Card('A', suit);

				for (val = '2', j = 1; val <= '9'; val++, j++) {
					masterPack[13 * k + j] = new Card(val, suit);

					masterPack[13 * k + j].set(val, suit);
				}
				masterPack[13 * k + 9] = new Card(val, suit);
				masterPack[13 * k + 9].set('T', suit);
				masterPack[13 * k + 10] = new Card(val, suit);
				masterPack[13 * k + 10].set('J', suit);
				masterPack[13 * k + 11] = new Card(val, suit);
				masterPack[13 * k + 11].set('Q', suit);
				masterPack[13 * k + 12] = new Card(val, suit);
				masterPack[13 * k + 12].set('K', suit);
				break;
			case 2:
				suit = Card.Suit.HEARTS;
				masterPack[13 * k] = new Card('A', suit);

				for (val = '2', j = 1; val <= '9'; val++, j++) {
					masterPack[13 * k + j] = new Card(val, suit);

					masterPack[13 * k + j].set(val, suit);
				}
				masterPack[13 * k + 9] = new Card(val, suit);
				masterPack[13 * k + 9].set('T', suit);
				masterPack[13 * k + 10] = new Card(val, suit);
				masterPack[13 * k + 10].set('J', suit);
				masterPack[13 * k + 11] = new Card(val, suit);
				masterPack[13 * k + 11].set('Q', suit);
				masterPack[13 * k + 12] = new Card(val, suit);
				masterPack[13 * k + 12].set('K', suit);
				break;
			case 3:
				suit = Card.Suit.SPADES;
				masterPack[13 * k] = new Card('A', suit);

				for (val = '2', j = 1; val <= '9'; val++, j++) {
					masterPack[13 * k + j] = new Card(val, suit);

					masterPack[13 * k + j].set(val, suit);
				}
				masterPack[13 * k + 9] = new Card(val, suit);
				masterPack[13 * k + 9].set('T', suit);
				masterPack[13 * k + 10] = new Card(val, suit);
				masterPack[13 * k + 10].set('J', suit);
				masterPack[13 * k + 11] = new Card(val, suit);
				masterPack[13 * k + 11].set('Q', suit);
				masterPack[13 * k + 12] = new Card(val, suit);
				masterPack[13 * k + 12].set('K', suit);
				break;
			}

		}

		for (int a = 0; a < 52; a++) {
			System.out.println(masterPack[a].toString());
		}

		System.out.println(" ");

	}

	/*
	 * re-populate cards[] with the standard 52 °— numPacks cards to restock the deck
	 * (init()) to the original full condition in preparation for a fresh deal
	 */
	public boolean init(int numPacks) {
		if (numPacks <= MAX_PACKS) {
			cards = new Card[numPacks * NUM_CARDS_PER_PACK];
			for (int i = 1; i <= numPacks; i++) {
				for (int j = 0 + (i - 1) * NUM_CARDS_PER_PACK; j < i * NUM_CARDS_PER_PACK; j++)
					cards[j] = new Card(masterPack[NUM_CARDS_PER_PACK - (j % 52) - 1]);

				// for (int j=NUM_CARDS_PER_PACK,k=0; j<numPacks* NUM_CARDS_PER_PACK ; j++)
				// cards[j]= new Card(masterPack[NUM_CARDS_PER_PACK-1-k]);
			}
			return true;
		}

		else
			return false;

	}

	/*
	 * returns and removes (effectively, not physically) the card in the top
	 * occupied position of cards[] (at the top of the deck). We have to return a
	 * copy of the card, not the actual reference to the object in the cards[] array
	 * since that object is also the object in the masterPack[] array, which the
	 * client must not be allowed to change.
	 */
	public Card dealCard() {

		Card cardDealt;
		if (topCard > 0) {
			if ((topCard % 52 == 0))
				cards[topCard - 1] = new Card(masterPack[(NUM_CARDS_PER_PACK - 1)]);
			else
				cards[topCard - 1] = new Card(masterPack[(topCard % 52) - 1]);
			cardDealt = cards[topCard - 1];
			// String strCardDealt = cardDealt.toString();
			// System.out.println(strCardDealt);
			topCard--;
			return cardDealt;
		} else
			cardDealt = new Card('0', Card.Suit.CLUBS);
		boolean isIllegal = cardDealt.set('0', Card.Suit.CLUBS);
		return cardDealt;
	}

	// An accessor for the int, topCard (no mutator.)
	public int getTopCard() {
		return topCard;
	}

	/*
	 * Accessor for an individual card. Returns a card with errorFlag = true if k is
	 * bad. Otherwise returns a copy of the card (see admonition for dealCard())
	 */
	public Card inspectCard(int k) {
		Card cardTest = null;
		if (k > topCard - 1) {
			cardTest = new Card();
			cardTest.set('0', Card.Suit.CLUBS);
		} else
			cardTest = new Card(cards[k].getValue(), cards[k].getSuit());

		return cardTest;
	}

	// to re-order the cards in a random fashion
	public void shuffle() {
		// this.init(numPacks);
		// Card shuffleClone = new Card();
		Card shuffleClone;
		Random random = new Random();
		int r1, r2;
		for (int i = 0; i < numCards; i++) {
			r1 = random.nextInt(numCards - 1);
			r2 = random.nextInt(numCards - 1);
			shuffleClone = cards[r1];
			cards[r1] = cards[r2];
			cards[r2] = shuffleClone;
		}
	}

}
