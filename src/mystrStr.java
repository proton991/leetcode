/**
 * @Auther: 99615
 * @Date: 2020/9/5 11:47
 * @Description:
 */
public class mystrStr {
    public int strStr_basic(String haystack, String needle) {
        int n = haystack.length(), L = needle.length();
        for (int i = 0; i < n - L + 1; i++){
            if (haystack.substring(i, i+L).equals(needle))
                return i;
        }
        return -1;
    }

    public int strStr_backtrack(String haystack, String needle) {
        int n = haystack.length(), L = needle.length();
        if (L == 0)
            return -1;
        int pn = 0;
        while (pn < n - L + 1) {
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0))   ++pn;
            int curLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++curLen;
            }
            if (curLen == L)
                return pn - L;
            pn = pn - curLen + 1; //这里进行回溯，注意回溯的起点要+1
        }
        return -1;
    }
}
