package app.easylink.recyclerview_cardview.view;
//Recycler Adapter
//Recycler ViewHolder

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.easylink.recyclerview_cardview.MainActivity;
import app.easylink.recyclerview_cardview.R;
import app.easylink.recyclerview_cardview.room.Product;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<Product> myItem;

    public ProductAdapter(List<Product> myItem) {
        this.myItem = myItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductAdapter.ViewHolder viewHolder, final int position) {

        viewHolder.titleText.setText(myItem.get(position).getName());
        viewHolder.descriptionText.setText(myItem.get(position).getAddress());
        viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Product product = new Product();
                product.setId(position);
                Toast.makeText(context, "User added Successfully "+ position, Toast.LENGTH_SHORT).show();

                MainActivity.appDatabase.productDao().delete(product);
                int p = viewHolder.getAdapterPosition();
                myItem.remove(p);
                notifyItemRemoved(p);
                notifyItemRangeChanged(p, myItem.size());

            }
        });
    }

    @Override
    public int getItemCount() {

        if (myItem.size() == 0) {
            return 1;
        } else {
            return myItem.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleText, descriptionText;

        Button btnDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.title);
            descriptionText = itemView.findViewById(R.id.description);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
