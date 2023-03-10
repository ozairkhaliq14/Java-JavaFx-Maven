
public class GenericQueue<T> extends GenericList<T> {
    Node<T> tail;

    public GenericQueue(T val) {
        super(val);
        this.tail = this.getHead();
    }

    public T removeTail() {
        T val = tail.data;
        tail = null;
        return val;
    }

    public void enqueue(T data) {
        this.add(data);
    }

    public T dequeue() {
        return this.delete();
    }

    public void add(T data) {
        if (this.getLength() == 1) {
            this.tail = new Node<T>(data);
            this.getHead().next = tail;
        } else {
            Node<T> temp = new Node<T>(data);
            this.tail.next = temp;
            this.tail = temp;
        }
        this.setLength(this.getLength() + 1);
    }
}
