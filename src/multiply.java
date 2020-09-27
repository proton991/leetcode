/**
 * @Auther: 99615
 * @Date: 2020/9/13 14:24
 * @Description:
 */
public class multiply {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String a = "", b = "";
        if (num1.length() <= num2.length()) {
            a = num1;
            b = num2;
        } else {
            a = num2;
            b = num1;
        }
        int[] res = new int[a.length() + b.length()];

        for (int i = a.length() - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = b.length() - 1; j >= 0; j--) {
                int ai = a.charAt(i)-'0';
                int bj = b.charAt(j)-'0';
                int tmp = ai * bj + res[i+j+1] + carry;
                res[i+j+1] = tmp % 10;
                carry = tmp / 10;
            }
            if (carry != 0) {
                res[i] += carry;
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0)
                continue;
            buffer.append(res[i]);

        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String res = multiply("123", "456");
        System.out.println(res);
    }
}
