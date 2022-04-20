package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraverseTree {
    // Binary trees are already defined with this interface:
    class Tree<T> {
        Tree(T x) {
            value = x;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    int[] solution(Tree<Integer> t) {
        if (t == null) return new int[0];

        List<Integer> res = new ArrayList<>();
        Queue<Tree<Integer>> queue = new LinkedList<>();
        queue.add(t);
        while (!queue.isEmpty()) {
            Tree<Integer> elem = queue.poll();
            res.add(elem.value);
            if (elem.left != null) queue.add(elem.left);
            if (elem.right != null) queue.add(elem.right);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

}
