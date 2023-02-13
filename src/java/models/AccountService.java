package models;

/**
 *
 * @author Swift
 */
public class AccountService {

    public User login(String username, String password) {
        if (username.equals("abe") && password.equals("password")
                || username.equals("barb") && password.equals("password")) {
            User user = new User(username, password);
            user.setPassword(null);
            return user;
        }
        return null;
    }
}
