package UserDao;

public class UserData {
        private String userName;                  //用户名
        private String userPassword;                   //用户密码
    public UserData(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
        //获取用户名
        public String getUserName() {             //获取用户名
            return userName;
        }
        //设置用户名
        public void setUserName(String userName) {  //输入用户名
            this.userName = userName;
        }
        //获取用户密码
        public String getUserPassword() {                //获取用户密码
            return userPassword;
        }
        //设置用户密码
        public void setUserPassword(String userPassword) {     //输入用户密码
            this.userPassword = userPassword;
        }
    public String toString() {
        return "UserData{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
