package e3;

import java.util.Arrays;
import java.util.Random;

public class OTP implements MfaStrategy {
    @Override
    public String GenerateCode() { //6-8 digitos
        String numbers = "0123456789";
        Random rndm_method = new Random();
        int digits = rndm_method.nextInt(3);
        int len;

        StringBuilder Code = new StringBuilder();

        if (digits == 0) len = 6;
        else if (digits == 1) len = 7;
        else len = 8;

        char[] otp = new char[len];

        for (int i = 0; i < len; i++) {
            otp[i] =
                    numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        for (int i=0;i < len;i++){
            Code.append(Character.toString(otp[i]));}
        return Code.toString();
    }
}
