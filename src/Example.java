import java.util.ArrayList;
import java.util.Collections;
public class Example {
//Something that’s common in all stats classes that you take, is learning about
//central tendencies
//Mean, Median, Mode
//Mean? -> sum of elements divided by count. Another word for it could be "Expected"
public double findMean(int[] userInput){
    //2 options, using an array or an array list
    //find the sum
    int sum = 0;
    for(int i = 0; i < userInput.length; i++){
       sum = userInput[i] + sum; //I'm aware you guys may know +=
    }
    double result = sum / userInput.length;
    return result;
}

public double findMedian(int[] userInput){

    ArrayList<Integer> test = new ArrayList<>();
    for (int i = 1; i <= userInput.length; i++){
        test.add(i);
    }
    Collections.sort(test); //Sort test list in order for median
    int size = userInput.length;
    double median = 0;

    if (size % 2 != 0){
        for(int i = 0; i < userInput.length/2 + 1; i++){
            median = userInput[i];
        }
        }

    if (size % 2 == 0){
        for(int i = 0; i < userInput.length/2; i++){
            median = (userInput[i] + userInput[i+1]);
        }
        median = median / 2;    
        }
    
    return median;
}

public int findMode(int[] userInput){
    int highest = 1;
    int mode = -1;
for (int i = 0; i < userInput.length; i++){
    int count = 0;
    for (int k = 0; k < userInput.length; k++){
        if (userInput[i] == userInput[k]){
            count ++;
            if (count > highest){
                highest = count;
                mode = userInput[i];
            }
        }
        
    }
}
if (mode != -1){
    return mode;
}
else{
    System.out.println("If the mode is -1 there is no mode.");
    return -1;
}
}

//Median -> Either the middle number if odd, or "average" of the two middlest numbers.
//The list must be ordered, so order the list before finding median. Should be able to call 
//collections sort or arraylist sort of some kind
//Mode -> Is the number that occurs the most, but it must be unique, no 2 or more modes
}

//warmup write a program that can find mean median and mode
//after that write a tester class to try it out

//Homework
//Write the Median and Mode Method
//Redraw hand and evaluate hand 1000 times find the odds of finding a pokemon modify run method 