package com.example.contentresolverdemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // book表
        Uri bookUri = Uri.parse("content://com.example.contentproviderdemo.provider/book");

        // 插入
        ContentValues values = new ContentValues();
        values.put("_id", 0);
        values.put("name", "艺术开发");
        getContentResolver().insert(bookUri, values);

        // 查询
        Cursor bookCursor = getContentResolver().query(bookUri, new String[]{"_id", "name"}, null, null, null);
        while (bookCursor.moveToNext()) {
            Book book = new Book();
            book.bookId = bookCursor.getInt(0);
            book.bookName = bookCursor.getString(1);
            Log.e("", "----query book: " + book.toString());
        }
        bookCursor.close();

        // user表
        Uri userUri = Uri.parse("content://com.example.contentproviderdemo.provider/user");

        // 查询
        Cursor userCursor = getContentResolver().query(userUri, new String[]{"_id", "name", "sex"}, null, null, null);
        while (userCursor.moveToNext()) {
            User user = new User();
            user.userId = userCursor.getInt(0);
            user.userName = userCursor.getString(1);
            user.userSex = userCursor.getString(2);
            Log.e("", "----query user: " + user.toString());
        }
        userCursor.close();


    }
}
