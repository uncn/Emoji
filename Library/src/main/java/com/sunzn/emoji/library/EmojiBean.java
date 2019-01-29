package com.sunzn.emoji.library;

public class EmojiBean {

    private String name;
    private int res;

    public EmojiBean(String name, int res) {
        this.name = name;
        this.res = res;
    }

    public String getName() {
        return name;
    }

    public int getRes() {
        return res;
    }

}
