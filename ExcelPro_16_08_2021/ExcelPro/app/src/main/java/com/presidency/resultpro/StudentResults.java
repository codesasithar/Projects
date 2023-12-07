package com.presidency.resultpro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class StudentResults extends Activity {
    static DatabaseReference rootRef;
    static DatabaseReference demoRefnum;
    static DatabaseReference cnsverify;
    static DatabaseReference officear;
    static DatabaseReference dmr;
    static DatabaseReference indianlanguage;
    static DatabaseReference english;
    static DatabaseReference name;
    static DatabaseReference clanguage;
    static DatabaseReference comporg;
    static DatabaseReference clab;
    static DatabaseReference foundationc;
    static DatabaseReference cc;
    static DatabaseReference demoRefmarks;


    static DatabaseReference indianlang;
    static DatabaseReference englishh;
    static DatabaseReference ds;
    static DatabaseReference dbms;
    static DatabaseReference nsm;
    static DatabaseReference dbmslab;
    static DatabaseReference dslab;
    static DatabaseReference foundationcc;
    static DatabaseReference ecandcc;


    static DatabaseReference indianlangs;
    static DatabaseReference englissh;
    static DatabaseReference fam;
    static DatabaseReference os;
    static DatabaseReference oopsusingc;
    static DatabaseReference oopsusingclab;
    static DatabaseReference tallylab;
    static DatabaseReference foundationnc;
    static DatabaseReference eccc;


    static DatabaseReference il;
    static DatabaseReference eng;
    static DatabaseReference vbnet;
    static DatabaseReference unix;
    static DatabaseReference se;
    static DatabaseReference vbnetlab;
    static DatabaseReference unixlab;
    static DatabaseReference skilld;
    static DatabaseReference ecanddcc;


    static DatabaseReference dcn;
    static DatabaseReference ai;
    static DatabaseReference java;
    static DatabaseReference ada;
    static DatabaseReference elective;
    static DatabaseReference adalab;
    static DatabaseReference javalab;
    static DatabaseReference project;
    static DatabaseReference skillc;


    static DatabaseReference sp;
    static DatabaseReference pbc;
    static DatabaseReference wp;
    static DatabaseReference elective2;
    static DatabaseReference wplab;
    static DatabaseReference projectt;
    static DatabaseReference skilldevlopment;


    private ArrayList<String> Userlist;
    TextView markstxt;
    static Button verify, ovbtn,ovbtn2,ovbtn3,ovbtn4,ovbtn5,ovbtn6;
    public static float dmpercent, cccc, officepercent, englishpercentage, comppercentage, clab1, ccc, foundationpercent, cpercentage, langpercent;

    public static float dmpercent2, cccc2, officepercent2, englishpercentage2, comppercentage2, clab12, ccc2, foundationpercent2, cpercentage2, langpercent2;

    public static float dmpercent3, cccc3, officepercent3, englishpercentage3, comppercentage3, clab13, ccc3, foundationpercent3, cpercentage3, langpercent3;

    public static float dmpercent4, cccc4, officepercent4, englishpercentage4, comppercentage4, clab14, ccc4, foundationpercent4, cpercentage4, langpercent4;

    public static float dmpercent5, cccc5, officepercent5, englishpercentage5, comppercentage5, clab15, ccc5, foundationpercent5, cpercentage5, langpercent5;

    public static float dmpercent6, cccc6, officepercent6, englishpercentage6, comppercentage6, clab16, ccc6, foundationpercent6, cpercentage6, langpercent6;

    public static TextView fetchedtext52, officea1, officepercentage1, percentage, grade, comp, lang, English, cl, officepercentage, Dm, clabpercent11, found, ccnec, regnum, fetchedtextname, fetchedtext4, fetchedtext10, officea, dm, fetchedtext5, fetchedtext666, fetchedtext111, fetchedtext7, fetchedtext8;

    public static TextView fetchedtext53, percentage2, grade2, comp2, lang2, English2, cl2, officepercentage2, Dm2, clabpercent112, found2, ccnec2, fetchedtext42, fetchedtext102, officea2, dm2, fetchedtext6662, fetchedtext1112, fetchedtext72, fetchedtext82;
    public static TextView fetchedtext54,fetchedtext1111, percentage3, grade3, comp3, lang3, English3, cl3, officepercentage3, Dm3, clabpercent113, found3, ccnec3, fetchedtext43, fetchedtext103, officea3, dm3, fetchedtext6663, fetchedtext1113, fetchedtext73, fetchedtext83;
    public static TextView fetchedtext55, fetchedtext6wp, percentage4, grade4, comp4, lang4, English4, cl4, officepercentage4, Dm4, clabpercent114, found4, ccnec4, fetchedtext44, fetchedtext104, officea4, dm4, fetchedtext6664, fetchedtext1114, fetchedtext74, fetchedtext84;
    public static TextView fetchedtext51,fetchedtext6661,fetchedtext101,cl1,dm1,Dm1,clabpercent111, comp1, grade5, comp5, lang5, English5, cl5, officepercentage5, Dm5, clabpercent115, found5, ccnec5, fetchedtext45, fetchedtext105, officea5, dm5, fetchedtext6665, fetchedtext1115, fetchedtext75, fetchedtext85;
    public static TextView English303,fetchedtext41,English1,lang1,percentage6, grade6, comp6, lang6, English6, cl6, officepercentage6, Dm6, clabpercent116, found6, ccnec6, fetchedtext46, fetchedtext106, officea6, dm6, fetchedtext6666, fetchedtext1116, fetchedtext76, fetchedtext86;


    TableLayout resulttable, resulttable2, resulttable3, resulttable4, resulttable5, resulttable6;
    CardView detailcard;
    static String output10000, output84222, output100001, output1, output1x, output1ppp, output4, output5, output10055, output666, output7, output8;

    static String output, output1000012, output12, output1x2, output1ppp2, output42, output52, output100552, output6662, output72, output82;

    static String output100003, output8456, output456, output83, out, output1000013, output13, output1x3, output1ppp3, output43, output53, output100553, output6663, output73;

    static String output100004, output822, output833, output823, output824, output825, output826, output1000014, output14, output1x4, output1ppp4, output44, output54, output100554, output6664, output74, output84;

    static String output100005, output1000015, output15, output1x5, output1ppp5, output45, output55, output100555, output6665, output75, output85;

    static String output100006, output1000016, output16, output1x6, output1ppp6, output46, output56, output100556, output6666, output76, output86;


    static String register;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_student_results);
        resulttable = findViewById(R.id.resulttable);
        resulttable2 = findViewById(R.id.resulttable2);
        resulttable3 = findViewById(R.id.resulttable3);
        resulttable4 = findViewById(R.id.resulttable4);
        resulttable5 = findViewById(R.id.resulttable5);
        resulttable6 = findViewById(R.id.resulttable6);
        comp = findViewById(R.id.comp);
        English303 = findViewById(R.id.English303);
        dm3 = findViewById(R.id.dm3);
        Dm3 = findViewById(R.id.English3);
        dm4 = findViewById(R.id.dm4);
        Dm4 = findViewById(R.id.Dm4);
        Dm5 = findViewById(R.id.Dm5);
        Dm6 = findViewById(R.id.Dm6);
        Dm2 = findViewById(R.id.Dm2);
        comp3 = findViewById(R.id.comp3);
        lang1 = findViewById(R.id.lang1);
        comp1 = findViewById(R.id.comp1);
        comp = findViewById(R.id.comp);
        comp3 = findViewById(R.id.comp3);
        comp4 = findViewById(R.id.comp4);
        comp5 = findViewById(R.id.comp5);
       // comp6 = findViewById(R.id.comp6);
        comp2 = findViewById(R.id.comp2);
        fetchedtext6661=findViewById(R.id.fetchedtext6661);
        fetchedtext1111=findViewById(R.id.fetchedtext1111);
        fetchedtext1112=findViewById(R.id.fetchedtext1112);
        clabpercent111=findViewById(R.id.clabpercent111);
        fetchedtext101=findViewById(R.id.fetchedtext101);
        fetchedtext41=findViewById(R.id.fetchedtext41);
        English1=findViewById(R.id.English1);
        English2=findViewById(R.id.English2);
        cl1=findViewById(R.id.cl1);
        dm1=findViewById(R.id.dm1);
        Dm1=findViewById(R.id.Dm1);
        fetchedtext53 = findViewById(R.id.fetchedtext53);
        fetchedtext5 = findViewById(R.id.fetchedtext5);
        grade = findViewById(R.id.grade);
        percentage = findViewById(R.id.percentage);
        ovbtn = findViewById(R.id.ovbtn);
        ovbtn2 = findViewById(R.id.ovbtn2);
        ovbtn3 = findViewById(R.id.ovbtn3);
        ovbtn4 = findViewById(R.id.ovbtn4);
        ovbtn5 = findViewById(R.id.ovbtn5);
        ovbtn6 = findViewById(R.id.ovbtn6);
        English = findViewById(R.id.English);
        English5 = findViewById(R.id.English5);
        English2 = findViewById(R.id.English2);
        English1 = findViewById(R.id.English1);
        English4 = findViewById(R.id.English4);
        English3 = findViewById(R.id.English3);
        cl = findViewById(R.id.cl);
        cl2 = findViewById(R.id.cl2);
        cl5 = findViewById(R.id.cl5);
        cl4 = findViewById(R.id.cl4);
        cl3 = findViewById(R.id.cl3);
        officea1 = findViewById(R.id.officea1);
        lang3 = findViewById(R.id.lang3);
        lang2 = findViewById(R.id.lang2);
        lang5 = findViewById(R.id.lang5);
        lang4 = findViewById(R.id.lang4);
        lang = findViewById(R.id.lang);
        officepercentage = findViewById(R.id.officepercentage);
        // = findViewById(R.id.officepercentage6);
        officepercentage1 = findViewById(R.id.officepercentage1);
        officepercentage2 = findViewById(R.id.officepercentage2);
        officepercentage3 = findViewById(R.id.officepercentage3);
        officepercentage4 = findViewById(R.id.officepercentage4);
        officepercentage5 = findViewById(R.id.officepercentage5);
        officea3 = findViewById(R.id.officea3);
        officea4 = findViewById(R.id.officea4);
        officea5 = findViewById(R.id.officea5);

        clabpercent111 = findViewById(R.id.clabpercent111);
        clabpercent11 = findViewById(R.id.clabpercent11);
        clabpercent112 = findViewById(R.id.clabpercent112);
        clabpercent113 = findViewById(R.id.clabpercent113);
        clabpercent115 = findViewById(R.id.clabpercent115);
        clabpercent114 = findViewById(R.id.clabpercent114);
        found = findViewById(R.id.found);
        found2 = findViewById(R.id.found2);
        found3 = findViewById(R.id.found3);
        found4 = findViewById(R.id.found4);
        found5 = findViewById(R.id.found5);
        ccnec = findViewById(R.id.ccnec);
        ccnec5 = findViewById(R.id.ccnec5);
        ccnec2 = findViewById(R.id.ccnec2);
        ccnec3 = findViewById(R.id.ccnec3);
        ccnec4 = findViewById(R.id.ccnec4);
        dm2 = findViewById(R.id.dm2);
        detailcard = findViewById(R.id.detailcard);
        fetchedtextname = findViewById(R.id.fetchedtextname);
        fetchedtext83 = findViewById(R.id.fetchedtext83);
        fetchedtext51 = findViewById(R.id.fetchedtext51);
        fetchedtext6662 = findViewById(R.id.fetchedtext6662);
        fetchedtext1113 = findViewById(R.id.fetchedtext1113);
        fetchedtext103 = findViewById(R.id.fetchedtext103);
        fetchedtext104 = findViewById(R.id.fetchedtext104);
        fetchedtext105 = findViewById(R.id.fetchedtext105);
        fetchedtext4 = findViewById(R.id.fetchedtext41);
        fetchedtext44 = findViewById(R.id.fetchedtext44);
        fetchedtext5 = findViewById(R.id.fetchedtext5);
        fetchedtext52 = findViewById(R.id.fetchedtext52);
        fetchedtext666 = findViewById(R.id.fetchedtext666);
        fetchedtext6665 = findViewById(R.id.fetchedtext6665);
        fetchedtext6664 = findViewById(R.id.fetchedtext6664);
        fetchedtext6663 = findViewById(R.id.fetchedtext6663);
        fetchedtext111 = findViewById(R.id.fetchedtext1111);
        fetchedtext1114 = findViewById(R.id.fetchedtext1114);
        fetchedtext1115 = findViewById(R.id.fetchedtext1115);
        fetchedtext7 = findViewById(R.id.fetchedtext7);
        fetchedtext10 = findViewById(R.id.fetchedtext10);
        fetchedtext75 = findViewById(R.id.fetchedtext75);
        fetchedtext72 = findViewById(R.id.fetchedtext72);
        fetchedtext74 = findViewById(R.id.fetchedtext74);
        fetchedtext82 = findViewById(R.id.fetchedtext82);
        fetchedtext1116 = findViewById(R.id.fetchedtext1116);
        fetchedtext8 = findViewById(R.id.fetchedtext8);
        fetchedtext85 = findViewById(R.id.fetchedtext85);
        fetchedtext84 = findViewById(R.id.fetchedtext84);
        fetchedtext6wp = findViewById(R.id.fetchedtext6wp);
        fetchedtext10 = findViewById(R.id.fetchedtext10);
        fetchedtext42 = findViewById(R.id.fetchedtext42);
        fetchedtext43 = findViewById(R.id.fetchedtext43);
        fetchedtext55 = findViewById(R.id.fetchedtext55);
        fetchedtext54 = findViewById(R.id.fetchedtext54);
        fetchedtext102 = findViewById(R.id.fetchedtext102);
        fetchedtext73 = findViewById(R.id.fetchedtext73);
        fetchedtext45 = findViewById(R.id.fetchedtext45);
        found3 = findViewById(R.id.found3);
        found4 = findViewById(R.id.found4);
        found5 = findViewById(R.id.found5);
        regnum = findViewById(R.id.regnum);
        lang = findViewById(R.id.lang);
        lang4 = findViewById(R.id.lang4);
        lang5 = findViewById(R.id.lang5);
        officea = findViewById(R.id.officea);
        officea2 = findViewById(R.id.officea2);
        dm6 = findViewById(R.id.dm6);
        Dm6 = findViewById(R.id.Dm6);
        dm5 = findViewById(R.id.dm5);
        Dm5 = findViewById(R.id.Dm5);
        verify = findViewById(R.id.verifybtn);
        resulttable.setVisibility(View.INVISIBLE);
        detailcard.setVisibility(View.INVISIBLE);
        rootRef = FirebaseDatabase.getInstance().getReference();
        demoRefnum = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(LoginActivity.username).child("registernumber");
        Query regno = demoRefnum.equalTo(register);
        String demoRefnums = demoRefnum.toString();
        resulttable.setVisibility(View.VISIBLE);
        detailcard.setVisibility(View.VISIBLE);
        if (LoginActivity.username.isEmpty()) {
            ///Toast.makeText(getApplicationContext(), "Empty Field", ///Toast.LENGTH_SHORT).show();

        } else {

            getit();

        }
        String subjects[] = {"SEMESTER I", "SEMESTER II", "SEMESTER III", "SEMESTER IV", "SEMESTER V", "SEMESTER VI"};
        String myString = "1";
        Spinner spinnersub = findViewById(R.id.spinnersubject);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinnerlist, subjects);
        spinnersub.setAdapter(adapter);
        int spinnerPosition = adapter.getPosition(myString);
        spinnersub.setSelection(spinnerPosition);

        spinnersub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        resulttable.setVisibility(View.VISIBLE);
                        resulttable2.setVisibility(View.INVISIBLE);
                        resulttable3.setVisibility(View.INVISIBLE);
                        resulttable4.setVisibility(View.INVISIBLE);
                        resulttable5.setVisibility(View.INVISIBLE);
                        resulttable6.setVisibility(View.INVISIBLE);
                        ovbtn.setVisibility(View.VISIBLE);
                        ovbtn2.setVisibility(View.INVISIBLE);
                        ovbtn3.setVisibility(View.INVISIBLE);
                        ovbtn4.setVisibility(View.INVISIBLE);
                        ovbtn5.setVisibility(View.INVISIBLE);
                        ovbtn6.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        resulttable.setVisibility(View.INVISIBLE);
                        resulttable2.setVisibility(View.VISIBLE);
                        resulttable3.setVisibility(View.INVISIBLE);
                        resulttable4.setVisibility(View.INVISIBLE);
                        resulttable5.setVisibility(View.INVISIBLE);
                        resulttable6.setVisibility(View.INVISIBLE);
                        grade.setText("");
                        percentage.setText("");
                        ovbtn.setVisibility(View.INVISIBLE);
                        ovbtn2.setVisibility(View.VISIBLE);
                        ovbtn3.setVisibility(View.INVISIBLE);
                        ovbtn4.setVisibility(View.INVISIBLE);
                        ovbtn5.setVisibility(View.INVISIBLE);
                        ovbtn6.setVisibility(View.INVISIBLE);

                        break;
                    case 2:
                        resulttable.setVisibility(View.INVISIBLE);
                        resulttable2.setVisibility(View.INVISIBLE);
                        resulttable3.setVisibility(View.VISIBLE);
                        resulttable4.setVisibility(View.INVISIBLE);
                        resulttable5.setVisibility(View.INVISIBLE);
                        resulttable6.setVisibility(View.INVISIBLE);
                        grade.setText("");
                        percentage.setText("");
                        ovbtn.setVisibility(View.INVISIBLE);
                        ovbtn2.setVisibility(View.INVISIBLE);
                        ovbtn3.setVisibility(View.VISIBLE);
                        ovbtn4.setVisibility(View.INVISIBLE);
                        ovbtn5.setVisibility(View.INVISIBLE);
                        ovbtn6.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        resulttable.setVisibility(View.INVISIBLE);
                        resulttable2.setVisibility(View.INVISIBLE);
                        resulttable3.setVisibility(View.INVISIBLE);
                        resulttable4.setVisibility(View.VISIBLE);
                        resulttable5.setVisibility(View.INVISIBLE);
                        resulttable6.setVisibility(View.INVISIBLE);
                        grade.setText("");
                        percentage.setText("");
                        ovbtn.setVisibility(View.INVISIBLE);
                        ovbtn2.setVisibility(View.INVISIBLE);
                        ovbtn3.setVisibility(View.INVISIBLE);
                        ovbtn4.setVisibility(View.INVISIBLE);
                        ovbtn5.setVisibility(View.VISIBLE);
                        ovbtn6.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        resulttable.setVisibility(View.INVISIBLE);
                        resulttable2.setVisibility(View.INVISIBLE);
                        resulttable3.setVisibility(View.INVISIBLE);
                        resulttable4.setVisibility(View.INVISIBLE);
                        resulttable5.setVisibility(View.VISIBLE);
                        resulttable6.setVisibility(View.INVISIBLE);
                        grade.setText("");
                        percentage.setText("");
                        ovbtn.setVisibility(View.INVISIBLE);
                        ovbtn2.setVisibility(View.INVISIBLE);
                        ovbtn3.setVisibility(View.INVISIBLE);
                        ovbtn4.setVisibility(View.INVISIBLE);
                        ovbtn5.setVisibility(View.VISIBLE);
                        ovbtn6.setVisibility(View.INVISIBLE);
                        break;
                    case 5:
                        resulttable.setVisibility(View.INVISIBLE);
                        resulttable2.setVisibility(View.INVISIBLE);
                        resulttable3.setVisibility(View.INVISIBLE);
                        resulttable4.setVisibility(View.INVISIBLE);
                        resulttable5.setVisibility(View.INVISIBLE);
                        resulttable6.setVisibility(View.VISIBLE);
                        grade.setText("");
                        percentage.setText("");
                        ovbtn.setVisibility(View.INVISIBLE);
                        ovbtn2.setVisibility(View.INVISIBLE);
                        ovbtn3.setVisibility(View.INVISIBLE);
                        ovbtn4.setVisibility(View.INVISIBLE);
                        ovbtn5.setVisibility(View.INVISIBLE);
                        ovbtn6.setVisibility(View.VISIBLE);
                        break;
                    default:
                        resulttable.setVisibility(View.INVISIBLE);
                        resulttable2.setVisibility(View.INVISIBLE);
                        resulttable3.setVisibility(View.INVISIBLE);
                        resulttable4.setVisibility(View.INVISIBLE);
                        resulttable5.setVisibility(View.INVISIBLE);
                        resulttable6.setVisibility(View.INVISIBLE);
                        grade.setText("");
                        percentage.setText("");
                        ovbtn.setVisibility(View.INVISIBLE);
                        ovbtn2.setVisibility(View.INVISIBLE);
                        ovbtn3.setVisibility(View.INVISIBLE);
                        ovbtn4.setVisibility(View.INVISIBLE);
                        ovbtn5.setVisibility(View.INVISIBLE);
                        ovbtn6.setVisibility(View.INVISIBLE);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Verified Successfully!", Toast.LENGTH_LONG).show();
                String value = "Verified by Student";

                FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(LoginActivity.username).child("status").setValue(value);

            }
        });

    }


    public static void getit() {


        register = LoginActivity.username;
        final Firebase firebaseRef = new Firebase("https://resultpro-29f21-default-rtdb.firebaseio.com/FirstSem3").child(register).child("registernumber");

///Toast.makeText(getApplicationContext(),register,///Toast.LENGTH_SHORT).show();
        firebaseRef.addListenerForSingleValueEvent(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    /////Toast.makeText(getApplicationContext(), "im in", ///Toast.LENGTH_SHORT).show();
                    cnsverify = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("status");
                    indianlanguage = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("INDIAN LANGUAGE");
                    name = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("name");
                    english = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("ENGLISH");
                    clanguage = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("C LANGUAGE");
                    comporg = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("COMPUTER ORGANISATION");
                    dmr = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("DM");
                    clab = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("C LAB");
                    officear = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("OFFICE AUTOMATION");
                    foundationc = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("FOUNDATION COURSE");
                    cc = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("CCANDEC");
                    demoRefmarks = FirebaseDatabase.getInstance().getReference().child("FirstSem3").child(register).child("registernumber");

/*
                    cnsverify = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("status");
                    indianlang = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("INDIAN LANGUAGE");
                    name = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("name");
                    englishh = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("ENGLISH");
                    ds = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("DATA STRUCTURES");
                    dbms = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("DATABASE MANAGEMENT SYSTEM");
                    nsm = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("NUMERICAL AND STATISTICAL METHODS");
                    dbmslab = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("DATASTRUCTURES USING C LAB");
                    dslab = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("DBMS LAB");
                    foundationcc = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("FOUNDATION COURSE");
                    ecandcc = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("CCANDEC");
                    demoRefmarks = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("registernumber");

                    cnsverify = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("status");
                    indianlangs = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("INDIAN LANGUAGE");
                    name = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("name");
                    englissh = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("ENGLISH");
                    fam = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("C LANGUAGE");
                    os = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("OOPS USING C++");
                    oopsusingc = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("FINANCIAL ACCOUNTING AND SYSTEM");
                    oopsusingclab = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("OPERATING SYSTEM");
                    tallylab = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("OOPS USING C++ LAB");
                    foundationnc = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("TALLY LAB");
                    eccc = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("FOUNDATION COURSE");
                    demoRefmarks = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("CC AND ECr");
                    demoRefmarks = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("registernumber");

                    cnsverify = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("status");
                    il = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("INDIAN LANGUAGE");
                    name = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("name");
                    eng = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("ENGLISH");
                    vbnet = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("VB NET PROGRAMMING");
                    unix = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("UNIX");
                    se = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("SOFTWARE PROGRAMMING");
                    vbnetlab = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("VB NET LAB");
                    unixlab = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("UNIX LAB");
                    skilld = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("SKILL DEVELOPMENT");
                    ecanddcc = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("CCANDEC");
                    demoRefmarks = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("registernumber");



                    cnsverify = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("status");
                    dcn = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("DATA COMMUNICATION AND NETWORK");
                    name = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("name");
                    ai = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("ARTIFICIAL INTELLIGENCE");
                    java = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("JAVA PROGRAMMING");
                    ada = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("ANALYSIS AND DESIGN OF ALGORITHM");
                    elective = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("ELECTIVE 1");
                    adalab = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("JAVA PROGRAMMING LAB");
                    javalab = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("ANALYSIS AND DESIGN OF ALGORITHM LAB");
                    project = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("PROJECT");
                    skillc = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("SKILL DEVELOPMENT COURSE");
                    demoRefmarks = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("registernumber");

                    cnsverify = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("status");
                    sp = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("SYSTEM PROGRAMMING");
                    name = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("name");
                    pbc = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("PROFESSIONAL AND BUSINESS COMMUNICATION");
                    wp = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("WEB PROGRAMMING");
                    elective2 = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("ELECTIVE 2");
                    wplab = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("WEB PROGRAMMING LAB");
                    project = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("PROJECT");
                    skilldevlopment = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("SKILL DEVELOPMENT");
                    demoRefmarks = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("registernumber");

*/
                    demoRefmarks.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot10000) {


                            output10000 = dataSnapshot10000.getValue().toString();

                            if (output10000 != null) {
                                //Set the textview to the output string
                                regnum.setText(output10000);


                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }
                    });

                    name.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot10000) {


                            output100001 = dataSnapshot10000.getValue().toString();

                            if (output10000 != null) {
                                //Set the textview to the output string
                                fetchedtextname.setText(output100001);

                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }
                    });


                    indianlanguage.addListenerForSingleValueEvent(new ValueEventListener() {


                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot111111) {


                            output1 = dataSnapshot111111.getValue().toString();

                            if (output1 != null) {
                                //Set the textview to the output string
                                fetchedtext51.setText(output1);
                                langpercent = Float.parseFloat(output1);
                                String langg = Float.toString(langpercent);

                                comp1.setText(langg);

                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            // ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();
                        }
                    });

                    officear.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot321) {


                            output1x = dataSnapshot321.getValue().toString();

                            if (output1x != null) {
                                //Set the textview to the output string
                                fetchedtext6661.setText(output1x);
                                officepercent = Float.parseFloat(output1x);
                                String off = Float.toString(officepercent);
                                clabpercent111.setText(off);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();
                        }
                    });


                    dmr.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot45) {


                            output1ppp = dataSnapshot45.getValue().toString();

                            if (output1ppp != null) {
                                //Set the textview to the output string
                                officea1.setText(output1ppp);
                                dmpercent = (Float.parseFloat(output1ppp) / 150) * 100;
                                String dms = Float.toString(dmpercent);
                                officepercentage1.setText(dms);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();
                        }
                    });


                    english.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot10) {


                            output4 = dataSnapshot10.getValue().toString();
                            if (output4 != null) {

                                //Set the textview to the output string

                                fetchedtext1111.setText(output4);
                                englishpercentage = Float.parseFloat(output4);
                                String eng = Float.toString(englishpercentage);
                                lang1.setText(eng);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }
                    });
                    clanguage.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot5) {


                            output5 = dataSnapshot5.getValue().toString();

                            if (output5 != null) {
                                //Set the textview to the output string

                                fetchedtext41.setText(output5);
                                cpercentage = Float.parseFloat(output5);
                                String cp = Float.toString(cpercentage);
                                English1.setText(cp);

                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                    comporg.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot555) {


                            output10055 = dataSnapshot555.getValue().toString();

                            if (output10055 != null) {
                                //Set the textview to the output string

                                fetchedtext101.setText(output10055);
                                comppercentage = Float.parseFloat(output10055);
                                String com = Float.toString(comppercentage);
                                cl1.setText(com);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }
                    });


                    clab.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot666) {


                            output666 = dataSnapshot666.getValue().toString();
                            if (output666 != null) {

                                //Set the textview to the output string

                                dm1.setText(output666);
                                clab1 = (Float.parseFloat(output666) / 50) * 100;
                                String cll = Float.toString(clab1);
                                Dm1.setText(cll);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }
                    });


                    foundationc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot7) {


                            output7 = dataSnapshot7.getValue().toString();

                            if (output7 != null) {
                                //Set the textview to the output string

                                fetchedtext7.setText(output7);
                                foundationpercent = Float.parseFloat(output7);
                                String foundd = Float.toString(foundationpercent);
                                found.setText(foundd);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }
                    });


                    cc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output8 = dataSnapshot8.getValue().toString();

                            if (output8 != null) {
                                //Set the textview to the output string

                                fetchedtext8.setText(output8);
                                cccc = (Float.parseFloat(output8) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();


                        }
                    });
                }
            }


            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        final Firebase firebaseRef2 = new Firebase("https://resultpro-29f21-default-rtdb.firebaseio.com/secondsem").child(register).child("registernumber");

