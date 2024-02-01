public class ProfessorsResearch extends Trainer{
    public void discardRedraw(){
        PokemonCardGame run = new PokemonCardGame();
        run.discardHand();
        run.drawHand();
    }
}
