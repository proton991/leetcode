package Stack_and_Queue;

import java.util.Stack;

/**
 * @Auther: 99615
 * @Date: 2020/9/7 16:20
 * @Description:
 */

/**
 * Example
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 */
public class decodeString {
    public String decodeString_Solution(String s) {
        int num = 0;
        Stack<Integer> digitStack = new Stack<>();
        Stack<StringBuffer> alphaStack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                digitStack.push(num);
                num = 0;
                alphaStack.push(sb);
                sb = new StringBuffer();
            } else if (Character.isAlphabetic(ch)) {
                sb.append(ch);
            } else {

                StringBuffer tmpBuffer = alphaStack.pop();
                int tmpVal = digitStack.pop();
                for (int j = 0; j < tmpVal; j++) {
                    tmpBuffer.append(sb);
                }
                sb = tmpBuffer;
            }
        }
        return sb.toString();
    }


}
