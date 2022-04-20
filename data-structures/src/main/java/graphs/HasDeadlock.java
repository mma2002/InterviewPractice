package graphs;

public class HasDeadlock {
    boolean solution(int[][] connections) {
        boolean visited[] = new boolean[connections.length];
        boolean reStack[] = new boolean[connections.length];
        for (int i = 0; i < connections.length; i++) {
            if (DFSUtil(connections, i, visited, reStack)) return true;
        }


        return false;

    }

    boolean DFSUtil(int[][] connections, int i, boolean visited[], boolean reStack[]) {
        if (reStack[i]) return true;
        if (visited[i]) return false;

        visited[i] = true;
        reStack[i] = true;
        int j = 0;
        while (j < connections[i].length) {
            if (DFSUtil(connections, connections[i][j], visited, reStack))
                return true;
            j++;
        }
        reStack[i] = false;
        return false;

    }
}
