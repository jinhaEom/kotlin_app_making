package ac.baekseok.listview20201126;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("리스트뷰 테스트 엄진하");
            //리스트뷰에 나열될 항목의 글자를 배열로 선언 final onCreate()
            final String[] mid={"ICT개론","IOT실습","해킹이론","안드로이드프로그래밍",
                    "파이썬","인공지능개론","VR실습","빅데이터","모바일 웹"};
            //추가했던 리스트뷰
            ListView list=(ListView)findViewById(R.id.listView1);
            //리스트뷰에 형식 단순리스트타입, 나열되는 글자를 지정하기 위한 ArrayAdapter를 추가
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,mid);
        //매개변수 리스트의 단순리스트 형식,나열글자
        list.setAdapter(adapter);//형식,나열글자가 적용됌 리스트뷰에 설정된 ArrayAdapter를 적용
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position이라는 매개변수는 list의 아이템중에 몇번째를 저장하고 있는지를 의미
                if(position==0){
                    //화면 Second.java로 이동, 인텐트 이동
                    Intent intent= new Intent(getApplicationContext(),Second.class);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent= new Intent(getApplicationContext(),Third.class);
                    startActivity(intent);
                }
            }
        });
    }//onCreate
}//MainActivity