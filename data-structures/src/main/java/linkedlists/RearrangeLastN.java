package linkedlists;

public class RearrangeLastN {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    ListNode<Integer> head;
    int count = 0;
    ListNode<Integer> prev;

    ListNode<Integer> solution(ListNode<Integer> l, int n) {
        if (l == null || n == 0) return l;
        solution(l.next, n);
        count++;
        if (n >= count) {
            push(l.value);
            if (n == count) {
                ListNode<Integer> temp = head;
                while (temp != null) {
                    prev = temp;
                    temp = temp.next;
                }
            }
        } else {
            insertAfter(prev, l.value);
        }
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

    void push(int new_data) {

        ListNode<Integer> new_node = new ListNode<>(new_data);


        new_node.next = head;


        head = new_node;
    }

}
