import java.util.*;

class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        // Add new request
        queue.offer(t);

        // Remove outdated requests
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        // Remaining size is the answer
        return queue.size();
    }
}
