package type;

public class EmplyManage {
    
    // 사원 번호
    private int id;
   
    
    // 사원 이름
    private String name;
    
    
    // 사원 부서
    private String team;
    
    
    // 사원 직급
    private String position;
    
    
    // 사원 연봉
    private int salary;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // 사원의 정보를 출력해주는 메소드
    public void printInfo() {
        System.out.println("--------------------------");
        System.out.println(name + " 사원 정보 ");
        System.out.println("--------------------------");
        System.out.printf("사원 번호 : %03d번 사원 이름 : %s\n", id, name);
        System.out.printf("사원 부서 : %s 사원 직급 : %s\n", 
                team, position);
        System.out.printf("사원 연봉 : %d원\n", salary);
        System.out.println("--------------------------");

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
