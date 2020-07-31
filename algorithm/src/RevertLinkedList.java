/**
 * @author hankin
 * @date 2020/7/31 17:43
 */
public class RevertLinkedList {
    public static void main(String[] args) {
        ListNode l1 =new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(3);
         /*l1.next.next.next=new ListNode(4);
        l1.next.next.next.next=new ListNode(5);*/
        ListNode listNode = reverseList(l1);
        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {
        if (head.next==null){
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }


}

