package treesbasic;

public class FindProfession {
    String solution(int level, int pos) {
        if (level == 1) return "Engineer";
        else {
            System.out.println(level - 1 + " ");
            String parent = solution(level - 1, ((pos + 1) / 2));
            if (parent.equals("Doctor") && (pos - 1) % 2 == 0) return "Doctor";
            else if (parent.equals("Engineer") && (pos - 1) % 2 == 0) return "Engineer";
            else if (parent.equals("Engineer") && (pos - 1) % 2 == 1) return "Doctor";
            else return "Engineer";

        }
        // return "Doctor";
    }

}
