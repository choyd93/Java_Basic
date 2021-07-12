package type;

public class EmplyManage {
    
    // 사원 번호
    private int id;
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    // 사원 이름
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    // 사원 부서
    private String depart;
    
    public void setDepart(String depart) {
        this.depart = depart;
    }
    
    public String getDepart() {
        return depart;
    }
    
    
    // 사원 직급
    private String rank;
    
    public void setRank(String rank) {
        this.rank = rank;
    }
    
    public String getrank() {
        return rank;
    }
    
    // 사원 연봉
    private int salary;
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public int getSalary() {
        return salary;
    }
    
    // 사원의 정보를 출력해주는 메소드
    public void printInfo() {
        System.out.printf("번호 : %03d번 이름 : %s\n", id, name);
        System.out.printf("부서 : %s 직급 : %s\n", 
                depart, rank);
        System.out.printf("연봉 : %s만원\n", salary);
    }
    
    //equals 메소드
    public boolean equals(Object o) { 
        
        if(o instanceof EmplyManage) {
            
            EmplyManage s = (EmplyManage)o;
            
            if(s.id == id) {
                return true;
            }
        }
        return false;
    }
}
