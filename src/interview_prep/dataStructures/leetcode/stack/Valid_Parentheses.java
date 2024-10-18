package interview_prep.dataStructures.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        boolean valid = new Valid_Parentheses().isValid("({)}");
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        Map<Character, Character> symbols = new HashMap<>();
        symbols.put(')', '(');
        symbols.put('}', '{');
        symbols.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] parans = s.toCharArray();


        for (char paran : parans) {
            //we receive an opening/closing tag at first
            if (stack.isEmpty()) {
                if (symbols.containsValue(paran)) stack.push(paran);
                else return false;

            } else {
                //now we have some elements in stack
                if (symbols.containsValue(paran)) stack.push(paran); //new opening
                else {
                    //closing bracket received
                    //need to check if last bracket was the opening for this one
                    //if we get a different closing bracket other than the one opened then it's an invalid case
                    char peek = stack.peek();
                    if (symbols.get(paran) == peek) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }

            }
        }

        if(stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

}
