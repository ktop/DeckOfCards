package deck.of.cards;

/*
 * Card class that knows the card's rank and suit. 
 */
public class Card {
	private char rank;
	private char suit;

	public Card(char rank, char suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/*
	 * Gets the card rank
	 */
	protected char getRank() {
		return this.rank;
	}

	/*
	 * Gets the card suit
	 */
	protected char getSuit() {
		return this.suit;
	}
}
