import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 99615
 * @Date: 2020/9/5 12:12
 * @Description:
 */
public class subSets {
    List<List<Integer>> res = new ArrayList<>();
    int n, k;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < nums.length + 1; ++k) {
            backtrack(0, new ArrayList<>(), nums);
        }
        return res;
    }
    public void backtrack(int first, ArrayList<Integer> current, int[] nums) {
        if (current.size() == k)
            res.add(new ArrayList<>(current));
        for (int i = first; i < n; i++) {
            current.add(nums[i]);
            backtrack(i+1, current, nums);
            current.remove(current.size() - 1);
        }
    }
}
