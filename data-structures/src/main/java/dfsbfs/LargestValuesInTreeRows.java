package dfsbfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValuesInTreeRows {
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
            int max = queue.peek().value;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Tree<Integer> elem = queue.poll();
                if (elem.value.intValue() > max) max = elem.value.intValue();
                if (elem.left != null) queue.add(elem.left);
                if (elem.right != null) queue.add(elem.right);
            }
            res.add(max);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

}
