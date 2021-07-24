package model;

import java.util.ArrayList;

public class dd {
    
    private ArrayList<TheaterDTO> list;
    private int nextId;
    
    public dd() {

    ArrayList<TheaterDTO> list = new ArrayList<>();
    TheaterDTO t = new TheaterDTO();
    int nextId;
    int call;
    
    public void theater(String name, String position) {
        
       
        String msg;
        nextId = 1;
        call = 1;
        if (call < 10) {
            msg = new String("070-2242-000"+call);
        } else {
            msg = new String("070-2242-00"+call);
        }
        t.setId(nextId++);
        t.setTheaterName(name);
        t.setTheaterPosition(position);
        t.setTheaterCall(msg);
        call ++;
        
        list.add(t);
        
    }

}
