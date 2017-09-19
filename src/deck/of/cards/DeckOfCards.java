package deck.of.cards;

import java.util.concurrent.ThreadLocalRandom;

/*
 * Model a standard deck of poker cards.
 * Performs shuffle and deal one card functions.
 */
public class DeckOfCards {
	private static final int deckSize = 52;
	private static final int numRanks = 13;
	private static final int numSuits = 4;
	private static final char[] ranks = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
	private static final char[] suits = {'s', 'h', 'c', 'd'};
	private Card[] deck = new Card[deckSize];
	private int currTop = 0;

	public DeckOfCards() {
		init();
	}

	/*
	 * Initialize standard deck of cards
	 */
	private void init() {
		int i = 0;
		for (int j = 0; j < numSuits; j++) {
			for (int k = 0; k < numRanks; k++) {
				deck[i] = new Card(ranks[k], suits[j]);
				i++;
			}
		}
	}

	/*
	 * Shuffle deck of cards
	 */
	protected void shuffle() {
		if (currTop != 0) {
			// Warning message
			System.out.println("Warning: Shuffling deck of cards without all cards returned to the deck. Did you want to reset the deck instead?");
		}
		for (int i = currTop + 1; i < deckSize; i++) {
			int randomIndex = random(i, deckSize);
			Card temp = deck[i - 1];
			deck[i - 1] = deck[randomIndex];
			deck[randomIndex] = temp;
		}
	}

	/*
	 * Deals the top of the deck of cards
	 * Throws an error if there are no more cards to deal
	 */
	protected Card dealOneCard() {
		if (currTop >= deckSize) {
			throw new Error("There are no more cards to be dealt. Reset the deck to deal again.");
		}
		return deck[currTop++];
	}

	/*
	 * Resets the deck of cards
	 */
	protected void reset() {
		currTop = 0;
		shuffle();
	}

	/*
	 * Random number generator between a range of min inclusive and max exclusive
	 */
	private int random(int min, int max) {
	    return ThreadLocalRandom.current().nextInt(min, max);
	}
}
