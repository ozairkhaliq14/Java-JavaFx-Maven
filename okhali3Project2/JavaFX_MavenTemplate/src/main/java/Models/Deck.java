package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck extends ArrayList<Card> {
    public Deck() {
        newDeck();
    }

    void newDeck() {
        List<Character> suits = Arrays.asList('C','H','D','S');
        List<Integer> ranks = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,14);

        for(char suit : suits) {
            for(int rank : ranks) {
                Card c = new Card(suit, rank);
                this.add(c);
            }
        }
    }
}
