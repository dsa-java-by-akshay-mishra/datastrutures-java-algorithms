import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class AddTwoNumbersUsingSLL {

    private static final Scanner sc = new Scanner(System.in);

    public static class LLNode {
        int data;
        LLNode next;

        LLNode(int data) {
            this.data = data;
            next = null;
        }

        @Override
        public String toString() {
            return String.format("Data: "+data+", ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        String X = arr[0]; //input number
        String Y = arr[1]; //input number
        System.out.println("X: "+X+", Y: "+Y);

        //System.out.println("Please enter initial number: ");
        LLNode head1 = createLinkedList(X);
        LLNode head2 = createLinkedList(Y);

        LLNode head = addLL(head1, head2);
        String result = toString(head);
        System.out.println("Result: "+result);


        bw.write(result);
        bw.newLine();
        bw.close();
        sc.close();
    }

    public static LLNode addLL(LLNode head1, LLNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);

        toString(head1);
        toString(head2);

        LLNode ptr1 = head1;
        LLNode ptr2 = head2;

        LLNode head3 = null;
        LLNode result = head3;
        int carry = 0;
        LLNode prev = null;
        while(ptr1 != null && ptr2 != null) {
            int data1 = ptr1.data;
            int data2 = ptr2.data;

            int sum = data1 + data2 + carry;
            carry = sum/10;
            int rem = sum%10;

            result = new LLNode(rem);

            if (prev != null) {
                prev.next = result;
            } else {
                head3 = result;
            }

            prev = result;

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while(ptr1 != null) {

            int data1 = ptr1.data;

            int sum = data1 + carry;
            carry = sum/10;
            int rem = sum%10;

            result = new LLNode(rem);

            if (prev != null)
                prev.next = result;

            prev = result;

            ptr1 = ptr1.next;
        }

        while(ptr2 != null) {

            int data2 = ptr2.data;

            int sum = data2 + carry;
            carry = sum/10;
            int rem = sum%10;

            result = new LLNode(rem);

            if (prev != null)
                prev.next = result;

            prev = result;

            ptr2 = ptr2.next;
        }


        if (carry > 0) {
            result = new LLNode(carry);
            prev.next = null;
        }

        head3 = reverse(head3);

        return head3;
    }

    public static LLNode reverse(LLNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LLNode ptr1 = null;
        LLNode ptr2 = head;
        LLNode ptr3 = head.next;

        while (ptr2 != null) {
            ptr2.next = ptr1;
            ptr1 = ptr2;
            ptr2 = ptr3;
            if(ptr3 != null)
            ptr3 = ptr3.next;
        }

        head = ptr1;

        return head;
    }

    public static LLNode createLinkedList(String number) {
        LLNode head = new LLNode(Integer.valueOf(String.valueOf(number.charAt(0))));
        LLNode ptr1 = head;
        for (int i=1;i<number.length();i++) {
            LLNode node = new LLNode(Integer.valueOf(String.valueOf(number.charAt(i))));
            ptr1.next = node;
            ptr1 = ptr1.next;
        }

        toString(head);
        return head;
    }

    public static String toString(LLNode head) {
        StringBuilder str = new StringBuilder();
        LLNode ptr1 = head;
        while(ptr1 != null) {
            str = str.append(ptr1.data);
            ptr1 = ptr1.next;
        }

        System.out.println(str.toString());
        return str.toString();
    }
}
