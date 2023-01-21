package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String url="https://api.apilayer.com/currency_data/convert?";
    public static final String APIKEY = "lZG8fC5NUTyhcunci1b3RmRzDucdBJ8c";


    Boolean isNew = true;
    String currentField="field_1";

    String oldNumber, amountToConvert;
    ArrayList<String> arrayList;
    char operator;

    String[] countries = {"AED", "AFN", "EUR", "USD", "RUB", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "KZT", "SHP", "ZAR", "BRL",
            "CZK"};

    Dialog fromDialog;
    Dialog toDialog;
    MediaPlayer sound;
    EditText field_one, field_two;
    TextView course_field1, course_field2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<>();
        field_one = findViewById(R.id.field1);
        field_two = findViewById(R.id.field2);
        course_field1 = findViewById(R.id.course1);
        course_field2 = findViewById(R.id.course2);
        sound = MediaPlayer.create(this, R.raw.single_tap);

        for (String country: countries) {
            arrayList.add(country);
        }
    }

    public void clickNumber(View view) {
        sound.start();
        EditText field = returnField();
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
        sendConvertRequest(course_field2.getText().toString(), course_field1.getText().toString(),  field.getText().toString());
    }

    public void Operations(View view) {
        sound.start();
        EditText field = returnField();
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
            sendConvertRequest(course_field2.getText().toString(), course_field1.getText().toString(),  field.getText().toString());
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
        sendConvertRequest(course_field2.getText().toString(), course_field1.getText().toString(),  field.getText().toString());
    }

    public void clickDeleteAll(View view) {
        sound.start();
        field_one.setText("0");
        field_two.setText("0");
        isNew = true;
    }

    public void clickReplace(View view){
        sound.start();
        String course1 = course_field1.getText().toString();
        String course2 = course_field2.getText().toString();

        String amount1 = field_one.getText().toString();
        String amount2 = field_two.getText().toString();
        if (currentField.equals("field_1")){
            course_field2.setText(course1);
            course_field1.setText(course2);

            field_two.setText(amount1);
            field_one.setText(amount2);
        }
        else
            course_field1.setText(course2);
            course_field2.setText(course1);

            field_one.setText(amount2);
            field_two.setText(amount1);
    }

    public void clickFiledOne(View view) {

        fromDialog = new Dialog(MainActivity.this);
        fromDialog.setContentView(R.layout.countries);
        fromDialog.getWindow().setLayout(1000, 1200);
        fromDialog.show();

        EditText search_text = fromDialog.findViewById(R.id.search_edit_text);
        ListView list_view = fromDialog.findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        list_view.setAdapter(adapter);

        search_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                course_field1.setText(adapter.getItem(i));
                fromDialog.dismiss();
                amountToConvert = adapter.getItem(i);
            }
        });
    }

    public void clickFiledTwo(View view) {

        toDialog = new Dialog(MainActivity.this);
        toDialog.setContentView(R.layout.countries);
        toDialog.getWindow().setLayout(1000, 1200);
        toDialog.show();

        EditText search_text = toDialog.findViewById(R.id.search_edit_text);
        ListView list_view = toDialog.findViewById(R.id.list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        list_view.setAdapter(adapter);

        search_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                course_field2.setText(adapter.getItem(i));
                toDialog.dismiss();
                amountToConvert = adapter.getItem(i);
            }
        });
    }

    public void sendConvertRequest(String convertTo, String convertFrom, String amountToConvert){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url + "to=" + convertTo + "&from=" + convertFrom + "&amount=" + amountToConvert + "&apikey=" + APIKEY, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    Double res = Double.valueOf(jsonObject.getString("result"));
                    System.out.println(res);
                    field_two.setText(res+"");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);

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
