package e3;

import java.util.Arrays;
import java.util.Random;

public class SMS implements MfaStrategy {
    @Override
    public String GenerateCode() { //6 digitos
        String numbers = "0123456789";
        Random rndm_method = new Random();
        char[] otp = new char[6];
        StringBuilder Code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            otp[i] =
                    numbers.charAt(rndm_method.nextInt(numbers.length()));
        }for (int i=0;i < 6;i++){
            Code.append(Character.toString(otp[i]));}
        return Code.toString();
    }

}
