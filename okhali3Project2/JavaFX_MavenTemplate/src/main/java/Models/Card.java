package Models;

public class Card implements Comparable{
    char suit;
    int value;

    public Card(char suit, int value) {
        this.suit = suit;
        this.value = value;

    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(suit)+String.valueOf(value);
    }

    @Override
    public boolean equals(Object o){
        Card c = (Card) o;
        return c.getValue() == this.getValue();
    }

    @Override
    public int compareTo(Object o) {
        Card c = (Card) o;
        int returnVal = c.getValue() < this.getValue() ? -1 : 1;
        return returnVal;
    }
}
