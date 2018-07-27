package com.example.sue.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int a, b; // 입력칸 2개에 입력된 숫자값을 불러올 변수
    private int c = 0; // 계산하여 출력하게 될 변수. 0 으로 초기화 한다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        /* Design View의 객체들을 변수로서 선언*/
        /* final은 지역 변수를 상수화시키는 것, OnCreate가 실행된 뒤에도 존재하게 됨
        final 선언을 안 하면 그 변수는 그냥 OnCreate의 지역변수이기 때문에 OnCreate가 한번 실행되면 그냥 사라져 버린다. */
        final EditText input1 = findViewById(R.id.input1); // 입력창 1
        final EditText input2 = findViewById(R.id.input2); // 입력창 2
        final TextView result = findViewById(R.id.result); // 버튼 밑에 계산 결과가 나올 결과창
        final Button btn_plus = findViewById(R.id.btn_plus); // '+' 버튼
        final Button btn_minus = findViewById(R.id.btn_minus); // '-' 버튼
        final Button btn_sub = findViewById(R.id.btn_sub); // '*' 버튼
        final Button btn_div = findViewById(R.id.btn_div); // '/' 버튼
        // Button 부분에 취소선이 뜨는데 이걸 대체할 클래스를..
        View.OnClickListener calc = new View.OnClickListener() {
            // 버튼 클릭했을때 처리되어야 할 작업을 작성하는 부분을 calc 함수로서 선언
            @Override
            public void onClick(View v) {
                if(v==btn_plus) { // + 버튼을 입력했을 때
                    a = Integer.valueOf(input1.getText().toString().trim());
                    // input1.getText()는 첫번째 입력 칸에서 입력한 숫자 값을 불러온다
                    b = Integer.valueOf(input2.getText().toString().trim());
                    // input2.getText()는 두번째 입력 칸에서 입력한 숫자 값을 불러온다
                    c = a + b; // '+' 버튼이므로 두 개의 값을 더한다.
                    result.setText(Integer.toString(c)); // 계산 결과를 결과창에 출력한다.
                }
                else if(v==btn_minus){ // - 버튼을 입력했을 때
                    a = Integer.valueOf(input1.getText().toString().trim()); // toString() 부분은 입력 받은 값을 문자열로 반환해준다.
                    b = Integer.valueOf(input2.getText().toString().trim()); // trim() 부분은 공백 부분을 지워준다.
                    c = a - b; // '-' 버튼이므로 두 개의 값을 뺀다.
                    result.setText(Integer.toString(c));
                }
                else if (v==btn_sub){ // * 버튼을 입력했을 때
                    a = Integer.valueOf(input1.getText().toString().trim());
                    b = Integer.valueOf(input2.getText().toString().trim());
                    c = a * b; // '*' 버튼이므로 두 개의 값을 곱한다.
                    result.setText(Integer.toString(c));
                }
                 else if (v==btn_div){
                    a = Integer.valueOf(input1.getText().toString().trim());
                    b = Integer.valueOf(input2.getText().toString().trim());
                    c = a / b; // '/' 버튼이므로 두 개의 값을 나눈다.
                    result.setText(Integer.toString(c));
                    // c를 int형으로 선언하고 정수로 출력하라는 뜻이므로 소수점 이하는 나타나지 않는다.
                }
            }
        };
        btn_plus.setOnClickListener(calc); // 버튼을 누르면 calc 함수에 선언된 명령을 수행한다.
        btn_minus.setOnClickListener(calc);
        btn_sub.setOnClickListener(calc);
        btn_div.setOnClickListener(calc);
    }
}
