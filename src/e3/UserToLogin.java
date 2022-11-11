package e3;

public class UserToLogin {
    private String Id;
    private String Password;
    private MfaStrategy MfaPrefered;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public MfaStrategy getMfaPrefered() {
        return MfaPrefered;
    }

    public void setMfaPrefered(MfaStrategy mfaPrefered) {
        MfaPrefered = mfaPrefered;
    }

    public UserToLogin(String id, String password, MfaStrategy mfaPrefered) {
        Id = id;
        Password = password;
        MfaPrefered = mfaPrefered;
    }
}
