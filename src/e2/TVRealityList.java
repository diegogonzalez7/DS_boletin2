package e2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class TVRealityList implements Iterable {
    private final int cand_n;
    private final int k;

    private final int method;
    private ArrayList<String> Lista_Nombres = new ArrayList<>();

    public TVRealityList(int cand_n, int method) {
        this.cand_n = cand_n;
        Random random_k = new Random();
        this.k = random_k.nextInt(cand_n);
        this.method = method;
    }

    public int ListSize() {
        return this.Lista_Nombres.size();
    }
    public int getCand_n() {
        return cand_n;
    }


    public void addName(String name) {
        if (getCand_n()!=ListSize())
            this.Lista_Nombres.add(name);
        else throw new UnsupportedOperationException("Numero de candidatos alcanzado, insercion invalida");
    }

    @Override
    public Iterator iterator() {
        // 0 -> recorrido circular
        // Else -> recorrido con rebote
        int i = 0;
        Circular c = new Circular(this.Lista_Nombres, 0);
        Rebote r = new Rebote(this.Lista_Nombres, 0);
        Object[] elementData = Lista_Nombres.toArray();

        if (this.method == 0) {
            if (c.hasNext()) {
                while (i != this.k + 1) {
                    c.next();
                    i++;
                }
                c.remove();
                return c.next();
            } else return (Iterator) elementData[0];
        } else {
            if (r.hasNext()) {
                while (i != this.k + 1) {
                    r.next();
                    i++;
                }
                r.remove();
                return r.next();
            } else return (Iterator) elementData[0];
        }
    }
}
