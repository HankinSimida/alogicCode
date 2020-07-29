/**
 *
 * 题源：7
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * @author hankin
 * @date 2020/7/29 23:43
 */
public class RevertNum {
    public static void main(String[] args) {
        System.out.println(reverse(1534236462));
    }
    public static long reverse(int x) {
        long a = (long) x;
        long t=0;
        long t2=0;
        long t1=0;
        if (a>(long)Math.pow(2,31)-1||a<(long)(-Math.pow(2,31))){
            return 0;
        }
        while (a!=0){
            t1 =t2*10;
            t=a-a/10*10;
            t2 = t1+t;
            a=a/10;
        }
        if (t2>(long)Math.pow(2,31)-1||t2<(long)(-Math.pow(2,31))){
            return 0;
        }
        return (int)t2;
    }
}
