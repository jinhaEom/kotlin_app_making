package ac.baekseok.inventory2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Join extends Activity {
    EditText jId,jPw;
    Button btnRegistration,btnMain;

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);
        jId=(EditText)findViewById(R.id.jId);
        jPw=(EditText)findViewById(R.id.jPw);
        btnRegistration=(Button)findViewById(R.id.jRegistration);
        btnMain=(Button)findViewById(R.id.jMainBtn);
        myHelper=new myDBHelper(this);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB=myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO JoinInfo VALUES('"+
                        jId.getText().toString()+"',"+jPw.getText().toString()
                        +");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"가입되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
    }
    public class myDBHelper extends SQLiteOpenHelper{
        public myDBHelper(Context context){
            super(context,"LoginDB",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE Joininfo(uId TEXT PRIMARY KEY,uPassword TEXT);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS JoinInfo");
            onCreate(db);

        }
    }
}//join
