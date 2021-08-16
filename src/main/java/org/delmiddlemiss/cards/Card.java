package org.delmiddlemiss.cards;

class Card {

    private final CardValue value;
    private final CardSuit suit;

    Card(CardValue value, CardSuit suit){
        this.value = value;
        this.suit = suit;
    }

    public CardValue getValue(){
        return value;
    }

    public CardSuit getSuit(){
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                '}';
    }
}
