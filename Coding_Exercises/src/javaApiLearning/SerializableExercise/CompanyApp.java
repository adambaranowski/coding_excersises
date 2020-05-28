package javaApiLearning.SerializableExercise;

import java.io.*;
import java.util.Scanner;

public class CompanyApp {
    private static final  String FILE_NAME = "employees.info";
    private static final int READ_FROM_USER = 1;
    private static final int READ_FROM_FILE = 2;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Wprowadzenie danych pracowników: " + READ_FROM_USER);
        System.out.println("Wczytaj dane z pliku: " + READ_FROM_FILE);

        int option = scanner.nextInt();
        scanner.nextLine();

        if(option == READ_FROM_USER){
            Company company = createCompany();
            writeFile(company);
        }else if(option == READ_FROM_FILE){
            Company company = readFile();
            System.out.println(company);
        }
        scanner.close();
    }


    private static Company createCompany(){
        Company company = new Company();

        for (int i = 0; i < Company.MAX_EMPLOYEES; i++) {
            System.out.println("Wprowadź imie: " );
            String name = scanner.nextLine();
            System.out.println("Wprowadź nazwisko: ");
            String lastName = scanner.nextLine();
            System.out.println("Wprowadź wypłate: ");
            double salary = scanner.nextDouble();
            //scanner po wczytaniu doubla nie konsumuje znaku entera doklejanego na końcu
            //stąd trzeba nextline żeby przejść dalej
            scanner.nextLine();
            company.add(new Employee(name, lastName, salary));
        }
        return company;
    }

    private static void writeFile(Company company){
        try(FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

                ){

            objectOutputStream.writeObject(company);
            System.out.println("Zapisano do pliku");

        }catch(IOException e){
            System.err.print("błąd przy zapisie pliku");
            e.printStackTrace();
        }
    }

    private static Company readFile(){
        try(FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ){
            return (Company)objectInputStream.readObject();

        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        throw new NullPointerException();
    }

}
