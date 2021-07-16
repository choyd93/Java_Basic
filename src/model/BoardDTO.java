package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BoardDTO {
    
    // 번호 등록
    private int id;
    
    // 제목 등록
    private String title;
    
    // 작성자의 회원 번호 
    private int writerId; //<- 생성
    
    // 내용 등록 
    private String content;
    
    private Calendar WrittenDate;
    
    private Calendar updatedDate;
    
    //Getter / Setter
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }    
    //겟터 셋터 writer 삭제 -> writerId로 대체 
    
    public int getWriterId() {
        return writerId;
    }
    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    
    public void setContent (String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    
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

    
    
    // equals() 메소드
    public boolean equals(Object o) {  
     
        if(o instanceof BoardDTO) {
        
            BoardDTO b = (BoardDTO)o;
          
            if(this.id == b.id) {
                return true;
            }
        }
        return false;
    }
    
}

