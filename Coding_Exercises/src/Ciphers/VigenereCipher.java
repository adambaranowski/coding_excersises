package Ciphers;

import java.util.ArrayList;
import java.util.List;

public class VigenereCipher {

    public static String code(String word, String mainkey) {

        List<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

        String cryptogram;
        char c;
        StringBuilder stringBuilder = new StringBuilder();
        word = word.toUpperCase();
        mainkey = mainkey.toUpperCase();


        String key;

        int mainKeyIndex = 0;
        for (int i = 0; i < word.length(); i++) {
            if (mainKeyIndex >= mainkey.length()) {
                mainKeyIndex = 0;
            }
            if (word.substring(i, i + 1).equals(" ")) {
                stringBuilder.append(" ");
            } else {
                if(mainkey.substring(mainKeyIndex, mainKeyIndex + 1).equals(" ")){
                    mainKeyIndex++;
                }
                stringBuilder.append(mainkey.substring(mainKeyIndex, mainKeyIndex + 1));
                mainKeyIndex++;
            }
        }

        key = stringBuilder.toString();

        for (int j = 0; j < 26; j++) {
            ArrayList<String> row = new ArrayList<String>();
            int charCounter = j;
            for (int i = 0; i < 26; i++) {

                c = (char) (charCounter + 65);
                row.add(String.valueOf(c));
                charCounter++;
                if (charCounter == 26) {
                    charCounter = 0;
                }
            }
            matrix.add(row);
        }

        int row;
        int collumn;
        stringBuilder.delete(0, stringBuilder.length());

        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i + 1).equals(" ")) {
                stringBuilder.append(" ");

            } else {
                row = matrix.get(0).indexOf(word.substring(i, i + 1));
                collumn = matrix.get(0).indexOf(key.substring(i, i + 1));
                stringBuilder.append(matrix.get(row).get(collumn));
            }

        }
        cryptogram = stringBuilder.toString();
        return cryptogram;
    }


    public static String decode(String word, String mainkey) {

        List<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

        String cryptogram;
        char c;
        StringBuilder stringBuilder = new StringBuilder();
        word = word.toUpperCase();
        mainkey = mainkey.toUpperCase();


        String key;

        int mainKeyIndex = 0;
        for (int i = 0; i < word.length(); i++) {
            if (mainKeyIndex >= mainkey.length()) {
                mainKeyIndex = 0;
            }
            if (word.substring(i, i + 1).equals(" ")) {
                stringBuilder.append(" ");
            } else {
                if(mainkey.substring(mainKeyIndex, mainKeyIndex + 1).equals(" ")){
                    mainKeyIndex++;
                }
                stringBuilder.append(mainkey.substring(mainKeyIndex, mainKeyIndex + 1));
                mainKeyIndex++;
            }
        }

        key = stringBuilder.toString();

        for (int j = 0; j < 26; j++) {
            ArrayList<String> row = new ArrayList<String>();
            int charCounter = j;
            for (int i = 0; i < 26; i++) {

                c = (char) (charCounter + 65);
                row.add(String.valueOf(c));
                charCounter++;
                if (charCounter == 26) {
                    charCounter = 0;
                }
            }
            matrix.add(row);
        }

        int row;
        int collumn;
        stringBuilder.delete(0, stringBuilder.length());

        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i + 1).equals(" ")) {
                stringBuilder.append(" ");

            } else {
                row = matrix.get(0).indexOf(key.substring(i, i + 1));
                collumn = matrix.get(row).indexOf(word.substring(i, i + 1));
                stringBuilder.append(matrix.get(0).get(collumn));
            }

        }
        cryptogram = stringBuilder.toString();
        return cryptogram;
    }


    public static void main(String[] args) {
        String d = code("bardzo niesamowicie tajna wiadomosc", "kluczyk");
        String c = decode(d, "kluczyk" );
        System.out.println(d);
        System.out.println(c);
    }
}
