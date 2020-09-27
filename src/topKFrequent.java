
import java.util.*;

/**
 * @Auther: 99615
 * @Date: 2020/9/7 18:57
 * @Description:
 */
public class topKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i])+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> (o2.getValue()-o1.getValue()));
        int i = 0;
        for (Map.Entry<Integer, Integer> entry: list) {
            if (i < k)
                ans[i++] = entry.getKey();
//            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,3, 3,2,2,3};

        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
