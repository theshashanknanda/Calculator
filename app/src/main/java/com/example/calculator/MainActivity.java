package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    public TextView zero, one, two, three, four, five, six, seven, eight, nine;
    public TextView plus, minus, multi, div, dot;
    public TextView inputTextView, outputTextView;
    public TextView clear, equals;
    public String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        dot = findViewById(R.id.dot);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.subtract);
        multi = findViewById(R.id.multiply);
        div = findViewById(R.id.div);

        inputTextView = findViewById(R.id.inputText);
        outputTextView = findViewById(R.id.outputText);
        clear = findViewById(R.id.clear_text);
        equals = findViewById(R.id.equals);

        outputTextView.setText("");

        clear.setOnClickListener(v -> {
            outputTextView.setText("");
        });

        zero.setOnClickListener(v -> {
            data = outputTextView.getText().toString();

            if(data.length() <= 13)
                outputTextView.setText(data+"0");
        });

        one.setOnClickListener(v -> {
            data = outputTextView.getText().toString();

            if(data.length() <= 13)
                outputTextView.setText(data+"1");
        });

        two.setOnClickListener(v -> {
            data = outputTextView.getText().toString();

            if(data.length() <= 13)
                outputTextView.setText(data+"2");
        });

        three.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"3");
        });

        four.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"4");
        });

        five.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"5");
        });

        six.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"6");
        });

        seven.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"7");
        });

        eight.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"8");
        });

        nine.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"9");
        });

        plus.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"+");
        });

        minus.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"-");
        });

        multi.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"x");
        });

        div.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+"/");
        });

        dot.setOnClickListener(v -> {
            data = outputTextView.getText().toString();
            if(data.length() <= 13)
            outputTextView.setText(data+".");
        });

        equals.setOnClickListener(v -> {
            String data = outputTextView.getText().toString();
            String result;

            data = data.replaceAll("x","*");

            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();

            result = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            inputTextView.setText(result);
        });
    }
}

