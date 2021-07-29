package ac.baekseok.spinner20172470;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("엄진하의 스피너 테스트");
        final String[] movie = {"쿵푸팬더", "짱구는 못말려", "아저씨", "아바타",
                "대부","국가대표", "토이스토리", "마당을 나온 암탉", "죽은 시인의 사회", "서유기"};
        final Integer[] posterID = {R.drawable.mov21, R.drawable.mov22, R.drawable.mov23,
                R.drawable.mov24, R.drawable.mov25, R.drawable.mov26, R.drawable.mov27,
                R.drawable.mov28, R.drawable.mov29, R.drawable.mov30};
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                movie);
        spinner.setAdapter(adapter);
        //스피너의 항목을 1개 선택해서 눌렀을때 동작을 설정
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView ivPoster=(ImageView)findViewById(R.id.ivPoster);
                ivPoster.setScaleType((ImageView.ScaleType.FIT_CENTER));
                ivPoster.setPadding(5,5,5,5);//여백지정
                ivPoster.setImageResource(posterID[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}