import java.util.Scanner;

public class PowerLevelsSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] powerLevels = new int[10];

        // Step 1: Input the power levels
        System.out.println("Enter 10 power levels of creatures:");
        for (int i = 0; i < 10; i++) {
            powerLevels[i] = scanner.nextInt();
        }

        // Bubble Sort for ascending order
        int[] bubbleSorted = powerLevels.clone();
        bubbleSort(bubbleSorted);
        System.out.println("\nBubble Sort (Ascending):");
        displayArray(bubbleSorted);

        // Selection Sort for descending order
        int[] selectionSorted = powerLevels.clone();
        selectionSort(selectionSorted);
        System.out.println("\nSelection Sort (Descending):");
        displayArray(selectionSorted);

        // Analysis
        int sumEven = 0, sumOdd = 0, min = powerLevels[0], max = powerLevels[0];
        for (int num : powerLevels) {
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        System.out.println("\nAnalysis:");
        System.out.println("Sum of Even Numbers: " + sumEven);
        System.out.println("Sum of Odd Numbers: " + sumOdd);
        System.out.println("Minimum Power Level: " + min);
        System.out.println("Maximum Power Level: " + max);

        scanner.close();
    }

    // Bubble Sort implementation for ascending order
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort implementation for descending order
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Swap array[i] and array[maxIdx]
            int temp = array[i];
            array[i] = array[maxIdx];
            array[maxIdx] = temp;
        }
    }

    // Utility method to display the array
    public static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