///Toast.makeText(getApplicationContext(),register,///Toast.LENGTH_SHORT).show();
        firebaseRef2.addListenerForSingleValueEvent(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    cnsverify = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("status");
                    indianlang = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("INDIAN LANGUAGE");
                    name = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("name");
                    englishh = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("ENGLISH");
                    ds = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("Data Structures");
                    dbms = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("DATABASE MANAGEMENT SYSTEM");
                    nsm = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("NUMERICAL AND STATISTICAL METHODS");
                    dbmslab = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("DATASTRUCTURES USING C LAB");
                    dslab = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("DBMS LAB");
                    foundationcc = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("FOUNDATION COURSE");
                    ecandcc = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("CCANDEC");
                    demoRefmarks = FirebaseDatabase.getInstance().getReference().child("secondsem").child(register).child("registernumber");


                    indianlang.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output82 = dataSnapshot8.getValue().toString();

                            if (output82 != null) {
                                //Set the textview to the output string

                                fetchedtext52.setText(output82);
                                langpercent2 = Float.parseFloat(output82);
                                 String ccc = Float.toString(langpercent2);
                                 comp2.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });


                    englishh.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {


                            output8456 = dataSnapshot1.getValue().toString();

                            if (output8456 != null) {
                                //Set the textview to the output string

                                fetchedtext1112.setText(output8456);
                                   cccc = Float.parseFloat(output8456);
                                 String ccc = Float.toString(cccc);
                                     lang2.setText(ccc);
                            } else {
                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });


                    ds.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot810) {


                            output833 = dataSnapshot810.getValue().toString();

                            if (output833 != null) {
                                //Set the textview to the output string

                                fetchedtext42.setText(output833);
                                cpercentage2 = Float.parseFloat(output833);
                                 String cp2 = Float.toString(cpercentage2);
                                 English2.setText(cp2);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });


                    dbms.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output83 = dataSnapshot8.getValue().toString();

                            if (output83 != null) {
                                //Set the textview to the output string

                                fetchedtext102.setText(output83);
                                   cccc = Float.parseFloat(output83) ;
                                 String cclc = Float.toString(cccc);
                                 cl2.setText(cclc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    nsm.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output822 = dataSnapshot8.getValue().toString();

                            if (output822 != null) {
                                //Set the textview to the output string

                                officea2.setText(output822);
                                 cccc = (Float.parseFloat(output822)/150)*100;
                                   String ccc = Float.toString(cccc);
                                 officepercentage2.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    dbmslab.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output823 = dataSnapshot8.getValue().toString();

                            if (output823 != null) {
                                //Set the textview to the output string

                                fetchedtext6662.setText(output823);
                                cccc = (Float.parseFloat(output823) / 50) * 100;
                                  String ccc = Float.toString(cccc);
                                 clabpercent112.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    dslab.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output824 = dataSnapshot8.getValue().toString();

                            if (output824 != null) {
                                //Set the textview to the output string

                                dm2.setText(output824);
                                cccc = (Float.parseFloat(output824) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                 Dm2.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    foundationcc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output825 = dataSnapshot8.getValue().toString();

                            if (output825 != null) {
                                //Set the textview to the output string

                                fetchedtext72.setText(output825);
                                   cccc = Float.parseFloat(output825);
                                String ccc = Float.toString(cccc);
                                  found2.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    ecandcc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output826 = dataSnapshot8.getValue().toString();

                            if (output826 != null) {
                                //Set the textview to the output string

                                fetchedtext82.setText(output826);
                                cccc = (Float.parseFloat(output826) / 50) * 100;
                                  String ccc = Float.toString(cccc);
                                ccnec2.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

/*
                    indianlangs.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext54.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    englissh.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext1114.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    fam.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext44.setText(output84);
                                cccc = (Float.parseFloat(output8) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    os.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext104.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    oopsusingc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                officea4.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    oopsusingclab.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                dm4.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    tallylab.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext6664.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    foundationnc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext74.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    eccc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext84.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    dcn.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output85 = dataSnapshot8.getValue().toString();

                            if (output85 != null) {
                                //Set the textview to the output string

                                fetchedtext55.setText(output85);
                                cccc = (Float.parseFloat(output85) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    ai.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output85 = dataSnapshot8.getValue().toString();

                            if (output85 != null) {
                                //Set the textview to the output string

                                fetchedtext1115.setText(output85);
                                cccc = (Float.parseFloat(output85) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    java.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output85 = dataSnapshot8.getValue().toString();

                            if (output85 != null) {
                                //Set the textview to the output string

                                fetchedtext45.setText(output85);
                                cccc = (Float.parseFloat(output85) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    ada.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output85 = dataSnapshot8.getValue().toString();

                            if (output85 != null) {
                                //Set the textview to the output string

                                fetchedtext105.setText(output85);
                                cccc = (Float.parseFloat(output85) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    elective.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output85 = dataSnapshot8.getValue().toString();

                            if (output85 != null) {
                                //Set the textview to the output string

                                officea5.setText(output85);
                                cccc = (Float.parseFloat(output85) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    adalab.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output85 = dataSnapshot8.getValue().toString();

                            if (output85 != null) {
                                //Set the textview to the output string

                                dm5.setText(output85);
                                cccc = (Float.parseFloat(output85) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    javalab.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output85 = dataSnapshot8.getValue().toString();

                            if (output85 != null) {
                                //Set the textview to the output string

                                fetchedtext6665.setText(output85);
                                cccc = (Float.parseFloat(output85) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    project.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output85 = dataSnapshot8.getValue().toString();

                            if (output85 != null) {
                                //Set the textview to the output string

                                fetchedtext75.setText(output85);
                                cccc = (Float.parseFloat(output85) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    skillc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output8 = dataSnapshot8.getValue().toString();

                            if (output85 != null) {
                                //Set the textview to the output string

                                fetchedtext85.setText(output85);
                                cccc = (Float.parseFloat(output85) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    sp.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output86 = dataSnapshot8.getValue().toString();

                            if (output86 != null) {
                                //Set the textview to the output string

                                fetchedtext5.setText(output86);
                                cccc = (Float.parseFloat(output86) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    pbc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output86 = dataSnapshot8.getValue().toString();

                            if (output86 != null) {
                                //Set the textview to the output string

                                fetchedtext1116.setText(output86);
                                cccc = (Float.parseFloat(output86) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    wp.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output86 = dataSnapshot8.getValue().toString();

                            if (output86 != null) {
                                //Set the textview to the output string

                                fetchedtext6wp.setText(output86);
                                cccc = (Float.parseFloat(output86) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    elective2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output86 = dataSnapshot8.getValue().toString();

                            if (output86 != null) {
                                //Set the textview to the output string

                                fetchedtext10.setText(output86);
                                cccc = (Float.parseFloat(output86) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    wplab.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output8 = dataSnapshot8.getValue().toString();

                            if (output86 != null) {
                                //Set the textview to the output string

                                officea.setText(output86);
                                cccc = (Float.parseFloat(output86) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    projectt.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output86 = dataSnapshot8.getValue().toString();

                            if (output86 != null) {
                                //Set the textview to the output string

                                dm.setText(output86);
                                cccc = (Float.parseFloat(output86) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                Dm.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    skilldevlopment.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output86 = dataSnapshot8.getValue().toString();

                            if (output8 != null) {
                                //Set the textview to the output string

                                fetchedtext666.setText(output86);
                                cccc = (Float.parseFloat(output86) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });







                } else {

                    ///Toast.makeText(getApplicationContext(),"Invalid Register Number",///Toast.LENGTH_SHORT).show();


                }


            }


            @Override
            public void onCancelled(FirebaseError firebaseError) {
                ///Toast.makeText(getApplicationContext(),"Invalid Register Number",///Toast.LENGTH_SHORT).show();
            }

        });*/

        final Firebase firebaseRef3 = new Firebase("https://resultpro-29f21-default-rtdb.firebaseio.com/thirdsem").child(register).child("registernumber");

///Toast.makeText(getApplicationContext(),register,///Toast.LENGTH_SHORT).show();
        firebaseRef3.addListenerForSingleValueEvent(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    cnsverify = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("status");
                    indianlangs = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("INDIAN LANGUAGE");
                    name = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("name");
                    englissh = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("ENGLISH");
                    fam = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("FINANCIAL ACCOUNTING AND SYSTEM");
                    //os = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("");
                    oopsusingc = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("OOPS USING C++");
                    os = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("OPERATING SYSTEM");
                    oopsusingclab = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("OOPS USING C++ LAB");
                    tallylab = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("TALLY LAB");
                    eccc = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("CC AND EC");
                    //  demoRefmarks = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("CC AND ECr");
                    //  demoRefmarks = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("registernumber");
                    foundationnc = FirebaseDatabase.getInstance().getReference().child("thirdsem").child(register).child("FOUNDATION COURSE");

                    indianlangs.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext53.setText(output84);
                                cccc = Float.parseFloat(output84);
                                String ccc = Float.toString(cccc);
                                comp3.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    englissh.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext1113.setText(output84);
                                cccc = Float.parseFloat(output84);
                                String ccc = Float.toString(cccc);
                                lang3.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    fam.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot812) {


                            output84222 = dataSnapshot812.getValue().toString();

                            if (output84222 != null) {
                                //Set the textview to the output string

                                fetchedtext103.setText(output84222);
                                cccc = Float.parseFloat(output84222);
                                String ccc = Float.toString(cccc);
                                cl3.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    os.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                officea3.setText(output84);
                                cccc = (Float.parseFloat(output84)/150)*100;
                                String ccc = Float.toString(cccc);
                                officepercentage3.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    oopsusingc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext43.setText(output84);
                                cccc = Float.parseFloat(output84);
                                String ccc = Float.toString(cccc);
                                English303.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    oopsusingclab.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                dm3.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                English3.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    tallylab.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext6663.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                clabpercent113.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    foundationnc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext73.setText(output84);
                                cccc = Float.parseFloat(output84);
                                String ccc = Float.toString(cccc);
                                found3.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });

                    eccc.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                            output84 = dataSnapshot8.getValue().toString();

                            if (output84 != null) {
                                //Set the textview to the output string

                                fetchedtext83.setText(output84);
                                cccc = (Float.parseFloat(output84) / 50) * 100;
                                String ccc = Float.toString(cccc);
                                ccnec3.setText(ccc);
                            } else {


                                ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                            }
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                        }


                    });


                    final Firebase firebaseRef4 = new Firebase("https://resultpro-29f21-default-rtdb.firebaseio.com/fourthsem").child(register).child("registernumber");

///Toast.makeText(getApplicationContext(),register,///Toast.LENGTH_SHORT).show();
                    firebaseRef4.addListenerForSingleValueEvent(new com.firebase.client.ValueEventListener() {
                        @Override
                        public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                cnsverify = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("status");
                                il = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("INDIAN LANGUAGE");
                                name = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("name");
                                eng = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("ENGLISH");
                                vbnet = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("VB NET PROGRAMMING");
                                unix = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("UNIX");
                                se = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("SOFTWARE PROGRAMMING");
                                vbnetlab = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("VB NET LAB");
                                unixlab = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("UNIX LAB");
                                skilld = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("SKILL DEVELOPMENT");
                                ecanddcc = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("CC AND EC");
                                demoRefmarks = FirebaseDatabase.getInstance().getReference().child("fourthsem").child(register).child("registernumber");


                                il.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                        output84 = dataSnapshot8.getValue().toString();

                                        if (output84 != null) {
                                            //Set the textview to the output string

                                            fetchedtext54.setText(output84);
                                            cccc = Float.parseFloat(output84);
                                            String ccc = Float.toString(cccc);
                                            comp4.setText(ccc);
                                        } else {


                                            ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                        }
                                    }


                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                    }


                                });

                                eng.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                        output84 = dataSnapshot8.getValue().toString();

                                        if (output84 != null) {
                                            //Set the textview to the output string

                                            fetchedtext1114.setText(output84);
                                            cccc = Float.parseFloat(output84);
                                            String ccc = Float.toString(cccc);
                                            lang4.setText(ccc);
                                        } else {


                                            ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                        }
                                    }


                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                    }


                                });

                                vbnet.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot812) {


                                        output84222 = dataSnapshot812.getValue().toString();

                                        if (output84222 != null) {
                                            //Set the textview to the output string

                                            fetchedtext44.setText(output84222);
                                            cccc = Float.parseFloat(output84222);
                                            String ccc = Float.toString(cccc);
                                            English4.setText(ccc);
                                        } else {


                                            ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                        }
                                    }


                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                    }


                                });

                                unix.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                        output84 = dataSnapshot8.getValue().toString();

                                        if (output84 != null) {
                                            //Set the textview to the output string

                                            fetchedtext104.setText(output84);
                                            cccc = Float.parseFloat(output84);
                                            String ccc = Float.toString(cccc);
                                            cl4.setText(ccc);
                                        } else {


                                            ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                        }
                                    }


                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                    }


                                });

                                se.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                        output84 = dataSnapshot8.getValue().toString();

                                        if (output84 != null) {
                                            //Set the textview to the output string

                                            officea4.setText(output84);
                                            cccc = (Float.parseFloat(output84)/150)* 100;
                                            String ccc = Float.toString(cccc);
                                            officepercentage4.setText(ccc);
                                        } else {


                                            ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                        }
                                    }


                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                    }


                                });

                                vbnetlab.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                        output84 = dataSnapshot8.getValue().toString();

                                        if (output84 != null) {
                                            //Set the textview to the output string

                                            dm4.setText(output84);
                                            cccc = (Float.parseFloat(output84) / 50) * 100;
                                            String ccc = Float.toString(cccc);
                                            Dm4.setText(ccc);
                                        } else {


                                            ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                        }
                                    }


                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                    }


                                });

                                unixlab.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                        output84 = dataSnapshot8.getValue().toString();

                                        if (output84 != null) {
                                            //Set the textview to the output string

                                            fetchedtext6664.setText(output84);
                                            cccc = (Float.parseFloat(output84) / 50) * 100;
                                            String ccc = Float.toString(cccc);
                                            clabpercent114.setText(ccc);
                                        } else {


                                            ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                        }
                                    }


                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                    }


                                });

                                skilld.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                        output84 = dataSnapshot8.getValue().toString();

                                        if (output84 != null) {
                                            //Set the textview to the output string

                                            fetchedtext74.setText(output84);
                                            cccc = Float.parseFloat(output84);
                                            String ccc = Float.toString(cccc);
                                            found4.setText(ccc);
                                        } else {


                                            ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                        }
                                    }


                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                    }


                                });

                                ecanddcc.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                        output84 = dataSnapshot8.getValue().toString();

                                        if (output84 != null) {
                                            //Set the textview to the output string

                                            fetchedtext84.setText(output84);
                                            cccc = (Float.parseFloat(output84) / 50) * 100;
                                            String ccc = Float.toString(cccc);
                                            ccnec4.setText(ccc);
                                        } else {


                                            ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                        }
                                    }


                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                        ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                    }


                                });


                                final Firebase firebaseRef5 = new Firebase("https://resultpro-29f21-default-rtdb.firebaseio.com/fifthsem").child(register).child("registernumber");

