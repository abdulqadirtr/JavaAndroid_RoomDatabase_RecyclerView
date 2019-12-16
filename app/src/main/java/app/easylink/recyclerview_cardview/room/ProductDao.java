package app.easylink.recyclerview_cardview.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

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