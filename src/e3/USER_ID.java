package e3;

import java.util.Objects;
import java.util.regex.Pattern;

public class USER_ID implements LoginStrategy{

    @Override
    public boolean validateID(String login) {
        return Pattern.compile("(?=.{1,20}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*#(\\d{4})$").matcher(login).matches();
    }
    @Override
    public boolean authenticatePassword(String id, String password) {
        return validateID(id); // && Que este contenido en el hashmap de los datos && Que coincida el la contraseña de ese login con la introducid;
    }
}
