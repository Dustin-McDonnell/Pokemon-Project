package Tests.PokemonSpecificTests;

import Pokemon.*;

public class TestDreepy {
    public static void main(String[] args){
        Dreepy dreep = new Dreepy();
        PunchingBag bag = new PunchingBag();
        dreep.attackOne(bag);
    }
}
