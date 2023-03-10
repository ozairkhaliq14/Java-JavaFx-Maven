package Models;

import Models.Dealer;
import Models.Player;

public class ThreeCardPokerGame{
    Player playerOne;
    Player playerTwo;
    Dealer theDealer;

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Dealer getTheDealer() {
        return theDealer;
    }

    public void setTheDealer(Dealer theDealer) {
        this.theDealer = theDealer;
    }
}
