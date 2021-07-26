package com.kollhong.oop_features;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

/* 이 앱은 ListView에 5개의 Item을 출력하는 앱이다.
 * 첫번째, 4번째 Item은 HeaderItem 타입이고, 글자 크기가 큰 게 특징이다.
 * 나머지 Item은 ContentItem 타입이고, 글자 크기가 작다.
 * */
public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseAdapter listAdapter = createAdapter();  // 다형성 사용
        listView = findViewById(R.id.listView);
        listView.setAdapter(listAdapter);
    }

    /***  다형성 예제
     * 오버로딩
     * 같은 이름의 메소드가 파라미터에 따라 다른 기능을 함
     * */
    BaseAdapter createAdapter() {
        return createAdapter(5);
    }
    BaseAdapter createAdapter(int count) {
        return new List_Adapter(count, this);
    }
}
