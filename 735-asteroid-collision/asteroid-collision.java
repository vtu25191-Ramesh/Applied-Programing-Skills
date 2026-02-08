import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

            // Collision only if stack top is moving right and current is moving left
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {

                if (Math.abs(ast) > stack.peek()) {
                    stack.pop(); // top asteroid explodes
                    continue;
                } 
                else if (Math.abs(ast) == stack.peek()) {
                    stack.pop(); // both explode
                }

                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
