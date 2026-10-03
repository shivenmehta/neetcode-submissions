class Solution {


    public List<List<Integer>> nodeEdges (List<List<Integer>> edges, int startingPoint) {

        List<List<Integer>> nodeEdges = new ArrayList<>();

        for (List<Integer> edge: edges) {

            if (edge.get(0) == startingPoint) {
                nodeEdges.add(Arrays.asList(edge.get(1), edge.get(2)));
            }

        }

        return nodeEdges;
    }

    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer,Integer> shortestPath = new HashMap<>();

        shortestPath.put(src, 0);

        List<List<Integer>> nodeEdges = nodeEdges(edges, src);
        for (List<Integer> edge: nodeEdges) {
            minHeap.add(new int[]{edge.get(0), edge.get(1)});
        }

        while (!minHeap.isEmpty() && shortestPath.size() < n) {
            int[] minNode = minHeap.poll();
            System.out.println(Arrays.toString(minNode));
            
            if (shortestPath.containsKey(minNode[0])) continue; //Check if shortestPath already exists for node

            shortestPath.put(minNode[0], minNode[1]); // <2,3>

            nodeEdges = nodeEdges(edges, minNode[0]); //Return list of all edges from minNode

            for (List<Integer> edge: nodeEdges) {
                minHeap.add(new int[]{edge.get(0), minNode[1] + edge.get(1)});
            }

            

        }

        if (shortestPath.size() < n) {
            for (int i = 0 ; i < n; i++) {
                if (!shortestPath.containsKey(i)) {
                        shortestPath.put(i, -1);
                }
            }
        }

        return shortestPath;
        
    }  
}
