package org.delmiddlemiss.cards;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    private final Card card = new Card(CardValue.ACE, CardSuit.SPADES);

    @Test
    public void cardHasSuit()
    {
        assertEquals(CardSuit.SPADES, card.getSuit());
    }

    @Test
    public void cardHasValue()
    {
        assertEquals(CardValue.ACE, card.getValue());
    }

}