class Solution {
        public int orangesRotting(int[][] grid) {
                Queue<int[]> q = new LinkedList<>();
                        int fresh = 0, time = 0;

                                int rows = grid.length, cols = grid[0].length;

                                        for (int i = 0; i < rows; i++) {
                                                    for (int j = 0; j < cols; j++) {
                                                                    if (grid[i][j] == 2) q.offer(new int[]{i, j});
                                                                                    if (grid[i][j] == 1) fresh++;
                                                                                                }
                                                                                                        }

                                                                                                                int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

                                                                                                                        while (!q.isEmpty() && fresh > 0) {
                                                                                                                                    int size = q.size();
                                                                                                                                                time++;

                                                                                                                                                            for (int i = 0; i < size; i++) {
                                                                                                                                                                            int[] curr = q.poll();
                                                                                                                                                                                            for (int[] d : dirs) {
                                                                                                                                                                                                                int r = curr[0] + d[0];
                                                                                                                                                                                                                                    int c = curr[1] + d[1];

                                                                                                                                                                                                                                                        if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == 1) {
                                                                                                                                                                                                                                                                                grid[r][c] = 2;
                                                                                                                                                                                                                                                                                                        fresh--;
                                                                                                                                                                                                                                                                                                                                q.offer(new int[]{r, c});
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                                                                return fresh == 0 ? time : -1;
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                    }
