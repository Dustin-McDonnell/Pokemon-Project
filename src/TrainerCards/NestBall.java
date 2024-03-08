package TrainerCards;

import Parent.*;


import java.util.ArrayList;
import java.util.Scanner;

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
        cards.remove(chosenCard - 1);
        System.out.println(cards.get(chosenCard-1).getName() + " added!");
        }
    }

