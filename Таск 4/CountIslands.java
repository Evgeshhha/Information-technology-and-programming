import java.util.Scanner;

public class CountIslands {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        s.close();

        line = line.replaceAll("\\[\\[", "").replaceAll("]]", "");
        String[] rows = line.split("\\],\\[");
        int n = rows.length;
        int m = rows[0].split(",").length;
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] nums = rows[i].split(",");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(nums[j].trim());
            }
        }

        System.out.println(countIslands(grid));
    }

    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m)
            return;
        if (visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true;

        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
    }
}