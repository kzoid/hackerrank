package com.kzoid.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Ricardo Gelschleiter on 08/02/2017.
 */
public class JavaStack {

    private static Map<Character, Character> validParentheses = populateValidParentheses();

    private static Map<Character, Character> populateValidParentheses() {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(validateAutomaton(input));
        }
    }

    private static boolean validateAutomaton(String str) {
        Stack<Character> characters = new Stack<>();

        for (Character ch : str.toCharArray()) {
            if (validParentheses.containsKey(ch)) { // opening
                characters.push(ch);
            } else if (!characters.isEmpty() && validParentheses.get(characters.peek()).equals(ch)) { //closing
                characters.pop();
            } else {
                return false; // closing an unopened paren
            }
        }

        return characters.isEmpty();
    }
}
