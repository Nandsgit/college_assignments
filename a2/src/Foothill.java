
/** CS1B_Assignment_2_Group 10
 * Creeger, Adam/ Kishore, Nand/ Lo, YaFan
 */
import java.util.Scanner;

public class Foothill {

	public static void main(String[] args) {
		/*
		 * A newly instantiated deck will have a multiple of 52 cards and will contain
		 * all the standard cards, so the number of cards in a newly instantiated deck
		 * will be 52, 104, 156, ... (numPacks °— 52).
		 */
		System.out.println("---------------PHASE 1-----------------");
		System.out.println("An unshffled deck containing two packs of cards:");
		Deck deck = new Deck(2);
		System.out.println("top Card = " + deck.getTopCard() + "\n\nDeal the cards:");
		int totalCards = deck.getTopCard();
		for (int i = 0; i < totalCards; i++)
			System.out.println(deck.dealCard().toString());

		System.out.println(
				"Next, reset the deck (2 packs) by initializing it again and shuffle the deck. Re-deal to the screen:");

		Deck deckShuffled = new Deck(2);
		System.out.println("top Card = " + deckShuffled.getTopCard());

		deckShuffled.init(2);
		deckShuffled.shuffle();
		Card shuffledCard;
		String strShuffledCards = "";
		for (int i = 0; i < deckShuffled.getTopCard(); i++) {
			shuffledCard = new Card(deckShuffled.inspectCard(i));
			strShuffledCards = strShuffledCards + shuffledCard.toString() + " \n";
		}
		System.out.print("Shuffle two  packs of cards and deal the cards:\n" + strShuffledCards);

		System.out.println("\n\nAn unshffled deck containing one pack of cards:");
		Deck deck1 = new Deck();
		totalCards = deck1.getTopCard();
		System.out.println("top Card = " + deck1.getTopCard() + "\nDeal the cards:");
		for (int i = 0; i < totalCards; i++)
			System.out.println(deck1.dealCard().toString());

		System.out.println(
				"Next, reset the deck (one pack) by initializing it again and shuffle the deck. Re-deal to the screen:");

		Deck deckShuffled1 = new Deck(1);
		System.out.println("top Card = " + deckShuffled1.getTopCard());

		deckShuffled1.init(1);
		deckShuffled1.shuffle();
		Card shuffledCard1;
		String strShuffledCards1 = "";
		for (int i = 0; i < deckShuffled.getTopCard(); i++) {
			shuffledCard1 = new Card(deckShuffled.inspectCard(i));
			strShuffledCards1 = strShuffledCards1 + shuffledCard1.toString() + " \n";
		}
		System.out.print("Shuffle one pack of cards and deal the cards:\n" + strShuffledCards1);

		System.out.println("\n\n\n---------------PHASE 2-----------------");
		System.out.println("Please select the number of players. A number from 1 to 10 :");
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		if (keyboard.hasNextInt()) {
			choice = keyboard.nextInt();
			if (choice > 10 || choice < 1) {
				System.out.println("***illegal number***");

				choice = 0;
			} else
				System.out.println("You've selected " + choice + " players");
		} else
			System.out.println("***illegal input***");
		// instantiate a single-pack Deck object without shuffling
		System.out.println("\nHere are our hands, from unshuffled deck:");
		Deck deckOnePack = new Deck();
		deckOnePack.init(1);
		System.out.println("card 3 = " + deckOnePack.inspectCard(2));

		int topCard = deckOnePack.getTopCard();
		System.out.println("The topCard = " + deckOnePack.getTopCard());

		// deal a deck into that many Hand objects, dealing all cards until the deck is
		// empty.
		Hand[] hand = new Hand[choice];

		String cardsInHand1 = "";
		String cardsInHand2 = "";
		String cardsInHand3 = "";
		String cardsInHand4 = "";
		String cardsInHand5 = "";
		String cardsInHand6 = "";
		String cardsInHand7 = "";
		String cardsInHand8 = "";
		String cardsInHand9 = "";
		String cardsInHand10 = "";

		int position = topCard;
		int n;
		// player 1 n=1
		for (int factor = 0; choice >= 1 && factor <= topCard / choice && position - choice >= 1; factor++) {
			n = 1;
			position = topCard - (choice * factor) - (n - 1);
			if (factor == topCard / choice && position - choice > topCard) {
				// System.out.println("I'm in position= "+position);

				cardsInHand1 = cardsInHand1 + deckOnePack.inspectCard(position - 1);
			}

			// System.out.println("topCard/choice = "+topCard/choice);
			//
			// System.out.println("position = "+ position);
			// System.out.println("choice*factor = "+choice*factor);

			Card cardReceived = new Card(deckOnePack.inspectCard(position - 1));
			cardsInHand1 = cardsInHand1 + cardReceived + "; ";

		}

		System.out.println("hand = ( " + cardsInHand1 + ")");

		// player2 n=2
		position = topCard - 1;
		for (int factor = 0; choice >= 2 && factor <= topCard / choice && position - choice >= 1; factor++) {
			n = 2;
			position = topCard - (choice * factor) - (n - 1);

			if (factor == topCard / choice && position - choice > topCard) {

				cardsInHand2 = cardsInHand2 + deckOnePack.inspectCard(position - 1);
			}

			else {
				Card cardReceived = new Card(deckOnePack.inspectCard(position - 1));
				cardsInHand2 = cardsInHand2 + cardReceived + "; ";
			}
		}

		System.out.println("hand = ( " + cardsInHand2 + ")");

		// player3 n=3
		position = topCard - 2;
		for (int factor = 0; choice >= 3 && factor <= topCard / choice && position - choice >= 1; factor++) {
			n = 3;
			position = topCard - (choice * factor) - (n - 1);

			if (factor == topCard / choice && position - choice > topCard) {

				cardsInHand3 = cardsInHand3 + deckOnePack.inspectCard(position - 1);
			}

			else {
				Card cardReceived = new Card(deckOnePack.inspectCard(position - 1));
				cardsInHand3 = cardsInHand3 + cardReceived + "; ";
			}
		}

		System.out.println("hand = ( " + cardsInHand3 + ")");

		// player4 n=4
		position = topCard - 3;
		for (int factor = 0; choice >= 4 && factor <= topCard / choice && position - choice >= 1; factor++) {
			n = 4;
			position = topCard - (choice * factor) - (n - 1);

			if (factor == topCard / choice && position - choice > topCard) {

				cardsInHand4 = cardsInHand4 + deckOnePack.inspectCard(position - 1);
			}

			else {
				Card cardReceived = new Card(deckOnePack.inspectCard(position - 1));
				cardsInHand4 = cardsInHand4 + cardReceived + "; ";
			}
		}

		System.out.println("hand = ( " + cardsInHand4 + ")");

		// player5 n=5
		position = topCard - 4;
		for (int factor = 0; choice >= 5 && factor <= topCard / choice && position - choice >= 1; factor++) {
			n = 5;
			position = topCard - (choice * factor) - (n - 1);

			if (factor == topCard / choice && position - choice > topCard) {

				cardsInHand5 = cardsInHand5 + deckOnePack.inspectCard(position - 1);
			}

			else {
				Card cardReceived = new Card(deckOnePack.inspectCard(position - 1));
				cardsInHand5 = cardsInHand5 + cardReceived + "; ";
			}
		}

		System.out.println("hand = ( " + cardsInHand5 + ")");

		// player6 n=6
		position = topCard - 5;
		for (int factor = 0; choice >= 6 && factor <= topCard / choice && position - choice >= 1; factor++) {
			n = 6;
			position = topCard - (choice * factor) - (n - 1);

			if (factor == topCard / choice && position - choice > topCard) {

				cardsInHand6 = cardsInHand6 + deckOnePack.inspectCard(position - 1);
			}

			else {
				Card cardReceived = new Card(deckOnePack.inspectCard(position - 1));
				cardsInHand6 = cardsInHand6 + cardReceived + "; ";
			}
		}

		System.out.println("hand = ( " + cardsInHand6 + ")");

		// player7 n=7
		position = topCard - 6;
		for (int factor = 0; choice >= 7 && factor <= topCard / choice && position - choice >= 1; factor++) {
			n = 7;
			position = topCard - (choice * factor) - (n - 1);

			if (factor == topCard / choice && position - choice > topCard) {

				cardsInHand7 = cardsInHand7 + deckOnePack.inspectCard(position - 1);
			}

			else {
				Card cardReceived = new Card(deckOnePack.inspectCard(position - 1));
				cardsInHand7 = cardsInHand7 + cardReceived + "; ";
			}
		}

		System.out.println("hand = ( " + cardsInHand7 + ")");

		// player8 n=8
		position = topCard - 7;
		for (int factor = 0; choice >= 8 && factor <= topCard / choice && position - choice >= 1; factor++) {
			n = 8;
			position = topCard - (choice * factor) - (n - 1);

			if (factor == topCard / choice && position - choice > topCard) {

				cardsInHand8 = cardsInHand8 + deckOnePack.inspectCard(position - 1);
			}

			else {
				Card cardReceived = new Card(deckOnePack.inspectCard(position - 1));
				cardsInHand8 = cardsInHand8 + cardReceived + "; ";
			}
		}

		System.out.println("hand = ( " + cardsInHand8 + ")");

		// player9 n=9
		position = topCard - 8;
		for (int factor = 0; choice >= 9 && factor <= topCard / choice && position - choice >= 1; factor++) {
			n = 8;
			position = topCard - (choice * factor) - (n - 1);

			if (factor == topCard / choice && position - choice > topCard) {

				cardsInHand9 = cardsInHand9 + deckOnePack.inspectCard(position - 1);
			}

			else {
				Card cardReceived = new Card(deckOnePack.inspectCard(position - 1));
				cardsInHand9 = cardsInHand9 + cardReceived + "; ";
			}
		}

		System.out.println("hand = ( " + cardsInHand9 + ")");

		// player10 n=10
		position = topCard - 9;
		for (int factor = 0; choice >= 10 && factor <= topCard / choice && position - choice >= 1; factor++) {
			n = 10;
			position = topCard - (choice * factor) - (n - 1);

			if (factor == topCard / choice && position - choice > topCard) {

				cardsInHand10 = cardsInHand10 + deckOnePack.inspectCard(position - 1);
			}

			else {
				Card cardReceived = new Card(deckOnePack.inspectCard(position - 1));
				cardsInHand10 = cardsInHand10 + cardReceived + "; ";
			}
		}

		System.out.println("hand = ( " + cardsInHand10 + ")");

	}

}
