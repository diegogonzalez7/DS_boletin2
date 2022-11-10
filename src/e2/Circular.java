package e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Circular<T> implements Iterator<T> {
    ArrayList<T> Lista;
    int cursor; //Indice actual
    int lastRet = -1; //indice del ultimo elemento devuelto
    boolean removable = false;

    Circular(ArrayList<T> Lista, int cursor) {
        this.Lista = Lista;
        if (cursor<0 || cursor > Lista.size()) throw new IllegalArgumentException("Valor de cursor invalido");
        else this.cursor = cursor;
    }
    @Override
    public boolean hasNext() {
        return Lista.size() != 1;
    }

    @Override
    public T next() {
        if (this.Lista.size() <= 1) {
            this.removable = false;
            throw new NoSuchElementException("Error:No hay mas iteraciones");
        }
        int i = cursor;
        cursor = (i + 1) % Lista.size();
        this.removable = true;
        return Lista.get(lastRet = i);
    }

    @Override
    public void remove() {
        if (lastRet != -1 && removable) {
            this.removable = false;
            this.Lista.remove(lastRet);
            cursor--;
            if (cursor < 0) {cursor = 0;}
        } else throw new IllegalStateException("Error: Remove no valido");
    }
}