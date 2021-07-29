package ac.baekseok.listadd20172470;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> midList = new ArrayList<String>() ;//리스트에 항목으로 쓰여지는 글자들(항목들) String타입으로 놓는다
        ListView list=(ListView)findViewById(R.id.listView1);
        //리스트에 형태 단순하게 나열되는 형태, 위에서 선언한 글자항목 지정 ArrayAdapter
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,midList);
        list.setAdapter(adapter);

        final EditText edtItem=(EditText)findViewById(R.id.edtItem);
        final Button btnAdd=(Button)findViewById(R.id.btnAdd);
        //btnAdd 버튼 누르면 edtItem 항목을 추가할 글자를 입력하고 btnAdd를 누르면 list(midList)에 추가됨
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midList.add(edtItem.getText().toString());//ArrayList추가됨
                adapter.notifyDataSetChanged();//변경된 항목을 adapter에 설정
                edtItem.setText("");
            }
        });
        //추가된 리스트의 해당항목을 롱클릭 하면 해당항목이 삭제되게 하기.
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                midList.remove(position);//position 몇번째 항목을 제거
                adapter.notifyDataSetChanged();//adapter에 변경사항을 반영
                return false;//롱클릭 안된상태를 리턴
            }
        });
    }//onCreate
}//MainActivity