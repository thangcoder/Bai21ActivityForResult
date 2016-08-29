package com.cheng.bai21activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityOutput extends AppCompatActivity {
    public static String RESULT_AB ="result_ab";
    private EditText edtNumberA;
    private EditText edtNumberB;
    private Button btnResult;
    private int a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        edtNumberA = (EditText) findViewById(R.id.edit_numberA);
        edtNumberB = (EditText) findViewById(R.id.edit_numberB);
        btnResult = (Button) findViewById(R.id.btn_result);
        getData();
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(RESULT_AB,a+b);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    public void getData(){
        Intent intent = getIntent();
        a = intent.getIntExtra(ActivityInput.NUMBER_A,0);
        b = intent.getIntExtra(ActivityInput.NUMBER_B,0);
        edtNumberA.setText(String.valueOf(a));
        edtNumberB.setText(String.valueOf(b));
    }
}
