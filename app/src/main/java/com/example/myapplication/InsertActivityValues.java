package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;

public interface InsertActivityValues {
    int getCount();

    Object getItem(int i);

    long getItemId(int i);

    View getView(int i, View view, ViewGroup viewGroup);
}
