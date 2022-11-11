package e3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    Login Login = new Login();
    UserToLogin user1 = new UserToLogin("alejandro.pazos@udc.es","ca34pat5",new OTP());
    UserToLogin user2 = new UserToLogin("ivan.romero@usc.es","L4R4ch4",new M_AUT());
    @Test
    void SetGetterLoginStrategy() {
        Login.setLoginStrategy(new EMAIL(Login.getId_psswd()));
        assertEquals(EMAIL.class,Login.getLoginStrategy().getClass());
        Login.setLoginStrategy(new TLF(Login.getId_psswd()));
        assertEquals(TLF.class,Login.getLoginStrategy().getClass());
        Login.setLoginStrategy(new USER_ID(Login.getId_psswd()));
        assertEquals(USER_ID.class,Login.getLoginStrategy().getClass());
    }

    @Test
    void signUpUser() {
        Login.setLoginStrategy(new TLF(Login.getId_psswd()));
        assertThrows(IllegalArgumentException.class,()->Login.SignUpUser(user1));
        Login.setLoginStrategy(new EMAIL(Login.getId_psswd()));
        Login.SignUpUser(user1);
        assertTrue(Login.getId_psswd().containsKey(user1.getId()));
        assertThrows(UnsupportedOperationException.class, ()->Login.SignUpUser(user1));
    }
    @Test
    void changeID(){
        Login.setLoginStrategy(new TLF(Login.getId_psswd()));
        assertThrows(UnsupportedOperationException.class,()->Login.ChangeID(user1,"pablo.rey@udc.es"));
        Login.setLoginStrategy(new EMAIL(Login.getId_psswd()));
        Login.SignUpUser(user1);
        Login.ChangeID(user1,"pablo.rey@udc.es");
        assertTrue(Login.getId_psswd().containsKey("pablo.rey@udc.es"));
    }

    @Test
    void changePassword() {
        Login.setLoginStrategy(new TLF(Login.getId_psswd()));
        assertThrows(UnsupportedOperationException.class,()->Login.ChangePassword(user1,"ca34sat5"));
        Login.setLoginStrategy(new EMAIL(Login.getId_psswd()));
        Login.SignUpUser(user1);
        Login.ChangePassword(user1,"ca34sat5");
        assertEquals(Login.getId_psswd().get(user1.getId()),"ca34sat5");
    }

    @Test
    void MFA() {
        Login.setLoginStrategy(new EMAIL(Login.getId_psswd()));
        Login.SignUpUser(user2);
        assertEquals(String.class,Login.MFA(user2).getClass());
    }

    @Test
    void GetterSetterUser() {
        assertEquals(user1.getId(),"alejandro.pazos@udc.es");
        user1.setId("roberto.torres@usc.es");
        assertEquals(user1.getId(),"roberto.torres@usc.es");
        assertEquals(user1.getPassword(),"ca34pat5");
        user1.setPassword("ca34sat5");
        assertEquals(user1.getPassword(),"ca34sat5");
        assertEquals(user1.getMfaPrefered().getClass(),OTP.class);
        user1.setMfaPrefered(new SMS());
        assertEquals(user1.getMfaPrefered().getClass(),SMS.class);
    }

    @Test
    void GenerateCodeOTP() {
        String i = new OTP().GenerateCode();
        assertTrue(i.length()==6 || i.length()==7 || i.length()==8);
    }

    @Test
    void GenerateCodeSMS() {
        String i = new SMS().GenerateCode();
        assertEquals(6, i.length());
    }

    @Test
    void GenerateCodeM_AUT() {
        String i = new M_AUT().GenerateCode();
        assertEquals(2, i.length());
    }

    @Test
    void EMAIL() {
        //Un correo valido tiene name@mail.domain name->No puede empezar por punto ni tener caraceteres especiales si A-Z a-z 0-9 _-
        assertFalse(()->new EMAIL(Login.getId_psswd()).validateID(",hola@udc.es"));
        assertFalse(()->new EMAIL(Login.getId_psswd()).validateID("673 981 334"));
        assertTrue(()->new EMAIL(Login.getId_psswd()).validateID("hola@udc.es"));
    }

    @Test
    void TLF() { //Un teléfono valido son 9 cifras que deben estar separadas por puntos, espacios o  guiones
        assertFalse(()->new TLF(Login.getId_psswd()).validateID("hola@udc.es"));
        assertTrue(()->new TLF(Login.getId_psswd()).validateID("673 981 334"));
        assertTrue(()->new TLF(Login.getId_psswd()).validateID("673-643-896"));
        assertTrue(()->new TLF(Login.getId_psswd()).validateID("673.643.896"));

    }

    @Test
    void USER_ID() { //El USER_ID tiene que tener un id seguido de un # y 4 numeros, en total no puede superar los 20 caracteres
        assertFalse(()->new USER_ID(Login.getId_psswd()).validateID("holamellamopepefernandez#2020"));
        assertTrue(()->new USER_ID(Login.getId_psswd()).validateID("holamellamopepe#2020"));
        assertFalse(()->new USER_ID(Login.getId_psswd()).validateID("h#2020"));
        assertFalse(()->new USER_ID(Login.getId_psswd()).validateID("673-643-896"));
        assertFalse(()->new USER_ID(Login.getId_psswd()).validateID("pepe@udc.es"));
    }
}