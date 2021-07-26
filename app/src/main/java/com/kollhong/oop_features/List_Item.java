package com.kollhong.oop_features;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;


/* 추상화 예제
 * abstract로 선언함
 * 상속받는 object는
 * 생성자와 getType을 반드시 선언해야 함
 *
 * 추후 abstract class 내에 있는 메소드를 외부에서 사용할 수 있으며
 * 이 과정을 동적 바인딩이라고 한다.
 */
abstract class List_Item {
    static final String TYPE_HEADER = "Header";
    static final String TYPE_CONTENT = "Content";

    View selfView;
    TextView header;
    TextView content;

    public List_Item(@NonNull View itemView) {
        selfView = itemView;
        header = itemView.findViewById(R.id.title_text);
        content = itemView.findViewById(R.id.content_text);
    }

    abstract String getType();
}

class HeaderItem extends List_Item {
    public HeaderItem(@NonNull View itemView) {
        super(itemView);
        header.setText("Header Item");
    }
    String getType() { return TYPE_HEADER;}
}

class ContentItem extends List_Item {
    public ContentItem(@NonNull View itemView) {
        super(itemView);
        header.setTextSize(16);
        header.setText("Content Item");
    }
    String getType() { return TYPE_CONTENT; }

    int getNumber() { return 0; }
}