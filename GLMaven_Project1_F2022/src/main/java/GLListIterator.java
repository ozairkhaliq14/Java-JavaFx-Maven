import java.util.ListIterator;
import java.util.NoSuchElementException;

public class GLListIterator<T> implements ListIterator<T> {
    private int nextIndex;
    GenericList<T>.Node<T> curr;
    GenericList<T>.Node<T> last;

    public GLListIterator(GenericList<T> gList) {
        nextIndex = 0;
        curr = gList.getHead();
        last = null;
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();
        T item = curr.data;
        last.next = last;
        last = curr;
        curr = curr.next;
        nextIndex++;
        return item;
    }

    @Override
    public boolean hasPrevious() {
        return nextIndex > 0;
    }

    @Override
    public T previous() {
        if (!hasPrevious())
            throw new NoSuchElementException();
        T item = last.data;
        curr = last;
        last = last.next;
        return item;
    }

    @Override
    public int nextIndex() {
        return nextIndex;
    }

    @Override
    public int previousIndex() {
        return nextIndex - 1;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t) {

    }

    @Override
    public void add(T t) {

    }
}
