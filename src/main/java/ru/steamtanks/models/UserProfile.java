package ru.steamtanks.models;

/**
 * Created by jake on 24.09.16.
 */
public class UserProfile {
    private String login;
    private String email;
    private String password;
    private int countLogin = 0;

    public UserProfile(String login, String password, String email) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public int getCountLogin() {return countLogin;}

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
