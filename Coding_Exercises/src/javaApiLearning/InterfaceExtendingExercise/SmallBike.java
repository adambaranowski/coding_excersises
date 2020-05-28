package javaApiLearning.InterfaceExtendingExercise;

public class SmallBike extends BikeImpl {
    public static void main(String[] args) {
        SmallBike smallBike = new SmallBike();
        //
        smallBike.changeGear();
        smallBike.turnLeft();
    }
}
