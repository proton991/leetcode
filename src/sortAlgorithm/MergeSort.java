package sortAlgorithm;

import static sortAlgorithm.SortUtils.printArr;

/**
 * @Auther: 99615
 * @Date: 2020/9/11 16:10
 * @Description:
 */
public class MergeSort {

    public int[] sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(nums, l, m);
            sort(nums, m+1, r);
            merge(nums, l, m, r);

        }
    }

    public void merge(int[] nums, int l, int m, int r) {
        int length = r - l + 1;
        int[] tmp = new int[length];
        int i = l, j = m + 1;
        int k = 0;

        while (i <= m && j <= r) {
            if (nums[i] < nums[j])
                tmp[k++] = nums[i++];
            else
                tmp[k++] = nums[j++];
        }
        while (i <= m) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }

        System.arraycopy(tmp, 0, nums, l, length);


    }
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        mergeSort.sort(nums);
        printArr(nums);
    }
}
