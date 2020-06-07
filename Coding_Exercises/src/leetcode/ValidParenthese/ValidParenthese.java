package leetcode.ValidParenthese;

import java.util.*;

public class ValidParenthese {
    public static boolean isValid(String s) {



        if(s.length()==0)
            return false;

        List<String> stack = new ArrayList<>();
        //stack.add("");
        String sub;
        int index = 0;

        List<String> openings = List.of("[", "{", "(");

        for (int i = 0; i < s.length(); i++) {
            sub = s.substring(i,i+1);

            if (openings.contains(sub)) {
                stack.add(sub);
                index++;
            }else if(index-1<0){
                return false;
            }
            else if(sub.equals("}")&&stack.get(index-1).equals("{")){
                index--;
                stack.remove(index);
            }else if(sub.equals("]")&&stack.get(index-1).equals("[")){
                index--;
                stack.remove(index);
            }else if(sub.equals(")")&&stack.get(index-1).equals("(")){
                index--;
                stack.remove(index);
            }else {
                return false;
            }

        }

       // System.out.println(index);
        if(index == 0)
            return true;
        return false;

    }

    public static void main(String[] args) {
        String test1 = "({{}})";
        String test2 = "";
        String test3 = "((){}{}()}";
        String test4 = "(){}{}{}()()";
        String test5 = "((({{({[";
        String test6 = "}}{}";

        System.out.println(isValid(test1));
        System.out.println(isValid(test2));
        System.out.println(isValid(test3));
        System.out.println(isValid(test4));
        System.out.println(isValid(test5));
        System.out.println(isValid(test6));
    }
}
