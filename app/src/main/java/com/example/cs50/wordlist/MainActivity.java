package com.example.cs50.wordlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SingAdapter adapter;
    EditText edt1, edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        adapter  = new SingAdapter();
        adapter.addItem(new SingerItem("소녀시대","010-1212-1212", R.drawable.blue));
        adapter.addItem(new SingerItem("티아라","010-2212-1212",R.drawable.blue2));
        adapter.addItem(new SingerItem("원더걸스","010-3212-1212",R.drawable.orange));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               SingerItem item = (SingerItem) adapter.getItem(position);//데이터에 접근 -> 어댑터 필요
                Toast.makeText(getApplicationContext(), "선택 "+item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        Button btn = findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt1.getText().toString();
                String mobile = edt2.getText().toString();

                adapter.addItem(new SingerItem(name,mobile,R.drawable.orange));
                adapter.notifyDataSetChanged();
            }
        });
    }

    class SingAdapter extends BaseAdapter {// 어댑터 : 데이터 관리
        List<SingerItem> items = new ArrayList<>();

        @Override
        public int getCount() {//리스트뷰가 아이템 갯수를 물어
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }


        @Override
        public Object getItem(int position) {//필요할 때 데이터를 물어봄
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position; //아ㅇ디 있다면 넘겨줌
        }

        //데이터 관리하는 어댑터가 뷰도 만들어줘!
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingerItemView view = new SingerItemView(getApplicationContext());
            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImg(item.getResId());
            return view;
        }
    }
}