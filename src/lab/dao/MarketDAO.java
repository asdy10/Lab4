package lab.dao;

import javafx.scene.media.MediaMarkerEvent;
import lab.Market;
import lab.Product;

import java.util.List;

public interface MarketDAO {

    List<Market> getAll();
    Market getByID(int ID);
    void create(Market market);
    void delete(Market market);
    void edit(long ID, Market market);

}
