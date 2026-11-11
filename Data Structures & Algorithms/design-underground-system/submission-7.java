// class UndergroundSystem {

//     private  HashMap<Integer, String> checked_in_station_name;
//     private  HashMap<Integer, Integer> checked_in_time;
//     private  HashMap<List<String>, ArrayList<Integer>> durationTracker;

//     public UndergroundSystem() {
//         checked_in_station_name = new HashMap<>();
//         checked_in_time = new HashMap<>();
//         durationTracker = new HashMap<>();

//     }
//     public void checkIn(int id, String stationName, int t) {
//         checked_in_station_name.put(id,stationName);
//         checked_in_time.put(id, t);
//     }
//     public void checkOut(int id, String stationName, int t) {
//         int startTime = checked_in_time.get(id);
//         int endTime = t;

//         String startingStation = checked_in_station_name.get(id);
//         String endingStation = stationName;

//         List<String> tripLabel = List.of(startingStation, endingStation);
//         int duration = endTime - startTime;

//         checked_in_station_name.remove(id);
//         checked_in_time.remove(id);
        
//         if (durationTracker.containsKey(tripLabel)) {
//             ArrayList<Integer> current = durationTracker.get(tripLabel);
//             current.set(0, current.get(0) + duration);
//             current.set(1, current.get(1) + 1);
//             durationTracker.put(tripLabel, current);
//         } else {
//             ArrayList<Integer> empty = new ArrayList<>();
//             empty.add(duration);
//             empty.add(1);
//             durationTracker.put(tripLabel, empty);
//         }

    
//     }
//     public double getAverageTime(String startStation, String endStation) {
//         List<String> tripLabel = new ArrayList<String>(List.of(startStation, endStation));
//         ArrayList<Integer> stationHistory = durationTracker.get(tripLabel);

//         // int sum = 0;
//         // for (int item: stationHistory) {
//         //     sum += item;
//         // }

//         // double average = (double) sum / stationHistory.size();
//         double average = (double) stationHistory.get(0) / stationHistory.get(1);

//         return average;
//     }
// }

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
