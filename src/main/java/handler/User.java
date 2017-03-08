package handler;

/**
 * Created by geyao on 2017/3/8.
 */
public class User {
    private String logInName;
    private String passWord;
    private String userName;

    public String getLogInName() {
        return logInName;
    }

    @Override
    public String toString() {
        return "User{" +
                "logInName='" + logInName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public void setLogInName(String logInName) {
        this.logInName = logInName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User() {

    }
}
