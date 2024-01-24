public class TestExample {
    public static void main(String Args[]){
        Example test = new Example();
        int[] mySampleNumbersOdd = {1,2,3,4,5,6,7,8,9};
        int[] mySampleNumbersEven = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int[] mySampleNumbersMode = {2,2,3,3,4,4,4};
        double meanResults = test.findMean(mySampleNumbersOdd);
        double medianResultsOdd = test.findMedian(mySampleNumbersOdd);
        double medianResultsEven = test.findMedian(mySampleNumbersEven);
        double modeResultsOdd = test.findMode(mySampleNumbersOdd);
        double modeResultsRepeat = test.findMode(mySampleNumbersMode);
        System.out.println("The mean for the odd array is: " + meanResults); 
        System.out.println("The median for the odd array is: " + medianResultsOdd);
        System.out.println("The median for the even array is: " + medianResultsEven);
        System.out.println("The mode for the odd array is: " + modeResultsOdd);
        System.out.println("The mode for the array with repeating ints is: " + modeResultsRepeat);
    }
}
