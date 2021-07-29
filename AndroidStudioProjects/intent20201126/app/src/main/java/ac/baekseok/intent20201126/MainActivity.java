package ac.baekseok.intent20201126;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("엄진하 메인화면");
        final Button mainBtn = (Button) findViewById(R.id.mainBtn);
        //메인버튼을 누르면 인텐트에 EditText에서 가져온 값을 인텐트에 실음
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //A,B 두 수는 EditText에서 가져옴 위젯 인스턴스생성
                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
                //인텐트 생성해서 변수를 인텐트에 실음
                Intent intent = new Intent(getApplicationContext(), Second.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));//인텐트에 edtNum1값을 실음
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent, 0);

            }
        });//mainBtn
    }//onCreate();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            int hap=data.getIntExtra("Hap",0);
            //data는 인텐트 받음, 매개변수 인텐트변수 가져오는 메소드getIntExtra()
            //토스트메시지로 화면상에 결과 Hap을 띄움
            Toast.makeText(getApplicationContext(),"합계"+hap,Toast.LENGTH_LONG).show();
        }
    }
}//MainActivity