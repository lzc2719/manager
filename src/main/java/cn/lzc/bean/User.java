package cn.lzc.bean;

public class User {

    private int userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private String userIdentity;

    public User(){}

    public User(String userName, String userAccount, String userPassword, String userIdentity) {
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userIdentity = userIdentity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }
}
