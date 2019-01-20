package JavaInterview;

public class Test8 {
    public static void move_bottom_to_top(MyStack<Integer> stack){
        if (stack.isEmpty())
            return;
        int top1 = stack.pop();
        if (!stack.isEmpty()){
            move_bottom_to_top(stack);
            int top2 = stack.pop();
            stack.push(top1);
            stack.push(top2);
        }else {
            stack.push(top1);
        }
    }
    public static void resverse_stack(MyStack<Integer> stack){
        if (stack.isEmpty())
            return;
        move_bottom_to_top(stack);
        int top = stack.pop();
        resverse_stack(stack);
        stack.push(top);
    }
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();
        for (int i = 1; i < 6; i++){
            stack.push(i);
        }
        resverse_stack(stack);
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+"  ");
        }
    }
}
