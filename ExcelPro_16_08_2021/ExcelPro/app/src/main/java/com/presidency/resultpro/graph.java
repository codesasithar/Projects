package com.presidency.resultpro;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

public class graph extends AppCompatActivity {
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;
    Button chart;
    String outp1;
    String outp2;
    String outp3;
    String outp4;
    String outp5;
    String outp6;
    String outp7;
    String outp8;
    String outp9;


    String outp21;
    String outp22;
    String outp23;
    String outp24;
    String outp25;
    String outp26;
    String outp27;
    String outp28;
    String outp29;



    String outp31;
    String outp32;
    String outp33;
    String outp34;
    String outp35;
    String outp36;
    String outp37;
    String outp38;
    String outp39;



    String outp41;
    String outp42;
    String outp43;
    String outp44;
    String outp45;
    String outp46;
    String outp47;
    String outp48;
    String outp49;



    String outp51;
    String outp52;
    String outp53;
    String outp54;
    String outp10;



    String outp20;
    String outp30;
    String outp40;
    String outp50;


    String outp11;
    String outp12;
    String outp13;
    String outp14;
    String outp15;
    String outp16;
    String outp17;
    String outp18;
    String outp19;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        outp1=StudentResults.comp1.getText().toString();
        outp2=StudentResults.clabpercent111.getText().toString();
        outp3=StudentResults.officepercentage1.getText().toString();
        outp4=StudentResults.lang1.getText().toString();
        outp5=StudentResults.English1.getText().toString();
        outp6=StudentResults.cl1.getText().toString();
        outp7=StudentResults.Dm1.getText().toString();
        outp8=StudentResults.found.getText().toString();
        outp9=StudentResults.ccnec.getText().toString();


        outp10=StudentResults.comp2.getText().toString();
        outp11=StudentResults.clabpercent112.getText().toString();
        outp12=StudentResults.officepercentage2.getText().toString();
        outp13=StudentResults.lang2.getText().toString();
        outp14=StudentResults.English2.getText().toString();
        outp15=StudentResults.cl2.getText().toString();
        outp16=StudentResults.Dm2.getText().toString();
        outp17=StudentResults.found2.getText().toString();
        outp18=StudentResults.ccnec2.getText().toString();


        outp19=StudentResults.comp3.getText().toString();
        outp20=StudentResults.clabpercent113.getText().toString();
        outp21=StudentResults.officepercentage3.getText().toString();
        outp22=StudentResults.lang3.getText().toString();
        outp23=StudentResults.English303.getText().toString();
        outp24=StudentResults.cl1.getText().toString();
        outp25=StudentResults.Dm3.getText().toString();
        outp26=StudentResults.found3.getText().toString();
        outp27=StudentResults.ccnec3.getText().toString();



        outp28=StudentResults.comp4.getText().toString();
        outp29=StudentResults.clabpercent114.getText().toString();
        outp30=StudentResults.officepercentage4.getText().toString();
        outp31=StudentResults.lang4.getText().toString();
        outp32=StudentResults.English4.getText().toString();
        outp33=StudentResults.cl4.getText().toString();
        outp34=StudentResults.Dm4.getText().toString();
        outp35=StudentResults.found4.getText().toString();
        outp36=StudentResults.ccnec4.getText().toString();


        outp37=StudentResults.comp5.getText().toString();
        outp38=StudentResults.clabpercent115.getText().toString();
        outp39=StudentResults.officepercentage5.getText().toString();
        outp40=StudentResults.lang5.getText().toString();
        outp41=StudentResults.English5.getText().toString();
        outp42=StudentResults.cl5.getText().toString();
        outp43=StudentResults.Dm5.getText().toString();
        outp44=StudentResults.found5.getText().toString();
        outp45=StudentResults.ccnec5.getText().toString();

        outp46=StudentResults.comp.getText().toString();
        outp47=StudentResults.clabpercent11.getText().toString();
        outp48=StudentResults.officepercentage.getText().toString();
        outp49=StudentResults.lang.getText().toString();
        outp50=StudentResults.English.getText().toString();
        outp51=StudentResults.cl.getText().toString();
        outp52=StudentResults.Dm6.getText().toString();



        barChart = findViewById(R.id.BarChart);


        String subjects[] ={"SEMESTER I","SEMESTER II","SEMESTER III","SEMESTER IV","SEMESTER V","SEMESTER VI"};

