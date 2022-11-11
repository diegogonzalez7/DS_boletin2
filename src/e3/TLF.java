package e3;

import java.util.HashMap;
import java.util.regex.Pattern;

public class TLF implements LoginStrategy {
    private final HashMap<String,String> LoginPswd;

    public TLF(HashMap<String, String> loginPswd) {
        LoginPswd = loginPswd;
    }

    @Override
    public boolean validateID(String login) {
        return Pattern.compile("\\d{3}[-.\\s]\\d{3}[-.\\s]\\d{3}").matcher(login).matches();

    }

    @Override
    public boolean authenticatePassword(String id, String password) {
        return validateID(id) && LoginPswd.containsKey(id) && password.equals(LoginPswd.get(id));
    }
}
