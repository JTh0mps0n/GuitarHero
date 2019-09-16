public class RingBuffer<T> {
    private int cap;
    private Object[] array;
    private int size;
    private int front;
    RingBuffer(int capacity){
        cap = capacity;
        array = new Object[cap];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == cap;
    }

    public void enqueue(T x){
        if(isFull()){
            throw new IllegalStateException();
        }
        array[(front + size) % cap] = x;
        size++;
    }

    public T dequeue(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        size--;
        front++;
        return (T) array[(front - 1) % cap];
    }

    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        return (T) array[(front) % cap];
    }
}
