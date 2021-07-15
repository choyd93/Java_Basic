package type;

public class User {
    // 회원번호
    private int id;
    // 로그인 시 아이디
    private String username;
    // 로그인 시 비밀번호
    private String password;
    // 닉네임
    private String nickname;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    
    public boolean equals(Object o) {
        if(o instanceof User) {
            User u = (User)o;
            if(id == u.id) {
                return true;
            }
        }
        return false;
    }
    
    public boolean auth(String username, String password) {
        
        return this.username.equals(username) &&
                this.password.equals(password);
                // 이 객체의 유저네임과 파라미터로 들어온 유저네임이 같고
                // 이 객체의 패스워드와 파라미터로 들어온 패스워드가 같으면 
    }
    
}
