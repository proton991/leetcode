package sortAlgorithm;

import static sortAlgorithm.SortUtils.printArr;

/**
 * @Auther: 99615
 * @Date: 2020/9/11 17:58
 * @Description:
 */
public class HeapSort {
    public int[] sort(int[] nums) {
        int n = nums.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify_min(nums, n, i);
        }
        for (int i = n-1; i >= 0; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;

            heapify_min(nums, i, 0);
        }
        return nums;
    }

    public void heapify_max(int[] nums, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = i;
        if (left < n && nums[left] < nums[min])
            min = left;
        if (right < n && nums[right] < nums[min])
            min = right;
        if (min != i) {
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
            heapify_max(nums, n, min);
        }
    }
    public void heapify_min(int[] nums, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < n && nums[left] > nums[max])
            max = left;
        if (right < n && nums[right] > nums[max])
            max = right;
        if (max != i) {
            int tmp = nums[i];
            nums[i] = nums[max];
            nums[max] = tmp;
            heapify_min(nums, n, max);
        }
    }
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        heapSort.sort(nums);
        printArr(nums);
    }
}
