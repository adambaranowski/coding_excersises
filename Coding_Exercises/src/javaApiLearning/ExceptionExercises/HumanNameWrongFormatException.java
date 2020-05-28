package javaApiLearning.ExceptionExercises;

public class HumanNameWrongFormatException extends RuntimeException {
    public HumanNameWrongFormatException(String message){
        super(message);
    }
}
