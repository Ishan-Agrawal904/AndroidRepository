package com.example.shayarimania.PoetryModel;

public class PoetryModel {
    String url;
    String poetName;
    String halfPoemFirst;
    String halfPoemSecond;

    String fullPoem3;
    String fullPoem4;

    public PoetryModel(String url, String poetName, String halfPoemFirst, String halfPoemSecond,
                       String fullPoem3, String fullPoem4) {
        this.url = url;
        this.poetName = poetName;
        this.halfPoemFirst = halfPoemFirst;
        this.halfPoemSecond = halfPoemSecond;

        this.fullPoem3 = fullPoem3;
        this.fullPoem4 = fullPoem4;
    }

    public PoetryModel(){}

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getPoetName() {
        return poetName;
    }
    public void setPoetName(String poetName) {
        this.poetName = poetName;
    }
    public String getHalfPoemFirst() {
        return halfPoemFirst;
    }
    public void setHalfPoemFirst(String halfPoemFirst) {
        this.halfPoemFirst = halfPoemFirst;
    }
    public String getHalfPoemSecond() {
        return halfPoemSecond;
    }
    public void setHalfPoemSecond(String halfPoemSecond) {
        this.halfPoemSecond = halfPoemSecond;
    }


    public String getFullPoem3() {
        return fullPoem3;
    }
    public void setFullPoem3(String fullPoem3) {
        this.fullPoem3 = fullPoem3;
    }
    public String getFullPoem4() {
        return fullPoem4;
    }
    public void setFullPoem4(String fullPoem4) {
        this.fullPoem4 = fullPoem4;
    }
}
