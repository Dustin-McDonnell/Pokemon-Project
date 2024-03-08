package Tests;

import Pokemon.Bulbasaur;
import Pokemon.Pikachu;

public class TestPikachu {
    public static void main(String[] args){
        Pikachu pikaMain = new Pikachu();
        Pikachu pikaTarget = new Pikachu();
        Bulbasaur newBulb = new Bulbasaur();

        System.out.println("Pokemon.Bulbasaur use leech seed!");
        newBulb.leechSeed(pikaMain);
        System.out.println("Pika Main Hp: " + pikaMain.getHp());
        System.out.println("New Bulb Hp: " + newBulb.getHp());

        pikaMain.quickAttack(newBulb);

        while(pikaTarget.getHp() > 0) {
            System.out.println("PIKACHU USE QUICK ATTACK!");
            pikaMain.quickAttack(pikaTarget);
            System.out.println("Pika Target Hp: " + pikaTarget.getHp());
        }
    }
}
