package com.example.listviewpractice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class WordsItemView extends LinearLayout {
    TextView text_view_word, text_view_meaning;

    public WordsItemView(Context context) {
        super(context);
        init(context);
    }

    public WordsItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_item, this, true);
        text_view_word = findViewById(R.id.text_view_word);
        text_view_meaning = findViewById(R.id.text_view_meaning);
    }

    public void setWord(String word) {
        text_view_word.setText(word);
    }

    public void setMeaning(String meaning) {
        text_view_meaning.setText(meaning);
    }
}
