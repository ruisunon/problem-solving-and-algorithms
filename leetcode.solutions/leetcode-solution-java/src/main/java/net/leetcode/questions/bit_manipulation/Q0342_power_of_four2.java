package net.leetcode.questions.bit_manipulation;

/**
 * @author liwei
 * @date 18/6/30 下午6:16
 */
public class Q0342_power_of_four2 {

    /**
     * 转换成四进制数
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && Integer.toString(num,4).matches("^10*$");
    }
}
