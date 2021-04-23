package dam.server.demo.pojo;

/**
 * @author : dam
 * @description :
 * @create :2021-04-23 10:16:00
 */
 public  class Executor {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String token;
    private String userName;
}
