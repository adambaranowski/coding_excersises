package javaApiLearning.GenericTypeStack;

import java.lang.reflect.Array;

public class Stack<T> {

    private T[] array;
    private int arrayLength = 3;
    private int index = -1;

    public Stack(){
        this.array = (T[]) new Object[arrayLength];
    }

    public void add(T object){
        if(index<arrayLength-1){
            index++;
            array[index] = object;


        }else{

            T[] newArray = (T[]) new Object[arrayLength*2];


            for (int i = 0; i < arrayLength; i++) {
                newArray[i] = array[i];
            }
            arrayLength *= 2;
            array = newArray;

            index++;
            array[index] = object;
        }
    }

    public T pop(){

        if(index==-1){
            System.out.println("Stack is empty");
            return null;
        }else{
            T object =  array[index];
            array[index] = null;
            index--;
            return object;
        }
    }

    public int length(){
        int i = 0;
        while (array[i]!=null){
            i++;
        }
        return i;

    }


}
