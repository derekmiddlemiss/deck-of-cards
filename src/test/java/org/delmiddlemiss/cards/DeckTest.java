package org.delmiddlemiss.cards;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class DeckTest {
    private Deck sortedDeck;
    private Deck randomDeck;
    private int numToDraw = CardSuit.values().length * CardValue.values().length;

    @Before
    public void init() {
        randomDeck = new Deck();
        sortedDeck = new Deck();
        sortedDeck.sort();
    }

    @Test
    public void dealYieldsValidCard() {
        Card card = randomDeck.deal();
        assertTrue(Arrays.asList(CardSuit.values()).contains(card.getSuit()));
        assertTrue(Arrays.asList(CardValue.values()).contains(card.getValue()));
    }

    @Test
    public void allCardsInDeckAreValid() {
        for(int i = 1; i <= numToDraw; i++){
            Card card = randomDeck.deal();
            assertTrue(Arrays.asList(CardSuit.values()).contains(card.getSuit()));
            assertTrue(Arrays.asList(CardValue.values()).contains(card.getValue()));
        }
    }

    @Test(expected = IllegalStateException.class)
    public void dealFromEmptyDeckRaisesException() {
        for(int i = 1; i <= numToDraw; i++){
            Card card = randomDeck.deal();
        }
        randomDeck.deal();
    }

    @Test
    public void canRefillEmptyDeckAndDeal() {
        for(int i = 1; i <= numToDraw; i++){
            Card card = randomDeck.deal();
        }
        randomDeck.fillCardsAndShuffle();
        for(int i = 1; i <= numToDraw; i++){
            Card card = randomDeck.deal();
            assertTrue(Arrays.asList(CardSuit.values()).contains(card.getSuit()));
            assertTrue(Arrays.asList(CardValue.values()).contains(card.getValue()));
        }
    }

    @Test
    public void sortedDeckDealsInDecreasingOrder() {
        Card lastCard = sortedDeck.deal();
        for(int i = 2; i <= numToDraw; i++){
            Card thisCard = sortedDeck.deal();
            // if cards sorted in order: lowest at bottom of pile and
            // highest at top of pile, then each card pulled from top of pile
            // should be lower than last card pulled from top of pile
            assertTrue(thisCard.compareTo(lastCard) < 0);
            lastCard = thisCard;
        }
    }



}