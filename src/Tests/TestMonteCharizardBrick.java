package Tests;

public class TestMonteCharizardBrick {
    public static void main(String[] args){
        MonteCarloCharizardBrick test = new MonteCarloCharizardBrick();
        for(int i = 1; i <= 4; i++) {
            test.brickChance(i);
        }

    }
}
