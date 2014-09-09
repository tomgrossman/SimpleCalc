package com.tgrossman.simplecalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class Main extends Activity {

    EditText eTNum1;
    EditText eTNum2;
    EditText eTNum3;

    Button btnResult;
    Spinner spinnerOp;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTNum1 = (EditText) findViewById(R.id.eTNum1);
        eTNum2 = (EditText) findViewById(R.id.eTNum2);
        eTNum3 = (EditText) findViewById(R.id.eTNum3);

        spinnerOp  = (Spinner) findViewById(R.id.spinnerOperators);
        adapter = ArrayAdapter.createFromResource(this, R.array.operators, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOp.setAdapter(adapter);

        btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculate();
            }
        });
    }

    private void Calculate()
    {
        int num1 = Integer.parseInt(eTNum1.getText().toString());
        int num2 = Integer.parseInt(eTNum2.getText().toString());
        char op = (String.valueOf(spinnerOp.getSelectedItem())).charAt(0);

        Calculate(num1,num2,op);
    }

    private void Calculate(int x, int y, char operator)
    {
        int result = 0;
        switch(operator)
        {
            case '+': result = x+y;
                break;
            case '-': result = x-y;
                break;
            case '*': result = x*y;
                break;
            case '/': result = x/y;
        }

        eTNum3.setText(String.valueOf(result));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
