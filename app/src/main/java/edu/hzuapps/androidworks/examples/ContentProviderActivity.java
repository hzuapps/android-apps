package edu.hzuapps.androidworks.examples;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import edu.hzuapps.androidworks.R;

public class ContentProviderActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        final ContentProviderActivity thisActivity = this;

        // 保存图书信息
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveBook();
            }
        });

        // 加载下一本书
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextBook();
            }
        });
    }

    // 保存图书信息
    private void saveBook() {
        String name = ((EditText) findViewById(R.id.book_name)).getText().toString();
        String tags = ((EditText) findViewById(R.id.book_tags)).getText().toString();

        // 插入新记录
        ContentValues book = new ContentValues();
        //book.put("name", name); // Map <- Key:Value
        book.put(ContentProviderOfBooks.NAME, name);
        book.put(ContentProviderOfBooks.TAGS, tags);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfBooks.CONTENT_URI, book);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showBookInfo("", ""); // 清除内容
    }

    private void showBookInfo(String name, String tags) {
        ((EditText) findViewById(R.id.book_name)).setText(name);
        ((EditText) findViewById(R.id.book_tags)).setText(tags);
    }

    // 显示下一本书
    private void showNextBook() {
        //String URL = ContentProviderOfBooks.URL;
        Cursor c = getContentResolver() // 执行查询
                .query(ContentProviderOfBooks.CONTENT_URI, null, null, null, null);

        // 随机取1条记录
        int random = (new Random()).nextInt(10);

        if (c.moveToFirst()) {
            String name = "";
            String tags = "";
            int count = 1;
            do {
                name = c.getString(c.getColumnIndex(ContentProviderOfBooks.NAME));
                tags = c.getString(c.getColumnIndex(ContentProviderOfBooks.TAGS));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
            // 显示在界面上
            this.showBookInfo(name, tags);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的图书!", Toast.LENGTH_LONG).show();
        }
    }

}
