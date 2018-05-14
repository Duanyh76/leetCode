class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<List<Integer>> firstToEndPaths = new ArrayList<>();
        allPaths.add(Arrays.asList(0));
        int endNodeValue = graph.length - 1;
        while (!allPaths.isEmpty()) {
            int pathNum = allPaths.size();
            List<List<Integer>> copyOriginPath = new ArrayList<>();
            copyOriginPath.addAll(allPaths);
            for (int pathIndex = 0; pathIndex < pathNum; pathIndex++) {
                List<Integer> path = copyOriginPath.get(pathIndex);
                int pathLength = path.size();
                int node = path.get(pathLength - 1);
                if (graph[node].length != 0) {
                    int nodeSize = graph[node].length;
                    for (int nodeIndex = 0; nodeIndex < nodeSize; nodeIndex++) {
                        List<Integer> pathWithNode = new ArrayList<>();
                        pathWithNode.addAll(path);
                        pathWithNode.add(graph[node][nodeIndex]);
                        if (graph[node][nodeIndex] == endNodeValue) {
                            firstToEndPaths.add(pathWithNode);
                        } else {
                            allPaths.add(pathWithNode);
                        }
                    }
                }
                allPaths.remove(path);
            }
        }
        return firstToEndPaths;
    }
}