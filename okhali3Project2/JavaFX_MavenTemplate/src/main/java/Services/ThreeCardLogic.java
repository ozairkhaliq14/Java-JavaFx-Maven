package Services;

import Models.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeCardLogic {

    public static int evalHand(ArrayList<Card> hand) {
        Collections.sort((List) hand);
        if(isSameSuite(hand) && isInSequence(hand)){
            return 1;
        } else if(isThreeOfKind(hand)){
            return 2;
        } else if(isInSequence(hand)){
            return 3;
        } else if(isSameSuite(hand)){
            return 4;
        } else if(isPair(hand)){
            return 5;
        }
        return 0;
    }

    public static int evalPPWinnings(ArrayList<Card> hand, int bet) {

        if(isSameSuite(hand) && isInSequence(hand)){
            return bet * 40;
        } else if(isThreeOfKind(hand)){
            return bet * 30;
        } else if(isInSequence(hand)){
            return bet * 6;
        } else if(isSameSuite(hand)){
            return bet * 3;
        } else if(isPair(hand)){
            return bet;
        }
        return 0;
    }

    public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
        int dealerScore = evalHand(dealer);
        int playerScore = evalHand(player);

        if(dealerScore > playerScore){
            return 1;
        } else if(dealerScore < playerScore) {
            return 2;
        } else {
            return 0;
        }
    }
    private static boolean isSameSuite(ArrayList<Card> hand){
        return hand.get(0).getSuit() == hand.get(1).getSuit() && hand.get(1).getSuit() == hand.get(2).getSuit();
    }

    private static boolean isInSequence(ArrayList<Card> hand){
        return hand.get(0).getValue() == hand.get(1).getValue() + 1 && hand.get(1).getValue() == hand.get(2).getValue() + 1;
    }

    private static boolean isThreeOfKind(ArrayList<Card> hand){
        return hand.get(0).getValue() == hand.get(1).getValue() && hand.get(1).getValue() == hand.get(2).getValue();
    }

    private static boolean isPair(ArrayList<Card> hand){
        return hand.get(0).getValue() == hand.get(1).getValue() || hand.get(1).getValue() == hand.get(2).getValue()
                || hand.get(0).getValue() == hand.get(2).getValue();
    }

}
