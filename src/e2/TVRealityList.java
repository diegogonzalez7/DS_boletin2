package e2;

import java.util.ArrayList;
import java.util.Iterator;

public class TVRealityList<T> implements Iterable<T> {
    private final int cand_n;
    private final int method;
    private final ArrayList<T> Lista = new ArrayList<>();

    public TVRealityList(int cand_n, int method) {
        if (cand_n <= 0 )throw new IllegalArgumentException("Valor invalido de candidatos");
        else this.cand_n = cand_n;
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
        if (getCand_n() == ListSize())
            throw new UnsupportedOperationException("Numero de candidatos alcanzado, insercion invalida");
        else this.Lista.add(name);
    }
    @Override
    public Iterator<T> iterator() {
        // 0 -> recorrido circular
        // Else -> recorrido con rebote
        if (this.method == 0)
            return new Circular<>(this.Lista, 0);
        else
            return new Rebote<>(this.Lista, 0);
    }
}