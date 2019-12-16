package app.easylink.recyclerview_cardview.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


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
