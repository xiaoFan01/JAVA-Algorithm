package JavaInterview;

class Node<T>{
    T data;
    Node<T> next;
}
class Stack<T>{
    private Node<T> head;
    public Stack(){
        head = new Node<T>();
        head.data = null;
        head.next = null;
    }
    boolean isEmpty(){
        return head.next == null;
    }
    int size(){
        int size = 0;
        Node<T> p = head.next;
        while (p != null){
            size++;
            p = p.next;
        }
        return size;
    }
    void push(T data){
        Node<T> tmp = new Node<T>();
        tmp.data = data;
        tmp.next = head.next;
        head.next = tmp;
    }
    T pop(){
        if (head.next != null){
            Node<T> tmp = head.next;
            head.next = tmp.next;
            return tmp.data;
        }
        System.out.println("栈空");
        return null;
    }
    T top(){
        if (head.next != null){
            return head.next.data;
        }
        System.out.println("栈空");
        return null;
    }
}
public class Test5 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        System.out.println("栈顶元素：" + stack.top());
        System.out.println("栈的大小：" + stack.size());
        stack.pop();
        System.out.println("弹栈成功");
        stack.pop();
    }
}
