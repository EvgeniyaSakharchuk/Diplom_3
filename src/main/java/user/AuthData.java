package user;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnore;

public class AuthData extends User {
    private String authemail;
    @JsonIgnore
    private String authpassword;

    public AuthData(String authemail, String authpassword) {
        this. authemail = authemail;
        this.authpassword = authpassword;
    }

    public static AuthData from(User user) {
        return new AuthData(user.getEmail(), user.getPassword());
    }

    public String getEmail() {
        return authemail;
    }

    public void setEmail(String email) {
        this.authemail = authemail;
    }

    public String getPassword() {
        return authpassword;
    }

    public void setPassword(String password) {
        this.authpassword = authpassword;
    }
}
