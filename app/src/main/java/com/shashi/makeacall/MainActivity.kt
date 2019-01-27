package com.shashi.makeacall

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun callNumber(view: View){
        val i = Intent()
        i.action = Intent.ACTION_DIAL
        var phNo = et1.text.toString()
        i.data = Uri.parse("tel:"+phNo)
        startActivity(i)
    }
    fun browseUrl(view: View){
        val i = Intent()
        i.action = Intent.ACTION_VIEW
        //i.type = "text/plain"
        var urlAdd = et2.text.toString()
        i.data = Uri.parse("$urlAdd")
        startActivity(i)
    }
    fun gotoFile(view: View){
        var i = Intent()
        i.action = Intent.ACTION_GET_CONTENT
        var typ = et3.text.toString()
        i.type = "$typ/*"
        startActivityForResult(i,1)
    }
}
