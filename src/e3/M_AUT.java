package e3;

import java.util.Arrays;
import java.util.Random;

public class M_AUT implements MfaStrategy {
    @Override
    public String GenerateCode() { //2 digitos
        String numbers = "0123456789";
        Random rndm_method = new Random();
        char[] otp = new char[2];

        for (int i = 0; i < 2; i++) {
            otp[i] =
                    numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return Arrays.toString(otp);
    }
}
