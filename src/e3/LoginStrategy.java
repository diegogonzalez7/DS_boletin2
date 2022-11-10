package e3;


public interface LoginStrategy{
    boolean validateID(String login);
    boolean authenticatePassword ( String id , String password );

}

