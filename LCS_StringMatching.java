import java.util.Scanner;

public class LCS_StringMatching {

// Function to find the Longest Common Subsequence
public static String lcs(String X, String Y) {
    int m = X.length();
    int n = Y.length();
    int[][] dp = new int[m + 1][n + 1];

    // Build dp table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    // Reconstruct LCS from dp table
    int i = m, j = n;
    StringBuilder lcsStr = new StringBuilder();

    while (i > 0 && j > 0) {
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            lcsStr.append(X.charAt(i - 1));
            i--;
            j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--;
        } else {
            j--;
        }
    }

    return lcsStr.reverse().toString();
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Taking input
    System.out.print("Enter first string: ");
    String str1 = sc.nextLine();

    System.out.print("Enter second string: ");
    String str2 = sc.nextLine();

    // Finding LCS
    String result = lcs(str1, str2);

    // Output
    System.out.println("Longest Common Subsequence: " + result);
    sc.close();
}


}
