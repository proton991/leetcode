package sortAlgorithm;

import static sortAlgorithm.SortUtils.printArr;

/**
 * @Auther: 99615
 * @Date: 2020/9/11 15:49
 * @Description:
 */
public class ShellSort {

    public int[] sort(int[] nums) {
        int n = nums.length;
        int gap = n/2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int tmp = nums[i];
                int j;
                for (j = i; j >= gap && tmp < nums[j-gap]; j -= gap) {
                    nums[j] = nums[j-gap];
                }
                nums[j] = tmp;
            }
            gap /= 2;
        }
        return nums;

    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] nums = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        shellSort.sort(nums);
        printArr(nums);
    }
}
