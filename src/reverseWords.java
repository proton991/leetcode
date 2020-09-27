import java.util.Arrays;

/**
 * @Auther: 99615
 * @Date: 2020/9/13 15:10
 * @Description:
 */
public class reverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuffer buffer = new StringBuffer();
        String[] arr = s.split("\\s+");
        for (int i = arr.length - 1; i >= 0; i--) {
            buffer.append(arr[i]);
            buffer.append(" ");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";



    }
}
