package org.lvzhouyang.datastructure.string;

/**
 * The type Contains.
 * 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
 * 为了简单起见，我们规定输入的字符串只包含大写英文字母，请实现函数bool StringContains(string &A, string &B)
 * 比如，如果是下面两个字符串：
 * String 1：ABCD
 * String 2：BAD
 * 答案是true，即String2里的字母在String1里也都有，或者说String2是String1的真子集。
 * 如果是下面两个字符串：
 * String 1：ABCD
 * String 2：BCE
 * 答案是false，因为字符串String2里的E字母不在字符串String1里。
 * 同时，如果string1：ABCD，string 2：AA，同样返回true。
 *
 * @author lvzhouyang
 * @version 1.0
 * @since 2019.05.24
 */
public class Contains {
    /**
     * 我们可以对字符串A，用位运算（26bit整数表示)计算出一个“签名”，再
     * 用B中的字符到A里面进行查找。
     *
     * @param a the a
     * @param b the b
     * @return the boolean
     * @since 2019.05.24
     */
    public static boolean containsHash(String a, String b) {
        int hash = 0;
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        for (int i = 0; i < a.length(); ++i) {
            hash |= (1 << (aChars[i] - 'A'));
        }
        for (int i = 0; i < b.length(); ++i) {
            if ((hash & (1 << (bChars[i] - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "abc";
        String c = "abe";

        System.out.println(containsHash(a, b));
        System.out.println(containsHash(a, c));

    }
}
