package com.example.bella.agecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //private ;
    private double animalYears;
    private TextView displayYear;
    private EditText inText;
    private double humanYear = 1;
    private double display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /***getting references of our Widgets***/

        RadioGroup rGroup = (RadioGroup) findViewById(R.id.radGrpAnimals);
        Button bCalculate = (Button) findViewById(R.id.calculateButton);
        bCalculate.setOnClickListener(this);
        inText = (EditText) findViewById(R.id.inYear);

       displayYear = (TextView) findViewById(R.id.displayYear);

        /***functionality behind RadioButtons ****/
        rGroup.clearCheck();
        rGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    //@Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton rb = (RadioButton) group.findViewById(checkedId);
                        //rb.getId();

                        switch (rb.getId()) {
                            case R.id.radCat:
                                animalYears = 3.2;
                                break;
                            case R.id.radDog:
                                animalYears = 3.6;
                                break;
                            case R.id.radKangaroo:
                                animalYears = 8.9;
                                break;
                        }
                    }
                }
        );





    } //end onCreate

    double calculateAge(double yrMult, double inYear){
        return inYear*yrMult;
    }


    @Override
    public void onClick(View v) { //when the button is clicked
        humanYear = Double.valueOf(inText.getText().toString()); //getting current inputted age from edit text
        display = calculateAge(animalYears, humanYear); //setting display using calculateAge
        displayYear.setText(Double.toString(display)); //making it a string & changing text
    }
}
