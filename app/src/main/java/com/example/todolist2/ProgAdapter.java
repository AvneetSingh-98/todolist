package com.example.todolist2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist2.R;


public class ProgAdapter extends RecyclerView.Adapter<ProgAdapter.ProgView> {
    @NonNull
    private String[] data;
    public ProgAdapter(String[] data){
        this.data=data;
    }
    public ProgView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.list_item_layout, parent,false);
        return new ProgView(view);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgView holder, int position) {
        String title=data[position];
        holder.txttitle.setText(title);
    }

    public class ProgView extends RecyclerView.ViewHolder{
        TextView txttitle;

        public ProgView(@NonNull View itemView) {
            super(itemView);
            txttitle=itemView.findViewById(R.id.txtview);
        }
    }


}