        Spinner spinnersub=findViewById(R.id.spinnersubjectchart);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.spinnerlist,subjects);
        spinnersub.setAdapter(adapter);





        spinnersub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        getEntries();
                        barDataSet = new BarDataSet(barEntries, "SEMESTER 1");
                        barData = new BarData(barDataSet);
                        barChart.setData(barData);
                        barChart.animateXY(2000, 2000);
                        barChart.invalidate();
                        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(18f);
                        break;
                    case 1:
                        getEntries2();
                        barDataSet = new BarDataSet(barEntries, "SEMESTER 2");
                        barData = new BarData(barDataSet);
                        barChart.setData(barData);
                        barChart.animateXY(2000, 2000);
                        barChart.invalidate();
                        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(18f);
                        break;
                    case 2:
                        getEntries3();
                        barDataSet = new BarDataSet(barEntries, "SEMESTER 3");
                        barData = new BarData(barDataSet);
                        barChart.setData(barData);
                        barChart.animateXY(2000, 2000);
                        barChart.invalidate();
                        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(18f);
                        break;
                    case 3:
                        getEntries4();
                        barDataSet = new BarDataSet(barEntries, "SEMESTER 4");
                        barData = new BarData(barDataSet);
                        barChart.setData(barData);
                        barChart.animateXY(2000, 2000);
                        barChart.invalidate();
                        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(18f);
                        break;
                    case 4:
                        getEntries5();
                        barDataSet = new BarDataSet(barEntries, "SEMESTER 5");
                        barData = new BarData(barDataSet);
                        barChart.setData(barData);
                        barChart.animateXY(2000, 2000);
                        barChart.invalidate();
                        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(18f);
                        break;
                    case 5:
                        getEntries6();
                        barDataSet = new BarDataSet(barEntries, "SEMESTER 6");
                        barData = new BarData(barDataSet);
                        barChart.setData(barData);
                        barChart.animateXY(2000, 2000);
                        barChart.invalidate();
                        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                        barDataSet.setValueTextColor(Color.BLACK);
                        barDataSet.setValueTextSize(18f);
                        break;
                    default:
                        //Default image
                        //image.setImageResource(R.drawable.item2);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }












    private void getEntries() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(2f, Float.parseFloat(outp1)));
        barEntries.add(new BarEntry(3f, Float.parseFloat(outp4)));
        barEntries.add(new BarEntry(4f, Float.parseFloat(outp5)));
        barEntries.add(new BarEntry(5f, Float.parseFloat(outp6)));
        barEntries.add(new BarEntry(6f, Float.parseFloat(outp3)));
        barEntries.add(new BarEntry(7f, Float.parseFloat(outp7)));
        barEntries.add(new BarEntry(8f, Float.parseFloat(outp2)));
        barEntries.add(new BarEntry(9f, Float.parseFloat(outp8)));
        barEntries.add(new BarEntry(10f, Float.parseFloat(outp9)));


    }


    private void getEntries2() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(2f, Float.parseFloat(outp10)));
        barEntries.add(new BarEntry(3f, Float.parseFloat(outp11)));
        barEntries.add(new BarEntry(4f, Float.parseFloat(outp14)));
        barEntries.add(new BarEntry(5f, Float.parseFloat(outp15)));
        barEntries.add(new BarEntry(6f, Float.parseFloat(outp12)));
        barEntries.add(new BarEntry(7f, Float.parseFloat(outp16)));
        barEntries.add(new BarEntry(8f, Float.parseFloat(outp13)));
        barEntries.add(new BarEntry(9f, Float.parseFloat(outp17)));
        barEntries.add(new BarEntry(10f, Float.parseFloat(outp18)));


    }


    private void getEntries3() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(2f, Float.parseFloat(outp19)));
        barEntries.add(new BarEntry(3f, Float.parseFloat(outp22)));
        barEntries.add(new BarEntry(4f, Float.parseFloat(outp23)));
        barEntries.add(new BarEntry(5f, Float.parseFloat(outp24)));
        barEntries.add(new BarEntry(6f, Float.parseFloat(outp21)));
        barEntries.add(new BarEntry(7f, Float.parseFloat(outp25)));
        barEntries.add(new BarEntry(8f, Float.parseFloat(outp20)));
        barEntries.add(new BarEntry(9f, Float.parseFloat(outp26)));
        barEntries.add(new BarEntry(10f, Float.parseFloat(outp27)));


    }

    private void getEntries4() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(2f, Float.parseFloat(outp28)));
        barEntries.add(new BarEntry(3f, Float.parseFloat(outp31)));
        barEntries.add(new BarEntry(4f, Float.parseFloat(outp32)));
        barEntries.add(new BarEntry(5f, Float.parseFloat(outp33)));
        barEntries.add(new BarEntry(6f, Float.parseFloat(outp30)));
        barEntries.add(new BarEntry(7f, Float.parseFloat(outp34)));
        barEntries.add(new BarEntry(8f, Float.parseFloat(outp29)));
        barEntries.add(new BarEntry(9f, Float.parseFloat(outp35)));
        barEntries.add(new BarEntry(10f, Float.parseFloat(outp36)));


    }

    private void getEntries5() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(2f, Float.parseFloat(outp37)));
        barEntries.add(new BarEntry(3f, Float.parseFloat(outp40)));
        barEntries.add(new BarEntry(4f, Float.parseFloat(outp41)));
        barEntries.add(new BarEntry(5f, Float.parseFloat(outp42)));
        barEntries.add(new BarEntry(6f, Float.parseFloat(outp39)));
        barEntries.add(new BarEntry(7f, Float.parseFloat(outp43)));
        barEntries.add(new BarEntry(8f, Float.parseFloat(outp38)));
        barEntries.add(new BarEntry(9f, Float.parseFloat(outp44)));
        barEntries.add(new BarEntry(10f, Float.parseFloat(outp45)));


    }

    private void getEntries6() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(2f, Float.parseFloat(outp46)));
        barEntries.add(new BarEntry(3f, Float.parseFloat(outp49)));
        barEntries.add(new BarEntry(4f, Float.parseFloat(outp50)));
        barEntries.add(new BarEntry(5f, Float.parseFloat(outp48)));
        barEntries.add(new BarEntry(6f, Float.parseFloat(outp51)));
        barEntries.add(new BarEntry(7f, Float.parseFloat(outp52)));
        barEntries.add(new BarEntry(8f, Float.parseFloat(outp47)));


    }











}