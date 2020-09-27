package SlidingWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auther: 99615
 * @Date: 2020/9/12 13:57
 * @Description:
 */
public class longest_substring_without_repeating_characters {
    Map<Character, Integer> map = new HashMap<>();
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0, right = 0;
        int n = s.length();
        while (right < n) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while (!check() && left <= right) {
                char lch = s.charAt(left);
                int count = map.get(lch);
                map.put(lch, count-1);
                left++;
            }
            int curLen = right - left + 1;
            maxLen = Math.max(curLen, maxLen);
            right++;
        }
        return maxLen;
    }
    private boolean check() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer val = entry.getValue();
            if (val > 1)
                return false;
        }
        return true;
    }

}
