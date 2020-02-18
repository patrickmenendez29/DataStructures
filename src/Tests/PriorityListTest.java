package Tests;

import Classes.PriorityList;

public class PriorityListTest {
    public static void main(String[] E){

        PriorityList list = new PriorityList();

        list.add(100);
        list.add(50);
        list.add(75);
        list.add(25);

        System.out.println(list);

        System.out.println("The first value passed: "+list.pop());

        System.out.println("After that: "+list);

    }
}
