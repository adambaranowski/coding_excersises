package javaApiLearning.ExceptionExercises;

import java.util.ArrayList;
import java.util.List;

public class HumanService {
    private List<Human> humans = new ArrayList<>();

    public HumanService(){
        humans.add(new Human(1, "pablo", "picasso"));
        humans.add(new Human(2, "adam", "puciak"));


    }

    private void addHuman(Human human){
        try{
            HumanValidator.IsNameCorrect(human);
            humans.add(human);
        }catch (HumanNameWrongFormatException e){
            e.printStackTrace();
        }
    }

    private Human getHumanByLastName(String lastName) throws HumanNotFoundException {
        for (Human h: humans
             ) {
            if(h.getLastName().equals(lastName)){
                return h;
            }else{
                throw new HumanNotFoundException("Nie znaleziono człowieka o nazwisku " + lastName);
            }

        }
        return null;
    }

    public static void main(String[] args) {
        HumanService humanService = new HumanService();

        humanService.addHuman(new Human(3, "pp", "asdfw"));

        try {
            humanService.getHumanByLastName("baranoski");
        }catch (HumanNotFoundException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

}
