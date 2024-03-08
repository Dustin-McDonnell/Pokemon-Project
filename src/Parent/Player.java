package Parent;
import java.util.ArrayList;


//Player class with Getters and Setters for the variables
public class Player {
        private ArrayList<Card> deck = new ArrayList<>();
        private ArrayList<Card> hand = new ArrayList<>();
        private ArrayList<Card> discardPile = new ArrayList<>();
        private ArrayList<Card> prizePile = new ArrayList<>();
        private ArrayList<Card> bench = new ArrayList<>();
        private ArrayList<Card> active = new ArrayList<>();

    public ArrayList<Card> getActive(){
        return active;
    }

    public void setActive(ArrayList<Card> userInputActive){
        active = userInputActive;
    }

    public ArrayList<Card> getBench(){
        return bench;
    }

    public void setBench(ArrayList<Card> userInputBench){
        bench = userInputBench;
    }

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