///Toast.makeText(getApplicationContext(),register,///Toast.LENGTH_SHORT).show();
                                firebaseRef5.addListenerForSingleValueEvent(new com.firebase.client.ValueEventListener() {
                                    @Override
                                    public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()) {
                                            cnsverify = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("status");
                                            dcn = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("DATA COMMUNICATION AND NETWORK");
                                            name = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("name");
                                            ai = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("ARTIFICIAL INTELLIGENCE");
                                            java = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("JAVA PROGRAMMING");
                                            ada = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("ANALYSIS AND DESIGN OF ALGORITHM");
                                            elective = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("ELECTIVE 1");
                                            adalab = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("JAVA PROGRAMMING LAB");
                                            javalab = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("ANALYSIS AND DESIGN OF ALGORITHM LAB");
                                            project = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("PROJECT");
                                            skillc = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("SKILL DEVELOPMENT COURSE");
                                            demoRefmarks = FirebaseDatabase.getInstance().getReference().child("fifthsem").child(register).child("registernumber");

                                            dcn.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                    output85 = dataSnapshot8.getValue().toString();

                                                    if (output85 != null) {
                                                        //Set the textview to the output string

                                                        fetchedtext55.setText(output85);
                                                        cccc = (Float.parseFloat(output85)/150)*100;
                                                        String ccc = Float.toString(cccc);
                                                        comp5.setText(ccc);
                                                    } else {


                                                        ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                    }
                                                }


                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {
                                                    ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                }


                                            });

                                            ai.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                    output85 = dataSnapshot8.getValue().toString();

                                                    if (output85 != null) {
                                                        //Set the textview to the output string

                                                        fetchedtext1115.setText(output85);
                                                        cccc = (Float.parseFloat(output85) / 150) * 100;
                                                        String ccc = Float.toString(cccc);
                                                        lang5.setText(ccc);
                                                    } else {


                                                        ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                    }
                                                }


                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {
                                                    ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                }


                                            });

                                            java.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                    output85 = dataSnapshot8.getValue().toString();

                                                    if (output85 != null) {
                                                        //Set the textview to the output string

                                                        fetchedtext45.setText(output85);
                                                        cccc = Float.parseFloat(output85);
                                                        String ccc = Float.toString(cccc);
                                                        English5.setText(ccc);
                                                    } else {


                                                        ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                    }
                                                }


                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {
                                                    ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                }


                                            });

                                            ada.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                    output85 = dataSnapshot8.getValue().toString();

                                                    if (output85 != null) {
                                                        //Set the textview to the output string

                                                        fetchedtext105.setText(output85);
                                                        cccc = (Float.parseFloat(output85) / 150) * 100;
                                                        String ccc = Float.toString(cccc);
                                                        cl5.setText(ccc);
                                                    } else {


                                                        ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                    }
                                                }


                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {
                                                    ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                }


                                            });

                                            elective.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                    output85 = dataSnapshot8.getValue().toString();

                                                    if (output85 != null) {
                                                        //Set the textview to the output string

                                                        officea5.setText(output85);
                                                        cccc = Float.parseFloat(output85);
                                                        String ccc = Float.toString(cccc);
                                                        officepercentage5.setText(ccc);
                                                    } else {


                                                        ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                    }
                                                }


                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {
                                                    ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                }


                                            });

                                            adalab.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                    output85 = dataSnapshot8.getValue().toString();

                                                    if (output85 != null) {
                                                        //Set the textview to the output string

                                                        fetchedtext6665.setText(output85);
                                                        cccc = (Float.parseFloat(output85) / 50) * 100;
                                                        String ccc = Float.toString(cccc);
                                                        clabpercent115.setText(ccc);
                                                    } else {


                                                        ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                    }
                                                }


                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {
                                                    ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                }


                                            });

                                            javalab.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                    output85 = dataSnapshot8.getValue().toString();

                                                    if (output85 != null) {
                                                        //Set the textview to the output string

                                                        dm5.setText(output85);
                                                        cccc = (Float.parseFloat(output85) / 50) * 100;
                                                        String ccc = Float.toString(cccc);
                                                        Dm5.setText(ccc);
                                                    } else {


                                                        ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                    }
                                                }


                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {
                                                    ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                }


                                            });

                                            project.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                    output85 = dataSnapshot8.getValue().toString();

                                                    if (output85 != null) {
                                                        //Set the textview to the output string

                                                        fetchedtext75.setText(output85);
                                                        cccc = (Float.parseFloat(output85) / 150) * 100;
                                                        String ccc = Float.toString(cccc);
                                                        found5.setText(ccc);
                                                    } else {


                                                        ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                    }
                                                }


                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {
                                                    ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                }


                                            });

                                            skillc.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                    output8 = dataSnapshot8.getValue().toString();

                                                    if (output85 != null) {
                                                        //Set the textview to the output string

                                                        fetchedtext85.setText(output85);
                                                        cccc = Float.parseFloat(output85);
                                                        String ccc = Float.toString(cccc);
                                                        ccnec5.setText(ccc);
                                                    } else {


                                                        ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                    }
                                                }


                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {
                                                    ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                }


                                            });


                                            final Firebase firebaseRef6 = new Firebase("https://resultpro-29f21-default-rtdb.firebaseio.com/sixthsem").child(register).child("registernumber");

