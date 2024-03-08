package TrainerCards;

import Parent.*;


import java.util.ArrayList;
import java.util.Scanner;

//Creates a secondary Array of all the Pokemon in the deck and allows the active player to choose
//one to add to their hand. I lost the implementation that was written in class, so I hope this isn't too
//offensive to the eye.

public class NestBall extends Trainer {
    public NestBall(){
        setName("Nest Ball");
    }

    public void activate(Player player){
        Scanner scan = new Scanner(System.in);
        ArrayList<Card> cards = player.getDeck();

        for (int i = 0; i < player.getDeck().size(); i++) {
            if (player.getDeck().get(i) instanceof Pokemon) {
                System.out.println(cards.get(i).getName() + " " + (i + 1));
            }
        }

            System.out.println("Enter the position number of the pokemon you want added to your hand.");
        int chosenCard = scan.nextInt();
        player.getHand().add(cards.get(chosenCard - 1));
        System.out.println(player.getHand().getLast().getName() + " added!");
        cards.remove(chosenCard - 1);
        }
    }

