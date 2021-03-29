package com.example.a04_11_recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a04_11_recyclerview.model.Product;


public class MainActivity extends AppCompatActivity {
    private RecyclerView revCat;
    private CatAdapter adapter;

    private Spinner spImg;
    private EditText eName,ePrice,eDescribe;
    private Button btAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intView();

        adapter=new CatAdapter(this);
        LinearLayoutManager manager=new LinearLayoutManager(this,
                RecyclerView.VERTICAL,false);
        revCat.setLayoutManager(manager);

        revCat.setAdapter(adapter);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p=new Product();
                String i=spImg.getSelectedItem().toString();
                int img=0;
                switch(i){
                    case "1":img=R.drawable.cat1;
                        break;
                    case "2":img=R.drawable.cat2;
                        break;
                    case "3":img=R.drawable.cat3;
                        break;
                    case "4":img=R.drawable.cat4;
                        break;
                    case "5":img=R.drawable.cat5;
                        break;
                    case "6":img=R.drawable.cat6;
                        break;
                }
                p.setResouceImg(img);
                p.setName(eName.getText().toString());
                p.setPrice(Double.parseDouble(ePrice.getText().toString()));
                p.setDescribe(eDescribe.getText().toString());
                adapter.add(p);
            }
        });
    }

    private void intView() {
        revCat=findViewById(R.id.recyclerView);
        spImg=findViewById(R.id.img);
        eName=findViewById(R.id.name);
        ePrice=findViewById(R.id.price);
        eDescribe =findViewById(R.id.describe);
        btAdd=findViewById(R.id.btAdd);
    }
}
