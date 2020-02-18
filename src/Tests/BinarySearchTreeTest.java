package Tests;


import Generics.TypeTree;

public class BinarySearchTreeTest {

    public static void main(String[] E){

        TypeTree<Integer> tree = new TypeTree<>(50,50);

        tree.add(100,100);
        tree.add(25,25);

        System.out.println("Root: "+tree.root.key);
        System.out.println("Left Value: "+tree.root.left.key);
        System.out.println("Right Value: "+tree.root.right.key);



    }
}
