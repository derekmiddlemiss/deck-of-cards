package org.delmiddlemiss.cards;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class DeckTest {

    private Deck sortedDeck;
    private Deck randomDeck;
    private final int numToDraw = CardSuit.values().length * CardValue.values().length;
    private final Comparator<Card> aceHighCardComparator = new AceHighCardComparator();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void init() {
        randomDeck = new Deck(aceHighCardComparator);
        sortedDeck = new Deck(aceHighCardComparator);
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

    @Test
    public void dealFromEmptyDeckRaisesSpecificException() {
        for(int i = 1; i <= numToDraw; i++){
            Card card = randomDeck.deal();
        }
        exceptionRule.expect(IllegalStateException.class);
        exceptionRule.expectMessage("Deck is empty: cannot deal");
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
            /* If cards sorted in order: lowest at bottom of pile and highest at top
             * of pile, then each card after first pulled from top of pile should be
             * lower than last card pulled from top of pile */
            assertTrue(aceHighCardComparator.compare(thisCard, lastCard) < 0);
            lastCard = thisCard;
        }
    }



}