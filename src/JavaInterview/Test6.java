package JavaInterview;

import java.util.ArrayList;

class MyQueue<T>{
    private ArrayList<T> arrayList = new ArrayList<T>();
    private int front;
    private int real;

    public MyQueue(){
        front = 0;
        real = 0;
    }

    public boolean isEmpty(){
        return front == real;
    }

    int size(){
        return real - front;
    }

    public T getFront(){
        if (isEmpty())
            return null;
        return arrayList.get(front);
    }

    public T getReal(){
        if (isEmpty())
            return null;
        return arrayList.get(real-1);
    }

    public void deQueue(){
        if (front<real)
            front++;
        System.out.println("队空");
    }

    public void enQueue(T data){
        arrayList.add(data);
        real++;
    }
}
public class Test6 {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        System.out.println("队头元素：" + myQueue.getFront());
        System.out.println("队尾元素：" + myQueue.getReal());
        System.out.println("队的大小：" + myQueue.size());
    }
}
