package JavaInterview;
/*
* 给定一个单链表，将其逆序：
* head ->1 ->2 ->3 ->4 ->5 ->6 ->7
* 逆序后：
* head ->7 ->6 ->5 ->4 ->3 ->2 ->1
*/

//node节点
class LNode{
    int data;
    LNode next;
}
public class Test {

//    ①逆序方法-就地逆序
//    public static void Reverse(LNode head){
//        if (head == null || head.next == null)
//            return;
//        //一下三个分别表示 当前节点、前驱节点、后续节点
//        LNode cur = null;
//        LNode pre = null;
//        LNode next = null;
//
//        cur = head.next;
//        next = cur.next;
//        cur.next = null;
//        pre = cur;
//        cur = next;
//        //让遍历到的节点指向前驱节点
//        while (cur.next != null){
//            next = next.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        //遍历结束，让head指向原链表的尾节点
//        cur.next = pre;
//        head.next = cur;
//    }
//  ②插入法逆序
    public static void Reverse(LNode head){
        if (head == null || head.next == null)
            return;
        LNode cur = head.next;
        LNode next = cur.next;
        while (next != null){
            cur.next = next.next;
            next.next = head.next;
            head.next = next;
            next = cur.next;
        }
    }

    public static void main(String[] args) {
        //头节点
        LNode head = new LNode();
        head.next = null;
        LNode tmp = null;
        LNode cur = head;
        //构造单链表
        for (int i=1; i<8; i++){
            tmp = new LNode();
            tmp.data = i;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        System.out.println("逆序前：");
        for (cur = head.next; cur != null; cur = cur.next){
            System.out.print(cur.data + "  ");
        }
        System.out.println();
        Reverse(head);
        System.out.println("逆序后：");
        for (cur = head.next; cur != null; cur = cur.next){
            System.out.print(cur.data + "  ");
        }
    }
}
