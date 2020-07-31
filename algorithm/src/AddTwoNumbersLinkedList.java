import java.math.BigDecimal;

/**
 * @author hankin
 * @date 2020/7/31 15:44
 */
public class AddTwoNumbersLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5;
        ListNode l3 = null;
        while (l1 != null) {
            s1 += String.valueOf(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2 += String.valueOf(l2.val);
            l2 = l2.next;
        }
        if (s1.length() >= s2.length()) {
            for (int i = s1.length() - 1; i >= 0; i--) {
                s3 += s1.charAt(i);
                if (i < s2.length()) {

                    s4 += s2.charAt(i);
                }
            }
        } else {
            for (int i = s2.length() - 1; i >= 0; i--) {
                s4 += s2.charAt(i);
                if (i < s1.length()) {
                    s3 += s1.charAt(i);

                }
            }
        }


        BigDecimal b1 = new BigDecimal(s3);
        BigDecimal b2 = new BigDecimal(s4);
        s5 = b1.add(b2).toString();

        ListNode point1 = null;
        ListNode point2;
        for (int i = s5.length() - 1; i >= 0; i--) {
            if (l3 == null) {
                l3 = new ListNode(Integer.parseInt(String.valueOf(s5.charAt(i))));
                point1 = l3;
            } else {
                point2 = new ListNode(Integer.parseInt(String.valueOf(s5.charAt(i))));
                point1.next = point2;
                point1 = point2;
            }
        }
        return l3;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
