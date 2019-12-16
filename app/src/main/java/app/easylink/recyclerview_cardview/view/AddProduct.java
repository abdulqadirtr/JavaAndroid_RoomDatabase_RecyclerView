package app.easylink.recyclerview_cardview.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import app.easylink.recyclerview_cardview.MainActivity;
import app.easylink.recyclerview_cardview.R;
import app.easylink.recyclerview_cardview.room.Product;

public class AddProduct extends AppCompatActivity {

    EditText my_id, my_name, my_address;
    Button saveButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);
        my_id = (EditText) findViewById(R.id.editId);
        my_name = (EditText) findViewById(R.id.editName);
        my_address = (EditText) findViewById(R.id.editAddress);
        saveButton = (Button) findViewById(R.id.saveBtn);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userId = Integer.parseInt(my_id.getText().toString());
                String nameText = my_name.getText().toString();
                String addressText = my_address.getText().toString();
                Product product = new Product();
                product.setId(userId);
                product.setName(nameText);
                product.setAddress(addressText);
                MainActivity.appDatabase.productDao().addProduct(product);

                Toast.makeText(getApplicationContext(), "User added Successfully", Toast.LENGTH_SHORT).show();
                my_id.setText("");
                my_name.setText("");
                my_address.setText("");


            }
        });


    }
}
