package hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class GroupingDishes {
    String[][] solution(String[][] dishes) {
        Map<String, TreeSet<String>> ingr = new HashMap<>();
        for (int i = 0; i < dishes.length; i++) {
            for (int j = 1; j < dishes[i].length; j++) {
                TreeSet<String> dish;
                if (ingr.get(dishes[i][j]) == null)
                    dish = new TreeSet<String>();
                else dish = ingr.get(dishes[i][j]);
                dish.add(dishes[i][0]);
                ingr.put(dishes[i][j], dish);
            }
        }
        TreeSet<String> base = new TreeSet<String>();
        for (Map.Entry<String, TreeSet<String>> entry : ingr.entrySet()) {
            String key = entry.getKey();
            base.add(key);
        }

        String[][] newDishes = new String[base.size()][];
        int i = 0;
        for (String key : base) {
            TreeSet<String> value = ingr.get(key);
            int j = 1;
            if (value.size() < 2) continue;
            String[] temp = new String[value.size() + 1];
            temp[0] = key;
            for (String item : value) {
                temp[j] = item;
                j++;
            }
            newDishes[i] = temp;
            i++;
        }
        String[][] arr = new String[i][];
        arr = Arrays.copyOf(newDishes, i);
        return arr;
    }

}
