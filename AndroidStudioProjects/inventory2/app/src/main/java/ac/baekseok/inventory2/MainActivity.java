package ac.baekseok.inventory2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Join {
    EditText edtId, edtPw;
    Button btnJoin, btnLogin;
    int idFlag = 0;
    int pwFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtId = (EditText) findViewById(R.id.edtId);
        edtPw = (EditText) findViewById(R.id.edtPw);
        btnJoin = (Button) findViewById(R.id.btnJoin);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join.class);
                startActivity(intent);
            }
        });//btnJoin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT*FROM JoinInfo;", null);
                String edt1 = null;
                String pass1 = null;
                String edt2 = null;
                String pass2 = null;

                while (cursor.moveToNext()) { //movetonext는 커서를 다음열로 이동시킨다.,cursor=레코드 읽어오기
                    edt2 = cursor.getString(0);
                    pass2 = cursor.getString(1);
                    edt1 = edtId.getText().toString();
                    pass1 = edtPw.getText().toString();
                    if (edt2.equals(edt1)) {
                        idFlag = 1;
                        if (pass2.equals(pass1)) {
                            pwFlag = 1;
                            Toast.makeText(getApplicationContext(), "정상회원입니다",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),
                                    Activity3.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Id는 일치하지만 비밀번호가 틀립니다.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                if (idFlag == 0 && pwFlag == 0) {
                    Toast.makeText(getApplicationContext(),
                            "회원가입이 필요합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}