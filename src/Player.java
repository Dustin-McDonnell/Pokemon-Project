import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
        private ArrayList<Card> deck = new ArrayList<>();
        private ArrayList<Card> hand = new ArrayList<>();
        private ArrayList<Card> discardPile = new ArrayList<>();
        private ArrayList<Card> prizePile = new ArrayList<>();

    public ArrayList<Card> getDeck(){
        return deck;
    }
    public void setDeck(ArrayList<Card> userInputDeck){
        deck = userInputDeck;
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public void setHand(ArrayList<Card> userInputDeck){
        hand = userInputDeck;
    }

    public ArrayList<Card> getDiscardPile(){
        return discardPile;
    }

    public void setDiscardPile(ArrayList<Card> userInputDiscard){
        discardPile = userInputDiscard;
    }

    public ArrayList<Card> getPrizePile(){
       return prizePile;
    }

    public void setPrizePile(ArrayList<Card> userInputPrize){
        prizePile = userInputPrize;
    }
}

//Deck has 20-20-20 ratio
//Hand stats at 7 cards, draw one each turn
//Prize Pile Starts at 6 each pokemon knock out put on in your hand
//Discard pile all played cards go here
//save deck as csv then load as text
