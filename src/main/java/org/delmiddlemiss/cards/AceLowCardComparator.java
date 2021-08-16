package org.delmiddlemiss.cards;

import java.util.Comparator;

class AceLowCardComparator implements Comparator<Card> {

    private static int minCardValueOrdinal = CardValue.values()[0].ordinal();
    private static int effectiveAceOrdinal = minCardValueOrdinal - 1;

    @Override
    public int compare(Card c1, Card c2){
        int suitComparison = c1.getSuit().compareTo(c2.getSuit());

        if(suitComparison == 0){
            // same suit - order by value - Aces high
            return valueComparison(c1, c2);
        }
        // different suit - order by suit
        return suitComparison;
    }

    public int valueComparison(Card c1, Card c2){
        int c1_ordinal = c1.getValue().ordinal();
        if(c1.getValue() == CardValue.ACE){
            c1_ordinal = effectiveAceOrdinal;
        }

        int c2_ordinal = c2.getValue().ordinal();
        if(c2.getValue() == CardValue.ACE){
            c2_ordinal = effectiveAceOrdinal;
        }

        return Integer.compare(c1_ordinal, c2_ordinal);
    }
}
