package celebrity;

/*
    Problem Statement:
    You are given a number n, representing the number of people in a party.
    A celebrity is defined as someone who knows no one else, but everyone else knows them.
    Given an n×n matrix 'mat' where mat[i][j] == 1 means person i knows person j,
    write a function to find the index of the celebrity. If there is no celebrity, return -1.
    
    Constraints:
    - 2 ≤ n  
    - mat[i][i] = 0 for all i  
    - You may assume at most one celebrity exists.
    
    Methods:
      - celebritySolution(int[][] mat): returns the celebrity index or -1 if none.
*/

public class CelebrityProblem {

    // Function to check if a person knows another person
    private boolean knows(int[][] matrix, int a, int b) {
        return matrix[a][b] == 1;
    }

    // Function to find the celebrity
    int findCelebrity(int[][] matrix, int n) {
        if (n <= 0)
            return -1;

        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(matrix, candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && knows(matrix, candidate, i))
                return -1;
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && !knows(matrix, i, candidate))
                return -1;
        }
        return candidate;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 }
        };
        CelebrityProblem a = new CelebrityProblem();
        System.out.println("Person " + a.findCelebrity(matrix, matrix.length) + " is the candidate");
    }
}