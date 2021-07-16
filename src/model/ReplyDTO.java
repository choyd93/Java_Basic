package model;

import java.util.Calendar;

public class ReplyDTO {
    
    // 1. 댓글 번호 
    private int replyId;
    
    // 2. 댓글 달린 게시판 번호
    private int boardId;
    
    // 3. 댓글 단 사람의 번호
    private int writerId;
    
    // 4. 댓글 내용 <- 객체 생성?
    private String content;
    
    // 5. 댓글 입력시간 
    private Calendar writtenDate;

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getWrittenDate() {
        return writtenDate;
    }

    public void setWrittenDate(Calendar writtenDate) {
        this.writtenDate = writtenDate;
    }
    
    public boolean equals(Object o) {
        if(o instanceof ReplyDTO) {
            ReplyDTO r = (ReplyDTO)o;
            if(replyId == r.replyId) {
                return true;
            }           
        }
        return false;
    }

}
