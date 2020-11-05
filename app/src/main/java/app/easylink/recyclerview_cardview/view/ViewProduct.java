package app.easylink.recyclerview_cardview.view;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.easylink.recyclerview_cardview.MainActivity;
import app.easylink.recyclerview_cardview.R;
import app.easylink.recyclerview_cardview.room.Product;

public class ViewProduct extends Activity {
    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter adapter;
    List<Product> items;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                items = MainActivity.appDatabase.productDao().getAll();
                recyclerView = (RecyclerView) findViewById(R.id.recycle1);
                final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                adapter = new ProductAdapter(items);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);

            }
        };

        Thread newThread = new Thread(r);
        newThread.start();


        List<Product> myValues = MainActivity.appDatabase.productDao().getAll();
        for (Product note : myValues) {
            System.out.println("-----------------------");
            System.out.println(note.getName());
            System.out.println(note.getAddress());
        }


    }
}
