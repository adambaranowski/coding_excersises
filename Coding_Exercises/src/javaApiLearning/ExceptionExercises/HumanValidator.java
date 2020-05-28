package javaApiLearning.ExceptionExercises;

public class HumanValidator {
    public static boolean IsNameCorrect(Human human){
        if(human.getName().length()>3){
            return true;
        }else{
            throw new HumanNameWrongFormatException("Za krótkie imie");

        }
    }
}
