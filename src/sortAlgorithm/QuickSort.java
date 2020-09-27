package sortAlgorithm;

import static sortAlgorithm.SortUtils.printArr;
import static sortAlgorithm.SortUtils.swap;

/**
 * @Auther: 99615
 * @Date: 2020/9/11 16:21
 * @Description:
 */
public class QuickSort {

    public int[] sort(int[] nums) {
        doSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void doSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            doSort(nums, left, pivot-1);
            doSort(nums, pivot, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        int pivot = nums[mid];
        while (left <= right) {
            while (nums[left] < pivot) {
                ++left;
            }
            while (nums[right] > pivot) {
                --right;
            }
            if (left <= right) {
                swap(nums, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        quickSort.sort(nums);
        printArr(nums);
    }
}
