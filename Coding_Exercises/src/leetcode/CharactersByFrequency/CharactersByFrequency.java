package leetcode.CharactersByFrequency;

import java.util.*;

public class CharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("aacddfrryhyhhaaw"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> letters = new HashMap<>();
        int length = s.length();

        char c;
        for (int i = 0; i < length; i++) {
            c = s.charAt(i);
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sortedLetters = new LinkedHashMap<>();

        List<Character> mapKeys = new ArrayList<>(letters.keySet());
        List<Integer> mapValues = new ArrayList<>(letters.values());
        Collections.sort(mapKeys);
        Collections.sort(mapValues, Collections.reverseOrder());


        for (int value: mapValues
             ) {
            Iterator<Character> keyIterator = mapKeys.iterator();
            while (keyIterator.hasNext()){
                c = keyIterator.next();
                if(letters.get(c)==value){
                    sortedLetters.put(c,value);
                    keyIterator.remove();
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: sortedLetters.entrySet()
             ) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }

        }

        return sb.toString();
    }
}

