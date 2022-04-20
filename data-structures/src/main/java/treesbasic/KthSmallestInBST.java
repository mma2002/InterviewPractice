package treesbasic;

import java.util.ArrayList;

public class KthSmallestInBST {

    // Binary trees are already defined with this interface:
    class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    int solution(Tree<Integer> t, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        traverseInOrder(t, list);
        return list.get(k - 1);
    }

    void traverseInOrder(Tree<Integer> node, ArrayList<Integer> list) {
        if (node != null) {

            traverseInOrder(node.left, list);
            // System.out.print(" " + node.value);
            list.add(node.value);
            traverseInOrder(node.right, list);
        }

    }

}
