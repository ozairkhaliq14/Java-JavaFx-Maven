package Models;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
    Deck theDeck;
    ArrayList<Card> dealersHand;

    public Dealer() {
        theDeck = new Deck();
        Collections.shuffle(theDeck);
    }

    public Deck getTheDeck() {
        return theDeck;
    }

    public void setTheDeck(Deck theDeck) {
        this.theDeck = theDeck;
    }

    public ArrayList<Card> getDealersHand() {
        return dealersHand;
    }

    public void setDealersHand(ArrayList<Card> dealersHand) {
        this.dealersHand = dealersHand;
    }

    public ArrayList<Card> dealHand() {

        ArrayList<Card> hand = new ArrayList<>();
        Card c1 = theDeck.remove(0);
        Card c2 = theDeck.remove(1);
        Card c3 = theDeck.remove(2);
        hand.add(new Card(c1.getSuit(), c1.getValue()));
        hand.add(new Card(c2.getSuit(), c2.getValue()));
        hand.add(new Card(c3.getSuit(), c3.getValue()));

        System.out.println(theDeck.size());

        return hand;
    }
}
