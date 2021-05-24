//Main to test Hand and Card classes
public class Foothill {

	// phase 1 n 2 testing
	public static void main(String[] args) {
		phaseOneCardTest();
		PhaseTwoHandTesting();
	}

	// Test Card method
	private static void phaseOneCardTest() {
		Card legalCard1 = new Card();
		Card legalCard2 = new Card('K', Card.Suit.spades);
		Card illegalCard1 = new Card('0', Card.Suit.diamonds);

		System.out.println(legalCard1);
		System.out.println(legalCard2);
		System.out.println(illegalCard1);

		System.out.println("====================  \n");

		legalCard1 = new Card();
		legalCard2 = new Card('1', Card.Suit.spades);
		illegalCard1 = new Card('Q', Card.Suit.diamonds);

		System.out.println(legalCard1);
		System.out.println(legalCard2);
		System.out.println(illegalCard1);

		System.out.println("====================  \n");

	}

	// Test Hand Method
	private static void PhaseTwoHandTesting() {

		Hand hand = new Hand();
		Card cardOne = new Card('A', Card.Suit.spades);
		Card cardTwo = new Card('K', Card.Suit.hearts);
		Card cardThree = new Card('T', Card.Suit.clubs);

		for (int i = 0; i < Hand.MAX_CARDS; i++) {
			if (i % 4 == 0) {
				hand.takeCard(cardOne);
			} else if (i % 3 == 0) {
				hand.takeCard(cardTwo);
			} else if (i % 2 == 0) {
				hand.takeCard(cardThree);
			}

		}

		System.out.println("Hand full \nAfter deal \nShowHand:" + hand);

		System.out.println(String.format("Testing inspectCard() : with two conditions \n \n \n", hand.inspectCard(0),
				hand.inspectCard(6)));

		System.out.println("Testing Playing Card: ");
		for (int i = 0, currentCount = hand.getNumCards(); i < currentCount; i++) {
			System.out.println(hand.playCard());
		}

		System.out.println(String.format("\nAfter playing all cards\nHand is = \n", hand));
	}

}

/*
 * ------------------------------------------- 
A of spades
K of spades
** illegal **
====================  

A of spades
** illegal **
Q of diamonds
====================  

Hand full 
After deal 
ShowHand:Hand = ( A of spades, T of clubs, K of hearts, A of spades, K of hearts, A of spades, K of hearts, T of clubs, A of spades, T of clubs, K of hearts, A of spades, K of hearts, A of spades, K of hearts, T of clubs, A of spades, T of clubs, K of hearts, A of spades, K of hearts, A of spades, K of hearts, T of clubs, A of spades, T of clubs, K of hearts, A of spades, K of hearts, A of spades, K of hearts, T of clubs, A of spades, T of clubs, K of hearts )
Testing inspectCard() : with two conditions 
 
 

Testing Playing Card: 
A of spades
T of clubs
K of hearts
A of spades
K of hearts
A of spades
K of hearts
T of clubs
A of spades
T of clubs
K of hearts
A of spades
K of hearts
A of spades
K of hearts
T of clubs
A of spades
T of clubs
K of hearts
A of spades
K of hearts
A of spades
K of hearts
T of clubs
A of spades
T of clubs
K of hearts
A of spades
K of hearts
A of spades
K of hearts
T of clubs
A of spades

After playing all cards
Hand is = 


 * 
 */
