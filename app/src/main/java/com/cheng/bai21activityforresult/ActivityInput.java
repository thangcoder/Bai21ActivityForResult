package com.cheng.bai21activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityInput extends AppCompatActivity {

    public static String NUMBER_A ="number_a";
    public static String NUMBER_B ="number_b";
    public static final int REQUEST_CODE =1994;

    private EditText edtNumberA;
    private EditText edtNumberB;
    private Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        edtNumberA = (EditText) findViewById(R.id.edit_numberA);
        edtNumberB = (EditText) findViewById(R.id.edit_numberB);
        btnCall = (Button) findViewById(R.id.btn_call);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityInput.this, ActivityOutput.class);
                intent.putExtra(NUMBER_A,Integer.parseInt(edtNumberA.getText().toString()));
                intent.putExtra(NUMBER_B,Integer.parseInt(edtNumberB.getText().toString()));
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
                Toast.makeText(ActivityInput.this,
                        String.valueOf(data.getIntExtra(ActivityOutput.RESULT_AB,0)),
                        Toast.LENGTH_SHORT).show();

            }
        }
    }
}
