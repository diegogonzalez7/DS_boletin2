package e2;

import java.util.Iterator;
import java.util.Random;


public class Winner {
    public String selectCandidates(TVRealityList<String> tvRealityList,boolean debugg,int k_debugg) {
        int i;
        Random random_k = new Random();
        int k = random_k.nextInt(tvRealityList.getCand_n());
        Iterator <String> iterador = tvRealityList.iterator();
        if (!debugg) {//k aleatoria
            while (iterador.hasNext()) {
                for (i = 0; i < k; i++) iterador.next();
                iterador.remove();
            }
        }
        else while (iterador.hasNext()) { //k no aleatoria para hacer los test
            for (i = 0; i < k_debugg; i++) iterador.next();
            iterador.remove();
        }
        return tvRealityList.getByIndex(0);
    }
}