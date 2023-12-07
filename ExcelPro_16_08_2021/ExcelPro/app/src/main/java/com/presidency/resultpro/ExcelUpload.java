package com.presidency.resultpro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class ExcelUpload extends AppCompatActivity {
    //initialising the cellcount as 2
    public static final int cellCount=12;
    CardView sem1,sem2,sem3,sem4,sem5,sem6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel_upload);


        sem1 = findViewById(R.id.uploadmarklist1);

        sem2 = findViewById(R.id.uploadmarklist2);

        sem3 = findViewById(R.id.uploadmarklist3);

        sem4 = findViewById(R.id.uploadmarklist4);

        sem5 = findViewById(R.id.uploadmarklist5);

        sem6 = findViewById(R.id.uploadmarklist6);

        //click on excel to select a file
        String subjects[] ={"SEMESTER I","SEMESTER II","SEMESTER III","SEMESTER IV","SEMESTER V","SEMESTER VI"};
        String myString="1";
        Spinner spinnersub=findViewById(R.id.spinnersubject);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.spinnerlist,subjects);
        spinnersub.setAdapter(adapter);
        int spinnerPosition = adapter.getPosition(myString);
        spinnersub.setSelection(spinnerPosition);

        spinnersub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        sem1.setVisibility(View.VISIBLE);
                        sem2.setVisibility(View.INVISIBLE);
                        sem3.setVisibility(View.INVISIBLE);
                        sem4.setVisibility(View.INVISIBLE);
                        sem5.setVisibility(View.INVISIBLE);
                        sem6.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        sem1.setVisibility(View.INVISIBLE);
                        sem2.setVisibility(View.VISIBLE);
                        sem3.setVisibility(View.INVISIBLE);
                        sem4.setVisibility(View.INVISIBLE);
                        sem5.setVisibility(View.INVISIBLE);
                        sem6.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        sem1.setVisibility(View.INVISIBLE);
                        sem2.setVisibility(View.INVISIBLE);
                        sem3.setVisibility(View.VISIBLE);
                        sem4.setVisibility(View.INVISIBLE);
                        sem5.setVisibility(View.INVISIBLE);
                        sem6.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        sem1.setVisibility(View.INVISIBLE);
                        sem2.setVisibility(View.INVISIBLE);
                        sem3.setVisibility(View.INVISIBLE);
                        sem4.setVisibility(View.VISIBLE);
                        sem5.setVisibility(View.INVISIBLE);
                        sem6.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        sem1.setVisibility(View.INVISIBLE);
                        sem2.setVisibility(View.INVISIBLE);
                        sem3.setVisibility(View.INVISIBLE);
                        sem4.setVisibility(View.INVISIBLE);
                        sem5.setVisibility(View.VISIBLE);
                        sem6.setVisibility(View.INVISIBLE);
                        break;
                    case 5:
                        sem1.setVisibility(View.INVISIBLE);
                        sem2.setVisibility(View.INVISIBLE);
                        sem3.setVisibility(View.INVISIBLE);
                        sem4.setVisibility(View.INVISIBLE);
                        sem5.setVisibility(View.INVISIBLE);
                        sem6.setVisibility(View.VISIBLE);
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


        sem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(ExcelUpload.this , Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectfile1();
                }
                else {
                    ActivityCompat.requestPermissions(ExcelUpload.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},101);
                }
            }
        });

        sem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(ExcelUpload.this , Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectfile2();
                }
                else {
                    ActivityCompat.requestPermissions(ExcelUpload.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},102);
                }
            }
        });

        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(ExcelUpload.this , Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectfile3();
                }
                else {
                    ActivityCompat.requestPermissions(ExcelUpload.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},103);
                }
            }
        });
        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(ExcelUpload.this , Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectfile4();
                }
                else {
                    ActivityCompat.requestPermissions(ExcelUpload.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},104);
                }
            }
        });

        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(ExcelUpload.this , Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectfile5();
                }
                else {
                    ActivityCompat.requestPermissions(ExcelUpload.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},105);
                }
            }
        });
        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(ExcelUpload.this , Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectfile6();
                }
                else {
                    ActivityCompat.requestPermissions(ExcelUpload.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},106);
                }
            }
        });


    }
    //request for storage permission if not given
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                selectfile1();
            } else {
                Toast.makeText(ExcelUpload.this, "Permission Not granted", Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == 102) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                selectfile2();
            } else {
                Toast.makeText(ExcelUpload.this, "Permission Not granted", Toast.LENGTH_LONG).show();
            }
        }else if (requestCode == 103) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                selectfile3();
            } else {
                Toast.makeText(ExcelUpload.this, "Permission Not granted", Toast.LENGTH_LONG).show();
            }
        }else if (requestCode == 104) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                selectfile4();
            } else {
                Toast.makeText(ExcelUpload.this, "Permission Not granted", Toast.LENGTH_LONG).show();
            }
        }
    }









    private void selectfile1(){
        //select the file from the file storage
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "Select File"),101);
    }

    private void selectfile2(){
        //select the file from the file storage
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "Select File"),102);
    }

    private void selectfile3(){
        //select the file from the file storage
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "Select File"),103);
    }

    private void selectfile4(){
        //select the file from the file storage
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "Select File"),104);
    }


    private void selectfile5(){
        //select the file from the file storage
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "Select File"),105);
    }
    private void selectfile6(){
        //select the file from the file storage
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "Select File"),106);
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                String filepath = data.getData().getPath();
                //If excel file then only select the file
                if (true) {
                    readfile(data.getData());
                }
                //else show the error
                else {
                    Toast.makeText(this, "Please Select an Excel file to upload", Toast.LENGTH_LONG).show();
                }
            }
        } else  if (requestCode == 102) {
            if (resultCode == RESULT_OK) {
                String filepath = data.getData().getPath();
                //If excel file then only select the file
                if (true) {
                    readfilesem2(data.getData());
                }
                //else show the error
                else {
                    Toast.makeText(this, "Please Select an Excel file to upload", Toast.LENGTH_LONG).show();
                }
            }
        }
        else  if (requestCode == 103) {
            if (resultCode == RESULT_OK) {
                String filepath = data.getData().getPath();
                //If excel file then only select the file
                if (true) {
                    readfilesem3(data.getData());
                }
                //else show the error
                else {
                    Toast.makeText(this, "Please Select an Excel file to upload", Toast.LENGTH_LONG).show();
                }
            }
        }
        else  if (requestCode == 104) {
            if (resultCode == RESULT_OK) {
                String filepath = data.getData().getPath();
                //If excel file then only select the file
                if (true) {
                    readfilesem4(data.getData());
                }
                //else show the error
                else {
                    Toast.makeText(this, "Please Select an Excel file to upload", Toast.LENGTH_LONG).show();
                }
            }
        }
        else  if (requestCode == 105) {
            if (resultCode == RESULT_OK) {
                String filepath = data.getData().getPath();
                //If excel file then only select the file
                if (true) {
                    readfilesem5(data.getData());
                }
                //else show the error
                else {
                    Toast.makeText(this, "Please Select an Excel file to upload", Toast.LENGTH_LONG).show();
                }
            }
        }
        else  if (requestCode == 106) {
            if (resultCode == RESULT_OK) {
                String filepath = data.getData().getPath();
                //If excel file then only select the file
                if (true) {
                    readfilesem6(data.getData());
                }
                //else show the error
                else {
                    Toast.makeText(this, "Please Select an Excel file to upload", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    ProgressDialog dialog;
    private void readfile(final Uri file)
    {
        dialog=new ProgressDialog(this);
        dialog.setMessage("Uploading");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                final HashMap<String ,Object> parentmap=new HashMap<>();

                try {
                    XSSFWorkbook workbook;
                    //check for the input from the excel file
                    try (InputStream inputStream = getContentResolver().openInputStream(file)) {
                        workbook = new XSSFWorkbook(inputStream);
                    }
                    final String timestamp=""+System.currentTimeMillis();
                    XSSFSheet sheet=workbook.getSheetAt(0);
                    FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();
                    int rowscount=sheet.getPhysicalNumberOfRows();
                    if(rowscount>0){
                        //check rowwise data
                        for (int r=0;r<rowscount;r++){
                            Row row=sheet.getRow(r);
                            if(row.getPhysicalNumberOfCells()==cellCount) {
                                //get cell data
                                String A = getCellData(row,0,formulaEvaluator);
                                String B = getCellData(row,1,formulaEvaluator);
                                String C = getCellData(row,2,formulaEvaluator);
                                String D = getCellData(row,3,formulaEvaluator);
                                String E = getCellData(row,4,formulaEvaluator);
                                String F = getCellData(row,5,formulaEvaluator);
                                String G = getCellData(row,6,formulaEvaluator);
                                String H = getCellData(row,7,formulaEvaluator);
                                String I = getCellData(row,8,formulaEvaluator);
                                String J = getCellData(row,9,formulaEvaluator);
                                String K = getCellData(row,10,formulaEvaluator);
                                String L = getCellData(row,11,formulaEvaluator);

                                //initialise the hashmap and put value of a and b into it
                                HashMap<String,Object> quetionmap=new HashMap<>();
                                quetionmap.put("SERIAL NUMBER",A);
                                quetionmap.put("registernumber",B);
                                quetionmap.put("name",C);
                                quetionmap.put("INDIAN LANGUAGE",D);
                                quetionmap.put("ENGLISH",E);
                                quetionmap.put("C LANGUAGE",F);
                                quetionmap.put("COMPUTER ORGANISATION",G);
                                quetionmap.put("DM",H);
                                quetionmap.put("C LAB",I);
                                quetionmap.put("OFFICE AUTOMATION",J);
                                quetionmap.put("FOUNDATION COURSE",K);
                                quetionmap.put("CCANDEC",L);

                                String id=B;


                                parentmap.put(id,quetionmap);
                            }
                            else {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"row no. "+(r+1)+" has incorrect data",Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        //add the data in firebase if everything is correct
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //add the data accourding to timestamp
                                FirebaseDatabase.getInstance().getReference().child("FirstSem3").updateChildren(parentmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Uploaded Successfully",Toast.LENGTH_LONG).show();
                                        }else {
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Something went wrong",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        });

                    }
                    //show the error if file is empty
                    else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"File is empty",Toast.LENGTH_LONG).show();

                            }
                        });
                        return;
                    }
                }
                //show the error message if failed due to file not found
                catch (final FileNotFoundException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                //show the error message if there is error in input outut
                catch (final IOException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    private void readfilesem2(final Uri file)
    {
        dialog=new ProgressDialog(this);
        dialog.setMessage("Uploading");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                final HashMap<String ,Object> parentmap=new HashMap<>();

                try {
                    XSSFWorkbook workbook;
                    //check for the input from the excel file
                    try (InputStream inputStream = getContentResolver().openInputStream(file)) {
                        workbook = new XSSFWorkbook(inputStream);
                    }
                    final String timestamp=""+System.currentTimeMillis();
                    XSSFSheet sheet=workbook.getSheetAt(0);
                    FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();
                    int rowscount=sheet.getPhysicalNumberOfRows();
                    if(rowscount>0){
                        //check rowwise data
                        for (int r=0;r<rowscount;r++){
                            Row row=sheet.getRow(r);
                            if(row.getPhysicalNumberOfCells()==cellCount) {
                                //get cell data
                                String A = getCellData(row,0,formulaEvaluator);
                                String B = getCellData(row,1,formulaEvaluator);
                                String C = getCellData(row,2,formulaEvaluator);
                                String D = getCellData(row,3,formulaEvaluator);
                                String E = getCellData(row,4,formulaEvaluator);
                                String F = getCellData(row,5,formulaEvaluator);
                                String G = getCellData(row,6,formulaEvaluator);
                                String H = getCellData(row,7,formulaEvaluator);
                                String I = getCellData(row,8,formulaEvaluator);
                                String J = getCellData(row,9,formulaEvaluator);
                                String K = getCellData(row,10,formulaEvaluator);
                                String L = getCellData(row,11,formulaEvaluator);

                                //initialise the hashmap and put value of a and b into it
                                HashMap<String,Object> quetionmap=new HashMap<>();
                                quetionmap.put("SERIAL NUMBER",A);

                                quetionmap.put("registernumber",B);
                                quetionmap.put("name",C);
                                quetionmap.put("INDIAN LANGUAGE",D);
                                quetionmap.put("ENGLISH",E);
                                quetionmap.put("Data Structures",F);
                                quetionmap.put("DATABASE MANAGEMENT SYSTEM",G);
                                quetionmap.put("NUMERICAL AND STATISTICAL METHODS",H);
                                quetionmap.put("DATASTRUCTURES USING C LAB",I);
                                quetionmap.put("DBMS LAB",J);
                                quetionmap.put("FOUNDATION COURSE",K);
                                quetionmap.put("CCANDEC",L);

                                String id=B;


                                parentmap.put(id,quetionmap);
                            }
                            else {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"row no. "+(r+1)+" has incorrect data",Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        //add the data in firebase if everything is correct
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //add the data accourding to timestamp
                                FirebaseDatabase.getInstance().getReference().child("secondsem").updateChildren(parentmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Uploaded Successfully",Toast.LENGTH_LONG).show();
                                        }else {
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Something went wrong",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        });

                    }
                    //show the error if file is empty
                    else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"File is empty",Toast.LENGTH_LONG).show();

                            }
                        });
                        return;
                    }
                }
                //show the error message if failed due to file not found
                catch (final FileNotFoundException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                //show the error message if there is error in input outut
                catch (final IOException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    private void readfilesem3(final Uri file)
    {
        dialog=new ProgressDialog(this);
        dialog.setMessage("Uploading");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                final HashMap<String ,Object> parentmap=new HashMap<>();

                try {
                    XSSFWorkbook workbook;
                    //check for the input from the excel file
                    try (InputStream inputStream = getContentResolver().openInputStream(file)) {
                        workbook = new XSSFWorkbook(inputStream);
                    }
                    final String timestamp=""+System.currentTimeMillis();
                    XSSFSheet sheet=workbook.getSheetAt(0);
                    FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();
                    int rowscount=sheet.getPhysicalNumberOfRows();
                    if(rowscount>0){
                        //check rowwise data
                        for (int r=0;r<rowscount;r++){
                            Row row=sheet.getRow(r);
                            if(row.getPhysicalNumberOfCells()==cellCount) {
                                //get cell data
                                String A = getCellData(row,0,formulaEvaluator);
                                String B = getCellData(row,1,formulaEvaluator);
                                String C = getCellData(row,2,formulaEvaluator);
                                String D = getCellData(row,3,formulaEvaluator);
                                String E = getCellData(row,4,formulaEvaluator);
                                String F = getCellData(row,5,formulaEvaluator);
                                String G = getCellData(row,6,formulaEvaluator);
                                String H = getCellData(row,7,formulaEvaluator);
                                String I = getCellData(row,8,formulaEvaluator);
                                String J = getCellData(row,9,formulaEvaluator);
                                String K = getCellData(row,10,formulaEvaluator);
                                String L = getCellData(row,11,formulaEvaluator);

                                //initialise the hashmap and put value of a and b into it
                                HashMap<String,Object> quetionmap=new HashMap<>();
                                quetionmap.put("SERIAL NUMBER",A);

                                quetionmap.put("registernumber",B);
                                quetionmap.put("name",C);
                                quetionmap.put("INDIAN LANGUAGE",D);
                                quetionmap.put("ENGLISH",E);
                                quetionmap.put("OOPS USING C++",F);
                                quetionmap.put("FINANCIAL ACCOUNTING AND SYSTEM",G);
                                quetionmap.put("OPERATING SYSTEM",H);
                                quetionmap.put("OOPS USING C++ LAB",I);
                                quetionmap.put("TALLY LAB",J);
                                quetionmap.put("FOUNDATION COURSE",K);
                                quetionmap.put("CC AND EC",L);

                                String id=B;


                                parentmap.put(id,quetionmap);
                            }
                            else {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"row no. "+(r+1)+" has incorrect data",Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        //add the data in firebase if everything is correct
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //add the data accourding to timestamp
                                FirebaseDatabase.getInstance().getReference().child("thirdsem").updateChildren(parentmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Uploaded Successfully",Toast.LENGTH_LONG).show();
                                        }else {
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Something went wrong",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        });

                    }
                    //show the error if file is empty
                    else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"File is empty",Toast.LENGTH_LONG).show();

                            }
                        });
                        return;
                    }
                }
                //show the error message if failed due to file not found
                catch (final FileNotFoundException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                //show the error message if there is error in input outut
                catch (final IOException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }


    private void readfilesem4(final Uri file)
    {
        dialog=new ProgressDialog(this);
        dialog.setMessage("Uploading");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                final HashMap<String ,Object> parentmap=new HashMap<>();

                try {
                    XSSFWorkbook workbook;
                    //check for the input from the excel file
                    try (InputStream inputStream = getContentResolver().openInputStream(file)) {
                        workbook = new XSSFWorkbook(inputStream);
                    }
                    final String timestamp=""+System.currentTimeMillis();
                    XSSFSheet sheet=workbook.getSheetAt(0);
                    FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();
                    int rowscount=sheet.getPhysicalNumberOfRows();
                    if(rowscount>0){
                        //check rowwise data
                        for (int r=0;r<rowscount;r++){
                            Row row=sheet.getRow(r);
                            if(row.getPhysicalNumberOfCells()==cellCount) {
                                //get cell data
                                String A = getCellData(row,0,formulaEvaluator);
                                String B = getCellData(row,1,formulaEvaluator);
                                String C = getCellData(row,2,formulaEvaluator);
                                String D = getCellData(row,3,formulaEvaluator);
                                String E = getCellData(row,4,formulaEvaluator);
                                String F = getCellData(row,5,formulaEvaluator);
                                String G = getCellData(row,6,formulaEvaluator);
                                String H = getCellData(row,7,formulaEvaluator);
                                String I = getCellData(row,8,formulaEvaluator);
                                String J = getCellData(row,9,formulaEvaluator);
                                String K = getCellData(row,10,formulaEvaluator);
                                String L = getCellData(row,11,formulaEvaluator);

                                //initialise the hashmap and put value of a and b into it
                                HashMap<String,Object> quetionmap=new HashMap<>();
                                quetionmap.put("SERIAL NUMBER",A);

                                quetionmap.put("registernumber",B);
                                quetionmap.put("name",C);
                                quetionmap.put("INDIAN LANGUAGE",D);
                                quetionmap.put("ENGLISH",E);
                                quetionmap.put("VB NET PROGRAMMING",F);
                                quetionmap.put("UNIX",G);
                                quetionmap.put("SOFTWARE PROGRAMMING",H);
                                quetionmap.put("VB NET LAB",I);
                                quetionmap.put("UNIX LAB",J);
                                quetionmap.put("SKILL DEVELOPMENT",K);
                                quetionmap.put("CC AND EC",L);

                                String id=B;


                                parentmap.put(id,quetionmap);
                            }
                            else {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"row no. "+(r+1)+" has incorrect data",Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        //add the data in firebase if everything is correct
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //add the data accourding to timestamp
                                FirebaseDatabase.getInstance().getReference().child("fourthsem").updateChildren(parentmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Uploaded Successfully",Toast.LENGTH_LONG).show();
                                        }else {
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Something went wrong",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        });

                    }
                    //show the error if file is empty
                    else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"File is empty",Toast.LENGTH_LONG).show();

                            }
                        });
                        return;
                    }
                }
                //show the error message if failed due to file not found
                catch (final FileNotFoundException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                //show the error message if there is error in input outut
                catch (final IOException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }


    private void readfilesem5(final Uri file)
    {
        dialog=new ProgressDialog(this);
        dialog.setMessage("Uploading");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                final HashMap<String ,Object> parentmap=new HashMap<>();

                try {
                    XSSFWorkbook workbook;
                    //check for the input from the excel file
                    try (InputStream inputStream = getContentResolver().openInputStream(file)) {
                        workbook = new XSSFWorkbook(inputStream);
                    }
                    final String timestamp=""+System.currentTimeMillis();
                    XSSFSheet sheet=workbook.getSheetAt(0);
                    FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();
                    int rowscount=sheet.getPhysicalNumberOfRows();
                    if(rowscount>0){
                        //check rowwise data
                        for (int r=0;r<rowscount;r++){
                            Row row=sheet.getRow(r);
                            if(row.getPhysicalNumberOfCells()==cellCount) {
                                //get cell data
                                String A = getCellData(row,0,formulaEvaluator);
                                String B = getCellData(row,1,formulaEvaluator);
                                String C = getCellData(row,2,formulaEvaluator);
                                String D = getCellData(row,3,formulaEvaluator);
                                String E = getCellData(row,4,formulaEvaluator);
                                String F = getCellData(row,5,formulaEvaluator);
                                String G = getCellData(row,6,formulaEvaluator);
                                String H = getCellData(row,7,formulaEvaluator);
                                String I = getCellData(row,8,formulaEvaluator);
                                String J = getCellData(row,9,formulaEvaluator);
                                String K = getCellData(row,10,formulaEvaluator);
                                String L = getCellData(row,11,formulaEvaluator);

                                //initialise the hashmap and put value of a and b into it
                                HashMap<String,Object> quetionmap=new HashMap<>();
                                quetionmap.put("SERIAL NUMBER",A);

                                quetionmap.put("registernumber",B);
                                quetionmap.put("name",C);
                                quetionmap.put("DATA COMMUNICATION AND NETWORK",D);
                                quetionmap.put("ARTIFICIAL INTELLIGENCE",E);
                                quetionmap.put("JAVA PROGRAMMING",F);
                                quetionmap.put("ANALYSIS AND DESIGN OF ALGORITHM",G);
                                quetionmap.put("ELECTIVE 1",H);
                                quetionmap.put("JAVA PROGRAMMING LAB",I);
                                quetionmap.put("ANALYSIS AND DESIGN OF ALGORITHM LAB",J);
                                quetionmap.put("PROJECT",K);
                                quetionmap.put("SKILL DEVELOPMENT COURSE",L);


                                String id=B;


                                parentmap.put(id,quetionmap);
                            }
                            else {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"row no. "+(r+1)+" has incorrect data",Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        //add the data in firebase if everything is correct
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //add the data accourding to timestamp
                                FirebaseDatabase.getInstance().getReference().child("fifthsem").updateChildren(parentmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Uploaded Successfully",Toast.LENGTH_LONG).show();
                                        }else {
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Something went wrong",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        });

                    }
                    //show the error if file is empty
                    else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"File is empty",Toast.LENGTH_LONG).show();

                            }
                        });
                        return;
                    }
                }
                //show the error message if failed due to file not found
                catch (final FileNotFoundException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                //show the error message if there is error in input outut
                catch (final IOException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    private void readfilesem6(final Uri file)
    {
        dialog=new ProgressDialog(this);
        dialog.setMessage("Uploading");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                final HashMap<String ,Object> parentmap=new HashMap<>();

                try {
                    XSSFWorkbook workbook;
                    //check for the input from the excel file
                    try (InputStream inputStream = getContentResolver().openInputStream(file)) {
                        workbook = new XSSFWorkbook(inputStream);
                    }
                    final String timestamp=""+System.currentTimeMillis();
                    XSSFSheet sheet=workbook.getSheetAt(0);
                    FormulaEvaluator formulaEvaluator=workbook.getCreationHelper().createFormulaEvaluator();
                    int rowscount=sheet.getPhysicalNumberOfRows();
                    if(rowscount>0){
                        //check rowwise data
                        for (int r=0;r<rowscount;r++){
                            Row row=sheet.getRow(r);
                            if(row.getPhysicalNumberOfCells()==cellCount) {
                                //get cell data
                                String A = getCellData(row,0,formulaEvaluator);
                                String B = getCellData(row,1,formulaEvaluator);
                                String C = getCellData(row,2,formulaEvaluator);
                                String D = getCellData(row,3,formulaEvaluator);
                                String E = getCellData(row,4,formulaEvaluator);
                                String F = getCellData(row,5,formulaEvaluator);
                                String G = getCellData(row,6,formulaEvaluator);
                                String H = getCellData(row,7,formulaEvaluator);
                                String I = getCellData(row,8,formulaEvaluator);
                                String J = getCellData(row,9,formulaEvaluator);
                                String K = getCellData(row,10,formulaEvaluator);
                                String L = getCellData(row,11,formulaEvaluator);

                                //initialise the hashmap and put value of a and b into it
                                HashMap<String,Object> quetionmap=new HashMap<>();
                                quetionmap.put("SERIAL NUMBER",A);

                                quetionmap.put("registernumber",B);
                                quetionmap.put("name",C);
                                quetionmap.put("SYSTEM PROGRAMMING",D);
                                quetionmap.put("PROFESSIONAL AND BUSINESS COMMUNICATION",E);
                                quetionmap.put("WEB PROGRAMMING",F);
                                quetionmap.put("ELECTIVE 2",G);
                                quetionmap.put("WEB PROGRAMMING LAB",H);
                                quetionmap.put("PROJECT",I);
                                quetionmap.put("SKILL DEVELOPMENT",J);

                                String id=B;


                                parentmap.put(id,quetionmap);
                            }
                            else {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"row no. "+(r+1)+" has incorrect data",Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        //add the data in firebase if everything is correct
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //add the data accourding to timestamp
                                FirebaseDatabase.getInstance().getReference().child("sixthsem").updateChildren(parentmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Uploaded Successfully",Toast.LENGTH_LONG).show();
                                        }else {
                                            dialog.dismiss();
                                            Toast.makeText(ExcelUpload.this,"Something went wrong",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        });

                    }
                    //show the error if file is empty
                    else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(ExcelUpload.this,"File is empty",Toast.LENGTH_LONG).show();

                            }
                        });
                        return;
                    }
                }
                //show the error message if failed due to file not found
                catch (final FileNotFoundException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                //show the error message if there is error in input outut
                catch (final IOException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(ExcelUpload.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }







    private String getCellData(Row row, int cellposition, FormulaEvaluator formulaEvaluator){
        String value="";
        //get cell fom excel sheet
        Cell cell=row.getCell(cellposition);
        switch (cell.getCellType()){

            case Cell.CELL_TYPE_BOOLEAN:
                return value+cell.getBooleanCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                return value+cell.getNumericCellValue();
            case Cell.CELL_TYPE_STRING:
                return value+cell.getStringCellValue();
            default:
                return value;
        }
    }











}