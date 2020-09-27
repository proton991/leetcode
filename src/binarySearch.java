import java.util.Arrays;

/**
 * @Auther: 99615
 * @Date: 2020/9/12 16:10
 * @Description:
 */
public class binarySearch {
    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int count = 0;
        int sl = staple.length;
        for (int i = 0; i < sl; i++) {
            int curS = staple[i];
            if (curS < x) {
                int idx = find(drinks, x - curS);
                count += idx + 1;
            } else
                break;

        }
        return count % (1000000007);
    }
    public static int find(int[] d, int val) {
        int left = 0, right = d.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (d[mid] > val)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 5, 5};
        System.out.println(find(arr, 4));
    }
}
