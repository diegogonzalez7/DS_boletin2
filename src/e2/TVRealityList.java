package e2;

import java.util.ArrayList;
import java.util.Iterator;

public class TVRealityList<T> implements Iterable<T> {
    private final int cand_n;
    private final int method;
    private final ArrayList<T> Lista = new ArrayList<>();

    public TVRealityList(int cand_n, int method) {
        this.cand_n = cand_n;

        this.method = method;
    }

    public int ListSize() {
        return this.Lista.size();
    }

    public int getCand_n() {
        return cand_n;
    }

    public T getByIndex(int i) {
        return this.Lista.get(i);
    }

    public void addName(T name) {
        if (getCand_n() != ListSize())
            this.Lista.add(name);
        else throw new UnsupportedOperationException("Numero de candidatos alcanzado, insercion invalida");
    }

    @Override
    public Iterator<T> iterator() {
        // 0 -> recorrido circular
        // Else -> recorrido con rebote
        /*int i;
        Circular<T> c = new Circular<>(this.Lista, 0);
        Rebote<T> r = new Rebote<>(this.Lista, 0);
        if (method == 0) {
            if (c.hasNext()) {
                for (i = 0; i < this.k+1; i++) c.next();
                c.remove();
                return (Iterator<T>) r.next();
            } else return (Iterator<T>) getByIndex(0);
        } else {
            if (r.hasNext()) {
                for (i = 0; i < this.k+1; i++) r.next();
                r.remove();
                return (Iterator<T>) r.next();
            } else return (Iterator<T>) getByIndex(0);
        }
    }*/
        if (this.method == 0)
            return new Circular<>(this.Lista, 0);
        else
            return new Rebote<>(this.Lista, 0);
    }
}