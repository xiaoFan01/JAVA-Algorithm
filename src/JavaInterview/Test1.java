package JavaInterview;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public static void removeDuplication(LNode head){
//        ①双层for循环实现链表去重
//        if (head == null || head.next == null)
//            return;
//        LNode cur = head.next;
//        LNode inner = null;
//        LNode innerPre = null;
//        for (;cur.next != null;cur = cur.next){
//            innerPre = cur;
//            for (inner = cur.next; inner != null; inner = inner.next,innerPre=innerPre.next){
//                if (inner.data == cur.data)
//                    innerPre.next = inner.next;
//            }
//        }
        //②借助额外空间（HashSet）实现去重
        if (head == null || head.next == null)
            return;
        Set set = new HashSet();
        LNode cur = null;
        cur = head.next;
        LNode pre = head;
        for (; cur.next != null; cur = cur.next){
            if (set.contains(cur.data)){
                pre.next = cur.next;
            }else {
                set.add(cur.data);
                pre = pre.next;
            }
        }
    }
    public static void main(String[] args) {
        LNode head = new LNode();
        head.next = null;
        LNode cur = head;
        LNode tmp = null;
        for (int i = 1; i<7; i++){
            tmp = new LNode();
            if (i % 2 == 0)
                tmp.data = i+1;
            else if (i % 3 == 0)
                tmp.data = i-2;
            else
                tmp.data = i;
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        System.out.println("初始化的链表");
        for (cur = head.next; cur != null; cur = cur.next){
            System.out.print(cur.data + "  ");
        }
        System.out.println();
        removeDuplication(head);
        System.out.println("去重后的链表");
        for (cur = head.next; cur != null; cur = cur.next){
            System.out.print(cur.data + "  ");
        }
    }
}
