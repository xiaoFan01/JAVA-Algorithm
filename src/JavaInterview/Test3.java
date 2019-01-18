package JavaInterview;

public class Test3 {
    //使后半段逆序
    public static LNode reverse(LNode head){
        if (head == null || head.next == null)
            return head;
        LNode headNode = new LNode();
        headNode.next = head;
        LNode cur = head;
        LNode next = head.next;
        while (next != null){
            cur.next = next.next;
            next.next = headNode.next;
            headNode.next = next;
            next = cur.next;
        }
        System.out.println();
        System.out.println("后半段逆序：");
        for(LNode tmp = headNode.next; tmp != null; tmp = tmp.next){
            System.out.print(tmp.data + "  ");
        }
        return headNode.next;
    }
    //按一定顺序合并到head
    public static void sort(LNode head){
        if (head == null || head.next == null)
            return;
        LNode mid = head;
        LNode cur = head;
        LNode next = null;
        LNode midPre = null;
        for (;cur != null; cur = cur.next.next){
            midPre = mid;
            mid = mid.next;
            if (cur.next!=null)
                continue;
            else
                break;
        }
        midPre.next = null;
        LNode reversed = reverse(mid);
        cur = head.next;
        next = cur.next;
        while (next != null){
            cur.next = reversed;
            reversed = reversed.next;
            cur = cur.next;
            cur.next = next;
            next = next.next;
            cur = cur.next;
        }
        cur.next = reversed;
    }
    public static void main(String[] args) {
        LNode head = new LNode();
        head.next = null;
        LNode tmp = null;
        LNode cur = head;
        //构造单链表
        for (int i=1; i<10; i++){
            tmp = new LNode();
            tmp.data = i;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        System.out.println("排序前：");
        for (cur = head.next; cur != null; cur = cur.next){
            System.out.print(cur.data + "  ");
        }
        sort(head);
        System.out.println();
        System.out.println("排序后：");
        for (cur = head.next; cur != null; cur = cur.next){
            System.out.print(cur.data + "  ");
        }
    }
}
