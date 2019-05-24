package org.lvzhouyang.datastructure.string;

/**
 * The type String to int.
 * 输入一个由数字组成的字符串，把它转换成整数并输出。例如：输入字符串"123"，输出整数123。
 * 给定函数原型int StrToInt(const char *str) ，实现字符串转换成整数的功能，不能使用库函数atoi。
 * <p>
 * <p>
 * 空指针输入：输入的是指针，在访问空指针时程序会崩溃，因此在使用指针之前需要先判断指针是否为空。
 * 正负符号：整数不仅包含数字，还有可能是以'+'或'-'开头表示正负整数，因此如果第一个字符是'-'号，则要把得到的整数转换成负整数。
 * 非法字符：输入的字符串中可能含有不是数字的字符。因此，每当碰到这些非法的字符，程序应停止转换。
 * 整型溢出：输入的数字是以字符串的形式输入，因此输入一个很长的字符串将可能导致溢出。
 *
 * @author lvzhouyang
 * @version 1.0
 * @since 2019.05.24
 */
public class StringToInt {
    private static final int DEFAULT = 0;


    public static int convert(String s) throws Exception {
        if (s.isEmpty()) {
            return DEFAULT;
        }
        boolean negative = false;
        int limit = -Integer.MAX_VALUE;
        int length = s.length(), i = 0;
        int multmin;
        int digit;
        int result = 0;
        if (length > 0) {

            if (s.charAt(0) < '0') {
                if (s.startsWith("-")) {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (!s.startsWith("+")) {
                    throw new Exception();
                }
                if (length == 1) {
                    throw new Exception();
                }
                i++;

            }
            multmin = limit / 10;
            while (i < length) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++), 10);
                if (digit < 0) {
                    throw new Exception();
                }
                if (result < multmin) {
                    throw new Exception();
                }
                result *= 10;
                if (result < limit + digit) {
                    throw new Exception();
                }
                result -= digit;
            }

        }
        return negative ? result : -result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(convert("123"));
    }
}
