package e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Rebote implements Iterator {

    ArrayList<String> Lista_string;
    int cursor; //Indice actual

    int lastRet = -1; //indice del ultimo elemento devuelto

    boolean change = false;
    boolean removable = false;

    Rebote(ArrayList<String> Lista_string, int cursor) {
        this.Lista_string = Lista_string;
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor != this.Lista_string.size();
    }

    @Override
    public Iterator next() {
        if (this.Lista_string.size() == 1) {
            this.removable = false;
            throw new NoSuchElementException("Error:No hay mas iteraciones");
        }
        int i = cursor;
        Object[] elementData = Lista_string.toArray();
        if (!change) cursor = i + 1;
        else cursor = i - 1;
        if (cursor == this.Lista_string.size()) {
            this.change = true;
            cursor = i - 1;
        }
        this.removable=true;
        return (Iterator) elementData[lastRet = i];
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
