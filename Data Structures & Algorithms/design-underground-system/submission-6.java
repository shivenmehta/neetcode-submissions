class UndergroundSystem {

    private Map<Integer, String> checkedInStation;
    private Map<Integer, Integer> checkedInTime;

    // route -> {total duration, trip count}
    private Map<List<String>, long[]> routeStats;

    public UndergroundSystem() {
        checkedInStation = new HashMap<>();
        checkedInTime = new HashMap<>();
        routeStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkedInStation.put(id, stationName);
        checkedInTime.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String startStation = checkedInStation.get(id);
        int startTime = checkedInTime.get(id);

        int duration = t - startTime;

        List<String> route = List.of(startStation, stationName);

        long[] stats = routeStats.getOrDefault(
            route,
            new long[2]
        );

        stats[0] += duration;
        stats[1]++;

        routeStats.put(route, stats);

        checkedInStation.remove(id);
        checkedInTime.remove(id);
    }

    public double getAverageTime(
        String startStation,
        String endStation
    ) {
        List<String> route = List.of(startStation, endStation);

        long[] stats = routeStats.get(route);

        return (double) stats[0] / stats[1];
    }
}