package ac.baekseok.dialog_xml20172470;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvName,tvEmail;
    Button button1;
    EditText dlgEdtName,dlgEdtEmail;
    TextView toastText;
    View dialogView,toastView;//class import

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("엄진하의 사용자 정보 입력");
        tvName=(TextView)findViewById(R.id.tvName);
        tvEmail=(TextView)findViewById(R.id.tvEmail);
        button1=(Button)findViewById(R.id.button1);
        //button1을 누르면 대화상자에 dialog1.xml이 확장되어 dlg.show() 대화상자로 뜸
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView=(View)View.inflate(MainActivity.this,R.layout.dialog1,null);
                //dialog1.xml을 확장해서(inflate)
                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("엄진하의 사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인",null);
                dlg.setNegativeButton("취소",null);
                dlg.show();
            }
        });
    }
}