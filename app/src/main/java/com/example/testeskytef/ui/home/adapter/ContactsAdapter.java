package com.example.testeskytef.ui.home.adapter;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeskytef.R;
import com.example.testeskytef.data.models.Contact;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    public ContactsAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Contact item);
    }

    private List<Contact> items;
    private final OnItemClickListener listener;
    @SuppressLint("NotifyDataSetChanged")
    public void setItems(List<Contact> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);

        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.tvName.setText(items.get(position).getFullname());
        holder.tvNumber.setText(items.get(position).getPhone());
        holder.bind(items.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ContactViewHolder extends  RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvNumber;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.name);
            tvNumber = itemView.findViewById(R.id.number);
        }

        public void bind(final Contact item, final OnItemClickListener listener){
            itemView.setOnClickListener(view -> listener.onItemClick(item));
        }
    }


}
