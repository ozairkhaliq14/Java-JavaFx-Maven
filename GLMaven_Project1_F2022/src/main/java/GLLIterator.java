import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T>{
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

    public GLLIterator(GenericList<T> gList) {
        node = gList.getHead();
    }
}