///Toast.makeText(getApplicationContext(),register,///Toast.LENGTH_SHORT).show();
                                            firebaseRef6.addListenerForSingleValueEvent(new com.firebase.client.ValueEventListener() {
                                                @Override
                                                public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                                                    if (dataSnapshot.exists()) {
                                                        cnsverify = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("status");
                                                        sp = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("SYSTEM PROGRAMMING");
                                                        name = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("name");
                                                        pbc = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("PROFESSIONAL AND BUSINESS COMMUNICATION");
                                                        wp = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("WEB PROGRAMMING");
                                                        elective2 = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("ELECTIVE 2");
                                                        wplab = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("WEB PROGRAMMING LAB");
                                                        project = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("PROJECT");
                                                        skilldevlopment = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("SKILL DEVELOPMENT");
                                                        demoRefmarks = FirebaseDatabase.getInstance().getReference().child("sixthsem").child(register).child("registernumber");

                                                        sp.addListenerForSingleValueEvent(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                                output86 = dataSnapshot8.getValue().toString();

                                                                if (output86 != null) {
                                                                    //Set the textview to the output string

                                                                    fetchedtext5.setText(output86);
                                                                    cccc = Float.parseFloat(output86);
                                                                    String ccc = Float.toString(cccc);
                                                                    comp.setText(ccc);
                                                                } else {


                                                                    ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                                }
                                                            }


                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {
                                                                ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                            }


                                                        });

                                                        pbc.addListenerForSingleValueEvent(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                                output86 = dataSnapshot8.getValue().toString();

                                                                if (output86 != null) {
                                                                    //Set the textview to the output string

                                                                    fetchedtext1116.setText(output86);
                                                                    cccc = (Float.parseFloat(output86) / 150) * 100;
                                                                    String ccc = Float.toString(cccc);
                                                                    lang.setText(ccc);
                                                                } else {


                                                                    ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                                }
                                                            }


                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {
                                                                ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                            }


                                                        });

                                                        wp.addListenerForSingleValueEvent(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                                output86 = dataSnapshot8.getValue().toString();

                                                                if (output86 != null) {
                                                                    //Set the textview to the output string

                                                                    fetchedtext6wp.setText(output86);
                                                                    cccc = Float.parseFloat(output86);
                                                                    String ccc = Float.toString(cccc);
                                                                    English.setText(ccc);
                                                                } else {


                                                                    ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                                }
                                                            }


                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {
                                                                ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                            }


                                                        });

                                                        elective2.addListenerForSingleValueEvent(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                                output86 = dataSnapshot8.getValue().toString();

                                                                if (output86 != null) {
                                                                    //Set the textview to the output string

                                                                    fetchedtext10.setText(output86);
                                                                    cccc = (Float.parseFloat(output86) / 50) * 100;
                                                                    String ccc = Float.toString(cccc);
                                                                    cl.setText(ccc);
                                                                } else {


                                                                    ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                                }
                                                            }


                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {
                                                                ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                            }


                                                        });

                                                        wplab.addListenerForSingleValueEvent(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                                output8 = dataSnapshot8.getValue().toString();

                                                                if (output86 != null) {
                                                                    //Set the textview to the output string

                                                                    officea.setText(output86);
                                                                    cccc = (Float.parseFloat(output86) / 50) * 100;
                                                                    String ccc = Float.toString(cccc);
                                                                    officepercentage.setText(ccc);
                                                                } else {


                                                                    ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                                }
                                                            }


                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {
                                                                ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                            }


                                                        });

                                                        project.addListenerForSingleValueEvent(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                                output86 = dataSnapshot8.getValue().toString();

                                                                if (output86 != null) {
                                                                    //Set the textview to the output string

                                                                    dm6.setText(output86);
                                                                    cccc = (Float.parseFloat(output86) / 100) * 100;
                                                                    String ccc = Float.toString(cccc);
                                                                    Dm6.setText(ccc);
                                                                } else {


                                                                    ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                                }
                                                            }


                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {
                                                                ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                            }


                                                        });

                                                        skilldevlopment.addListenerForSingleValueEvent(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot8) {


                                                                output86 = dataSnapshot8.getValue().toString();

                                                                if (output8 != null) {
                                                                    //Set the textview to the output string

                                                                    fetchedtext666.setText(output86);
                                                                    cccc = Float.parseFloat(output86);
                                                                    String ccc = Float.toString(cccc);
                                                                    clabpercent11.setText(ccc);
                                                                } else {


                                                                    ///Toast.makeText(getApplicationContext(), "Invalid register number", ///Toast.LENGTH_SHORT).show();

                                                                }
                                                            }


                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {
                                                                ///Toast.makeText(getApplicationContext(), "Please Enter Correct Register number", ///Toast.LENGTH_SHORT).show();

                                                            }


                                                        });


                                                    } else {

                                                        ///Toast.makeText(getApplicationContext(),"Invalid Register Number",///Toast.LENGTH_SHORT).show();


                                                    }


                                                }


                                                @Override
                                                public void onCancelled(FirebaseError firebaseError) {
                                                    ///Toast.makeText(getApplicationContext(),"Invalid Register Number",///Toast.LENGTH_SHORT).show();
                                                }

                                            });
                                            ovbtn.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    float overall = ((Float.parseFloat(comp1.getText().toString()) + Float.parseFloat(clabpercent111.getText().toString()) + Float.parseFloat(officepercentage1.getText().toString()) + Float.parseFloat(lang1.getText().toString()) + Float.parseFloat(English1.getText().toString()) + Float.parseFloat(cl1.getText().toString()) + Float.parseFloat(Dm1.getText().toString()) + Float.parseFloat(found.getText().toString()) + Float.parseFloat(ccnec.getText().toString())) / 9);
                                                    String s = String.format("%.2f",overall);
                                                    percentage.setText(s + " %");


                                                    if (overall > 90) {

                                                        grade.setText("O-outstanding");


                                                    } else if (overall > 80 && overall < 90) {

                                                        grade.setText("A+ Exemplary");

                                                    } else if (overall > 70 && overall < 80) {

                                                        grade.setText("A First Class Distinction");

                                                    } else if (overall > 60 && overall < 70) {

                                                        grade.setText("B+");

                                                    } else if (overall > 50 && overall < 60) {

                                                        grade.setText("B");

                                                    }


                                                }

                                            });



                                            ovbtn2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    float overall = ((Float.parseFloat(comp2.getText().toString()) + Float.parseFloat(lang2.getText().toString()) + Float.parseFloat(English2.getText().toString()) + Float.parseFloat(cl2.getText().toString()) + Float.parseFloat(officepercentage2.getText().toString()) + Float.parseFloat(clabpercent112.getText().toString()) + Float.parseFloat(Dm2.getText().toString()) + Float.parseFloat(found2.getText().toString()) + Float.parseFloat(ccnec2.getText().toString())) / 9);
                                                    String s = String.format("%.2f", overall);
                                                    percentage.setText(s + " %");


                                                    if (overall > 90) {

                                                        grade.setText("O-outstanding");


                                                    } else if (overall > 80 && overall < 90) {

                                                        grade.setText("A+ Exemplary");

                                                    } else if (overall > 70 && overall < 80) {

                                                        grade.setText("A First Class Distinction");

                                                    } else if (overall > 60 && overall < 70) {

                                                        grade.setText("B+");

                                                    } else if (overall > 50 && overall < 60) {

                                                        grade.setText("B");

                                                    }


                                                }

                                            });




                                            ovbtn3.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    float overall = ((Float.parseFloat(lang3.getText().toString()) + Float.parseFloat(English303.getText().toString()) + Float.parseFloat(comp3.getText().toString())+Float.parseFloat(English3.getText().toString()) + Float.parseFloat(ccnec3.getText().toString()) + Float.parseFloat(found3.getText().toString()) + Float.parseFloat(officepercentage3.getText().toString()) + Float.parseFloat(Dm3.getText().toString()) + Float.parseFloat(clabpercent113.getText().toString())) / 9);
                                                    String s = String.format("%.2f", overall);
                                                    percentage.setText(s + " %");


                                                    if (overall > 90) {

                                                        grade.setText("O-outstanding");


                                                    } else if (overall > 80 && overall < 90) {

                                                        grade.setText("A+ Exemplary");

                                                    } else if (overall > 70 && overall < 80) {

                                                        grade.setText("A First Class Distinction");

                                                    } else if (overall > 60 && overall < 70) {

                                                        grade.setText("B+");

                                                    } else if (overall > 50 && overall < 60) {

                                                        grade.setText("B");

                                                    }


                                                }

                                            });





                                            ovbtn4.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    float overall = Float.parseFloat(ccnec4.getText().toString())+((Float.parseFloat(lang4.getText().toString()) + Float.parseFloat(English4.getText().toString()) + Float.parseFloat(comp4.getText().toString()) + Float.parseFloat(cl4.getText().toString()) + Float.parseFloat(found4.getText().toString()) + Float.parseFloat(officepercentage4.getText().toString()) + Float.parseFloat(Dm4.getText().toString()) + Float.parseFloat(clabpercent114.getText().toString())) / 9);
                                                    String s = String.format("%.2f", overall);
                                                    percentage.setText(s + " %");


                                                    if (overall > 90) {

                                                        grade.setText("O-outstanding");


                                                    } else if (overall > 80 && overall < 90) {

                                                        grade.setText("A+ Exemplary");

                                                    } else if (overall > 70 && overall < 80) {

                                                        grade.setText("A First Class Distinction");

                                                    } else if (overall > 60 && overall < 70) {

                                                        grade.setText("B+");

                                                    } else if (overall > 50 && overall < 60) {

                                                        grade.setText("B");

                                                    }


                                                }

                                            });



                                            ovbtn5.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    float overall = ((Float.parseFloat(lang5.getText().toString()) + Float.parseFloat(English5.getText().toString()) + Float.parseFloat(comp5.getText().toString()) + Float.parseFloat(ccnec5.getText().toString()) + Float.parseFloat(found5.getText().toString()) + Float.parseFloat(cl5.getText().toString()) + Float.parseFloat(officepercentage5.getText().toString()) + Float.parseFloat(Dm5.getText().toString()) + Float.parseFloat(clabpercent115.getText().toString())) / 9);
                                                    String s = String.format("%.2f", overall);
                                                    percentage.setText(s + " %");


                                                    if (overall > 90) {

                                                        grade.setText("O-outstanding");


                                                    } else if (overall > 80 && overall < 90) {

                                                        grade.setText("A+ Exemplary");

                                                    } else if (overall > 70 && overall < 80) {

                                                        grade.setText("A First Class Distinction");

                                                    } else if (overall > 60 && overall < 70) {

                                                        grade.setText("B+");

                                                    } else if (overall > 50 && overall < 60) {

                                                        grade.setText("B");

                                                    }


                                                }

                                            });


                                            ovbtn6.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    float overall = ((Float.parseFloat(lang.getText().toString()) + Float.parseFloat(English.getText().toString()) + Float.parseFloat(comp.getText().toString()) + Float.parseFloat(cl.getText().toString()) + Float.parseFloat(officepercentage.getText().toString())   + Float.parseFloat(Dm6.getText().toString()) + Float.parseFloat(clabpercent11.getText().toString())) / 7);
                                                    String s = String.format("%.2f", overall);
                                                    percentage.setText(s + " %");


                                                    if (overall > 90) {

                                                        grade.setText("O-outstanding");


                                                    } else if (overall > 80 && overall < 90) {

                                                        grade.setText("A+ Exemplary");

                                                    } else if (overall > 70 && overall < 80) {

                                                        grade.setText("A First Class Distinction");

                                                    } else if (overall > 60 && overall < 70) {

                                                        grade.setText("B+");

                                                    } else if (overall > 50 && overall < 60) {

                                                        grade.setText("B");

                                                    }


                                                }

                                            });

                                        }
                                    }

                                    @Override
                                    public void onCancelled(FirebaseError firebaseError) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}












