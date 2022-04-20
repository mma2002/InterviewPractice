package linkedlists;

public class MergeTwoLinkedLists {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    ListNode<Integer> head;

    ListNode<Integer> solution(ListNode<Integer> l1, ListNode<Integer> l2) {
        return traverse(l1, l2, null);
    }

    ListNode<Integer> traverse(ListNode<Integer> l1, ListNode<Integer> l2, ListNode<Integer> prev) {
        if (l1 == null && l2 == null) return head;
        boolean isFromFirst = false;

        if (l1 != null && l2 != null) {
            if (l1.value.intValue() > l2.value.intValue()) prev = insertAfter(prev, l2.value);
            else if (l2.value.intValue() > l1.value.intValue()) {
                prev = insertAfter(prev, l1.value);
                isFromFirst = true;
            } else prev = insertAfter(prev, l2.value);

        } else {
            if (l1 == null) prev = insertAfter(prev, l2.value);
            else if (l2 == null) {
                prev = insertAfter(prev, l1.value);
                isFromFirst = true;
            }
        }

        traverse((l1 != null && isFromFirst ? l1.next : l1), (l2 != null && isFromFirst == false ? l2.next : l2), prev);
        return head;

    }

    ListNode<Integer> insertAfter(ListNode<Integer> prev_node, int new_data) {
        if (prev_node == null) {
            head = new ListNode<>(new_data);
            return head;
        }

        ListNode<Integer> new_node = new ListNode<Integer>(new_data);

        new_node.next = prev_node.next;

        prev_node.next = new_node;

        return new_node;
    }

}
