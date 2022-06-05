package Leetcode_Problems.CircularQueue;

public class CircularQueue {
    int[] q;
    int capacity;
    int front;
    int rear;
    int size;

    public CircularQueue(int k) {
        q= new int[k];
        capacity = k;
        front = 0;
        rear = -1;
        size = 0;   
    }
    
    public boolean enQueue(int value) {
        if(size >= capacity)
        {
            return false;
        }
        q[(rear + 1) % capacity] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty())
        {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if(size == 0)
        {
            return -1;
        }
        return q[front % capacity];
    }
    
    public int Rear() {
        if(size == 0)
        {
            return -1;
        }
        return q[rear%capacity];
        
    }
    
    public boolean isEmpty() {
        return size == 0;
        
    }
    
    public boolean isFull() {
        return size == capacity;
        
    }

    public static void main(String[] args) {
    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
 
       
    }

    
}
