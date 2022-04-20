package linkedlists;

import java.util.ArrayList;
import java.util.Stack;

public class AddTwoHugeNumbers {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    ListNode<Integer> head;

    ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
        Stack<Integer> sa = new Stack<>();
        Stack<Integer> sb = new Stack<>();
        ArrayList<String> total = new ArrayList<>();
        int odd = traverse(a, b, sa, sb, total);
        for (String item : total) {
            if (head == null) head = new ListNode<>(Integer.parseInt(item));
            else push(Integer.parseInt(item));
        }
        if (odd > 0) push(odd);
        return head;
    }

    int traverse(ListNode<Integer> a, ListNode<Integer> b,
                 Stack<Integer> sa, Stack<Integer> sb, ArrayList<String> total) {
        if (a == null && b == null) return 0;
        if (a != null) {
            sa.add(a.value);
            a = a.next;
        }
        if (b != null) {
            sb.add(b.value);
            b = b.next;
        }
        int odd = traverse(a, b, sa, sb, total);

        int aval = sa.isEmpty() ? 0 : sa.pop().intValue();
        int bval = sb.isEmpty() ? 0 : sb.pop().intValue();
        int value = aval + bval + odd;
        String temp = String.valueOf(value);
        if ((temp.length()) > 4) {
            odd = Integer.parseInt(temp.substring(0, 1));
            total.add(temp.substring(1, temp.length()));
        } else {
            odd = 0;
            total.add(String.format("%04d", value));
        }
        return odd;
    }

    void push(int new_data) {

        ListNode<Integer> new_node = new ListNode<>(new_data);


        new_node.next = head;


        head = new_node;
    }

}
