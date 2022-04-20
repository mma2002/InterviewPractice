package heapsstackqueues;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    String solution(String path) {
        Stack<String> stack = new Stack<>();
        String[] aPath = path.split("/");
        String newPath = "";
        for (int i = 0; i < aPath.length; i++) {
            String p = aPath[i];
            if (p.isEmpty()) continue;
            if (p.equals(".")) continue;
            if (p.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                continue;
            }
            stack.push("/" + aPath[i]);
        }

        Iterator<String> iter = stack.iterator();
        List<String> list = new ArrayList<>();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        for (String item : list) {
            newPath += item;
        }
        return (newPath.isEmpty() ? "/" : newPath);

    }

}
