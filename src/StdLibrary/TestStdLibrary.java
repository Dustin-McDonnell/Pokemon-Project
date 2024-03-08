package StdLibrary;

import StdLibrary.StdLibrary;

import java.util.ArrayList;
import java.util.Collections;

public class TestStdLibrary {
    public static void main(String Args[]){
        StdLibrary test = new StdLibrary();
        double[] mySampleNumbersOdd = {1,2,3,4,5,6,7,8,9};
        double[] mySampleNumbersEven = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        double[] mySampleNumbersStd = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        double[] mySampleNumbersMode = {2,2,3,3,4,4,4};
        double testDouble = 5;

        System.out.println("Mean of even sample numbers: " + test.findMean(mySampleNumbersEven));
        System.out.println("Median of odd sample numbers: " + test.findMedian(mySampleNumbersOdd));
        System.out.println("Mode of odd sample numbers: " + test.findMode(mySampleNumbersMode));
        System.out.println("Standard deviation: " + test.standardDeviation(mySampleNumbersStd));
        System.out.println("Factorial of 4: " + test.factorial(4));
        System.out.println("Factorial of 4 with big Integer: " + test.factorialBigInteger(4));
        System.out.println("Permutation test of 4 and 4: " + test.permutation(4,4) );
        System.out.println("Combination test of 4 and 4: " + test.combinations(4,4) );
        System.out.println("Binomial test with p of .4, 5 test, 3 successes: " + test.binomialDistribution(5,.4,.6,3));
        System.out.println("Conditional probability with .4 and 2: " + test.conditionalProbability(.4, .3));
        System.out.println("Independence test with p(2) and P(5): " + test.determineIndependence(2,5));

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

        System.out.println("Expected of binomial distribution n=5 p=.4: " + test.expectedBinomialDistribution(5,.4));
        System.out.println("Variance of binomial distribution n=10 p=.2: " + test.varianceBinomialDistribution(10,.2,.8));
        System.out.println("Geometric Distribution Test with y = 5 p =.8:  " + test.geometricDistribution(.2,5,.8));
        System.out.println("Expected of geometric with p=.8: " + test.expectedGeometricDistribution(.8));
        System.out.println("Variance of geometric with p=.8: " + test.varianceGeometricDistribution(.8));
        System.out.println("Hypergeometric distribution of r:5, y:4, N:10, n:4" + test.hyperGeometricDistribution(5,4,10,4));
        System.out.println("Expected of hypergeometric distribution");

    }
}
