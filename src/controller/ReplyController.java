package controller;

import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;

import model.ReplyDTO;

public class ReplyController {
    private ArrayList<ReplyDTO> list;
    private int nextId; // <- 같은 이름 써도 되나

    public ReplyController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public void isert(ReplyDTO r) {
        r.setReplyId(nextId++);
        r.setWrittenDate(Calendar.getInstance());

        list.add(r);
    }

    public void delete(int id) {
        ReplyDTO temp = new ReplyDTO();
        temp.setReplyId(id);
        list.remove(temp);
    }

    // 해당 게시글번호를 가진 댓글을
    // 어레이리스트에 담아서 리턴하는
    // selectByBoardId(int)
    public ArrayList<ReplyDTO> selectByBoardId(int boardId) {
        ArrayList<ReplyDTO> temp = new ArrayList<>();

        for (ReplyDTO r : list) {
            if (r.getBoardId() == boardId) {
                temp.add(r);
            }
        }

        return temp;
    }

    // 해당 작성자번호를 가진 댓글을
    // 어레이리스트에 담아서 리턴하는
    // selectByWriterId(int)
    public ArrayList<ReplyDTO> selectByWriterId(int writerId) {
        ArrayList<ReplyDTO> temp = new ArrayList<>();

        for (ReplyDTO r : list) {
            if (r.getWriterId() == writerId) {
                temp.add(r);
            }
        }
        return temp;
    }

    // 탈퇴한 회원의 번호와 일치하는
    // 작성자 번호를 가진 객체의
    // 내용을 수정하는
    // updateWriterId(int)
    public void updateWriterId(int writerId) {
        for (ReplyDTO r : list) {
            if (r.getWriterId() == writerId) {
                r.setWriterId(0);
            }
        }
    }

    public ArrayList<ReplyDTO> selectAll() {
        return list;
    }

    // 댓글 번호와 일치하는
    // ReplyDTO 객체를 리턴하는
    // selectOne(int)
    public ReplyDTO selectOne(int id) {
        ReplyDTO r = new ReplyDTO();
        r.setReplyId(id);
        if(list.contains(r)) {
            int index = list.indexOf(r);
            return list.get(index);
        }
        
        return null;
    }
    

}






