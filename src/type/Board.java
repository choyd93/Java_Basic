package type;
//게시판 프로그램에 입력날짜와 수정날짜를 추가하여 Board.java를 개조하여
//사용자가 글을 입력하면 자동으로 입력날짜 수정날짜가 입력시간으로 입력이 되고
//사용자가 해당 글을 수정하면 자동으로 수정날짜가 수정시간으로 바뀌게 프로그램을 만드시오
//단, 주요 기능들 중 글 개별 보기나 수정 삭제는 인덱스가 아닌 글 번호로 접근하고
//그외 기능들은 기존 프로그램에서 복사 붙여넣기 하셔도 됩니다.

// 1. 캡슐화를 구현하시오
// 2. equals()를 구현하시오
// 3. 상세보기를 할 메소드를 구현하시오

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    public void setTitle(String title) {
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
    
    private int writerId; //<- 생성
    
    
    public int getWriterId() {
        return writerId;
    }
    public void setWriterId(int writerId) {
        this.writerId = writerId;
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
    
    private Calendar WrittenDate;
    
    private Calendar updatedDate;

    
    public Calendar getWrittenDate() {
        return WrittenDate;
    }
    public void setWrittenDate(Calendar writtenDate) {
        WrittenDate = writtenDate;
    }
    public Calendar getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Calendar updatedDate) {
        this.updatedDate = updatedDate;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    
    
    // 게시판 내용을 출력해주는 메소드
    public void printInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("y-m-d H:m:s");
        System.out.println("=================================");
        System.out.println("제목 : " + title);
        System.out.println("---------------------------------");
        System.out.printf("번호 : %03d번 작성자 : %s\n", id, writer);
        System.out.printf("작성일 : " + sdf.format(WrittenDate.getTime()));
        System.out.printf("\n수정일 : " + sdf.format(updatedDate.getTime()));
        System.out.printf("\n-----------------------------------");
        System.out.println();
        System.out.println("내용 : " +content);
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

