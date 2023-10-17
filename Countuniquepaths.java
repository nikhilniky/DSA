class Solution {
    // public int uniquePaths(int m, int n) {
    //     if(m==1 ||n==1)
    //     return 1;
    //     return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    // }
// public int uniquePaths(int m, int n) {
//     int[][] dp = new int[m][n];

//     // Initialize the top row and left column to 1
//     for (int i = 0; i < m; i++) {
//         dp[i][0] = 1;
//     }
//     for (int j = 0; j < n; j++) {
//         dp[0][j] = 1;
//     }

//     // Fill in the rest of the dp array
//     for (int i = 1; i < m; i++) {
//         for (int j = 1; j < n; j++) {
//             dp[i][j] = dp[i-1][j] + dp[i][j-1];
//         }
//     }

//     return dp[m-1][n-1];
// }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return uniquePathsHelper(m - 1, n - 1, memo);
    }

    private int uniquePathsHelper(int m, int n, int[][] memo) {
        if (m == 0 || n == 0) {
            return 1;
        }

        if (memo[m][n] > 0) {
            return memo[m][n];
        }

        int leftPaths = uniquePathsHelper(m, n - 1, memo);
        int upPaths = uniquePathsHelper(m - 1, n, memo);
        memo[m][n] = leftPaths + upPaths;

        return memo[m][n];
    }


}

// https://leetcode.com/problems/unique-paths/submissions/1077241608/



