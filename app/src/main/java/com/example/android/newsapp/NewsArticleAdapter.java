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

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link NewsArticleAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link NewsArticle} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsArticleAdapter extends ArrayAdapter<NewsArticle> {

     /**
     * Constructs a new {@link NewsArticleAdapter}.
     *
     * @param context      of the app
     * @param NewsArticles is the list of NewsArticles, which is the data source of the adapter
     */
    public NewsArticleAdapter(Context context, List<NewsArticle> NewsArticles) {
        super(context, 0, NewsArticles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        NewsArticle currentNewsArticle = getItem(position);

        TextView TitleView = (TextView) listItemView.findViewById(R.id.title);

        TitleView.setText(currentNewsArticle.getTitle());

        String sectionName = currentNewsArticle.getSectionName();

        TextView SectionView = (TextView) listItemView.findViewById(R.id.section);
        SectionView.setText(sectionName);

        Bitmap thumbnail = currentNewsArticle.getBitMap();

        String datestring=currentNewsArticle.getDate();
        // Date format changed to YYYY-MM-DD
        int tlocation=datestring.indexOf("T");
        String formatteddate=datestring.substring(0,tlocation);

        TextView DateView = (TextView) listItemView.findViewById(R.id.date);
        DateView.setText(formatteddate);

        String authorString = currentNewsArticle.getAuthor();
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        authorView.setText(authorString);

        ImageView imageView= (ImageView) listItemView.findViewById(R.id.thumbnail);
        imageView.setImageBitmap(formatImageFromBitmap(thumbnail));



        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    private Bitmap formatImageFromBitmap(Bitmap articleThumbnail) {
        // Bitmap for image
        Bitmap returnBitmap;
        // Check thumbnail valid
        if (articleThumbnail == null) {
            // If not valid return default image
            returnBitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.no_picture);
        } else {
            // If valid return image
            returnBitmap = articleThumbnail;
        }
        // Return bitmap
        return returnBitmap;
    }


}
