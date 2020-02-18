package Classes;

import java.util.ArrayList;
import java.util.Iterator;

public class PriorityList {

    ArrayList<Integer> list;





    public PriorityList(){

        list = new ArrayList<>();

    }

    public void add(int e){

        list.add(e);
        sort();


    }

    private void sort()
    {
        int n = list.size();
        for (int i = 1; i < n; ++i) {
            int key = list.get(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && list.get(j) > key) {

                list.set(j + 1,list.get(j));
                j = j - 1;
            }
            list.set(j+1,key);

        }
    }

    public int peek(){

        try {
            return list.get(0);
        } catch (IndexOutOfBoundsException e){

            return Integer.MIN_VALUE;
        }

    }

    public int pop(){
        try {
            return list.remove(0);
        } catch (Exception e){
            return Integer.MIN_VALUE;
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
