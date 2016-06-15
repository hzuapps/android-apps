package edu.hzuapps.androidworks.homeworks.net1314080903112;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileExplorerActivity_net1314080903112 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    SimpleAdapter adapter;
    String rootPath = Environment.getExternalStorageDirectory().getPath();
    String currentPath = rootPath;
    List<Map<String, Object>> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_explorer_net1314080903112);
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new SimpleAdapter(this, list, R.layout.list_item_net1314080903112,
                new String[]{"name", "img"}, new int[]{R.id.name, R.id.img});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        refreshListItems(currentPath);
    }

    private void refreshListItems(String path) {
        setTitle(path);
        File[] files = new File(path).listFiles();
        list.clear();
        if (files != null) {
            for (File file : files) {
                Map<String, Object> map = new HashMap<>();
                if (file.isDirectory()) {
                    map.put("img", R.drawable.directory_net1314080903112);
                } else {
                    map.put("img", R.drawable.file_doc_net1314080903112);
                }
                map.put("name", file.getName());
                map.put("currentPath", file.getPath());
                list.add(map);
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        currentPath = (String) list.get(position).get("currentPath");
        File file = new File(currentPath);
        if (file.isDirectory())
            refreshListItems(currentPath);
        else {
            Intent intent = new Intent();
            intent.putExtra("apk_path", file.getPath());
            setResult(RESULT_OK, intent);
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        if (rootPath.equals(currentPath)) {
            super.onBackPressed();
        } else {
            File file = new File(currentPath);
            currentPath = file.getParentFile().getPath();
            refreshListItems(currentPath);
        }
    }
}