
import java.util.*;

/**
 * @Auther: 99615
 * @Date: 2020/9/16 15:44
 * @Description:
 */
public class AllOne {

    static class Cache extends LinkedHashMap<String, Integer>{


        public Cache() {
            super();
        }

        public int get(String key) {
            return super.getOrDefault(key, -1);
        }

        public void put(String key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
            return eldest.getValue() <= 1;
        }
    }
    /**
     * Initialize your data structure here.
     */
    int maxVal = 1;
    String maxKey = "";
    String minKey = "";
    int minVal = Integer.MAX_VALUE;
    Map<String, Integer> cache;
    public AllOne() {
        cache = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (cache.size() == 0) {
            maxVal = 1;
            minVal = 1;
            maxKey = minKey = key;
        }
        if (cache.containsKey(key)) {
            int val = cache.get(key)+1;
            cache.put(key, val);
           if (val > maxVal) {
               maxVal = val;
               maxKey = key;
           }
        }

        else {
            cache.put(key, 1);
            minVal = 1;
            minKey = key;
        }

    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {

        if (cache.containsKey(key)) {
            int val = cache.get(key);

            if (val == 1) {
                cache.remove(key);
                if (cache.isEmpty()) {
                    minKey = maxKey = "";
                    minVal = Integer.MAX_VALUE;
                    maxVal = 1;
                }
            }

            else {
                cache.put(key, val - 1);
                if (val < minVal) {
                    minVal = val;
                    minKey = key;
                }
            }

        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return maxKey;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return minKey;
    }
}
