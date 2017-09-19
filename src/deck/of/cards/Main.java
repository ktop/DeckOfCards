package deck.of.cards;

public class Main {
	public static void main(String[] args) {
		DeckOfCards deck = new DeckOfCards();
		
		// Scenario 1
		// Shuffle the deck and deal 52 cards
		deck.shuffle();
		Card[] cards = new Card[52];

		for (int i = 0; i < 52; i++) {
			cards[i] = deck.dealOneCard();
			System.out.printf("%c%c\n", cards[i].getRank(), cards[i].getSuit());
		}

		// Scenario 2
		// Resets the deck and deals one more card
//		deck.reset();
//		deck.dealOneCard();

		// Scenario 3
		// Shuffling the deck without returning all cards to the deck should print a warning message
//		deck.shuffle();

		// Scenario 4
		// Throws error if dealing one more card without resetting
//		for (int i = 0; i < 52; i++) {
//			cards[i] = deck.dealOneCard();
//			System.out.printf("%c%c\n", cards[i].getRank(), cards[i].getSuit());
//		}
	}
}
