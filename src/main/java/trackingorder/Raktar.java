package trackingorder;

import java.util.ArrayList;
import java.util.List;

public class Raktar {
    private List<Termek> termekek = new ArrayList<Termek>();

    public void addTermek( Integer id, String name ){
        termekek.add( id , new Termek(  ) );
    }

    public void plusKeszlet( Integer id, Integer darab ){

    }

    public Integer getKeszlet( Integer id ){
        return 0;
    }

    public void minusKeszlet( Integer id, Integer darab ){

    }

}
