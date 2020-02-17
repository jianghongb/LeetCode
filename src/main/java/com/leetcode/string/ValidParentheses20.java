package com.leetcode.string;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: "([)]"
 * Output: false
 */
public class ValidParentheses20 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (character.equals('(') || character.equals('[') || character.equals('{')) {
                stack.push(character);
            } else if (stack.isEmpty()) {
                return false;
            } else if (character.equals(')') && !stack.peek().equals('(')
                    || character.equals(']') && !stack.peek().equals('[')
                    || character.equals('}') && !stack.peek().equals('{')) {
                return false;
            } else {
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
