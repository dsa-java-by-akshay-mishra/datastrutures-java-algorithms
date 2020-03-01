import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PairSumStrictlyGreaterThan {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        Integer N = new Integer(sc.nextLine().trim()); //input number
        System.out.println("N: " + N); //number of elements in an array.

        Integer S = new Integer(sc.nextLine().trim()); //pair sum greater than S
        System.out.println("S: " + S);

        if (!sc.hasNext()) return;
        String input = sc.nextLine();
        String[] strArr = input.split(" ");
        Integer[] arr = new Integer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(arr);
        print(arr);

        int count = findPairsGreaterThan(arr, 0, arr.length-1, S);

        System.out.println("Result count: "+ count);

        bw.write(String.valueOf(count));
        bw.close();
        sc.close();
    }

    private static int findPairsGreaterThan(Integer[] arr, int low, int high, int S) {
        int count = 0;
        int l = low;
        int h = high;

        while(l < h) {
            if (arr[l] + arr[h] <= S) {
                l++;
            } else {
                count += (h - l);
                h--;
            }
        }

        return count;
    }

    public static void print(Integer[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("");
    }
}
