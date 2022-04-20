package linkedlists;

public class ReverseNodesInKGroups {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    ListNode<Integer> head;

    ListNode<Integer> solution(ListNode<Integer> l, int k) {
        if (k == 1) return l;
        int count = 1;
        ListNode<Integer> prev = null;
        ListNode<Integer> temp = null;

        while (l != null) {

            if (temp == null) temp = new ListNode<>(l.value);
            else temp = push(temp, l.value);

            if (count == k) {
                while (temp != null) {
                    prev = insertAfter(prev, temp.value);
                    temp = temp.next;
                }
                count = 0;
            }
            count++;
            l = l.next;
        }

        traverse(temp, prev);
        return head;
    }

    ListNode<Integer> traverse(ListNode<Integer> temp, ListNode<Integer> prev) {
        if (temp == null) return prev;
        prev = traverse(temp.next, prev);
        System.out.println(temp.value);
        prev = insertAfter(prev, temp.value);

        return prev;
    }


    ListNode<Integer> push(ListNode<Integer> head, int new_data) {

        ListNode<Integer> new_node = new ListNode<>(new_data);


        new_node.next = head;


        head = new_node;

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
