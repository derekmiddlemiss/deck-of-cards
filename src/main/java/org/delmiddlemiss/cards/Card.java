package org.delmiddlemiss.cards;

class Card implements Comparable<Card>{

    private final Value value;
    private final Suit suit;

    Card(Value value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public Value getValue(){
        return value;
    }

    public Suit getSuit(){
        return suit;
    }

    @Override
    public int compareTo(Card card){
        int suitComparison = this.suit.compareTo(card.getSuit());
        if(suitComparison == 0){
            // same suit - order by value
            return this.value.compareTo(card.getValue());
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
