package app.easylink.recyclerview_cardview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import app.easylink.recyclerview_cardview.room.AppDatabase;
import app.easylink.recyclerview_cardview.view.AddProduct;
import app.easylink.recyclerview_cardview.view.ViewProduct;

/**
 * @author Abdul Qadir
 * Demo application to add and view data from database using Room Persistant library in a recyclerView
 */

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    public static AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.addBtn);
        btn2 = (Button) findViewById(R.id.viewBtn);

        appDatabase = AppDatabase.getInstance(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(MainActivity.class, );
                Intent intent = new Intent(MainActivity.this, AddProduct.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewProduct.class);
                startActivity(intent);
            }
        });


    }
}
