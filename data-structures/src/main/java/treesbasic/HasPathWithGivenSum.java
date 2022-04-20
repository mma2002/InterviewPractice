package treesbasic;

public class HasPathWithGivenSum {
    //
// Binary trees are already defined with this interface:
    class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    boolean solution(Tree<Integer> t, int s) {
        return inorderRec(t, s, 0);
    }

    boolean inorderRec(Tree<Integer> root, int s, int sum) {
        // boolean result = false;
        if (root != null) {
            Tree left = root.left;
            Tree right = root.right;
            sum += root.value;
            if (left == null && right == null) return s == sum;
            if (inorderRec(root.left, s, sum)) return true;
            // System.out.println(root.value);
            if (inorderRec(root.right, s, sum)) return true;
        }
        return false;
    }

}
