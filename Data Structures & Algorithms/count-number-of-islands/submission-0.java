class Solution {
    public int numIslands(char[][] grid) {

        // Set<int[]> visitedCoords = new HashSet<>();
        boolean[][] visitedCoords = new boolean[grid.length][grid[0].length];
        int numIslands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int[] currentCoord = {row, col};
                if (visitedCoords[row][col] || grid[row][col] == '0') {
                    continue;
                }
                visitedCoords = bfs(row, col, visitedCoords, grid);

                numIslands++;
            }
        }

        return numIslands;
        
    }

    public boolean validCoord(int[] coord, int rowLength, int colLength) {
        if (coord[0] >= 0 && coord[1] >= 0 && coord[0] < rowLength && coord[1] < colLength) {
            return true;
        } else {
            return false;
        }
    }

    public boolean[][] bfs(int row, int col, boolean[][] visitedCoords, char[][] grid) {
        List<int[]> queue = new ArrayList<>();
        int[] initialCoords = {row, col};

        int rowLength = grid.length;
        int colLength = grid[0].length;

        queue.addFirst(initialCoords);
        visitedCoords[row][col] = true;

        while (!queue.isEmpty()) {
            int[] polled = queue.removeLast();

            int currRow = polled[0];
            int currCol = polled[1];

            int[] left = {currRow, currCol - 1};
            int[] right = {currRow, currCol + 1};
            int[] up = {currRow - 1, currCol};
            int[] down = {currRow + 1, currCol};

            if (validCoord(left, rowLength, colLength)) {
                if (!visitedCoords[left[0]][left[1]] && !(grid[left[0]][left[1]] == '0')) {
                    visitedCoords[left[0]][left[1]] = true;
                    queue.addFirst(left);
                }
            } 
            if (validCoord(right, rowLength, colLength)) {
                if (!visitedCoords[right[0]][right[1]] && !(grid[right[0]][right[1]] == '0')) {
                    visitedCoords[right[0]][right[1]] = true;
                    queue.addFirst(right);
                }
            }
            if (validCoord(up, rowLength, colLength)) {
                if (!visitedCoords[up[0]][up[1]] && !(grid[up[0]][up[1]] == '0')) {
                    visitedCoords[up[0]][up[1]] = true;
                    queue.addFirst(up);
                }
            }
            if (validCoord(down, rowLength, colLength)) {
                if (!visitedCoords[down[0]][down[1]] && !(grid[down[0]][down[1]] == '0')) {
                    visitedCoords[down[0]][down[1]] = true;
                    queue.addFirst(down);
                }
            }
        }

        return visitedCoords;
    }
}
