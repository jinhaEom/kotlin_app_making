package ac.baekseok.listview2017247013wek;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("엄진하의 그리드뷰 영화 포스터");
        //격자무늬 GridView위젯을 인스턴스 생성
        final GridView gv = (GridView) findViewById(R.id.grieView);
        //리스트뷰와 동일하게 그리드뷰도 형태를 지정하기 위한 myGrid Adapter클래스 사용->GridView에 adapter 적용
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

    }//onCreate

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        //생성자 MyGridAdapter()
        public MyGridAdapter(Context c) {
            context = c;
        }//생성자
        //BaseAdapter에서 사용되는 필수 메소드가 4개 더 추가할 예정=>ctrl + i

        @Override
        public int getCount() { //그리드뷰에 보여질 이미지 개수를 반환하도록 함함
            return posterID.length;//40개의 요소 리턴됨
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //ivPoster의 ID를 배열로 처리 =>Integer
        Integer[] posterID = {R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
                R.drawable.mov10, R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14,
                R.drawable.mov15, R.drawable.mov16, R.drawable.mov17, R.drawable.mov18, R.drawable.mov19,
                R.drawable.mov20, R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24,
                R.drawable.mov25, R.drawable.mov26, R.drawable.mov27, R.drawable.mov28, R.drawable.mov29,
                R.drawable.mov30, R.drawable.mov31, R.drawable.mov32, R.drawable.mov33, R.drawable.mov34,
                R.drawable.mov35, R.drawable.mov36, R.drawable.mov37, R.drawable.mov38, R.drawable.mov39,
                R.drawable.mov40,};
        String[] posterTitle = {"써니", "완득이", "괴물", "라디오스타", "비열한 거리", "왕의 남자",
                "아일랜드", "웰컴투 동막골", "헬보이", "백투더 퓨처", "여인의 향기", "쥬라기공원",
                "포레스트 검프", "그라운드 호그 데이", "혹성탈출", "아름다운비행", "내이름은 칸",
                "해리포터:이제모든것이 끝난다.", "마더", "킹콩을 들다", "쿵푸팬더2", "짱구는 못말려", "아저씨",
                "아바타", "대부", "국가대표", "토이스토리3", "마당을 나온 암탉", "죽은 시인의 사회", "서유쌍기",
                "킹콩", "반지의 제왕", "8월의 크리스마스", "미녀는 괴로워", "나홀로 집에", "파이란", "더록",
                "로마의 휴일", "매트릭스", "가위손"};

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //컬럼을 클릭했을때 처리동작 정의(이미지뷰를 인스턴스처리하고 이미지뷰가 보이게 설정)
            //이미지뷰배치, position은 해당되는 컬럼의 위치값
            ImageView imageview = new ImageView(context);
            //이미지뷰의 가로 세로 길이 속성을 정의,이미지뷰크기 설정
            imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);//여백 지정 상하좌우 전체지정
            imageview.setImageResource(posterID[position]);
            //각 영화이미지를 클릭하면 큰이미지포스터가 dialog.xml이 대화상자로 뜨게 처리 inflate()
            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //대화상자를 적용할 View 인스턴스생성, dialog.xml을 확장해서 사용할 View인스턴스 생성
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    //dialog.xml의 큰이미지뷰를 인스턴스생성
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterTitle[pos]);//타이틀설정
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return imageview;
        }
    }
}//MainActivity