package controller;

import java.util.ArrayList;
import java.util.Calendar;

import model.BoardDTO;
import type.User;

public class BoardController {
    private ArrayList<BoardDTO> list;
    private int nextId;

    public BoardController() {
        list = new ArrayList<>();
        nextId = 1001;
    }

    // 생성 메소드
    public int insert(BoardDTO s) { // <- void -> int
        // 번호
        s.setId(nextId++);// ?
        s.setWrittenDate(Calendar.getInstance());
        s.setUpdatedDate(Calendar.getInstance());
        list.add(s);

        return s.getId();
    }

    // selectByWritwerId(int writerId) <-----토탈 4. 메소드 생성
    public ArrayList<BoardDTO> selectByWriterId(int writerId) {
        // 원래 데이터들이 저장되어 있는
        // 필드 list에서 해당 작성자 회원 번호를 가진
        // 객체들을 뽑아서
        // 저장할 ArrayList 객체
        ArrayList<BoardDTO> temp = new ArrayList<>();

        // list 전체를 확인하여
        // 해당 writerId 값을 가진 객체를 temp에 추가한다.
        for (BoardDTO b : list) {
            if (b.getWriterId() == writerId) {
                temp.add(b);
            }
        }

        // 해당 작성자 번호를 가지고 있는 객체를 모두 담은
        // temp를 리턴한다.
        return temp;
    }

    // 회수 메소드
    public BoardDTO selectOne(int id) {
        for (BoardDTO s : list) {
            if (id == s.getId()) {
                return s;
            }
        }
        return null;
    }

    // 회수 메소드
    public ArrayList<BoardDTO> selectAll() {
        return list;
    }

    public void update(BoardDTO s) {
        int index = list.indexOf(s);

        BoardDTO origin = list.get(index);
        s.setWriterId(origin.getWriterId()); // 라이터 -> 라이터 아이디 변경
        s.setWrittenDate(origin.getWrittenDate());
        s.setUpdatedDate(Calendar.getInstance());
        list.set(index, s);
    }

    public void delete(int id) {
        BoardDTO s = selectOne(id);
        if (s != null) {
            list.remove(s);
        }
    }

    // 토탈 6.1 (1)
    // 파라미터로 들어온 회원번호와 일치하는
    // 작성자 회원번호를 가진 글들을
    // 모두 리스트에서 삭제하는
    // deleteByWriterId(int writerId)
    public void deleteByWriterId(int writerId) {
        // 우리가 출력에서 사용하던 forEach 문의 경우,
        // 해당 리스트의 크기가 변경되면 에러가 발생하므로
        // 기존의 for문을 사용한다.
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWriterId() == writerId) {
                list.remove(i);
                i--; // 삭제하기전 값으로 갔다가 반복문에서 다시 i++
            }
        }

    }

}