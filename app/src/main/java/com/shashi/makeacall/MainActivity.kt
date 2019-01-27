package com.shashi.makeacall

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.webkit.URLUtil
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun callNumber(view: View){
        val i = Intent()
        i.action = Intent.ACTION_DIAL
        var phNo = et1.getText().toString()!!
        if(phNo.isNotEmpty()){
            i.data = Uri.parse("tel:"+phNo)
            startActivity(i)
            Toast.makeText(applicationContext,"Trying to Call:- $phNo",Toast.LENGTH_SHORT).show()
        }
        else{
            tvMsg.text = "Please ENter the valid Phone Number!"
            Toast.makeText(applicationContext,"Invalid Phone Number!" ,Toast.LENGTH_SHORT).show()
        }
    }
    fun browseUrl(view: View){
        val i = Intent()
        i.action = Intent.ACTION_VIEW
        //i.type = "text/plain"
        var urlAdd = et2.text.toString()
        if(urlAdd.isNotEmpty()){
            if(!URLUtil.isNetworkUrl(urlAdd)){
                urlAdd = "https://www.google.com/search?q="+urlAdd
            }
            i.data = Uri.parse("$urlAdd")
            startActivity(i)
            Toast.makeText(applicationContext,"Taking you to the browser!",Toast.LENGTH_SHORT).show()
        }
        else{
            tvMsg.text = "Please Enter the correct URl First!"
            Toast.makeText(applicationContext,"Empty Url Not allowed!" ,Toast.LENGTH_SHORT).show()

        }

    }
    fun gotoFile(view: View){
        var i = Intent()
        i.action = Intent.ACTION_GET_CONTENT
        if(et3.text.isNotEmpty()){
            var typ = et3.text.toString()
            i.type = "$typ/*"
            startActivity(i)
            Toast.makeText(applicationContext,"Opening all the $typ files in the directory!",Toast.LENGTH_SHORT).show()
            et3.setText("")
        }
        else{
            tvMsg.text = "You should Enter the file type in small and must be valid!"
            Toast.makeText(applicationContext,"Enter File Type First!" ,Toast.LENGTH_SHORT).show()

        }
    }
}
