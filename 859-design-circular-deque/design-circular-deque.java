class MyCircularDeque {

    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Adds an item at the front
    public boolean insertFront(int value) {
        if (isFull()) return false;

        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
        if (size == 1) rear = front;
        return true;
    }

    // Adds an item at the rear
    public boolean insertLast(int value) {
        if (isFull()) return false;

        rear = (rear + 1) % capacity;
        deque[rear] = value;
        size++;
        return true;
    }

    // Deletes front item
    public boolean deleteFront() {
        if (isEmpty()) return false;

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    // Deletes last item
    public boolean deleteLast() {
        if (isEmpty()) return false;

        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    // Gets front item
    public int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }

    // Gets rear item
    public int getRear() {
        if (isEmpty()) return -1;
        return deque[rear];
    }

    // Checks if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks if full
    public boolean isFull() {
        return size == capacity;
    }
}
