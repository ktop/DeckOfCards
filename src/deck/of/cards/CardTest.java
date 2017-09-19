package deck.of.cards;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {
	Card c = new Card('A', 'h');
	
	@Test
	public void getRankShouldGetCardRank() {
		assertEquals(c.getRank(), 'A');
	}
	
	@Test
	public void getSuitShouldGetCardSuit() {
		assertEquals(c.getSuit(), 'h');
	}
}
