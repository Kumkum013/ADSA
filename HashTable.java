import java.util.Scanner;

public class HashTable {

    public static int calculateAsciiSum(String input) {
        int sum = 0;
        System.out.println("Characters and ASCII values:");

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;
            sum += ascii;
            System.out.println(ch + " (" + ascii + ")");
        }

        System.out.println("Total ASCII sum: " + sum);
        return sum;
    }

    public static int getHashindex(int asciiSum, int tableSize) {
        return asciiSum % tableSize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take string input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Take hash table size safely
        int tableSize = 0;
        while (true) {
            System.out.print("Enter the size of the hash table: ");
            String tableInput = sc.nextLine(); // read as string
            try {
                tableSize = Integer.parseInt(tableInput);
                if (tableSize <= 0) {
                    System.out.println("Hash table size must be positive.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }

        int asciiSum = calculateAsciiSum(input);
        int index = getHashindex(asciiSum, tableSize);
        System.out.println("The string \"" + input + "\" will be stored at index: " + index);

        sc.close();
    }
}
