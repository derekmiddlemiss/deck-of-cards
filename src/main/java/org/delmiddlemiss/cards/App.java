package org.delmiddlemiss.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Card card1 = new Card(Value.ACE, Suit.SPADES);
        Card card2 = new Card(Value.FIVE, Suit.CLUBS);
        Card card3 = new Card(Value.TWO, Suit.CLUBS);
        Card card4 = new Card(Value.TWO, Suit.HEARTS);

        List<Card> sorted = Stream.of(card1, card2, card3, card4)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sorted);
    }
}
