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
import android.widget.ImageView;
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


public class uploadcred extends AppCompatActivity {
    //initialising the cellcount as 2
    public static final int cellCount=2;
    CardView upcred;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadcred);


        upcred = findViewById(R.id.cred);


        //click on excel to select a file
        String subjects[] ={"SEMESTER I","SEMESTER II","SEMESTER III","SEMESTER IV","SEMESTER V","SEMESTER VI"};

        upcred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(uploadcred.this , Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectfile();
                }
                else {
                    ActivityCompat.requestPermissions(uploadcred.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},101);
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
                Toast.makeText(uploadcred.this,"Permission Not granted",Toast.LENGTH_LONG).show();
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
                if(true){
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


                                //initialise the hashmap and put value of a and b into it
                                HashMap<String,Object> quetionmap=new HashMap<>();
                                quetionmap.put("registernumber",A);

                                quetionmap.put("password",B);


                                String id=A;


                                parentmap.put(id,quetionmap);
                            }
                            else {
                                dialog.dismiss();
                                Toast.makeText(uploadcred.this,"row no. "+(r+1)+" has incorrect data",Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        //add the data in firebase if everything is correct
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //add the data accourding to timestamp
                                FirebaseDatabase.getInstance().getReference().child("credentials").updateChildren(parentmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            dialog.dismiss();
                                            Toast.makeText(uploadcred.this,"Credentials Uploaded Successfully default pwd : 123",Toast.LENGTH_LONG).show();
                                        }else {
                                            dialog.dismiss();
                                            Toast.makeText(uploadcred.this,"Something went wrong",Toast.LENGTH_LONG).show();
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
                                Toast.makeText(uploadcred.this,"File is empty",Toast.LENGTH_LONG).show();

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
                            Toast.makeText(uploadcred.this,e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                //show the error message if there is error in input outut
                catch (final IOException e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(uploadcred.this,e.getMessage(), Toast.LENGTH_LONG).show();
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