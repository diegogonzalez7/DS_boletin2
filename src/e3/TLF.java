package e3;

import java.util.Objects;
import java.util.regex.Pattern;

public class TLF implements LoginStrategy {
    @Override
    public boolean validateID(String login) {
        return Pattern.compile("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}").matcher(login).matches();
    }

    @Override
    public boolean authenticatePassword(String id, String password) {
        return validateID(id); //&& Objects.equals(password, LoginPswd.get(id));
    }
}
