package com.presidency.resultpro;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class ExcelIt extends AppCompatActivity {

    private EditText editTextExcel;
    private File filePath = new File( Environment.getExternalStorageDirectory().getAbsolutePath()+"/MarkList","demo.xls");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel_it);
        Button excelit = findViewById(R.id.excelit);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        editTextExcel = findViewById(R.id.editText);


        excelit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
                HSSFSheet hssfSheet = hssfWorkbook.createSheet("Custom Sheet");

                HSSFRow hssfRow = hssfSheet.createRow(0);
                HSSFCell hssfCell = hssfRow.createCell(0);

                hssfCell.setCellValue(editTextExcel.getText().toString());


                try {
                    if (!filePath.exists()) {

                        filePath.createNewFile();
                        Toast.makeText(getApplicationContext(),filePath.toString(),Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                    hssfWorkbook.write(fileOutputStream);

                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), "check", Toast.LENGTH_SHORT).show();
            }
        });

    }
/*
    public void buttonCreateExcel(View view){
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("Custom Sheet");

        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCell = hssfRow.createCell(0);

        hssfCell.setCellValue(editTextExcel.getText().toString());

        try {
            if (!filePath.exists()){
                filePath.mkdir();
                filePath.createNewFile();
                Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
            }
else{

                Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();

            }
            FileOutputStream fileOutputStream= new FileOutputStream(filePath);
            hssfWorkbook.write(fileOutputStream);

            if (fileOutputStream!=null){
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();*/
}