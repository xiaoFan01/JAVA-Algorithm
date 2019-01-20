package JavaInterview;

public class Test7 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        for (int i = 1; i < 6; i++){
            stack.push(i);
        }
        MyQueue queue = new MyQueue();
        System.out.println("初始栈内元素：");
        while (stack.size()>0){
            System.out.print(stack.top() + " ");
            queue.enQueue(stack.pop());
        }
        while (queue.size()>0){
            stack.push(queue.getFront());
            queue.deQueue();
        }
        System.out.println();
        System.out.println("反转后栈内元素：");
        while (stack.size()>0){
            System.out.print(stack.pop() + " ");
        }
    }
}
