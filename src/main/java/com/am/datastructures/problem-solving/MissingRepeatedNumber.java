import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MissingRepeatedNumber {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        Integer N = new Integer(sc.nextLine().trim()); //input number
        System.out.println("X: " + N);

        if (!sc.hasNext()) return;
        String input = sc.nextLine();
        String[] strArr = input.split(" ");
        Integer[] arr = new Integer[strArr.length];
        for (int i=0; i<strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        print(arr);

        findMissingRepeatedNumber(arr, N, bw);
    }


    public static void findMissingRepeatedNumber(Integer[] arr, int N, BufferedWriter bw) throws IOException {
        StringBuilder missing = new StringBuilder();
        StringBuilder repeated = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            int abs = Math.abs(arr[i]);
            System.out.println("abs: "+abs);
            int j = abs>N ? abs-N-1 : abs-1;
            System.out.println("j: "+j);
            if (Math.abs(arr[j]) > N) continue;
            if (arr[j] < 0)
                arr[j] = arr[j]-N;
            else
                arr[j] = -arr[j];

            print(arr);
        }

        for (int k=0; k<arr.length; k++) {
            if (arr[k] > 0) {
                missing.append(k + 1);
                missing.append(" ");
            } else if (arr[k] < -N) {
                repeated.append(k + 1);
                repeated.append(" ");
            }
        }

        System.out.println("Missing numbers: "+missing.toString());
        System.out.println("Repeated numbers: "+repeated.toString());

        bw.write(missing.toString());
        bw.newLine();
        bw.write(repeated.toString());
        bw.close();
        sc.close();
    }

    public static void print(Integer[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

}
