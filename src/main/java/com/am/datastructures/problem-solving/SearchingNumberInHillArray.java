import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SearchingNumberInHillArray {


    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        Integer N = new Integer(sc.nextLine().trim()); //input number
        System.out.println("N: " + N);

        if (!sc.hasNext()) return;
        String input = sc.nextLine();
        String[] strArr = input.split(" ");
        Integer[] arr = new Integer[strArr.length];
        for (int i=0; i<strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        print(arr);

        int mid = arr.length/2;
        int peak = findPeak(arr, mid);
        System.out.println("peak: "+ peak);

        Integer X = new Integer(sc.nextLine().trim()); //number to search
        System.out.println("X: " + X);
        int index = -1;
        if (X.equals(arr[peak])) {
            index = peak;
        } else {

            index = binarySearch(arr, 0, peak - 1, X, true);
            if (index == -1) {
                index = binarySearch(arr, peak + 1, arr.length - 1, X, false);
            }
        }

        System.out.println("Search Result: "+ index);

        bw.write(String.valueOf(index));
        bw.close();
        sc.close();
    }

    public static int binarySearch(Integer[] arr, int low, int high, int X, boolean asc) {
        if (high < low) {
            return -1;
        }

        int mid = (low + high)/2;

        if (arr[mid] == X) {
            return mid;
        }

        if (asc) {
            if (arr[mid] > X) {
                return binarySearch(arr, 0, mid-1, X, asc);
            } else {
                return binarySearch(arr, mid +1, high, X, asc);
            }
        } else {
            if (arr[mid] > X) {
                return binarySearch(arr, mid +1, high, X, asc);
            } else {
                return binarySearch(arr, 0, mid-1, X, asc);
            }
        }
    }

    public static int findPeak(Integer[] arr, int peak) {
        if (peak == 0 || peak == arr.length-1) {
            return peak;
        }

        if (arr[peak] > arr[peak + 1] && arr[peak] > arr[peak - 1]) {
            return peak;
        } else if (arr[peak] < arr[peak + 1]) {
            return findPeak(arr, peak + 1);
        } else {
            return findPeak(arr, peak - 1);
        }
    }

    public static void print(Integer[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("");
    }
}
