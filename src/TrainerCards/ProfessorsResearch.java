package TrainerCards;

import Parent.*;

public class ProfessorsResearch extends Trainer {
    public ProfessorsResearch(){
        setName("Professor's Research");
    }
    public void activate(Player player){
        player.getHand().clear();
        for(int i = 0; i < 7; i++){
            player.getHand().add(player.getDeck().get(i));
            player.getDeck().remove(i);
        }
        System.out.println("New hand drawn!");
    }
}
