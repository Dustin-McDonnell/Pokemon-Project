public class TestMonte {
    public static void main(String[] args){
        MonteCarlo mont = new MonteCarlo();
        for (int i = 1; i <= 60; i++){
            mont.handPercentChance(i);
        }
    }
}
