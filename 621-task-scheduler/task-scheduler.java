class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // count task frequencies
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int countMax = 0;
        for (int f : freq) {
            if (f == maxFreq) countMax++;
        }

        int partCount = maxFreq - 1;
        int partLength = n + 1;

        int minIntervals = partCount * partLength + countMax;

        return Math.max(minIntervals, tasks.length);
    }
}
