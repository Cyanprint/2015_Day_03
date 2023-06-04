import java.util.HashMap;

public class Delivery {
    private static HashMap<String, Integer> housesHashMap = new HashMap<>();

    public static void deliver(String coordinates) {
        housesHashMap.putIfAbsent(coordinates, 0);
        housesHashMap.replace(coordinates, housesHashMap.get(coordinates) + 1);
    }

    public static int numHouses() {
        return housesHashMap.size();
    }

    public static void clear() {
        housesHashMap.clear();
    }
}
