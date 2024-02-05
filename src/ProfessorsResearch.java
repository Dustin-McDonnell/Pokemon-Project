import java.util.ArrayList;

public class ProfessorsResearch extends Trainer{
    public ProfessorsResearch(){
        setName("Professor's Research");
    }
    public void discardRedraw(){
        PokemonCardGame run = new PokemonCardGame();
        run.discardHand();
        run.drawHand();

    }
}
