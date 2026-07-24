import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    private static class RouteInfo {
        double totalTime = 0;
        int count = 0;

        void addTrip(int duration) {
            this.totalTime += duration;
            this.count++;
        }

        double getAverage() {
            return totalTime / count;
        }
    }
    private Map<Integer, CheckInInfo> checkInMap;
    private Map<String, RouteInfo> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkIn = checkInMap.remove(id);
        
        String routeKey = checkIn.stationName + "->" + stationName;
        int travelTime = t - checkIn.time;
        routeMap.putIfAbsent(routeKey, new RouteInfo());
        routeMap.get(routeKey).addTrip(travelTime);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        return routeMap.get(routeKey).getAverage();
    }
}
