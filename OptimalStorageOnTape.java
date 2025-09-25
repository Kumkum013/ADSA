import java.util.*;
public class OptimalStorageOnTape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of programs
        System.out.print("Enter number of programs: ");
        int n = sc.nextInt();

        int[] programs = new int[n];

        // Input lengths of programs
        System.out.println("Enter lengths of programs:");
        for (int i = 0; i < n; i++) {
            programs[i] = sc.nextInt();
        }

        // Sort programs by length (ascending)
        Arrays.sort(programs);

        // Calculate retrieval times
        int[] retrievalTime = new int[n];
        retrievalTime[0] = programs[0];

        for (int i = 1; i < n; i++) {
            retrievalTime[i] = retrievalTime[i - 1] + programs[i];
        }

        // Calculate Mean Retrieval Time (MRT)
        int total = 0;
        for (int time : retrievalTime) {
            total += time;
        }
        double mrt = (double) total / n;
        

        //   for printing Output
        System.out.println("\nOptimal Program Order (by length): " + Arrays.toString(programs));
        System.out.println("Retrieval Times: " + Arrays.toString(retrievalTime));
        System.out.printf("Mean Retrieval Time (MRT): %.2f\n", mrt);
    }
}
