package leetcode.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> parentheses(int n){
        if(n==0)
            return new ArrayList<>();
        List<String> parentheses = new ArrayList<>();
        addPar(0, 0, n, parentheses, "");
        return parentheses;
    }

    public static void addPar(int lefts, int rights, int n, List<String> parentheses, String s){
        if(s.length()==n*2){
            parentheses.add(s);
            return;
        }

        if(lefts < n){
            addPar(lefts+1 , rights, n, parentheses, s+"(");
        }
        if(rights<lefts){
            addPar(lefts , rights+1, n,  parentheses, s+")");
        }
    }

    public static void main(String[] args) {
        System.out.println(parentheses(10).toString());
    }
}
