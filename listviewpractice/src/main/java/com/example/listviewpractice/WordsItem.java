package com.example.listviewpractice;

public class WordsItem {
    private String word;
    private String meaning;

    public WordsItem(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    @Override
    public String toString() {
        return "WordsItem{" +
                "word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}
