package com.example.a04_11_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a04_11_recyclerview.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends
        RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private Context mContext;
    private List<Product> mlist;

    public List<Product> getList() {
        return mlist;
    }

    public void setList(List<Product> mlist) {
        this.mlist = mlist;
    }

    public CatAdapter(Context mContext) {
        this.mContext = mContext;
        mlist=new ArrayList<>();
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                            int viewType) {
        View v= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_card,parent,
                        false);
        return new CatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder,
                                 final int position) {
         Product p=mlist.get(position);
         if(p!=null) {
             holder.img.setImageResource(p.getResouceImg());
             holder.name.setText(p.getName());
             holder.price.setText(p.getPrice() + "");
             holder.describe.setText(p.getDescribe());

             holder.btRemove.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     mlist.remove(position);
                     notifyDataSetChanged();
                 }
             });
         }
         return;

    }
    public void add(Product p){
        mlist.add(p);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name;
        private TextView price;
        private TextView describe;
        private Button btRemove;

        public CatViewHolder(@NonNull View v) {
            super(v);
            img= v.findViewById(R.id.img);
            name=v.findViewById(R.id.txtName);
            price=v.findViewById(R.id.txtPrice);
            describe=v.findViewById(R.id.txtDescribe);
            btRemove=v.findViewById(R.id.bt1);
        }
    }

}
