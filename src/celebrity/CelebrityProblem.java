package celebrity;

public class CelebrityProblem {

    // Function to check if a person knows another person
    static boolean knows(int[][] matrix, int a, int b) {
        return matrix[a][b] == 1;
    }

    // Function to find the celebrity
    static int findCelebrity(int[][] matrix, int n) {
        int candidate = 0;

        // Step 1: Find the candidate
        for (int i = 1; i < n; i++) {
            if (knows(matrix, candidate, i)) {
                candidate = i;
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(matrix, candidate, i) || !knows(matrix, i, candidate))) {
                return -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
        };
        int n = matrix.length;
        int result = findCelebrity(matrix, n);
        if (result == -1) {
            System.out.println("No celebrity found.");
        } else {
            System.out.println("Celebrity is person " + result);
        }
    }

    static int myalgo(int[][] matrix){
        int celeb = 0;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[celeb][i] == 1){
                celeb = i;
            }
        }
        return celeb;
    }
}