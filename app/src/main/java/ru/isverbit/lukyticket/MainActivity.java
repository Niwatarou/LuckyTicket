package ru.isverbit.lukyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        int[] numArr = new int[6];

        for (int i = 0; i < 6; i++) {
            numArr[i] = num % 10;
            num = num / 10;
            if(i < 3) {
                rightSide += numArr[i];
            } else {
                leftSide += numArr[i];
            }
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
}
