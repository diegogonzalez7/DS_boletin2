package e3;

import java.util.HashMap;
import java.util.regex.Pattern;

public class USER_ID implements LoginStrategy{
    private final HashMap<String,String> LoginPswd;

    public USER_ID(HashMap<String, String> loginPswd) {
        LoginPswd = loginPswd;
    }

    @Override
    public boolean validateID(String login) {
        return Pattern.compile("(?=.{1,20}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*#(\\d{4})$").matcher(login).matches();

    }
    @Override
    public boolean authenticatePassword(String id, String password) {
        return validateID(id) && LoginPswd.containsKey(id) && password.equals(LoginPswd.get(id));
    }
}
