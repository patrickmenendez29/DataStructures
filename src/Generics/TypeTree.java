package Generics;

import Generics.TypeNode;

import java.util.ArrayList;

public class TypeTree<Type> {



    public TypeNode<Type> root;

    public ArrayList<Integer> values;

    public TypeTree(int rootValue, Type key){
        root = new TypeNode(rootValue,key);
        values = new ArrayList<>();
    }

    // private recursive method to find number by route
  /*  private int find(Node current,int result, Side ... path){

        System.out.println("Recursion started");
        System.out.println(current);

        ArrayList<Side> newPath = new ArrayList<Side>(Arrays.asList(path));

        if (current == null){
            return result;
        }

        if (current.left == null || current.right == null){
             return current.value;
        }
        if (current == null){
            System.out.println("The value was not found in the tree");
            return 0;
        } else {

            if (path == null){
                System.out.println("path is empty");
                return result;
            }
            switch (path[0]){
                case RIGHT:
                    current = current.right;
                    System.out.println("made a right turn");
                    return find(current,current.value,newPath.toArray(new Side[newPath.size()]));


                case LEFT:
                    current = current.left;
                    System.out.println("made a left turn");

                    return find(current,current.value,newPath.toArray(new Side[newPath.size()]));

            }
        }

        return 0;

    } */


    // private recursive method that adds values to the tree
    protected TypeNode add(TypeNode currentNode, int value, Type key){

        if (currentNode == null){ //run this in the last leaf

            return new TypeNode(value,key);

        } else if (value < currentNode.value){ // add node to the left

            currentNode.left = add(currentNode.left,value,key);

        } else if (value > currentNode.value){ //add node to the right

            currentNode.right = add(currentNode.right,value,key);

        } else {
            return currentNode; //value is already on the Tree
        }

        return currentNode; //fail safe


    }

    // public non-recursive method that makes life easier :)

    public void add(int value,Type key) {
        addValue(value);
        root = add(root, value,key);

    }


    // local compare method makes it easier to read
    protected int compare(int x, int y){
        if (x < y){
            return -1;
        } else if (x > y){
            return 1;
        } else return 0;
    }

    /* private ArrayList<String> findPath(Node currentNode, int value, ArrayList<String> path){

        System.out.println("Recursion started");
        if (currentNode == null) {
            System.out.println("The number does not exist on the Tree");
            return null;
        }


        else {
            System.out.println("This node is not null");
            if (currentNode.value == value) {

                return path;

            } else if (value < currentNode.value) {

                System.out.println("Trying to add left direction");
                path.add("left");
                currentNode = currentNode.left;
                path = findPath(currentNode, value, path);

            } else if (value > currentNode.value) {

                System.out.println("Trying to add right direction");
                path.add("right");
                currentNode = currentNode.right;
                path = findPath(currentNode, value, path);
            }


        }

        return null;
    } */

    protected ArrayList<String> findPath(TypeNode current, int value, ArrayList path){


        try {
            if (current == root){
                path.add("Root");
            }
        } catch (NullPointerException e){

        }


        try {
            if (current.value == value){
                return path;
            }
        } catch (NullPointerException e){

        }

      if (current == null){ //return the path if the value is found
          return path;
      } else { // the value has not been found yet

          // return null if the value is not found
          if (current.value == value){
              System.out.println("The value does not exist in the Tree");
              return null;

          }



          if (current.value < value){ // if value is less than current node
              current = current.left;
              path.add("right");
              path = findPath(current,value,path);

          } else if (current.value > value)  { // value is greater than current node
              path.add("left");
              current = current.right;
              path = findPath(current,value,path);
          }

          return path;



      }
    }


    public String findPath(int value){
        return findPath(root,value,new ArrayList<>()).toString();
    }



    protected void sort(ArrayList<Integer> arr) {
        int n = arr.size();


        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr.get(min_idx);
            arr.set(min_idx,arr.get(i));
            arr.set(i,temp);
            }
        }

        protected void addValue(Integer value){

            values.add(value);
            sort(values);
        }



    }


