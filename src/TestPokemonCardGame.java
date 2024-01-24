public class TestPokemonCardGame {
    //Add a dragonite
    public static void main(String[] args){

        PokemonCardGame[] test = new PokemonCardGame[60];
        for (int i = 0; i < 60; i++){
            test[i] = new PokemonCardGame(i+1);
            test[i].averageHandDraw();
            test[i].handPercentChance();
        }
        
    }
}
