package javaApiLearning.LambaTraining;

public class GenericMethods<V> {


    private V zawartosc;

    private  <T> V print(T var){
        if(var.getClass().equals("Integer"))
            return (V) new Integer("1");
        else
            return (V) new String("1");
    }

    public static void main(String[] args) {

    }

}
