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
//        MaterialButton play_sound_delete = (MaterialButton) this.findViewById(R.id.delete);
//        MaterialButton play_sound_delete_all = (MaterialButton) this.findViewById(R.id.delete_all);
//        MaterialButton play_sound_replace = (MaterialButton) this.findViewById(R.id.replace);
//
//        MaterialButton play_sound_zero = (MaterialButton) this.findViewById(R.id.zero);
//        MaterialButton play_sound_one = (MaterialButton) this.findViewById(R.id.one);
//        MaterialButton play_sound_two = (MaterialButton) this.findViewById(R.id.two);
//        MaterialButton play_sound_three = (MaterialButton) this.findViewById(R.id.three);
//        MaterialButton play_sound_four = (MaterialButton) this.findViewById(R.id.four);
//        MaterialButton play_sound_five = (MaterialButton) this.findViewById(R.id.five);
//        MaterialButton play_sound_six = (MaterialButton) this.findViewById(R.id.six);
//        MaterialButton play_sound_seven = (MaterialButton) this.findViewById(R.id.seven);
//        MaterialButton play_sound_eight = (MaterialButton) this.findViewById(R.id.eight);
//        MaterialButton play_sound_nine = (MaterialButton) this.findViewById(R.id.nine);
//
//        MaterialButton play_sound_comma = (MaterialButton) this.findViewById(R.id.comma);
//        MaterialButton play_sound_plus = (MaterialButton) this.findViewById(R.id.plus);
//        MaterialButton play_sound_minus = (MaterialButton) this.findViewById(R.id.minus);
//        MaterialButton play_sound_equal = (MaterialButton) this.findViewById(R.id.equal);
//        MaterialButton play_sound_multiply = (MaterialButton) this.findViewById(R.id.multiply);
//        MaterialButton play_sound_divide = (MaterialButton) this.findViewById(R.id.divide);
//
//        play_sound_zero.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_one.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_two.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_three.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_four.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_five.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_six.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_seven.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_eight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_nine.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//
//        play_sound_delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_delete_all.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_replace.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//
//        play_sound_comma.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_divide.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_plus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_minus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_multiply.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
//        play_sound_equal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.start();
//            }
//        });
    }

    public void clickNumber(View view) {
        MaterialButton button = (MaterialButton) view;
        sound.start();
        if (isNew) {
            field_one.setText("");
        }
        isNew = false;
        String number = field_one.getText().toString();

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

        field_one.setText(number);
    }

    public void Operations(View view) {
        sound.start();
        isNew = true;
        oldNumber = field_one.getText().toString();
        switch (view.getId()) {
            case R.id.plus: operator = '+';break;
            case R.id.minus: operator = '-';break;
            case R.id.divide: operator = '/';break;
            case R.id.multiply: operator = '*';break;
        }
    }

    public void clickEqual(View view) {
        sound.start();
        String newNumber = field_one.getText().toString();
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
            field_one.setText(result + "");
        }
    }

    public void clickDelete(View view) {
        sound.start();
        String newNumber = field_one.getText().toString();
        if (newNumber.length() > 0 && !newNumber.equals("0")) {
            newNumber = newNumber.substring(0, newNumber.length() - 1);
        }
        field_one.setText(newNumber);
    }

    public void clickDeleteAll(View view) {
        sound.start();
        field_one.setText("0");
        isNew = true;
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

    private boolean numberIsZero(String number) {
        if(number.equals("0") || number.equals("")){
            return true;
        }else {
            return false;
        }
    }
}
//    public void clickNumber(View view) {
//        sound.start();
//        if(isNew)
//            editText.setText("");
//        isNew=false;
//        String number = editText.getText().toString();
//
//        switch (view.getId()){
//            case R.id.bu1:
//                if (zeroIsFirst(number) && number.length() == 1){
//                    number = number.substring(1);;
//                }
//                number = number+"1" ; break;
//            case R.id.bu2:
//                if (zeroIsFirst(number )  && number.length() == 1){
//                    number = number.substring(1);
//                }
//                number = number+"2" ; break;
//            case R.id.bu3:
//                if (zeroIsFirst(number) && number.length() == 1){
//                    number = number.substring(1);
//                }
//                number = number+"3" ; break;
//            case R.id.bu4:
//                if (zeroIsFirst(number) && number.length() == 1){
//                    number = number.substring(1);
//                }
//                number = number+"4" ; break;
//            case R.id.bu5:
//                if (zeroIsFirst(number) && number.length() == 1){
//                    number = number.substring(1);
//                }
//                number = number+"5" ; break;
//            case R.id.bu6:
//                if (zeroIsFirst(number) && number.length() == 1){
//                    number = number.substring(1);
//                }
//                number = number+"6" ; break;
//            case R.id.bu7:
//                if (zeroIsFirst(number) && number.length() == 1){
//                    number = number.substring(1);
//                }
//                number = number+"7" ; break;
//            case R.id.bu8:
//                if (zeroIsFirst(number) && number.length() == 1){
//                    number = number.substring(1);
//                }
//                number = number+"8" ; break;
//            case R.id.bu9:
//                if (zeroIsFirst(number ) && number.length() == 1){
//                    number = number.substring(1);
//                }
//                number = number+"9" ;
//                break;
//
//            case R.id.bu0:
//                if (zeroIsFirst(number) && number.length() == 1){
//                    number = "0";
//                }else {
//                    number = number + "0";
//                }
//                break;
//
//            case R.id.buDot:
//                if (dotIsPresent(number)) {
//
//                }
//                if (zeroIsFirst(number) ) {
//                    number = "0.";
//                }
//                else{
//                    number = number+".";
//                }
//                break;
//
//            case R.id.buPlusMinus:
//                if (numberIsZero(number)){
//                    number = "0";
//                }else {
//                    if (minusIsPresent(number)) {
//                        number = number.substring(1);
//                    } else {
//                        number = "-" + number;
//                    }
//                }
//                break;
//
//        }
//
//        editText.setText(number);
//
//    }
