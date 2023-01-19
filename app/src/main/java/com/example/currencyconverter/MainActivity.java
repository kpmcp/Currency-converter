package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    Boolean isNew = true;
    String oldNumber;
    char operator;
    String currentField="field_1";

    MediaPlayer sound;
    EditText field_one, field_two;

    MaterialButton delete, delete_all, replace, divide, seven, eight, nine, six, five, four,
            three, two, one, zero, comma, plus, minus, multiply, equals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field_one = findViewById(R.id.field1);
        field_two = findViewById(R.id.field2);
        sound = MediaPlayer.create(this, R.raw.calculator_button_press_single_002_11984);
    }

    public void clickNumber(View view) {
//        MaterialButton button = (MaterialButton) view;
        EditText field = returnField();
        sound.start();
        if (isNew) {
            field.setText("");
        }
        isNew = false;
        String number = field.getText().toString();

        switch (view.getId()) {
            case R.id.one:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);;
                }
                number = number + "1";
                break;
            case R.id.two:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);;
                }
                number = number + "2";
                break;
            case R.id.three:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);;
                }
                number = number + "3";
                break;
            case R.id.four:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);;
                }
                number = number + "4";
                break;
            case R.id.five:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);;
                }
                number = number + "5";
                break;
            case R.id.six:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);;
                }
                number = number + "6";
                break;
            case R.id.seven:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);;
                }
                number = number + "7";
                break;
            case R.id.eight:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);;
                }
                number = number + "8";
                break;
            case R.id.nine:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);;
                }
                number = number + "9";
                break;
            case R.id.zero:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = "0";
                }else {
                    number = number + "0";
                }
                break;
            case R.id.comma:
                if (dotIsPresent(number)) {}
                else
                if (zeroIsFirst(number) ) {
                    number = "0.";
                }
                else{
                    number = number+".";
                }
                break;

        }

        field.setText(number);
    }

    public void Operations(View view) {
        EditText field = returnField();
        sound.start();
        isNew = true;
        oldNumber = field.getText().toString();
        switch (view.getId()) {
            case R.id.plus: operator = '+';break;
            case R.id.minus: operator = '-';break;
            case R.id.divide: operator = '/';break;
            case R.id.multiply: operator = '*';break;
        }
    }

    public void clickEqual(View view) {
        sound.start();
        EditText field = returnField();
        String newNumber = field.getText().toString();
        Double result = 0.0;
        if (Double.parseDouble(newNumber) < 0.000000001 && operator == '/'
                || newNumber.equals("") && operator == '/') {
            Toast.makeText(MainActivity.this, "Нельзя делить на ноль!", Toast.LENGTH_SHORT).show();
        }
        else {
            switch (operator) {
                case '-':
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                    break;
                case '+':
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                    break;
                case '*':
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                    break;
                case '/':
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                    break;
            }
            field.setText(result + "");
        }
    }

    public void clickDelete(View view) {
        EditText field = returnField();
        sound.start();
        String newNumber = field.getText().toString();
        if (newNumber.length() > 0 && !newNumber.equals("0")) {
            newNumber = newNumber.substring(0, newNumber.length() - 1);
        }
        field.setText(newNumber);
    }

    public void clickDeleteAll(View view) {
        EditText field = returnField();
        sound.start();
        field.setText("0");
        isNew = true;
    }

    public void clickReplace(View view){
        sound.start();
        if (currentField.equals("field_1")){
            currentField = "field_2";
        }
        else currentField = "field_1";
    }

    private EditText returnField(){
        if (currentField.equals("field_1")) {
            return field_one;
        }
        return field_two;
    }

    private boolean dotIsPresent (String number){

        if (number.indexOf(".") == -1 ){
            return false;
        } else{
            return true;
        }
    }

    private boolean zeroIsFirst (String number){
        if (number.equals("")){return true;}
        if (number.charAt(0) == '0'){return true;}
        else{
            return false;
        }

    }
}
