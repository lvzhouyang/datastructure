package org.lvzhouyang.datastructure.string;

/**
 * The type Calc all permutation.
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串
 * abc、acb、bac、bca、cab 和 cba。
 *
 * @author lvzhouyang
 * @version 1.0
 * @since 2019.05.24
 */
public class CalcAllPermutation {

    /**
     * 在一个字符串中找到第一个只出现一次的字符。如输入abaccdeff，则输出b
     *
     * @param s the s
     * @since 2019.05.24
     */
    public static void findFirstOne(String s) {
        int length = s.length();
        int hash = 0;
        char target = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if ((hash & (1 << chars[i])) == 0) {
                target = chars[i];
            } else {
                if (target == chars[i]) {
                    target = 0;
                }
            }
            hash |= (1 << chars[i]);

        }
        System.out.println(target);
    }

    public static void remove(String source, String target) {

    }

    public static void main(String[] args) {
        findFirstOne("abaccdeff");
    }
}
