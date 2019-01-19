package JavaInterview;

import java.util.ArrayList;

class MyStack<T>{
    private ArrayList<T> arrayList;
    private int stackSize;
    public MyStack(){
        arrayList = new ArrayList<T>();
        stackSize = 0;
    }
    boolean isEmpty(){
        return stackSize == 0;
    }
    int size(){
        return stackSize;
    }
    T top(){
        if (isEmpty())
            return null;
        else
            return arrayList.get(stackSize-1);
    }
    T pop(){
        if (stackSize>0){
            stackSize = stackSize - 1;
            return arrayList.get(stackSize);
        }
        System.out.println("栈空");
        return null;
    }
    void push(T data){
        arrayList.add(data);
        stackSize++;
    }
}
public class Test4 {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.push(1);
        System.out.println("栈顶元素：" + myStack.top());
        System.out.println("栈的大小：" + myStack.size());
        myStack.pop();
        System.out.println("弹栈成功");
        myStack.pop();
    }
}
