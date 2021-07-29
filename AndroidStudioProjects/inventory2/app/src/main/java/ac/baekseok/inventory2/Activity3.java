package ac.baekseok.inventory2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    //인스턴스 생성
    myDBHelper myHelper;
    EditText edtName, edtNumber, edtNameResult, edtNumberResult, edtPriceResult, edtPrice;
    Button btnInsert, btnSelect, btnUpdate, btnDelete, btnInit, btn6,btn;
    SQLiteDatabase sqlDB;
    String n1,n2,n3;



  /*  @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            int hap=data.getIntExtra("Hap",0);
            Toast.makeText(getApplicationContext(),"합계
            :"+hap,Toast.LENGTH_LONG).show();
        }
    }*/
    //계산기에 activity3에서 입력된값을 자동합해주는 기능을 하려했었음

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        edtName = (EditText) findViewById(R.id.edtName);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        edtPrice = (EditText) findViewById(R.id.edtPrice);
        edtNameResult = (EditText) findViewById(R.id.edtNameResult);
        edtPriceResult = (EditText) findViewById(R.id.edtPriceResult);
        edtNumberResult = (EditText) findViewById(R.id.edtNumberResult);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnInit = (Button) findViewById(R.id.btnInit);
        btn6 = (Button) findViewById(R.id.btn6);
        btn = (Button)findViewById(R.id.btn);
        myHelper = new myDBHelper(this);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=edtName.getText().toString();
                n2=edtNumber.getText().toString();
                n3=edtPrice.getText().toString();

                sqlDB = myHelper.getWritableDatabase();
                if(n1.equals("")||n2.equals("")||n3.equals("")){
                    Toast.makeText(getApplicationContext(), "입력칸이 비었습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{sqlDB.execSQL("INSERT INTO groupTBL VALUES('" + edtName.getText().toString()
                        + "','" + edtPrice.getText().toString() + "'," + edtNumber.getText().toString() + ");");
                Toast.makeText(getApplicationContext(), "제품이 추가되었습니다.", Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();}


            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;//2차원형태의 테이블정보를 리턴,인스턴스선언 첫 레코드 이동
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL", null);
                String strNames = "제품명" + "\r\n" + "ㅡㅡㅡㅡㅡ" + "\r\n";
                String strPrices = "제품 가격" + "\r\n" + "ㅡㅡㅡㅡㅡ" + "\r\n";
                String strNumbers = "제품갯수" + "\r\n" + "ㅡㅡㅡㅡㅡ" + "\r\n";

                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\r\n";
                    strPrices += cursor.getString(1) + "\r\n";
                    strNumbers += cursor.getString(2) + "\r\n";
                }


                edtNameResult.setText(strNames);
                edtPriceResult.setText(strPrices);
                edtNumberResult.setText(strNumbers);
                cursor.close();
                sqlDB.close();

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                if (edtName.getText().toString() != "") {
                    sqlDB.execSQL("UPDATE groupTBL SET gPrice="
                            + edtNumber.getText() + " WHERE gName='" +
                            edtName.getText().toString() + "';");

                }
                 if (edtName.getText().toString() != "") {
                    sqlDB.execSQL("UPDATE groupTBL SET gNumber="
                            + edtPrice.getText() + " WHERE gName='" +
                            edtName.getText().toString() + "';");
                }



                sqlDB.close();
                Toast.makeText(getApplicationContext(), "수정되었습니다.", Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                if (edtName.getText().toString() != "") {
                    sqlDB.execSQL("DELETE FROM groupTBL WHERE gName='"
                            + edtName.getText().toString() + "';");
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();
            }
        });
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
                btnSelect.callOnClick();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtName.setText("");
                edtNumber.setText("");
                edtPrice.setText("");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Sum.class);
                startActivity(intent);
            }
        });

    }//onCreate

    public static class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 2);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL(gName CHAR(20)PRIMARY KEY,gNumber INTEGER,gPrice INTEGER" +
                    ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL"); //drop table=ㅌ이블 삭제
            onCreate(db);
        }
    }
}//Activity3
