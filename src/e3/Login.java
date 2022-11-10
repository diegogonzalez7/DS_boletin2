package e3;

public class Login {
    LoginStrategy LoginStrategy;
    MfaStrategy MfaStrategy;
    String Login;
    String Mobile_Num;
    String User_Id;
    String Password;

    public Login(String login, String mobile_Num, String user_Id, String password) {
        Login = login;
        Mobile_Num = mobile_Num;
        User_Id = user_Id;
        Password = password;
    }

    public String getLogin() {
        return Login;
    }

    protected void setLogin(String Login) {
        if (LoginStrategy.validateID(Login)) {
            this.Login = Login;
        } else throw new IllegalArgumentException("Login no valido para la estrategia actual");
    }

    public String getMobile_Num() {
        return Mobile_Num;
    }

    public void setMobile_Num(String Mobile_Num) {
        if (LoginStrategy.validateID(Login)) {
            this.Mobile_Num = Mobile_Num;
        } else throw new IllegalArgumentException("Login no valido para la estrategia actual");
    }

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String user_Id) {
        if (LoginStrategy.validateID(Login)) {
            this.User_Id = user_Id;
        } else throw new IllegalArgumentException("Login no valido para la estrategia actual");
    }

    public LoginStrategy getLoginStrategy() {
        return this.LoginStrategy;
    }

    private void setLoginStrategy(LoginStrategy loginStrategy) {
        this.LoginStrategy = loginStrategy;
    }

    public MfaStrategy getMfaStrategy() {
        return MfaStrategy;

    }

    private void setMfaStrategy(MfaStrategy MfaStrategy) {
        this.MfaStrategy = MfaStrategy;
    }

}
/*
AUTENTICACIÓN MULTIFACTOR (MFA)
Código)
public class login
	Identificador del usuario (habitualmente un email, aunque se puede cambiar en cualquier momento)
        Se valida que el identificador de usuario tenga un formato válido.
        Se introduce la contraseña del usuario (primer factor de autenticación).
        Se autentica la contraseña (se comprueba que la contraseña corresponde con el identificador).
        El proceso termina aquí, con la generación del código MFA. Este código no se enviará ni se introducirá en ningún sitio.

        Este proceso se puede repetir las veces que queramos y para distintos usuarios.
        Usuario (identificador, contraseña, estrategia MFA preferida, etc.)
        Las partes que varían dentro de nuestro sistema son:
        los identificadores de usuario pueden ser de diversos tipos (email, teléfono, móvil)
        los códigos MFA generados pueden ser de distintos tipos: OTP enviada por SMS, un código generado por una aplicación autenticadora como Microsoft Authenticator, etc.

        Usaremos una jerarquía basada en interfaces similares a:
public interface LoginStrategy {
    boolean validateId ( String id );
    boolean authenticatePassword ( String id , String password );
    // ...
}

public interface MfaStrategy {
    String generateCode ();
    // ...
}
    Pasándole a un setter una instancia de  la nueva estrategia por parámetro podemos cambiar la estrategia de login actual
public void setLoginStrategy ( LoginStrategy loginStrategy ) {
        this.loginStrategy = loginStrategy ;
        // ...
        }
        Cada usuario tendrá una MfaStrategy preferida que provocará que se generen códigos del tipo correspondiente, TODAS DEVUELVEN UN STRING. Podrá cambiarse con un setter como con la elección del identificador.

        El proceso se ejecutará mediante setters y llamadas a métodos, no habrá interfaz gráfica ni se introducirán datos por teclado.
        Hay que crear:
        3 clases de estrategias de login concretas.
        3 clases de estrategias MFA concretas, con códigos semi-aleatorios.

        Se recomienda usar estructuras tipo Map para establecer correspondencias entre identificadores y contraseñas.


        Tests)
        No se harán asserts del valor del código MFA porque son semi-aleatorios, se comprobará que tienen el formato adecuado, que no se repita, tenga la longitud adecuada, etc.
        Se puede añadir un main que imprima el proceso por pantalla, pero no formará parte de los test.
        */