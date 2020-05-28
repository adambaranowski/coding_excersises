package javaApiLearning.SerializableExercise;

import java.io.Serializable;

public class Company implements Serializable {
    public static int MAX_EMPLOYEES = 3;
    private Employee[] employees = new Employee[MAX_EMPLOYEES];
    private int index = 0;

    public void add(Employee employee){
        employees[index] = employee;
        index++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee e: employees
             ) {
            stringBuilder.append(e.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
