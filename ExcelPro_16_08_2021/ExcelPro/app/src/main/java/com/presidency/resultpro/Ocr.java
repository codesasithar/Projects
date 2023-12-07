package com.presidency.resultpro;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class Ocr extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    ImageView imageview;
    public Button btnProcess, excelit;
    TextView txtView;
    public static String Excelit, exceltxt, currentLine;
    Bitmap bitmap;
    Bitmap photo;
    Bitmap tst;
    File root = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
    FileInputStream fis;
    File filePath = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "demo.xls");
    File file2 = new File(root, "scanned");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr);


        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        Toast.makeText(getApplicationContext(), filePath.toString(), Toast.LENGTH_LONG).show();


        Button photoButton = (Button) this.findViewById(R.id.button1);
        excelit = findViewById(R.id.ExceliT);
        EditText editTextExcel = findViewById(R.id.editText);
        imageview = findViewById(R.id.image_view);
        btnProcess = findViewById(R.id.Scan);
        txtView = findViewById(R.id.txtView);
        bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                R.drawable.ocr_sample2);
        imageview.setImageBitmap(bitmap);

        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextRecognizer txtRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();
                if (!txtRecognizer.isOperational()) {
                    txtView.setText(R.string.error_prompt);
                } else {
                    tst = BitmapFactory.decodeResource(getResources(), R.drawable.ocr_sample2);
                    Frame frame = new Frame.Builder().setBitmap(tst).build();
                    SparseArray items = txtRecognizer.detect(frame);
                    StringBuilder strBuilder = new StringBuilder();
                    for (int m = 0; m < items.size(); m++) {
                        TextBlock item = (TextBlock) items.valueAt(m);
                        strBuilder.append(item.getValue());
                        strBuilder.append("/");
                        for (Text line : item.getComponents()) {
                            //extract scanned text lines here
                            Log.v("lines", line.getValue());
                            for (Text element : line.getComponents()) {
                                //extract scanned text words here

                                Log.v("element", element.getValue());
                            }
                            txtView.setText(strBuilder.substring(0, strBuilder.toString().length() - 1));
                            exceltxt = txtView.getText().toString();
                            String sF = "scanned";


                                try {

                                    File gpxfile = new File(root, sF);
                                    FileWriter writer = new FileWriter(gpxfile);
                                    writer.append(exceltxt);
                                    writer.flush();
                                    //Toast.makeText(getApplicationContext(), "Saved Text File!", Toast.LENGTH_SHORT).show();
                                    writer.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                                }
                            }

                        }
                    }
                }


        });



        excelit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                //  HSSFWorkbook workBook = new HSSFWorkbook();
                //   HSSFSheet sheet = workBook.createSheet("sheet1");
                //  HSSFRow hssfRow = sheet.createRow(7);
                       /* HSSFCell hssfCell = hssfRow.createCell(5);
                        HSSFCell hssfCell2 = hssfRow.createCell(4);
                        HSSFCell hssfCell3 = hssfRow.createCell(3);
                        HSSFCell hssfCell4 = hssfRow.createCell(2);
                        HSSFCell hssfCell5 = hssfRow.createCell(1);
                        //HSSFCell hssfCelltime = hssfRowtime.createCell(1);

                        hssfCell2.setCellValue("Names");
                        hssfCell3.setCellValue("Marks");
                        hssfCell4.setCellValue("Internal marks");
                        hssfCell5.setCellValue("SGPA");
                        //hssfCell.setCellValue(exceltxt);
                        // hssfCelltime.setCellValue(getDateTime());

*/
                ArrayList<ArrayList<String>> allRowAndColData = null;
                ArrayList<String> oneRowData = null;
                String fName = file2.toString();
                String currentLine = null;
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream(fName);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                DataInputStream myInput = new DataInputStream(fis);
                int i = 0;
                allRowAndColData = new ArrayList<ArrayList<String>>();
                while (true) {
                    try {
                        if (!((currentLine = myInput.readLine()) != null)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    oneRowData = new ArrayList<String>();
                    String oneRowArray[] = currentLine.split("/");
                    for (int j = 0; j < oneRowArray.length; j++) {
                        oneRowData.add(oneRowArray[j]);
                    }
                    allRowAndColData.add(oneRowData);
                    System.out.println();
                    i++;
                }

                try {
                    HSSFWorkbook workBook = new HSSFWorkbook();
                    HSSFSheet sheet = workBook.createSheet("MarkList");
                    for (i = 0; i < allRowAndColData.size(); i++) {
                        ArrayList<?> ardata = (ArrayList<?>) allRowAndColData.get(i);
                        HSSFRow row = sheet.createRow(i);
                        for (int k = 0; k < ardata.size(); k++) {
                            System.out.print(ardata.get(k));
                            HSSFCell cell = row.createCell(k);
                            cell.setCellValue(ardata.get(k).toString());
                        }
                        System.out.println();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(filePath.toString());
                    workBook.write(fileOutputStream);
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(),"Excel Sheet Created",Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                }
            }
        });


    }
}

























                /*
Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_LONG).show();
                ArrayList<ArrayList<String>> allRowAndColData = null;
                ArrayList<String> oneRowData = null;
                String fName = filePath.toString();





                Toast.makeText(getApplicationContext(), "camein", Toast.LENGTH_LONG).show();
                Excelit = txtView.getText().toString();
                Toast.makeText(getApplicationContext(), "came till click", Toast.LENGTH_LONG).show();

                HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
                HSSFSheet hssfSheet = hssfWorkbook.createSheet("My Sheet");


                HSSFRow hssfRow = hssfSheet.createRow(7);
                HSSFRow hssfRowtime = hssfSheet.createRow(1);
                                         HSSFCell hssfCell = hssfRow.createCell(5);
                                          /* HSSFCell hssfCell2 = hssfRow.createCell(4);
                                           HSSFCell hssfCell3 = hssfRow.createCell(3);
                                           HSSFCell hssfCell4 = hssfRow.createCell(2);
                                           HSSFCell hssfCell5 = hssfRow.createCell(1);
                                           HSSFCell hssfCelltime = hssfRowtime.createCell(1);

                                           hssfCell2.setCellValue("Names");
                                           hssfCell3.setCellValue("Marks");
                                           hssfCell4.setCellValue("Internal marks");
                                           hssfCell5.setCellValue("SGPA");
                hssfCell.setCellValue(exceltxt);
                // hssfCelltime.setCellValue(getDateTime());

                try {
                    fis = new FileInputStream(fName);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                // DataInputStream myInput = new DataInputStream(fis);
                BufferedReader myInput = new BufferedReader(new InputStreamReader(fis));
                int i = 0;
                allRowAndColData = new ArrayList<>();
                while (true) {
                    try {
                        if ((currentLine = myInput.readLine()) == null) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }


                    String[] oneRowArray = currentLine.split("/");
                    oneRowData = new ArrayList<String>(Arrays.asList(oneRowArray));
                    allRowAndColData.add(oneRowData);
                    System.out.println();
                    i++;
                }


                try {
                    filePath.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    {


                        Toast.makeText(getApplicationContext(),"file created",Toast.LENGTH_LONG).show();

                        for (i = 0; i < allRowAndColData.size(); i++) {
                            ArrayList<?> ardata = (ArrayList<?>) allRowAndColData.get(i);
                            assert false;
                            hssfRow.createCell(i);
                            for (int k = 0; k < ardata.size(); k++) {
                                System.out.print(ardata.get(k));
                                HSSFCell cell = hssfRow.createCell(k);
                                cell.setCellValue(ardata.get(k).toString());


                                Toast.makeText(getApplicationContext(), filePath.toString(), Toast.LENGTH_LONG).show();
                                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(filePath.toString());
                            hssfWorkbook.write(fileOutputStream);

                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                        Toast.makeText(getApplicationContext(), "Excel sheet Created", Toast.LENGTH_SHORT).show();
                    }


                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

    }




                //DataInputStream myInput = new DataInputStream(fis);


                    try {
                        HSSFWorkbook workBook = new HSSFWorkbook();
                        HSSFSheet sheet = workBook.createSheet("sheet1");

                            System.out.println("camehere");

                        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                        workBook.write(fileOutputStream);
                        fileOutputStream.close();
                    } catch (Exception ex) {
                        Toast.makeText(getApplicationContext(),ex.toString(),Toast.LENGTH_LONG).show();
                    }

                }






    public String getDateTime() {
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ||  HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }*/













