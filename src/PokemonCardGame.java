import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
//60 card deck, in order to take a turn you need to have a basic pokemon in your hand
//monte carlo simulation?
//Let's write a monte carlo simulation. That means, using raw brute force, try to figure out
//something interesting
//What if your deck had exactly 1 pokemon. How many times would you expect to have to mulligan in order to
//have your only pokemon
//What if your deck had 2? Etc.
//Write a simulation that shows the expected mulligans at 1-60 pokemon in your deck.
public class PokemonCardGame {
    //A deck of cards
    private ArrayList<Card> deck1;//This is the constructors job = new Card[];
    private ArrayList<Card> deck2;
    private ArrayList<Card> hand;

    public PokemonCardGame(){
        deck1 = new ArrayList<Card>();
        deck2 = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        for (int i = 0; i < 20; i++){
            deck1.add(new Dreepy());
            deck2.add(new Dreepy());
        }
        int deckSize = 60;
        for(int i = 20; i < 40; i++){
            deck1.add(new PsychicEnergy());
            deck2.add(new PsychicEnergy());
        }
        for(int i = 40; i < 60; i++){
            deck1.add(new ProfessorsResearch());
            deck2.add(new ProfessorsResearch());
        }
    }

    public PokemonCardGame(int pCards){
        System.out.println("Number of Pokemon Cards in deck: " + pCards);
        deck1 = new ArrayList<Card>();
        hand = new ArrayList<Card>();
        for (int i = 0; i < pCards; i++){
            deck1.add(new Pokemon());
        }
        int deckSize = 60;
        for(int i = pCards; i < deckSize; i++){
            deck1.add(new Energy());
        }
    }

    public Card drawCard(){
        Random rng = new Random();
        int cardIndex = rng.nextInt(deck1.size()); //Find random card
        Card drawnCard = deck1.get(cardIndex);
        deck1.remove(cardIndex);
        return drawnCard;
    }

    public Card drawCard(ArrayList<Card> deck){
        Random rng = new Random();
        int cardIndex = rng.nextInt(deck.size()); //Find random card
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }

    public void drawHand(){
        for (int i = 0; i < 7; i ++){
            hand.add(drawCard());
        }
    }

    public void drawHand(ArrayList<Card> playerHand, ArrayList<Card> deck){
        for (int i = 0; i < 7; i ++){
            playerHand.add(drawCard(deck));
        }
    }

    public void drawPrizePile(ArrayList<Card> playerPrizePile, ArrayList<Card> deck){
        for (int i = 0; i < 6; i ++){
            playerPrizePile.add(drawCard(deck));
        }
    }

    public void returnHand(){
        for (int i = 0; i < hand.size(); i++){
            deck1.add(hand.get(i));
        }
        hand.clear();
    }

    public void discardHand(){
        hand.clear();
    }

    public void shuffleDeck(){
        Collections.shuffle(deck1);
    }
    public void shuffleDeck(ArrayList<Card> deck){
        Collections.shuffle(deck);
    }

    
    public boolean evaluateOpeningHand(){
        for (int i = 0; i < hand.size(); i++){
            Card currentCard = hand.get(i);
            if(currentCard instanceof Pokemon){
                return true;
            }
        }
        return false;
    }


//Make engine for program
public void averageHandDraw(){
    int counter = 0;
    int hasCard = 0;
    for (int i = 0; i < 1000; i++){
    boolean result = false;
    do{
        counter ++;
        drawHand();
        result = evaluateOpeningHand();
        returnHand();
        shuffleDeck();
    }
    while(result == false);
}
    System.out.println("Average amount of hands to draw for a pokemon after a thousand tests: " + counter/1000);
}

public void setUpGame(){
    Player playerOne = new Player();
    Player playerTwo = new Player();
    playerOne.setDeck(deck1);
    playerTwo.setDeck(deck2);

    ArrayList<Card> playerDeck1 = playerOne.getDeck();
    ArrayList<Card> playerDeck2 = playerTwo.getDeck();

    shuffleDeck(playerDeck1);
    shuffleDeck(playerDeck2);

    drawPrizePile(playerOne.getPrizePile(), playerDeck1);
    drawPrizePile(playerTwo.getPrizePile(), playerDeck2);

    drawHand(playerOne.getHand(), playerDeck1);
    drawHand(playerTwo.getHand(), playerDeck2);

    System.out.println("Player 1 Prize Pile: " + playerOne.getPrizePile());
    System.out.println("Player 2 Prize Pile: " + playerTwo.getPrizePile());


}

public void runGame(){

}

}
//MONTE CARLO
//Unwire the monte carlo sim if it's wired too tightly, bonues points
//show me the monte carlo simulation abstracted out completely from the "game" class

//ADD INTERFACE
//We want to program to an interface. So write an interface (programming 2)
//name it Attackable() and give it 2 abstract methods, attackOne() and attackTwo()
//We want in each of the pokemon, say pikachu, to implement the interface
//ie.  public class Pikachu extends Pokemon implements Attackable
//Update the methods to attack 1 and 2, make global variables String attackOneName, attackTwoName
//The main purpose of this interface inclusion is to let you add userinterface to simply attack
//by choosing attack1 or attack2 instead of searching for a name

//ADD A TRAINER CARD
//We'll use "Professor's Research" discard hand and draw seven cards
//Rebuild deck using equal parts PR, Energy, and Charmander

//SOFTWARE ENGINEERING PORTION
//Let's correctly organize your game
//We'll have PokemonGame class which has two players, player1 and player2
//Create a PLayer Object, will have arraylist of a deck, a hand, prize pile, a discard pile
//Any print methods the game needs
//Print hand
//Print field
//Print Prize
//Print card stats

//CREATE A GAME ENGINE
//In the Pokemon game class, write a method called "runGame" it will have a while loop
//Outside of the loop, have a setUpGame() method
//"While either player has prize cards remaining, continue"
//      playerOneTurn()
//      playerTwoTurn()
//Player deck 20 pokemon, 20 energy, 20 trainer
//Player has a PokemonBench Pile Max 5 Pokemon
//Active Pokemon Pile Max 1 Pokemon

//PLAYER TURN
//Draw 1 card.
//Play Pokemon, as many as you want
//Play Energy
//Play Trainer, I believe there are restrictions
//Attack with pokemon
//End turn