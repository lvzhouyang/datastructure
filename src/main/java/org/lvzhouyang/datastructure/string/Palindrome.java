package org.lvzhouyang.datastructure.string;

/**
 * The type Palindrome.
 * 回文，英文palindrome，指一个顺着读和反过来读都一样的字符串，比如madam、我爱我，这样的短句在智力性、趣味性和艺术性上都颇有特色，中国历史上还有很多有趣的回文诗。
 * <p>
 * 那么，我们的第一个问题就是：判断一个字串是否是回文？
 *
 * @author lvzhouyang
 * @version 1.0
 * @since 2019.05.24
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        int left, right;
        int mid = (s.length() >> 1) - 1 > 0 ? (s.length() >> 1) - 1 : 0;
        left = mid;
        right = mid + 1 + (s.length() & ((1 << 1) - 1));
        while (left >= 0) {
            if (s.charAt(left--) != s.charAt(right++)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("s"));
        System.out.println(isPalindrome("is5si"));
        System.out.println(isPalindrome("i1i"));
        System.out.println(isPalindrome("idssdi"));
    }
}
