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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ExcelSp extends AppCompatActivity {
    //initialising the cellcount as 2
    public static final int cellCount=12;

    CardView sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel_sp);
        sp = findViewById(R.id.uploadmarklist);
        //click on excel to select a file

        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(ExcelSp.this , Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectfile();
                }
                else {
                    ActivityCompat.requestPermissions(ExcelSp.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},101);
                }
            }
        });

    }
    //request for storage permission if not given
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==101){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                selectfile();
            }else {
                Toast.makeText(ExcelSp.this,"Permission Not granted",Toast.LENGTH_LONG).show();
            }
        }
    }
    private void selectfile(){
        //select the file from the file storage
        Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(Intent.createChooser(intent, "Select File"),102);
    }



    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==102){
            if(resultCode==RESULT_OK){
                String filepath=data.getData().getPath();
                //If excel file then only select the file
                if(filepath.endsWith(".xlsx") || filepath.endsWith(".xls")){
                    readfile(data.getData());
                }
                //else show the error
                else {
                    Toast.makeText(this,"Please Select an Excel file to upload",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    ProgressDialog dialog;
    private void readfile(final Uri file)
    {
        dialog=new ProgressDialog(this);
        dialog.setMessage("Uploading Marksheet");
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
                                Toast.makeText(getApplicationContext(),"row no. "+(r+1)+" has incorrect data",Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        //add the data in firebase if everything is correct
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //add the data accourding to timestamp
                                FirebaseDatabase.getInstance().getReference().child("firstseminternals").updateChildren(parentmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            dialog.dismiss();
                                            Toast.makeText(ExcelSp.this,"Marksheet Uploaded Successfully",Toast.LENGTH_LONG).show();
                                        }else {
                                            dialog.dismiss();
                                            Toast.makeText(ExcelSp.this,"Marksheet not uploaded",Toast.LENGTH_LONG).show();
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
                                Toast.makeText(ExcelSp.this,"File is empty",Toast.LENGTH_LONG).show();

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
                            Toast.makeText(ExcelSp.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                //show the error message if there is error in input outut
                catch (final IOException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(ExcelSp.this,e.getMessage(), Toast.LENGTH_LONG).show();
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