package Tests;

public class TestMonteCardDraw {
    public static void main(String[] args){
        MonteCarloCardDraw mont = new MonteCarloCardDraw();
        for (int i = 1; i <= 60; i++){
            mont.handPercentChance(i);
        }
    }
}
