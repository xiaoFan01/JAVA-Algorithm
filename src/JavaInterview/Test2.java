package JavaInterview;

public class Test2 {
    public static LNode addResult(LNode head1, LNode head2){
        if (head1 == null || head1.next == null)
            return head2;
        if (head2 == null || head2.next == null)
            return head1;
        LNode result = new LNode();
        result.next = null;
        LNode cur1 = head1.next;
        LNode cur2 = head2.next;
        LNode cur3 = result;
        int flag = 0;
        for (;cur1 != null && cur2 != null; cur1 = cur1.next, cur2 = cur2.next, cur3 = cur3.next){
            LNode tmp = new LNode();
            tmp.data = (cur1.data+cur2.data+flag)%10;
            flag = (cur1.data+cur2.data+flag)/10;
            cur3.next = tmp;
        }
        if (cur1 == null){
            while (flag == 1){
                LNode temp1 = new LNode();
                if (cur2 == null){
                    temp1.data = flag;
                    temp1.next = null;
                    cur3.next = temp1;
                    cur3 = temp1;
                    break;
                }else {
                    temp1.data = (cur2.data+flag)%10;
                    flag = (cur2.data+flag)/10;
                    cur3.next = temp1;
                    cur3 = temp1;
                    cur2 = cur2.next;
                }
            }
            cur3.next = cur2;
        }else if (cur2 == null){
            while (flag == 1){
                LNode temp2 = new LNode();
                if (cur1 == null){
                    temp2.data = flag;
                    temp2.next = null;
                    cur3.next = temp2;
                    cur3 = temp2;
                    break;
                }else{
                    temp2.data = (cur1.data+flag)%10;
                    flag = (cur1.data+flag)/10;
                    cur3.next = temp2;
                    cur3 = temp2;
                    cur1 = cur1.next;
                }
            }
            cur3.next = cur1;
        }
        return result;
    }
    public static void main(String[] args) {
        LNode head1 = new LNode();
        head1.next = null;
        LNode head2 = new LNode();
        head2.next = null;
        LNode cur1 = head1;
        LNode cur2 = head2;
        for (int i = 1; i < 10; i++){
            LNode tmp = new LNode();
            tmp.data = i;
            tmp.next = null;
            if (i % 2 != 0){
                cur1.next = tmp;
                cur1 = cur1.next;
            }else {
                cur2.next = tmp;
                cur2 = cur2.next;
            }
        }
        System.out.println("链表1：");
        for (cur1 = head1.next; cur1 != null; cur1 = cur1.next){
            System.out.print(cur1.data + "  ");
        }
        System.out.println();
        System.out.println("链表2：");
        for (cur2 = head2.next; cur2 != null; cur2 = cur2.next){
            System.out.print(cur2.data + "  ");
        }
        LNode result = addResult(head1,head2);
        System.out.println();
        System.out.println("相加后的链表：");
        for (LNode cur3 = result.next; cur3 != null; cur3 = cur3.next){
            System.out.print(cur3.data + "  ");
        }
    }
}
