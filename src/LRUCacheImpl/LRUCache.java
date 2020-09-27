package LRUCacheImpl;

import java.util.*;

/**
 * @Auther: 99615
 * @Date: 2020/9/16 15:26
 * @Description:
 */
class LRUCache {
    private int CACHE_SIZE;
    private int size;
    private Deque<Integer> queue;
    private Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.CACHE_SIZE = capacity;
        this.map = new HashMap<>();
        this.size = 0;
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            queue.remove(key);
            queue.addLast(key);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            queue.remove(key);
            queue.addLast(key);
        }
        else if (CACHE_SIZE == size) {
            int removeKey = queue.removeFirst();
            map.remove(removeKey);
            map.put(key, value);
            queue.addLast(key);
        }
        else {
            map.put(key, value);
            queue.addLast(key);
            size++;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        cache.get(1);
        System.out.println(cache.get(2));
    }
}
