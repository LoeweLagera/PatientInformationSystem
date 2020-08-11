package com.theblockph.patientinformationsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {


    private List<ListItem> listItems;
    private Context context;


    public ViewAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);
        return new ViewHolder(v);
    }

    //BIND DATA with ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.cardViewFirstName.setText(listItem.getFirstName() );
        holder.cardViewContactNum.setText(listItem.getContactNumber() );
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView cardViewFirstName;
        public TextView cardViewContactNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewFirstName = itemView.findViewById(R.id.cardViewFirstName);
            cardViewContactNum = itemView.findViewById(R.id.cardViewContactNum);
        }
    }
}
