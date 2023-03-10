import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class GenericList<T> implements Iterable<T> {

    private Node<T> head;
    private int length;

    public void print() {
        Iterator<T> iter = this.iterator();
        if(!iter.hasNext()) {
            System.out.println("**This List is Empty**");
        }
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public abstract void add(T data);

    public T delete() {
        if (head != null) {
            T val = head.data;
            head = head.next;
            return val;
        } else {
            return null;
        }
    }

    public ArrayList<T> dumpList() {
        ArrayList<T> arr = new ArrayList<T>();
        while(head != null) {
            arr.add(head.data);
            this.delete();
        }
        return arr;
    }

    public T get(int index) {
        if (index >= this.length) {
            return null;
        } else {
            Iterator<T> iter = this.iterator();
            for (int i = 0; i < index; i++) {
                iter.next();
            }
            return iter.next();
        }
    }

    public T set(int index, T element) {
        if (index >= this.length) {
            return null;
        } else {
            Node<T> curr = head;
            Node<T> temp = new Node<T>(element);
            for(int i = 0; i <= index; i++) {
                curr = curr.next;
            }
            T item = curr.data;
            curr = temp;

            return item;
        }
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public ListIterator<T> listIterator(int index) {
        if (index >= this.length) {
            return null;
        } else {
            GLListIterator<T> iter = new GLListIterator<T>(this);
            for(int i = 0; i <= index; i++) {
                iter.next();
            }
            return iter;
        }
    }

    public Iterator<T> descendingIterator() {
        ReverseGLLIterator<T> iter = new ReverseGLLIterator<>(this);
        return iter;
    }
    public Iterator<T> iterator() {
        GLLIterator<T> iter = new GLLIterator<>(this);
        return iter;
    }

    public GenericList(T val) {
        this.head = new Node<T>(val);
        length = 1;
    }

    public class Node<T> {
        T data;
        Node<T> next;

        public Node(T val) {
            this.data = val;
        }
    }
}


