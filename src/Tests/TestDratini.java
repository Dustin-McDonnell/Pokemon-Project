package Tests;

import Parent.Pokemon;
import Pokemon.*;
public class TestDratini{
    public static void main(String[] args) {
        Pokemon dratini = new Dratini();
        System.out.println(dratini instanceof Pokemon);
    }
}