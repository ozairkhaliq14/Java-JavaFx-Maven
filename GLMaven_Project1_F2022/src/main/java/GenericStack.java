public class GenericStack<T> extends GenericList<T>{
    Node<T> tail;

    public T removeTail() {
        T temp = tail.data;
        tail = null;
        return temp;
    }

    public void push(T data) { this.add(data); }

    public T pop() { return this.delete(); }

    public void add(T data) {
        Node<T> curr = this.getHead();
        Node<T> temp = new Node<T>(data);
        this.setHead(temp);
        this.getHead().next = curr;
        this.setLength(this.getLength() + 1);
    }

    public GenericStack(T val) {
        super(val);
        this.tail = this.getHead();
    }

}
