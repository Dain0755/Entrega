package com.example.myapplication;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class DataActivity extends SQLiteOpenHelper {
    public DataActivity(@Nullable Context onClickListener, @Nullable String nombres, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(onClickListener, nombres, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase dataActivity){
        dataActivity.execSQL("CREATE TABLE gastos(valor int primary key, descripcion string)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }

}