package Parent;
import Pokemon.*;
import Energy.*;
import TrainerCards.*;

import Parent.Card;
import Parent.Player;
import Parent.Pokemon;

import java.util.*;

//A charizard deck needs to find a rare candy to have a chance at winning,
//what if, a rare candy wasnt in the deck? i.e it was in the prize pile
//Write a monte carlo sim adding 1, then 2, then 3, then 4, rare candy trainer cards into
//your deck, find the odds, given that a pokemon was in the opening hand, what are the odds
//that your deck is "bricked". Whats? the probability that your rare candy is in your prize pile?
//15 pokemon in the deck, 10 energy, rest trainer, (4 rare candy)

public class PokemonCardGame {
    //A deck of cards
    private ArrayList<Card> deck;//This is the constructors job = new Parent.Card[];
    private ArrayList<Card> hand;

    public PokemonCardGame() {
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            deck.add(new Dreepy());
        }
        for (int i = 5; i < 10; i++){
            deck.add(new PunchingBag());
        }
        for(int i = 10; i < 20; i++){
            deck.add(new Dratini());
        }
        for (int i = 20; i < 30; i++) {
            deck.add(new PsychicEnergy());
        }
        for (int i = 30; i < 40; i++){
            deck.add(new NestBall());
        }
        for (int i = 40; i < 50; i++) {
            deck.add(new ProfessorsResearch());
        }
        for (int i = 50; i < 60; i++){
            deck.add(new Potion());
        }
    }

    public PokemonCardGame(int rareCandy) {
        deck = new ArrayList<>();
        hand = new ArrayList<>();

       for(int i = 0; i < rareCandy; i++){
           deck.add(new RareCandy());
       }
       for(int i = 4; i < 15; i++){
           deck.add(new Dreepy());
       }
       for(int i = 15; i < 25; i++){
           deck.add(new FireEnergy());
       }
       for(int i = 25; i < (60 - deck.size()); i++){
           deck.add(new Potion());
       }
    }

    public Card drawCard() {
        Random rng = new Random();
        int cardIndex = rng.nextInt(deck.size()); //Find random card
        Card drawnCard = deck.get(cardIndex);
        deck.remove(cardIndex);
        return drawnCard;
    }

    public Card drawCard(Player player) {
        Random rng = new Random();
        int cardIndex = rng.nextInt(player.getDeck().size()); //Find random card
        Card drawnCard = player.getDeck().get(cardIndex);
        player.getDeck().remove(cardIndex);
        return drawnCard;
    }

    public void drawHand() {
        for (int i = 0; i < 7; i++) {
            hand.add(drawCard());
        }
    }

    public void drawHand(Player player) {
        for (int i = 0; i < 7; i++) {
            player.getHand().add(drawCard(player));
        }
    }

    public void drawPrizePile(Player player) {
        for (int i = 0; i < 6; i++) {
            player.getPrizePile().add(drawCard(player));
        }
    }

    public void returnHand() {
        for (int i = 0; i < hand.size(); i++) {
            deck.add(hand.get(i));
        }
        hand.clear();
    }

    public void returnHand(Player player) {
        for (int i = 0; i < player.getHand().size(); i++) {
            player.getDeck().add(player.getHand().get(i));
        }
        player.getHand().clear();
    }

    public void discardHand() {
        hand.clear();
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void shuffleDeck(ArrayList<Card> deck) {
        Collections.shuffle(deck);
    }


    public boolean evaluateOpeningHand() {
        for (int i = 0; i < hand.size(); i++) {
            Card currentCard = hand.get(i);
            if (currentCard instanceof Pokemon) {
                return true;
            }
        }
        return false;
    }

    public boolean evaluateHandContainsBasic(Player player) {
        for (int i = 0; i < player.getHand().size(); i++) {
            Card currentCard = player.getHand().get(i);
            if (currentCard.stage() == "Basic") {
                return true;
            }
        }
        return false;
    }


    //Make engine for program
    public void averageHandDraw() {
        int counter = 0;
        int hasCard = 0;
        for (int i = 0; i < 1000; i++) {
            boolean result = false;
            do {
                counter++;
                drawHand();
                result = evaluateOpeningHand();
                returnHand();
                shuffleDeck();
            }
            while (!result);
        }
        System.out.println("Average amount of hands to draw for a pokemon after a thousand tests: " + counter / 1000);
    }

    public void setUpGame(Player player1, Player player2) {
        ArrayList<Card> copyDeck1 = new ArrayList<Card>(deck);
        ArrayList<Card> copyDeck2 = new ArrayList<Card>(deck);
        player1.setDeck(copyDeck1);
        player2.setDeck(copyDeck2);

        ArrayList<Card> playerDeck1 = player1.getDeck();
        ArrayList<Card> playerDeck2 = player2.getDeck();

        shuffleDeck(playerDeck1);
        shuffleDeck(playerDeck2);

        drawPrizePile(player1);
        drawPrizePile(player2);

        drawHand(player1);
        drawHand(player2);

        //This might be causing a bound error! Don't forget about this!
        while (!evaluateHandContainsBasic(player1)) {
            returnHand(player1);
            drawHand(player1);
            player2.getHand().add(drawCard(player2));
        }

        while (!evaluateHandContainsBasic(player2)) {
            returnHand(player2);
            drawHand(player2);
            player1.getHand().add(drawCard(player1));
        }
    }


    public void playerTurn(Player player, Player Opponent) {
        ArrayList<Card> playerHand = player.getHand();
        ArrayList<Card> playerDeck = player.getDeck();
        Scanner scan = new Scanner(System.in);
        Boolean turnStatus = true;
        Card draw = drawCard(player);
        player.getHand().add(draw);

        System.out.println("Current Hand: ");
        System.out.println("Enter a command Type 'Help' for options: ");
        for (int i = 0; i < playerHand.size(); i++) {
            System.out.println(playerHand.get(i).getName() + " " + (i + 1));
        }

        while (turnStatus) {
            String input = scan.nextLine();

            if (input.contentEquals("Help")) {
                System.out.println("'Hand' to display your hand, Type the number of the card you want to activate.");
            }

            if (input.contentEquals("Prize")) {
                System.out.println("Current Prize Pile: ");
                for (int i = 0; i < player.getPrizePile().size(); i++) {
                    System.out.println(player.getPrizePile().get(i).getName() + " " + (i + 1));
                }
            }

            if (input.contentEquals("Bench")) {
                if (player.getBench().size() != 0) {
                    System.out.println("Current Bench: ");
                    for (int i = 0; i < player.getBench().size(); i++) {
                        System.out.println(player.getBench().get(i).getName() + " " + (i + 1));
                    }
                } else {
                    System.out.println("Your bench is empty.");
                }
            }

            if (input.contentEquals("hp")){
                if (!player.getActive().isEmpty()){
                    Pokemon card = (Pokemon) player.getActive().get(0);
                    System.out.println(card.getHp());
                }
                else{
                    System.out.println("No active pokemon.");
                }
            }

            if (input.contentEquals("Activate")) {
                int cardPosition = -1;

                do{
                    try{
                        System.out.println("Enter the number position of the card you want to activate, or cancel to exit");
                        String stringCardPosition = scan.next();

                        if(stringCardPosition.equalsIgnoreCase("cancel")){
                            break;
                        }

                        cardPosition = Integer.parseInt(stringCardPosition) - 1;
                        Card card = playerHand.get(cardPosition);

                        if(!player.getActive().isEmpty() && card instanceof Pokemon) {
                            System.out.println("You already have an active Parent.Pokemon! Pick another card!");
                            card = null;
                            cardPosition = -1;
                        }

                        playerHand.remove(cardPosition);
                        card.activate(player);
                        System.out.println(card.getName() + " activated!");
                    }
                    catch (NumberFormatException | IndexOutOfBoundsException | NullPointerException e){
                        //https://stackoverflow.com/questions/3572160/how-to-handle-infinite-loop-caused-by-invalid-input-inputmismatchexception-usi
                        System.out.println("Enter a valid number.");
                    }

                }while(cardPosition < 0 || cardPosition > playerHand.size());

            }

            if (input.contentEquals("Active")) {
                System.out.println("Active Parent.Pokemon: ");
                for (int i = 0; i < player.getActive().size(); i++) {
                    System.out.println(player.getActive().get(i).getName());
                }
            }

            if (input.contentEquals("hand")){
                System.out.println("Current Hand: ");
                for (int i = 0; i < playerHand.size(); i++) {
                    System.out.println(playerHand.get(i).getName() + " " + (i + 1));
                }
            }

            if (input.contentEquals("Attack")) {

                if (!Opponent.getActive().isEmpty() && !player.getActive().isEmpty()) {
                    System.out.println("Enter which attack number you wish to use. 1 or 2");
                    String attack = scan.nextLine();
                    Card active = player.getActive().get(0);
                    Pokemon enemy = (Pokemon) Opponent.getActive().get(0);
                    switch (attack) {
                        case "1":
                            active.attackOne(enemy);
                        case "2":
                            active.attackTwo(enemy);
                    }
                    if(enemy.getHp() <= 0) {
                        System.out.println("Enemy " + enemy.getName() + " fainted!");
                        Opponent.getActive().clear();
                        choosePrize(player);
                    }
                }
                turnStatus = false;

            }
        }

    }

    public void choosePrize(Player player){
        Scanner scan = new Scanner(System.in);
        ArrayList<Card> playerHand = player.getHand();

        int prize = -1;

        System.out.println("Choose a prize card.");
        System.out.println("Prize pool: ");

        for (int i = 0; i < player.getPrizePile().size(); i++) {
            System.out.println(player.getPrizePile().get(i).getName() + " " + (i + 1));
        }
        do{
            try{
                prize = scan.nextInt() - 1;
                if(prize < 0 || prize >= player.getPrizePile().size()){
                    System.out.println("Please choose a valid prize number.");
                }
                player.getHand().add(player.getPrizePile().get(prize));
                player.getPrizePile().remove(prize);
            }
            catch (InputMismatchException | NullPointerException e){
                System.out.println("Please choose a valid prize number.");
            }
        }while(prize < 0 || prize > player.getPrizePile().size());
    }

    public boolean checkForWinner(Player player1, Player player2){
        if (player1.getPrizePile().isEmpty()){
            System.out.println("Parent.Player 1 wins!");
            return false;
        }
        if (player2.getPrizePile().isEmpty()){
            System.out.println("Parent.Player 2 wins!");
            return false;
        }
        else {
            return true;
        }
    }


    public void runGame() {
        Player player1 = new Player();
        Player player2 = new Player();
        setUpGame(player1, player2);
        boolean running = true;

        while (running) {
            System.out.println("\nParent.Player 1's Turn");
            playerTurn(player1, player2);
            running = checkForWinner(player1, player2);
            System.out.println("\nParent.Player 2's Turn");
            playerTurn(player2, player1);
            running = checkForWinner(player1, player2);
        }


    }

}
//MONTE CARLO
//Unwire the monte carlo sim if it's wired too tightly, bonues points
//show me the monte carlo simulation abstracted out completely from the "game" class

