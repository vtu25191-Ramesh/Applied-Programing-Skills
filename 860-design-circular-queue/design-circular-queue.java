class MyCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Insert element into the circular queue
    public boolean enQueue(int value) {
        if (isFull()) return false;

        queue[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    // Delete element from the circular queue
    public boolean deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    // Get front item
    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    // Get last item
    public int Rear() {
        if (isEmpty()) return -1;
        int lastIndex = (rear - 1 + capacity) % capacity;
        return queue[lastIndex];
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if full
    public boolean isFull() {
        return size == capacity;
    }
}
