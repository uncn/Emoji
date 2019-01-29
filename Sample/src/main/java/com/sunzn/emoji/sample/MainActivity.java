package com.sunzn.emoji.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.sunzn.emoji.library.EmojiEditText;
import com.sunzn.emoji.library.EmojiPool;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView mGridView;
    private EmojiAdapter mAdapter;
    private EmojiEditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initView();
        initData();
    }

    private void initView() {
        mEditText = findViewById(R.id.etv);
        mGridView = findViewById(R.id.grid);
    }

    private void initData() {
        mAdapter = new EmojiAdapter(this, EmojiPool.sFaceList);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mEditText.insert(mAdapter.getItem(position));
    }

}
