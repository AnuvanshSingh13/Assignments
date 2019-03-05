package com.example.recyclerviewasignment;

public class ModalClassRowText {
    String text;
    int type;

    public ModalClassRowText(String text, int type) {
        this.text = text;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
