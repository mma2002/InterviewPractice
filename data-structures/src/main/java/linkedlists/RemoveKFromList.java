package linkedlists;

public class RemoveKFromList {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }


    ListNode head;
    ListNode<Integer> solution(ListNode<Integer> l, int k) {
        while (l != null && k == l.value) {
            l = l.next;
        }
        ListNode<Integer> result = null;
        if (l != null) {
            result = new ListNode<Integer>(l.value);
            create(l.next, result, k);
        }
        return result;
    }

    // create new list
    ListNode<Integer> create(ListNode<Integer> l, ListNode<Integer> result, int k) {
        if (l != null) {
            if (k != l.value) {
                result.next = new ListNode<>(l.value);
                return create(l.next, result.next, k);
            }

            else return create(l.next, result, k);
        } else return result;
    }


}
