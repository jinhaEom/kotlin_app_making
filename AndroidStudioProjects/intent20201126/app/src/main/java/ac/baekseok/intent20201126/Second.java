package ac.baekseok.intent20201126;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class Second extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("엄진하 둘째화면");
        //인텐트에서 Num1,Num2 변수값을 받아야함
        Intent inIntent = getIntent();
        //인텐트에서 가져오는 메소드 inIntent.getIntExtra();
        final int hapValue = inIntent.getIntExtra("Num1", 0) +
                inIntent.getIntExtra("Num2", 0);
        //메인으로 이동하는 버튼 추가
        final EditText sEdt1=(EditText)findViewById(R.id.sEdt1);
        final EditText sEdt2=(EditText)findViewById(R.id.sEdt2);
        final Button btnReturn=(Button)findViewById(R.id.btnReturn);
        //임시변수를 num1,num2를 선언
        String num1=null;
        String num2=null;
        num1=String.valueOf(inIntent.getIntExtra("Num1",0));//정수형을 String타입값을 리턴
        num2=String.valueOf(inIntent.getIntExtra("Num2",0));
        sEdt1.setText(num1);
        sEdt2.setText(num2);


        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hapValue를 인텐트에 실어서 메인으로 전달 setReturl()
                Intent outIntent=new Intent(getApplicationContext(),MainActivity.class);
                outIntent.putExtra("Hap",hapValue);
                setResult(RESULT_OK,outIntent);//설정을 해도 메인화면의 onActivityResult()가 실행됌
                finish();//본화면을 닫음
            }
        });
    }//onCrete

}//MainActivity
