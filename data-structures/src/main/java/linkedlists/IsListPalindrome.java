package linkedlists;

import java.util.Stack;

public class IsListPalindrome {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    boolean solution(ListNode<Integer> l) {
        ListNode<Integer> slowPointer = l;
        ListNode<Integer> fastPointer = l;

        Stack<Integer> stack = new Stack<>();
        while (fastPointer != null && fastPointer.next != null) {
            stack.add(slowPointer.value);
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        if (fastPointer != null) slowPointer = slowPointer.next;
        while (slowPointer != null) {
            if (stack.pop().intValue() != slowPointer.value.intValue())
                return false;
            slowPointer = slowPointer.next;
        }


        return true;
    }

}
