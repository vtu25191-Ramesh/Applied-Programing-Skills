import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> remove = new HashSet<>();

        // First pass: find invalid parentheses
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    remove.add(i); // extra ')'
                } else {
                    stack.pop();
                }
            }
        }

        // Remaining '(' are invalid
        while (!stack.isEmpty()) {
            remove.add(stack.pop());
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
