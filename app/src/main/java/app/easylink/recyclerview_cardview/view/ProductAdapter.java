package app.easylink.recyclerview_cardview.view;
//Recycler Adapter
//Recycler ViewHolder

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

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
    public void onBindViewHolder(ProductAdapter.ViewHolder viewHolder, int position) {

        viewHolder.titleText.setText(myItem.get(position).getName());
        viewHolder.descriptionText.setText(myItem.get(position).getAddress());
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.title);
            descriptionText = itemView.findViewById(R.id.description);
        }
    }
}
