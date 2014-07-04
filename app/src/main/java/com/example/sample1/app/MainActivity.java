package com.example.sample1.app;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.app.SearchManager;

// 音声入力を文字変換して表示するアプリ

public class MainActivity extends Activity
{
    private static final int REQUEST = 0;               // リクエストコード

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // レイアウトの作成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.rgb(255,255,255));
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        // ボタンの生成
        Button  button;
        button = new Button(this);
        button.setText("検索ページへ");
        setMyLayoutParams(button);
        layout.addView(button);

        Button  button2;
        button2 = new Button(this);
        button2.setText("会話ページへ");
        setMyLayoutParams(button2);
        layout.addView(button2);

        // ボタンイベント処理
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,
                            com.example.sample1.app.Search.class);
                    startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        com.example.sample1.app.talk.class);
                startActivity(intent);
            }
        });
    }

    // レイアウトのパラメータを設定する
    private static void setMyLayoutParams(View view)
    {
        view.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    }
}