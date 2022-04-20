package treesbasic;

public class IsSubtree {
    // Binary trees are already defined with this interface:
    class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    boolean solution(Tree<Integer> t1, Tree<Integer> t2) {
        if ((t1 == null && t2 == null) || t2 == null) return true;
        else if (t1 == null) return false;
        return traversePreOrder(t1, t2);
    }

    boolean traversePreOrder(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 != null) {
//			System.out.print(" " + t1.value);
            if (t1.value.intValue() == t2.value.intValue())
                return traversePreOrderTwoTrees(t1, t2);
            return (traversePreOrder(t1.left, t2)) ||
                    (traversePreOrder(t1.right, t2));
        }

        return false;
    }

    boolean traversePreOrderTwoTrees(Tree<Integer> t1, Tree<Integer> t2) {
        if ((t1 != null && t2 == null) || (t1 == null && t2 != null)) return false;
        if (t1 == null && t2 == null)
            return true;
        if (t1 != null && t2 != null) {
            System.out.print(" t1= " + t1.value);
            System.out.print(" t2= " + t2.value);
            return t1.value.intValue() == t2.value.intValue() &&
                    (traversePreOrderTwoTrees(t1.left, t2.left)) &&
                    (traversePreOrderTwoTrees(t1.right, t2.right));
        }
        return false;
    }

}
