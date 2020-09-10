import java.util.ArrayList;
import java.util.Iterator;

public class RevList<Type> implements Iterable<Type> {

    private ArrayList<Type> arrayList;
    private int currentSize;

    public RevList(ArrayList<Type> newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.size();
    }

    @Override
    public Iterator<Type> iterator() {
        Iterator<Type> it = new Iterator<Type>() {

            private int currentIndex = currentSize;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0 && arrayList.get(currentIndex - 1) != null;
            }

            @Override
            public Type next() {
                return arrayList.get(currentIndex--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}

