package type;
// 1. 캡슐화를 구현하시오
// 2. equals()를 구현하시오
// 3. 상세보기를 할 메소드를 구현하시오

public class Board {
    
    // 번호 등록
    private int id;
    
    // setter
    public void setId(int id) {
        this.id = id;
    }
    // getter
    public int getId() {
        return id;
    }    
    // 제목 등록
    private String title;
    
    // setter
    public void setTitle(String tile) {
        this.title = title;
    }
    // getter
    public String getTitle() {
        return title;
    }
    
    // 작성자 등록
    private String writer;
    
    // setter
    public void setwriter (String writer) {
        this.writer = writer;
    }
    // getter
    public String getWriter() {
        return writer;
    }
    
    // 내용 등록 
    private String content;
    
    // setter
    public void setContent (String content) {
        this.content = content;
    }
    // getter
    public String getContent() {
        return content;
    }
    
   
    // 게시판 내용을 출력해주는 메소드
    public void printInfo() {
        System.out.println("=================================");
        System.out.println("제목 : " + title);
        System.out.println("---------------------------------");
        System.out.printf("번호 : %03d번 작성자 : %s\n", id, writer);
        System.out.printf("-----------------------------------");
        System.out.println(content);
        System.out.println("=================================");

    }
    
    // equals() 메소드
    public boolean equals(Object o) { // <- 여기 이해 안감. 
     
        if(o instanceof Board) {
        
            Board b = (Board)o;
          
            if(this.id == b.id) {
                return true;
            }
        }
        return false;
    }
}

