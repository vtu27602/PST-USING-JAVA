import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private static class CheckInRecord {
        String stationName;
        int time;

        public CheckInRecord(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class RouteData {
        long totalTime = 0;
        int totalTrips = 0;
    }

    private Map<Integer, CheckInRecord> checkInMap;
    private Map<String, RouteData> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInRecord(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInRecord record = checkInMap.remove(id);
        if (record != null) {
            String routeKey = record.stationName + "->" + stationName;
            int travelTime = t - record.time;
            
            RouteData data = routeMap.computeIfAbsent(routeKey, k -> new RouteData());
            data.totalTime += travelTime;
            data.totalTrips += 1;
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteData data = routeMap.get(routeKey);
        if (data == null || data.totalTrips == 0) {
            return 0.0;
        }
        return (double) data.totalTime / data.totalTrips;
    }
}
Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]

Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
