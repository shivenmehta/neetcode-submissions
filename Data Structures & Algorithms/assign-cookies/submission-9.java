class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Map<Integer, Integer> childMap = new HashMap<>();

        // for (int i = 0; i < g.length; i++) {
        //     int greedFactor = g[i];
        //     if (childMap.containsKey(greedFactor)) {
        //         childMap.put(greedFactor, childMap.get(greedFactor) + 1);
        //     } else {
        //         childMap.put(greedFactor, 1);
        //     }
        // }

        Arrays.sort(g);
        Arrays.sort(s);

        int total = 0;

        System.out.println(Arrays.toString(g));
        System.out.println(Arrays.toString(s));

        for (int i = 0; i < s.length; i++) {
            int currentCookie = s[i];

            for (int j = 0; j < g.length; j++) {
                int greedFactor = g[j];

                if (greedFactor == 0) continue;

                if (greedFactor > currentCookie) {
                    break;
                }

                if (greedFactor == currentCookie) {
                    total += 1;
                    g[j] = 0;
                    break;
                }
                if (greedFactor < currentCookie) {
                    if (j == g.length - 1) {
                        total += 1;
                        g[j] = 0;
                        break;
                    } else if (g[j+1] > currentCookie || g[j+1] == 0) {
                        total += 1;
                        g[j] = 0;
                        break;
                    } else {
                        continue;
                    }
                }
            }

        }
        return total;
    }
}