package org.delmiddlemiss.cards;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class AceHighCardComparatorTest {

    private final Comparator<Card> aceHighCardComparator = new AceHighCardComparator();
    private final Card aceSpades = new Card(CardValue.ACE, CardSuit.SPADES);
    private final Card twoSpades = new Card(CardValue.TWO, CardSuit.SPADES);
    private final Card twoClubs = new Card(CardValue.TWO, CardSuit.CLUBS);
    private final Card queenHearts = new Card(CardValue.QUEEN, CardSuit.HEARTS);
    private final Card dupAceSpades = new Card(CardValue.ACE, CardSuit.SPADES);

    @Test
    public void aceSpadesHigherThanTwoSpades() {
        assertTrue(aceHighCardComparator.compare(aceSpades, twoSpades) > 0);
    }

    @Test
    public void twoClubsLowerThanTwoSpades() {
        assertTrue(aceHighCardComparator.compare(twoClubs, twoSpades) < 0);
    }

    @Test
    public void aceSpadesHigherThanTwoClubs() {
        assertTrue(aceHighCardComparator.compare(aceSpades, twoClubs) > 0);
    }

    @Test
    public void aceSpadesEqualsAceSpades() {
        // edge case - this shouldn't happen in production unless someone's cheating!
        assertEquals(0, aceHighCardComparator.compare(aceSpades, dupAceSpades));
    }

    @Test
    public void sortsListInAceHighOrder() {
        List<Card> sortedCards = Stream.of(aceSpades, twoClubs, queenHearts, twoSpades)
                .sorted((c1, c2) -> aceHighCardComparator.compare(c1, c2))
                .collect(Collectors.toList());
        List<Card> expected = Stream.of(twoClubs, queenHearts, twoSpades, aceSpades).collect(Collectors.toList());
        assertArrayEquals(expected.toArray(), sortedCards.toArray());
    }


}
