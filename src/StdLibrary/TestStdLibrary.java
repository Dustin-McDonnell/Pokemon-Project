package StdLibrary;

import StdLibrary.StdLibrary;

import java.util.ArrayList;
import java.util.Collections;

public class TestStdLibrary {
    public static void main(String Args[]){
        StdLibrary test = new StdLibrary();
        //Declaring some sample numbers for testing
        double[] mySampleNumbersOdd = {1,2,3,4,5,6,7,8,9};
        double[] mySampleNumbersEven = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        double[] mySampleNumbersStd = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        double[] mySampleNumbersMode = {2,2,3,3,4,4,4};
        double testDouble = 5;

        //All the tests
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
        System.out.println("Expected of binomial distribution n=5 p=.4: " + test.expectedBinomialDistribution(5,.4));
        System.out.println("Variance of binomial distribution n=10 p=.2: " + test.varianceBinomialDistribution(10,.2,.8));
        System.out.println("Geometric Distribution Test with y = 5 p =.8:  " + test.geometricDistribution(.2,5,.8));
        System.out.println("Expected of geometric with p=.8: " + test.expectedGeometricDistribution(.8));
        System.out.println("Variance of geometric with p=.8: " + test.varianceGeometricDistribution(.8));
        System.out.println("Hypergeometric distribution of r=5, y=4, N=10, n=4, :" + test.hyperGeometricDistribution(5,4,10,4));
        System.out.println("Expected of hypergeometric distribution of n=5, N=10, r=4 " + test.expectedHyperGeometricDistribution(5,4,10));
        System.out.println("Variance of hypergeometric distribution of n=5,r=4,N=10: " + test.varianceHyperGeometricDistribution(5,4,10));
        System.out.println("Negative Binomial Distribution of y=5,r=4,p=.3,q=.7: " + test.negativeBinomialProbabilityDistribution(5,4,.3,.7));
        System.out.println("Expected of Negative Binomial Distribution of r=4, p=.3: " + test.expectedNegativeBinomialProbabilityDistribution(4,.3));
        System.out.println("Variance of Negative Binomial Distribution of r=4, p=.3: " + test.varianceNegativeBinomialProbabilityDistribution(4,.3));

    }
}
