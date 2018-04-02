package com.willpower.study.home;

/**
 * Created by Administrator on 2018/3/30.
 */

public class ChapterBean {
    //第几章
    private String chapterIndex;
    //章节名称
    private String chapterDesc;

    public ChapterBean(String chapterIndex, String chapterName) {
        this.chapterIndex = chapterIndex;
        this.chapterDesc = chapterName;
    }

    public String getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(String chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public String getChapterDesc() {
        return chapterDesc;
    }

    public void setChapterDesc(String chapterDesc) {
        this.chapterDesc = chapterDesc;
    }
}
