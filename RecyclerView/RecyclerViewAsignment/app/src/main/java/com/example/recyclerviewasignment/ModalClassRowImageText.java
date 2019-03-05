package com.example.recyclerviewasignment;

public class ModalClassRowImageText {
    String text;
    int imgRes;
    int type;

    public ModalClassRowImageText(String text, int imgRes, int type) {
        this.text = text;
        this.imgRes = imgRes;
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

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
