package ac.baekseok.listview20201126;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Second extends Activity {
    //code-override-oncreate

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);//second.xml 설정
        //버튼이 하나 배치 되어 있었는데,메인으로 이동버튼
        final Button secondBtn=(Button)findViewById(R.id.secondBtn);
        secondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
