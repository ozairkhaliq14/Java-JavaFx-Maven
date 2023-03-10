import java.util.Iterator;

public class ReverseGLLIterator<T> implements Iterator<T>{
    GenericList<T>.Node<T> node;

    @Override
    public boolean hasNext() {
        if (node != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        T item = node.data;
        node = node.next;
        return item;
    }

    public ReverseGLLIterator(GenericList<T> gList) {
        node = gList.getHead();
        GenericList<T>.Node<T> prev = null;
        GenericList<T>.Node<T> next;

        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
    }
}
