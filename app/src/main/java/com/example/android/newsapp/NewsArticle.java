/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.newsapp;

import android.graphics.Bitmap;

/**
 * An {@link NewsArticle} object contains information related to a single earthquake.
 */
public class NewsArticle {

    private String nTitle;

    private String nSectionName;

    private String nDate;

    private String nAuthor;

    private String mUrl;

    private Bitmap bitMap;



    public NewsArticle(String Title, String SectionName, String Date, String Author, String url, Bitmap bitmap) {
        nTitle = Title;
        nSectionName = SectionName;
        nDate = Date;
        nAuthor = Author;
        mUrl = url;
        bitMap=bitmap;
    }

    public String getTitle() {
        return nTitle;
    }

    public String getSectionName() {
        return nSectionName;
    }

    public String getDate() {
        return nDate;
    }

    public String getAuthor() { return nAuthor; }

    public String getUrl() {
        return mUrl;
    }

    public Bitmap getBitMap() {
        return bitMap;
    }

}
