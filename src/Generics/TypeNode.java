package Generics;

public class TypeNode<Type> {

    public Integer value;
    public TypeNode left;
    public TypeNode right;
    public Type key;

    public TypeNode(int value, Type key){

        this.value = value;
        left = null;
        right = null;
        this.key = key;


    }




}
