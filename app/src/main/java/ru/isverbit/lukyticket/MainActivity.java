package ru.isverbit.lukyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNum;
    Button btnResult;
    TextView tvResult, tvInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum = findViewById(R.id.etNum);
        tvResult = findViewById(R.id.tvResult);
        tvInput = findViewById(R.id.tvInput);

        btnResult = findViewById(R.id.btnResult);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(etNum.getText().toString())) { return; }
        int num = Integer.parseInt(etNum.getText().toString());
        tvInput.setText(etNum.getText().toString());
        int rightSide = 0;
        int leftSide = 0;
        int inLength = numLength(num);

//        ArrayList<Integer> numArr = new ArrayList<>();


        for (int i = 0; i < inLength; i++) {
//            numArr.add(num % 10);
            if(i < inLength / 2) {
                rightSide += num % 10;
            } else {
                leftSide +=num % 10;
            }
            num = num / 10;
        }

        switch(v.getId()) {
            case R.id.btnResult:
                if(rightSide == leftSide) {
                    etNum.setText("");
                    tvResult.setText(R.string.lucky);
                    Toast.makeText(this, "Сумма левой части: " + leftSide +
                            ", сумма правой части: " + rightSide, Toast.LENGTH_LONG).show();

                } else {
                    etNum.setText("");
                    tvResult.setText(R.string.unlucky);
                    Toast.makeText(this, "Сумма левой части: " + leftSide +
                            ", сумма правой части: " + rightSide, Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    public int numLength(int i) {
        int result = 0;
        while(i != 0) {
            i = i / 10;
            result++;
        }
//        Toast.makeText(this, "Result = " + result, Toast.LENGTH_LONG).show();
        return result;
    }
}
