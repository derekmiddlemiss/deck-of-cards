package org.delmiddlemiss.cards;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class AceLowCardComparatorTest {

    private final Comparator<Card> aceLowCardComparator = new AceLowCardComparator();
    private final Card aceSpades = new Card(CardValue.ACE, CardSuit.SPADES);
    private final Card twoSpades = new Card(CardValue.TWO, CardSuit.SPADES);
    private final Card twoClubs = new Card(CardValue.TWO, CardSuit.CLUBS);
    private final Card queenHearts = new Card(CardValue.QUEEN, CardSuit.HEARTS);
    private final Card dupAceSpades = new Card(CardValue.ACE, CardSuit.SPADES);

    @Test
    public void aceSpadesLowerThanTwoSpades() {
        assertTrue(aceLowCardComparator.compare(aceSpades, twoSpades) < 0);
    }

    @Test
    public void twoClubsLowerThanTwoSpades() {
        assertTrue(aceLowCardComparator.compare(twoClubs, twoSpades) < 0);
    }

    @Test
    public void aceSpadesHigherThanTwoClubs() {
        assertTrue(aceLowCardComparator.compare(aceSpades, twoClubs) > 0);
    }

    @Test
    public void aceSpadesEqualsAceSpades() {
        // edge case - this shouldn't happen in production unless someone's cheating!
        assertEquals(0, aceLowCardComparator.compare(aceSpades, dupAceSpades));
    }

    @Test
    public void sortsListInAceLowOrder() {
        List<Card> sortedCards = Stream.of(twoClubs, aceSpades, queenHearts, twoSpades)
                .sorted((c1, c2) -> aceLowCardComparator.compare(c1, c2))
                .collect(Collectors.toList());
        List<Card> expected = Stream.of(twoClubs, queenHearts, aceSpades, twoSpades).collect(Collectors.toList());
        assertArrayEquals(expected.toArray(), sortedCards.toArray());
    }


}
