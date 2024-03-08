package StdLibrary;

import java.util.ArrayList;


public class SetOperations {

    //https://www.tutorialspoint.com/java/java_generics.htm This is where I learned about generics
    //This seems horribly inefficient
    //Union Set
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

    //Complement Set
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

    //Intersection Set
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
}

