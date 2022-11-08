package e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Circular implements Iterator {
    ArrayList<String> Lista_string;
    int cursor; //Indice actual
    int lastRet = -1; //indice del ultimo elemento devuelto
    boolean removable = false;

    Circular(ArrayList<String> Lista_string, int cursor) {
        this.Lista_string = Lista_string;
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor != Lista_string.size();
    }

    @Override
    public Iterator next() {
        if (this.Lista_string.size() == 1) {
            this.removable = false;
            throw new NoSuchElementException("Error:No hay mas iteraciones");
        }
        int i = cursor;
        Object[] elementData = Lista_string.toArray();
        cursor = i + 1 % Lista_string.size();
        this.removable = true;
        return (Iterator) elementData[lastRet = i];
    }

    @Override
    public void remove() {
        if (lastRet != -1 && removable) {
            this.removable = false;
            this.Lista_string.remove(lastRet);
        } else throw new IllegalStateException("Error: Remove no valido");
    }
}
