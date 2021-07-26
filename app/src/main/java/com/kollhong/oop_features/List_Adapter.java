package com.kollhong.oop_features;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class List_Adapter extends BaseAdapter {
    Activity activity;
    int count = 0;
    ArrayList<List_Item> items = new ArrayList<List_Item>();

    public List_Adapter(int count, Activity activity) {
        super();
        this.count = count;
        this.activity = activity;
    }

    @Override
    public long getItemId(int i) {
        return count;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(activity).inflate(R.layout.list_holder, viewGroup, false);

        List_Item item;
        if (position == 0 || position == 3){
            item = new HeaderItem(v);
        } else {
            item = new ContentItem(v);
        }

        /* 동적 바인딩
        * item의 자료형은 List_Item 이지만
        * 리스트 위치에 따라 서로 다른 자료형으로 선언 함
        *
        * 따라서 하나의 List 배열에 추가할 수 있으면서도
        * item.getType()을 호출했을 때 리턴값이 달라진다.
        *  */
        items.add(position,item);

        position++;
        item.content.setText(position + "th " + item.getType() +" item.");

        /* 동적 바인딩
        * ContentItem에는 getNumber 메소드가 있는데,
        * 이는 동적 바인딩을 이용해서는 실행할 수 없다.
        * getNumber를 사용하려면 캐스팅해야 함
        * */
//        item.getNumber;
        if( item.getType() == List_Item.TYPE_CONTENT) {
            ContentItem contentItem = (ContentItem)item;
            contentItem.getNumber();
        }

        return v;
    }
}
