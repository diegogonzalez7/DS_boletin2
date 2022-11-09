package e2;

import java.util.Random;

public class Winner {
    public String selectCandidates(TVRealityList<String> tvRealityList) {
        int i;
        Random random_k = new Random();
        int k = random_k.nextInt(tvRealityList.getCand_n());

        while (tvRealityList.iterator().hasNext()) {
            for (i = 0; i < k + 1; i++) tvRealityList.iterator().next();
            tvRealityList.iterator().remove();
        }

        return tvRealityList.getByIndex(0);
    }
}
