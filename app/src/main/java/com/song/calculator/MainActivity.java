package com.song.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button numone_button,numtwo_button,numthree_button,numfive_button,numsix_button,numfour_button;
    private Button numseven_button,numeight_button,numnine_button,numpoint_button,numzexo_button;
    private Button equals_button,subtract_button,divide_button,multiply_button,add_button,clean_button;
    private ButtonClick buttonClick = new ButtonClick();
    private ButtonClick2 bc2 = new ButtonClick2();
    private TextView displayText;
    private Double number,result;
    private char c;
    private String displayContent ="";
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        displayText = (TextView) findViewById(R.id.displayText);
        displayText.setText("");
        clean_button = (Button) findViewById(R.id.clean_button);
        clean_button.setOnClickListener(buttonClick);
        numone_button = (Button)findViewById(R.id.numone_button);
        numone_button.setOnClickListener(buttonClick);
        numtwo_button = (Button)findViewById(R.id.numtwo_button);
        numtwo_button.setOnClickListener(buttonClick);
        numthree_button = (Button)findViewById(R.id.numthree_button);
        numthree_button.setOnClickListener(buttonClick);
        numfour_button = (Button)findViewById(R.id.numfour_button);
        numfour_button.setOnClickListener(buttonClick);
        numfive_button = (Button)findViewById(R.id.numfive_button);
        numfive_button.setOnClickListener(buttonClick);
        numsix_button = (Button)findViewById(R.id.numsix_button);
        numsix_button.setOnClickListener(buttonClick);
        numseven_button = (Button)findViewById(R.id.numseven_button);
        numseven_button.setOnClickListener(buttonClick);
        numeight_button = (Button)findViewById(R.id.numeight_button);
        numeight_button.setOnClickListener(buttonClick);
        numnine_button = (Button)findViewById(R.id.numnine_button);
        numnine_button.setOnClickListener(buttonClick);
        numzexo_button = (Button)findViewById(R.id.numzexo_button);
        numzexo_button.setOnClickListener(buttonClick);
        equals_button = (Button)findViewById(R.id.equals_button);
        equals_button.setOnClickListener(bc2);
        add_button = (Button)findViewById(R.id.add_button);
        add_button.setOnClickListener(bc2);
        multiply_button = (Button)findViewById(R.id.multiply_button);
        multiply_button.setOnClickListener(bc2);
        subtract_button = (Button)findViewById(R.id.subtract_button);
        subtract_button.setOnClickListener(bc2);
        divide_button = (Button)findViewById(R.id.divide_button);
        divide_button.setOnClickListener(bc2);
        numpoint_button = (Button)findViewById(R.id.numpoint_button);
        numpoint_button.setOnClickListener(buttonClick);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /* 计算器*/
    private class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.numone_button:
                    displayText.setText(displayContent + "1");
                    displayContent = displayText.getText().toString();
                    break;
                case R.id.numtwo_button:
                    displayText.setText(displayContent + "2");
                    displayContent = displayText.getText().toString();
                    break;
                case R.id.numthree_button:
                    displayText.setText(displayContent + "3");
                    displayContent = displayText.getText().toString();
                    break;
                case R.id.numfour_button:
                    displayText.setText(displayContent + "4");
                    displayContent = displayText.getText().toString();
                    break;
                case R.id.numfive_button:
                    displayText.setText(displayContent + "5");
                    displayContent = displayText.getText().toString();
                    break;
                case R.id.numsix_button:
                    displayText.setText(displayContent + "6");
                    displayContent = displayText.getText().toString();
                    break;
                case R.id.numseven_button:
                    displayText.setText(displayContent + "7");
                    displayContent = displayText.getText().toString();
                    break;
                case R.id.numeight_button:
                    displayText.setText(displayContent + "8");
                    displayContent = displayText.getText().toString();
                    break;
                case R.id.numnine_button:
                    displayText.setText(displayContent + "9");
                    displayContent = displayText.getText().toString();
                    break;
                case R.id.numzexo_button:
                    displayText.setText(displayContent + "0");
                    displayContent = displayText.getText().toString();
                    break;
                case R.id.numpoint_button:
                    if(!displayContent.contains(".")){
                        displayText.setText(displayContent + ".");
                        displayContent = displayText.getText().toString();
                    }
                    break;
                case R.id.clean_button:
                    displayText.setText("");
                    displayContent = "";
                    number = null;
                    result = null;
                    flag = true;
                    break;
            }
        }
    }

    private class ButtonClick2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (!displayContent .equals("") && !displayContent.equals(".")) {
                calresult();
                displayText.setText(subZeroAndDot(result));
            }
            switch (v.getId()){
                case R.id.add_button:
                    c = '+';
                    break;
                case R.id.subtract_button:
                    c = '-';
                    break;
                case R.id.multiply_button:
                    c = '*';
                    break;
                case R.id.divide_button:
                    c = '/';
                    break;
                case R.id.equals_button:
                    break;
            }
            displayContent = "";
        }
    }

    private void calresult(){
        if (flag){
            number = Double.parseDouble(displayContent);
            result = number;
            flag = false;
        } else {
            switch (c){
                case '+':
                    number = Double.parseDouble(displayContent);
                    result += number;
                    break;
                case '-':
                    number = Double.parseDouble(displayContent);
                    result -= number;
                    break;
                case '*':
                    number = Double.parseDouble(displayContent);
                    result *= number;
                    break;
                case '/':
                    number = Double.parseDouble(displayContent);
                    if (number ==0){
                        Toast.makeText(MainActivity.this,"除数不能为0",Toast.LENGTH_SHORT).show();
                    } else {
                        result /= number;
                    }
            }
        }
    }

    private String subZeroAndDot(double result){
        String s = String.valueOf(result);
        if (s.indexOf(".")>0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }
}
