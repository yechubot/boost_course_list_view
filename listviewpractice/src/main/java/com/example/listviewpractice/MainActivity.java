package com.example.listviewpractice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.WrapperListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    WordsAdapter adapter;
    ListView listView;
    Button btn_add;
    EditText add_words, add_meaning;
    String str_words, str_meaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        listView = findViewById(R.id.list_view);
        btn_add = findViewById(R.id.btn_add);
        adapter = new WordsAdapter();
        adapter.addItem(new WordsItem("alebit", "guess what"));
        adapter.addItem(new WordsItem("dichotomy", "guess what"));
        adapter.addItem(new WordsItem("feckless", "guess what"));
        listView.setAdapter(adapter);

    }

    class WordsAdapter extends BaseAdapter {
        List<WordsItem> wordsItem = new ArrayList<>();

        @Override
        public int getCount() {
            return wordsItem.size();
        }

        public void addItem(WordsItem words) {
            wordsItem.add(words);
        }

        @Override
        public Object getItem(int position) {
            return wordsItem.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            WordsItemView view = new WordsItemView(getApplicationContext());
            final WordsItem word = wordsItem.get(position);
            view.setWord(word.getWord());
            view.setMeaning(word.getMeaning());
            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //뜻, 의미 추가해서 리스트뷰에 넣기
                    View dialogView = View.inflate(MainActivity.this, R.layout.words_add, null);
                    add_words = dialogView.findViewById(R.id.edit_text_words);
                    add_meaning = dialogView.findViewById(R.id.edit_text_meaning);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Add words!");
                    builder.setView(dialogView);
                    builder.setPositiveButton("cancel", null);
                    builder.setNegativeButton("add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            str_words = add_words.getText().toString();
                            str_meaning = add_meaning.getText().toString();
                            if(str_words!=null && str_meaning!=null) {
                                adapter.addItem(new WordsItem(str_words, str_meaning));
                            }
                        }
                    });
                    builder.show();

                }
            });
            return view;
        }
    }

}
