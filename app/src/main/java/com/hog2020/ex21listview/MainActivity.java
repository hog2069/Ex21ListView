package com.hog2020.ex21listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    //Adapter객체 참조변수
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);

        //리스트뷰에 보여질 항목(item) View 객체를
        //만들어 내는 작업을 수행하는 Adapter 객체 생성
        adapter =ArrayAdapter.createFromResource(this,R.array.datas,R.layout.list_item);
        listView.setAdapter(adapter);

        //리스트뷰의 항목(item)을 클릭하는 것을 듣는 리스너 객체생성 및 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //res폴더의 arrays.xml안에 있는
                //배열을 참조하기

                //res 폴더 관리자 소환
                Resources res =getResources();

                String[] arr =res.getStringArray(R.array.datas);


                Toast.makeText(MainActivity.this, arr[position], Toast.LENGTH_SHORT).show();
            }
        });

        //아이템 롱~클릭 리스너
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();

                //이 리턴값이 false 면 onclick 도 반응을 함
                return true;
            }
        });
    }
}