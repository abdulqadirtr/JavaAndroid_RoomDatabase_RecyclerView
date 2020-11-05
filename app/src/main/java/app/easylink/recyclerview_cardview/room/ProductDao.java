package app.easylink.recyclerview_cardview.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {


    @Query("SELECT *FROM Product")
    List<Product> getAll();

    @Query("SELECT *FROM Product where id IN (:productIds)")
    List<Product> loadAllByIds(int[] productIds);


    @Insert
    void insertAll(Product... products);

    @Insert
    public void addProduct(Product product);

    @Delete
    void delete(Product product);

}