package org.delmiddlemiss.cards;

class Card implements Comparable<Card>{

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
    public int compareTo(Card card){
        int suitComparison = suit.compareTo(card.getSuit());
        if(suitComparison == 0){
            // same suit - order by value
            return value.compareTo(card.getValue());
        } else {
            // different suit - order by suit
            return suitComparison;
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                '}';
    }
}
