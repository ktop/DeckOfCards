package deck.of.cards;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DeckOfCardsTest {
	DeckOfCards deck = new DeckOfCards();
	
	@Test
	public void dealOneCardShouldDealTopCard() {
		Card c1 = deck.dealOneCard();
		deck.dealOneCard();
		deck.dealOneCard();
		deck.dealOneCard();
		deck.dealOneCard();
		Card c2 = deck.dealOneCard();
		assertEquals(c1.getRank(), '2');
		assertEquals(c1.getSuit(), 's');
		assertEquals(c2.getRank(), '7');
		assertEquals(c2.getSuit(), 's');
	}
	
	@Test
	public void shuffleShouldPutCardsInDifferentOrder() {
		deck.shuffle();
		Card c = deck.dealOneCard();
		String str = "" + c.getRank() + c.getSuit();
		assertNotEquals(str, "8s");
	}

	@Test
	public void resetShouldResetCardsAndReshuffle() {
		// c1 is the card at the 7th index (8th call to dealOneCard())
		Card c1 = deck.dealOneCard();
		String str1 = "" + c1.getRank() + c1.getSuit();
		
		deck.reset();
		
		// 7 calls to dealOneCard()
		for (int i = 0; i < 7; i++) {
			deck.dealOneCard();
		}
		
		// c2 is new 8th call to dealOneCard()
		Card c2 = deck.dealOneCard();
		String str2 = "" + c2.getRank() + c2.getSuit();
		
		assertNotEquals(str1, str2);
	}
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void dealOneCardShouldThrowErrorDealingMoreThan52Cards() {
		expectedEx.expect(Error.class);
	    expectedEx.expectMessage("There are no more cards to be dealt. Reset the deck to deal again.");
	    for (int i = 0; i < 53; i++) {
	    		deck.dealOneCard();
	    }
	}
}
