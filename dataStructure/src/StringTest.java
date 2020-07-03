/**
 * @author hankin
 * @date 2020/7/3 15:49
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 =new String("abc");
        String s2 =new String("abc");
        System.out.println(s1==s2);
        String s3 = "abc";
        System.out.println(s2==s3);
        String s4 = "abc";
        System.out.println(s3==s4);
    }
}
