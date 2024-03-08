package StdLibrary;

import StdLibrary.SetOperations;

import java.util.ArrayList;
import java.util.Collections;

public class TestSetOperations {
    public static void main(String[] args){
        SetOperations setO = new SetOperations();
        ArrayList<String> mySetOperationString = new ArrayList<String>();
        ArrayList<String> mySubSetOperationString = new ArrayList<String>();

        ArrayList<Double> mySetOperationDouble = new ArrayList<Double>();
        ArrayList<Double> mySubSetOperationDouble = new ArrayList<Double>();

        ArrayList<Integer> mySetOperationInt = new ArrayList<Integer>();
        ArrayList<Integer> mySubSetOperationInt = new ArrayList<Integer>();

        //Learned below here https://ioflood.com/blog/java-arraylist-add/#:~:text=addAll()%20method%20is%20another,ArrayList%20in%20a%20single%20line.&text=In%20this%20example%2C%20we%20use,ArrayList%20in%20a%20single%20line.
        Collections.addAll(mySetOperationString, "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday");
        Collections.addAll(mySubSetOperationString, "Monday","Wednesday","Friday");

        Collections.addAll(mySetOperationDouble, 1.1,2.2,3.3,4.4,5.5);
        Collections.addAll(mySubSetOperationDouble, 2.2,5.5);

        Collections.addAll(mySetOperationInt, 2,4,6,8,10);
        Collections.addAll(mySubSetOperationInt,4,8);
        //This is causing issues, array lists are mutable from anywhere, do I make a copy?
        //For now just run them one at a time

        setO.union(mySetOperationInt, mySubSetOperationInt);
        setO.complement(mySetOperationString, mySubSetOperationString);
        setO.intersection(mySetOperationDouble, mySubSetOperationDouble);
    }
}
