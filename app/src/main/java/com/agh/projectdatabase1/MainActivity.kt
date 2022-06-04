package com.agh.projectdatabase1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtge = findViewById<TextView>(R.id.txtge)
        val radiog = findViewById<RadioGroup>(R.id.radiog)
        val btnsub = findViewById<Button>(R.id.btn_submit)
        val btngo = findViewById<Button>(R.id.btn_golist)
        val radiom = findViewById<RadioButton>(R.id.radio_men)
        val radiow = findViewById<RadioButton>(R.id.radio_women)
        val edtlfname = findViewById<EditText>(R.id.edt_txtlfname)
        val edtphone = findViewById<EditText>(R.id.edt_txtphone)

        radiog.setOnCheckedChangeListener { group, checkedId ->
            if (radiom.isChecked) {
                txtge.setText(radiom.text)
            } else {
                if (radiow.isChecked) {
                    txtge.setText(radiow.text)
                }
            }
        }

        btnsub.setOnClickListener {

            if (edtlfname.text.toString().equals("") || edtphone.text.toString().equals("")){

                Toast.makeText(
                    getApplicationContext(),
                    "تمام فیلد ها را پر کنید",
                    Toast.LENGTH_LONG
                ).show();

            } else if (edtphone.text.length != 11 || !edtphone.text.startsWith("09")) {

                Toast.makeText(getApplicationContext(), "شماره تلفن صحیح نیست!", Toast.LENGTH_LONG)
                    .show();

            } else if (radiog.checkedRadioButtonId == -1) {

                Toast.makeText(getApplicationContext(), "جنسیت خود را مشخص کنید", Toast.LENGTH_LONG)
                    .show();

            }else{

                val db = AppDatabase(this)
                var existph = db.phonedao().findByTitle(edtphone.text.toString())
                if (existph==null){

                    var ph:phone= phone(edtphone.text.toString(), edtlfname.text.toString(), txtge.text.toString())
                    db.phonedao().insertAll(ph)
                    Toast.makeText(getApplicationContext(), "با موفقیت ثبت شد :)", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext(), "این شماره قبلا ثبت شده است :(", Toast.LENGTH_LONG).show();
                }

            }

        }



        btngo.setOnClickListener {

            val intent:Intent= Intent(this, Activitylistph::class.java)
            startActivity(intent)


        }







    }
}