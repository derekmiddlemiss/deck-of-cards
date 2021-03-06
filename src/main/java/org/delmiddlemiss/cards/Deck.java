package org.delmiddlemiss.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Deck {

    private List<Card> cards;
    private int numCardsRemaining;

    Deck(){
        fillCardsAndShuffle();
    }

    public void fillCardsAndShuffle(){
        cards = new ArrayList<>();
        numCardsRemaining = 0;
        for (CardSuit suit: CardSuit.values()){
            for (CardValue value: CardValue.values()){
                cards.add(new Card(value, suit));
                numCardsRemaining += 1;
            }
        }
        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public void sort(){
        cards = cards.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Card deal() throws IllegalStateException{
        if(numCardsRemaining == 0){
            throw new IllegalStateException("Deck is empty: cannot deal");
        }
        Card dealtCard = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        numCardsRemaining -= 1;
        return dealtCard;
    }

}
