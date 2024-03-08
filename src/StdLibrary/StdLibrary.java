package StdLibrary;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class StdLibrary {
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

    public long factorial(long userInput){
        long result = 1;
        for (long i = userInput; i > 0; i --){
            result = result * i;
        }
        return result;
    }

    public double factorial(double userInput){
        double result = 1;
        for (double i = userInput; i > 0; i --){
            result = result * i;
        }
        return result;
    }

    public BigInteger factorialBigInteger(long userInput){
        BigInteger result = BigInteger.valueOf(1);
        for (long i = userInput; i > 0; i--){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;

    }
    //Wire the pokemon game to another terminal
    public Double permutation(double userInputN, double userInputR){
        double nFactorial = factorial(userInputN);
        double denominator = userInputN - userInputR;
        return nFactorial/factorial(denominator);
    }

    public Double combinations(double userInputN, double userInputR){
        double nFactorial = factorial(userInputN);
        double denominator = userInputN - userInputR;
        denominator = factorial(denominator) * factorial(userInputR);
        return nFactorial/denominator;
        }

    public Double binomialDistribution(double trials, double successProb, double fail, double successNumber){
        double combination = combinations(trials, successNumber);
        successProb = Math.pow(successProb, successNumber);
        fail = Math.pow(fail, trials - successNumber);
        double answer = combination * successProb * fail;
        return answer;
    }

    public Double conditionalProbability(double aIntersectB, double b){
        double conditionalProbability = aIntersectB/b;
        return conditionalProbability;
    }

    public Boolean determineIndependence(double conditional, double firstEvent){
        if (conditional == firstEvent){
            return true;
        }
        return false;
    }

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

    //https://www.tutorialspoint.com/java/java_generics.htm This is where I learned about generics
    //This seems horribly inefficient
    public <T, K> void union(ArrayList<T> set, ArrayList<K> subSet) {
        //Remove Duplicates
        for (int i = 0; i < subSet.size(); i++) {
            for (int k = 0; k < set.size(); k++) {
                //Why does .equals() work but not ==
                if (subSet.get(i).equals(set.get(k))) {
                    set.remove(k);
                }
            }
        }
        //Unions the sets
        for (int j = 0; j < subSet.size(); j++) {
            set.add((T) subSet.get(j));
        }
        System.out.println("Union of set and subset, not sorted: " + set);
    }

    public <T, K> ArrayList<T> complement(ArrayList<T> set, ArrayList<K> subSet) {
        //Remove Duplicates
        for (int i = 0; i < subSet.size(); i++) {
            for (int k = 0; k < set.size(); k++) {
                if (subSet.get(i).equals(set.get(k))) {
                    set.remove(k);
                }
            }
        }
        System.out.println("Complement of subset: " + set);
        return set;
    }

    public <T, K> void intersection(ArrayList<T> set, ArrayList<K> subSet) {
        //Remove Duplicates
        ArrayList<T> intersectSet = new ArrayList<T>();
        for (int i = 0; i < subSet.size(); i++) {
            for (int k = 0; k < set.size(); k++) {
                if(subSet.get(i).equals(set.get(k))){
                    intersectSet.add(set.get(k));
                }
            }
        }
        System.out.println("Intersection of set and subset: " + intersectSet);
    }

    public double expectedBinomialDistribution(double n, double p){
        double expected = n * p;
        return expected;
    }

    public double varianceBinomialDistribution(double n, double p, double q){
        double variance = n * p * q;
        return variance;
    }

    public double geometricDistribution(double q, double y, double p){
        q = Math.pow(q, y-1);
        double result = q*p;
        return result;
    }

    public double expectedGeometricDistribution(double p){
        double result = 1/p;
        return result;
    }

    public double varianceGeometricDistribution(double p){
        double numerator = 1 - p;
        double denominator = Math.pow(p,2);
        double result = numerator/denominator;
        return result;
    }

    public double hyperGeometricDistribution(double r, double y, double N, double n){
        double numerator = permutation(r,y) * permutation(N-r,n-y);
        double denominator = permutation(N,n);
        double result = numerator/denominator;
        return result;
    }
    public double expectedHyperGeometricDistribution(double n, double r, double N){
        double result = (n*r)/N;
        return result;
    }

    public double varianceHyperGeometricDistribution(double n, double r, double N){
        double result = n * (r/n) * ((N-r)/N) * ((N-n)/(N-1));
        return result;
    }

    public double negativeBinomialProbabilityDistribution(double y, double r, double p, double q){
        Math.pow(p,r);
        double result = combinations(y,r) * Math.pow(p,r) * Math.pow(q,(y-r));
        return result;
    }

    public double expectedNegativeBinomialProbabilityDistribution(double r, double p){
        double result = r/p;
        return result;
    }

    public double varianceNegativeBinomialProbabilityDistribution(double r, double p){
        double result = (r*(1-p))/Math.pow(p,2);
        return result;
    }

    }


