package StdLibrary;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class StdLibrary {
    //Finds the mean
    public double findMean(double[] userInput){
        //2 options, using an array or an array list
        //find the sum
        double sum = 0;
        for(int i = 0; i < userInput.length; i++){
            sum = userInput[i] + sum; //I'm aware you guys may know +=
        }
        double result = sum / userInput.length;
        return result;
    }

    //Finds the Median
    public double findMedian(double[] userInput){

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

    //Finds the mode
    public Double findMode(double[] userInput){
        int highest = 1;
        Double mode = null;
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
        if (mode != null){
            return mode;
        }
        else{
            return mode;
        }
    }
    //Finds Standard Deviation
    public Double standardDeviation(double[] userInput){
        double mean = findMean(userInput);
        double variance = 0;

        for (int i = 0; i < userInput.length; i++){
            userInput[i] = userInput[i] - mean;
            userInput[i] = userInput[i] * userInput[i];
            variance += userInput[i];
        }
        variance = variance/(userInput.length - 1);
        variance = Math.sqrt(variance);
        return variance;
    }

    //Finds the factorial of a number using long
    public long factorial(long userInput){
        long result = 1;
        for (long i = userInput; i > 0; i --){
            result = result * i;
        }
        return result;
    }
    //Finds the factorial of a number using double
    public double factorial(double userInput){
        double result = 1;
        for (double i = userInput; i > 0; i --){
            result = result * i;
        }
        return result;
    }

    //Finds the factorial of a number using big integer
    public BigInteger factorialBigInteger(long userInput){
        BigInteger result = BigInteger.valueOf(1);
        for (long i = userInput; i > 0; i--){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;

    }
    //Finds the permutation of N and R
    public Double permutation(double userInputN, double userInputR){
        double nFactorial = factorial(userInputN);
        double denominator = userInputN - userInputR;
        return nFactorial/factorial(denominator);
    }

    //Finds the combinations
    public Double combinations(double userInputN, double userInputR){
        double nFactorial = factorial(userInputN);
        double denominator = userInputN - userInputR;
        denominator = factorial(denominator) * factorial(userInputR);
        return nFactorial/denominator;
        }

        //Finds the binomial distribution
    public Double binomialDistribution(double trials, double successProb, double fail, double successNumber){
        double combination = combinations(trials, successNumber);
        successProb = Math.pow(successProb, successNumber);
        fail = Math.pow(fail, trials - successNumber);
        double answer = combination * successProb * fail;
        return answer;
    }

    //Finds the conditional probability
    public Double conditionalProbability(double aIntersectB, double b){
        double conditionalProbability = aIntersectB/b;
        return conditionalProbability;
    }

    //Determines independence between a conditional probability and an event
    public Boolean determineIndependence(double conditional, double firstEvent){
        if (conditional == firstEvent){
            return true;
        }
        return false;
    }

    //Determines independence between an intersection and events A and B
    public Boolean determineIndependence(double aIntersectB, double a, double b){
        if(aIntersectB == a*b){
            return true;
        }
        return false;
    }

    public Double additiveLop(double a, double b, double aIntersectB){
        double result = (a+b) - aIntersectB;
        return result;
    }

    public Double additiveLop(double a, double b){
        double result = a+b;
        return result;
    }

    //Finds the maen of binomial distribution
    public double expectedBinomialDistribution(double n, double p){
        double expected = n * p;
        return expected;
    }
    //Finds the variance of binomial distribution
    public double varianceBinomialDistribution(double n, double p, double q){
        double variance = n * p * q;
        return variance;
    }
    //Finds the geometric distribution
    public double geometricDistribution(double q, double y, double p){
        q = Math.pow(q, y-1);
        double result = q*p;
        return result;
    }
    //Finds the mean of Geometric Distribution
    public double expectedGeometricDistribution(double p){
        double result = 1/p;
        return result;
    }
    //Finds the variance of Geometric Distribution
    public double varianceGeometricDistribution(double p){
        double numerator = 1 - p;
        double denominator = Math.pow(p,2);
        double result = numerator/denominator;
        return result;
    }
    //Finds the HyperGeometric Distribution
    public double hyperGeometricDistribution(double r, double y, double N, double n){
        double numerator = permutation(r,y) * permutation(N-r,n-y);
        double denominator = permutation(N,n);
        double result = numerator/denominator;
        return result;
    }
    //Finds the mean of the HyperGeometricDistribution
    public double expectedHyperGeometricDistribution(double n, double r, double N){
        double result = (n*r)/N;
        return result;
    }
    //Finds the variance of the HyperGeometric Distribution
    public double varianceHyperGeometricDistribution(double n, double r, double N){
        double result = n * (r/n) * ((N-r)/N) * ((N-n)/(N-1));
        return result;
    }
    //Finds the NegativeBinomial Probability Distribution
    public double negativeBinomialProbabilityDistribution(double y, double r, double p, double q){
        Math.pow(p,r);
        double result = combinations(y-1,r-1) * Math.pow(p,r) * Math.pow(q,(y-r));
        return result;
    }
    //Finds the mean of the Negative Binomial Probability Distribution
    public double expectedNegativeBinomialProbabilityDistribution(double r, double p){
        double result = r/p;
        return result;
    }

    //Finds the variance of the Negative Binomial Probability Distributionb
    public double varianceNegativeBinomialProbabilityDistribution(double r, double p){
        double result = (r*(1-p))/Math.pow(p,2);
        return result;
    }

    }


