package ac.baekseok.dialog20172470;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = (Button) findViewById(R.id.button1);
        //버튼을 클릭하면 속성 지정
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼을 클릭시 대화상자의 속성을 지정하고 대화상자를 띄움->대화상자 인스턴스 생성
                final String[] versionArray=new String[]{"안드로이드10",
                        "파이","누가","오레오"};//나열되는 목록글자 배열초기화
                final boolean[] checkArray=new boolean[]{true,false,false,false};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                //속성 타이틀 재목을 설정
                dlg.setTitle("좋아하는 안드로이드 버전은?");
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        button1.setText(versionArray[which]);
                    }
                });
                //내용부분을 목록으로 나열하는 속성 setItems()목록 설정
               /* dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        button1.setText(versionArray[which]);
                    }
                });*/
 /*               dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //which는 목록의 몇번째 요소를 클릭했는지 요소의 위치 가지고 저장
                        button1.setText(versionArray[which]);
                    }
                });*/
                //dlg.setMessage("엄진하 내용입니다.");//내용을 설정하는 메소드
                //타이틀의 제목이미지
                dlg.setIcon(R.drawable.icon1);
                //확인버튼을 대화상자의 위에 얹음
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "확인버튼이 눌렸어요.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("닫기",null);

                dlg.show();

            }
        });

    }
}