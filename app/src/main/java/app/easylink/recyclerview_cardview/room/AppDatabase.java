package app.easylink.recyclerview_cardview.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Product.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    private static final String dbName = "productDb";
    private static AppDatabase appDatabase;

    /*
    when the resource belongs to all instances (i.e. when it is in a static variable)
     then you use a synchronized static method to access it.
     */
    public static synchronized AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, dbName).allowMainThreadQueries().build();
        }
        return appDatabase;
    }

    public abstract ProductDao productDao();

}
