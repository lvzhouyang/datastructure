package org.lvzhouyang.datastructure.string;

/**
 * The type Reserve.
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
 * 使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，
 * 要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * @author lvzhouyang
 * @version 1.0
 * @since 2019.05.24
 */
public class Reserve {

    /**
     * Left shift one.
     *
     * @param chars the chars
     * @since 2019.05.24
     */
    private static void leftShiftOne(char[] chars) {
        char one = chars[0];

        System.arraycopy(chars, 1, chars, 0, chars.length - 1);
        chars[chars.length - 1] = one;
    }

    /**
     * Reserve string.
     *
     * @param chars the chars
     * @param from  the from
     * @param to    the to
     * @since 2019.05.24
     */
    private static void reserveString(char[] chars, int from, int to) {
        while (from < to) {
            char target = chars[from];
            chars[from++] = chars[to];
            chars[to--] = target;
        }
    }

    /**
     * Left rotate.
     * 时间复杂度为O(m n)，空间复杂度为O(1)
     *
     * @param chars the chars
     * @param m     the m
     * @since 2019.05.24
     */
    private static void leftRotate(char[] chars, int m) {
        while (m-- > 0) {
            leftShiftOne(chars);
        }
    }

    /**
     * Left rotate with reserve.
     *
     * @param chars the chars
     * @param m     the m
     * @since 2019.05.24
     */
    private static void leftRotateWithReserve(char[] chars, int m) {
        // 边界处理
        m %= chars.length;
        reserveString(chars, 0, m - 1);
        reserveString(chars, m, chars.length - 1);
        reserveString(chars, 0, chars.length - 1);

    }

    private static void rightRotateWithReserve(char[] chars, int m) {
        // 边界处理
        int t = chars.length - m;
        t %= chars.length;
        reserveString(chars, 0, t - 1);
        reserveString(chars, t, chars.length - 1);
        reserveString(chars, 0, chars.length - 1);

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @since 2019.05.24
     */
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
//        leftRotate(chars, 2);
//        leftRotateWithReserve(chars, 2);
        rightRotateWithReserve(chars, 2);
        System.out.println(new String(chars));
    }
}
