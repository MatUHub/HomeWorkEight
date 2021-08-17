package com.example.homeworkeight;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class CardSourceImpl implements CardSource {
    private List<CardData> dataSource;
    private Resources resources;
    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }

    public CardSourceImpl(Resources resources){
        dataSource = new ArrayList<>();
        this.resources = resources;
    }

    public CardSourceImpl init(){



        String[] titles = resources.getStringArray(R.array.notes);

        for(int i = 0; i < titles.length; i++){
            dataSource.add(new CardData(titles[i]));
        }
        return this;
    }
}
