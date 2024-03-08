package Parent;
import Pokemon.*;
import Energy.*;
import TrainerCards.*;
import java.util.*;

public class PokemonCardGame {
    //A deck of cards
    private ArrayList<Card> deck;//This is the constructors job = new Parent.Card[];
    private ArrayList<Card> hand;

    //Constructor Builds the Deck with 20 Pokemon, 10 Energy, 30 trainer Cards
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

    //Draw Card: Randomly chooses a card from the deck, adds it to the active Players Hand
    //then removes it from the Deck
    public Card drawCard(Player player) {
        Random rng = new Random();
        int cardIndex = rng.nextInt(player.getDeck().size()); //Find random card
        Card drawnCard = player.getDeck().get(cardIndex);
        player.getDeck().remove(cardIndex);
        return drawnCard;
    }

    //Draws 7 cards to the Active Players Hand
    public void drawHand(Player player) {
        for (int i = 0; i < 7; i++) {
            player.getHand().add(drawCard(player));
        }
    }
    //Draws 6 cards to the Active Players Prize Pile
    public void drawPrizePile(Player player) {
        for (int i = 0; i < 6; i++) {
            player.getPrizePile().add(drawCard(player));
        }
    }
    //Returns the entire Active Hand to the Deck then Shuffles it
    public void returnHand(Player player) {
        for (int i = 0; i < player.getHand().size(); i++) {
            player.getDeck().add(player.getHand().get(i));
        }
        shuffleDeck(player.getDeck());
        player.getHand().clear();
    }

    //Calls Collections.shuffle to simulate a deck shuffle
    public void shuffleDeck(ArrayList<Card> deck) {
        Collections.shuffle(deck);
    }

    //Checks if the opening hand contains a Pokemon Card
    public boolean evaluateHandContainsBasic(Player player) {
        for (int i = 0; i < player.getHand().size(); i++) {
            Card currentCard = player.getHand().get(i);
            if (currentCard.stage() == "Basic") {
                return true;
            }
        }
        return false;
    }

    //Copies the original Deck for each Player, Calls the methods for: assigns the copies to each Player
    //Shuffles the deck, draws the prize pile draws the initial hand of each player, checks if each initital hand contains a Pokemon
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

    //Prints the instructions for the game
    public void help(){
        System.out.println("'Hand to display your hand along with the use numbers.");
        System.out.println("'Activate' to use a card, Type the number of the card displayed in your hand you want to activate");
        System.out.println("'Prize' to display your prize pool, 'Bench' to show you your active Pokemon");
        System.out.println("'hp' to your Active Pokemon's remaining health");
        System.out.println("'Attack' to attack with your active Pokemon, you must choose attack to end your turn.");
    }

    //Shows the Pokemon on the Bench
    public void bench(Player player){
        if (player.getBench().size() != 0) {
            System.out.println("Current Bench: ");
            for (int i = 0; i < player.getBench().size(); i++) {
                System.out.println(player.getBench().get(i).getName() + " " + (i + 1));
            }
        } else {
            System.out.println("Your bench is empty.");
        }
    }
    //Displays the remaining hp of the active Pokemon
    public void hp(Player player){
        if (!player.getActive().isEmpty()){
            Pokemon card = (Pokemon) player.getActive().get(0);
            System.out.println(card.getHp());
        }
        else{
            System.out.println("No active pokemon.");
        }
    }
    //Shows the active Pokemon
    public void active(Player player){
        System.out.println("Active Pokemon: ");
        for (int i = 0; i < player.getActive().size(); i++) {
            System.out.println(player.getActive().get(i).getName());
        }
    }
    //Controls the turn, allows the player to choose what they want to do, calls the methods to do so
    //Ends the turn when Attack is chosen
    public void playerTurn(Player player, Player Opponent) {
        ArrayList<Card> playerHand = player.getHand();
        ArrayList<Card> playerDeck = player.getDeck();
        Scanner scan = new Scanner(System.in);
        Boolean turnStatus = true;
        Card draw = drawCard(player);
        player.getHand().add(draw);

        System.out.println("Current Hand: ");
        for (int i = 0; i < playerHand.size(); i++) {
            System.out.println(playerHand.get(i).getName() + " " + (i + 1));
        }

        while (turnStatus) {
            System.out.println("Enter a command Type 'Help' for options: ");
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("Help")) {
                help();
            }

            if (input.equalsIgnoreCase("Prize")) {
                prize(player);
            }

            if (input.equalsIgnoreCase("Bench")) {
                bench(player);
            }

            if (input.equalsIgnoreCase("hp")){
                hp(player);
            }

            if (input.equalsIgnoreCase("Activate")) {
                activate(player);
            }

            if (input.equalsIgnoreCase("Active")) {
                active(player);
            }

            if (input.contentEquals("hand")){
                hand(player);
            }

            if (input.equalsIgnoreCase("Attack")) {
                attack(player , Opponent);
                turnStatus = false;
                }
            }
        }
        //Displays the cards in the Active Players hand
        public void hand(Player player){
            System.out.println("Current Hand: ");
            for (int i = 0; i < player.getHand().size(); i++) {
                System.out.println(player.getHand().get(i).getName() + " " + (i + 1));
            }
        }
        //Displays the prize pile of the active player
        public void prize(Player player){
        Scanner scan = new Scanner(System.in);
            System.out.println("Current Prize Pile: ");
            for (int i = 0; i < player.getPrizePile().size(); i++) {
                System.out.println(player.getPrizePile().get(i).getName() + " " + (i + 1));
            }
        }
    //Activates the effect of the chosen card
    public void activate(Player player){
        Scanner scan = new Scanner(System.in);
        ArrayList<Card> playerHand = player.getHand();
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

                if(!player.getActive().isEmpty() && card instanceof Pokemon && player.getBench().size() > 5) {
                    System.out.println("You already have an active Pokemon! Pick another card!");
                    card = null;
                    cardPosition = -1;
                }

                if(!player.getActive().isEmpty() && card instanceof Pokemon){
                    System.out.println("You placed the Pokemon in your bench!");
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

    //Allows you to choose the attack of the active Pokemon
    public void attack(Player player, Player Opponent){
        Scanner scan = new Scanner(System.in);
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
    }
    //Lets the Player choose what prize they want added to their hand after
    //knocking out an opposing Pokemon
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

    //Checks after every turn for empty prize piles to declare the winner
    public boolean checkForWinner(Player player1, Player player2){
        if (player1.getPrizePile().isEmpty()){
            System.out.println("Player 1 wins!");
            return false;
        }
        if (player2.getPrizePile().isEmpty()){
            System.out.println("Player 2 wins!");
            return false;
        }
        else {
            return true;
        }
    }

    //Engine for the game and turn order
    public void runGame() {
        Player player1 = new Player();
        Player player2 = new Player();
        setUpGame(player1, player2);
        boolean running = true;

        while (running) {
            System.out.println("\nPlayer 1's Turn");
            playerTurn(player1, player2);
            running = checkForWinner(player1, player2);
            System.out.println("\nPlayer 2's Turn");
            playerTurn(player2, player1);
            running = checkForWinner(player1, player2);
        }


    }

}
