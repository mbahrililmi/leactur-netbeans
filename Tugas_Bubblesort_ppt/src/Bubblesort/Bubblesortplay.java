package Bubblesort;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author M.BAHRIL.I
 */
public class Bubblesortplay {

  
    public static void main(String[] args) {
       int[] array = {5, 2, 4, 6, 1, 3};

        System.out.print("unsorted data: ");
        printArray(array);

        System.out.print("ascending order: "); // 1,2,3,4,5,6
        bubble_sort(array);
        printArray(array);

        System.out.print("descending order: "); //6,5,4,3,2,1
        bubble_sort(array, false);
        printArray(array);  
    }
      private static void bubble_sort(int[] input) {
        bubble_sort(input, true);
    }
     private static void bubble_sort(int[] input, boolean ascending) {

        int inputLength = input.length;
        int temp;
        boolean is_sorted;

        for (int i = 0; i < inputLength; i++) {

            is_sorted = true;

            for (int j = 1; j < (inputLength - i); j++) {

                if (ascending) {
                    if (input[j - 1] > input[j]) {
                        temp = input[j - 1];
                        input[j - 1] = input[j];
                        input[j] = temp;
                        is_sorted = false;
                    }
                } else {
                    if (input[j - 1] < input[j]) {
                        temp = input[j - 1];
                        input[j - 1] = input[j];
                        input[j] = temp;
                        is_sorted = false;
                    }

                }

            }
            if (is_sorted) break;
        }
    }
     
     private static void printArray(int[] data) {
        String result = Arrays.stream(data)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(result);
    }  
}
