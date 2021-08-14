package org.delmiddlemiss.cards;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTest
{
    private static Card card1;
    private static Card card2;
    private static Card card3;

    @BeforeClass
    public static void init(){
        card1 = new Card(Value.ACE, Suit.SPADES);
        card2 = new Card(Value.TEN, Suit.SPADES);
        card3 = new Card(Value.KING, Suit.CLUBS);
    }

    @Test
    public void cardHasSuit()
    {
        assertEquals(Suit.SPADES, card1.getSuit());
    }

    @Test
    public void cardHasValue()
    {
        assertEquals(Value.ACE, card1.getValue());
    }

    @Test
    public void sameSuitCompare()
    {
        // Ace Spades higher than Ten Spades
        assertTrue(card1.compareTo(card2) > 0);
    }

    @Test
    public void differentSuitCompare()
    {
        // Ten Spades higher than King Clubs
        assertTrue(card2.compareTo(card3) > 0);
    }

    @Test
    public void sameCardCompare()
    {
        // Edge case, this should never come up in normal use
        assertEquals(0, card1.compareTo(card1));
    }


}