//ADD INTERFACE
//We want to program to an interface. So write an interface (programming 2)
//name it Parent.Attackable() and give it 2 abstract methods, attackOne() and attackTwo()
//We want in each of the pokemon, say pikachu, to implement the interface
//ie.  public class Pokemon.Pikachu extends Parent.Pokemon implements Parent.Attackable
//Update the methods to attack 1 and 2, make global variables String attackOneName, attackTwoName
//The main purpose of this interface inclusion is to let you add userinterface to simply attack
//by choosing attack1 or attack2 instead of searching for a name

//ADD A TRAINER CARD
//We'll use "Professor's Research" discard hand and draw seven cards
//Rebuild deck using equal parts PR, Parent.Energy, and Charmander

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
//In the Parent.Pokemon game class, write a method called "runGame" it will have a while loop
//Outside of the loop, have a setUpGame() method
//"While either player has prize cards remaining, continue"
//      playerOneTurn()
//      playerTwoTurn()
//Parent.Player deck 20 pokemon, 20 energy, 20 trainer
//Parent.Player has a PokemonBench Pile Max 5 Parent.Pokemon
//Active Parent.Pokemon Pile Max 1 Parent.Pokemon

//PLAYER TURN
//Draw 1 card.
//Play Parent.Pokemon, as many as you want
//Play Parent.Energy
//Play Parent.Trainer, I believe there are restrictions
//Attack with pokemon
//End turn