package sortAlgorithm;

import static sortAlgorithm.SortUtils.printArr;
import static sortAlgorithm.SortUtils.swap;

/**
 * @Auther: 99615
 * @Date: 2020/9/11 15:21
 * @Description:
 */
public class BubbleSort {
    public int[] sort(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        return arr;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        bubbleSort.sort(nums);
        printArr(nums);
    }
}
