package ac.baekseok.event20172470;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox check1,check2,check3;
    Button btn,btnRotate;
    EditText edtText;
    ImageView imgDog;
    float angle=0;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check1=(CheckBox)findViewById(R.id.checkBox1);
        check2=(CheckBox)findViewById(R.id.checkBox2);
        check3=(CheckBox)findViewById(R.id.checkBox3);
        btn=(Button)findViewById(R.id.button1);
        edtText=(EditText)findViewById(R.id.edtText1);
        btnRotate=(Button)findViewById(R.id.BtnRotation);
        imgDog=(ImageView)findViewById(R.id.ImgDog);


        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)btn.setEnabled(true); //true이면 활성화처리 됨
                else btn.setEnabled(false);
            }
        });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) btn.setClickable(true);//클릭이 되게
                else btn.setClickable(false);//클릭이 안되게

            }
        });
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)btn.setRotation(45);
                else btn.setRotation(0);
            }
        });
        edtText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP)
                    Toast.makeText(getApplicationContext(), edtText.getText().toString(),
                            Toast.LENGTH_LONG).show();

                return false;
            }
        });
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angle+=10;
                imgDog.setRotation(angle);
            }
        });



    }//onCreate
}//MainActivity