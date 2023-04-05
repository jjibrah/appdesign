package com.example.morningintents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    lateinit var mSMS:Button
    lateinit var mEmail:Button
    lateinit var mCamera:Button
    lateinit var mShare:Button
    lateinit var mMpesa:Button
    lateinit var mCall:Button
    lateinit var mWebsite:Button
    lateinit var mMap:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSMS=findViewById(R.id.mBtnSms)
        mEmail=findViewById(R.id.mBtnEmail)
        mCamera=findViewById(R.id.mBtnCamera)
        mShare=findViewById(R.id.mBtnShare)
        mMpesa=findViewById(R.id.mBtnMpesa)
        mCall=findViewById(R.id.mBtnCall)
        mWebsite=findViewById(R.id.mBtnWebsite)
        mMap=findViewById(R.id.mBtnMap)
        // Proceed to set on click
        mSMS.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0798272697")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello there I am trying this our now")
            startActivity(intent)
        }
        mEmail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "ibarbdi109@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Job Application")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Sir , following the advertisement.......")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
        mCamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }
        mShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app from https://www.")
            startActivity(shareIntent)
        }
        mMpesa.setOnClickListener {
            val simToolKitLaunchIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }
        mCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0798272697"))
            if (ContextCompat.checkSelfPermission(this@MainActivity, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1)
            } else {
                startActivity(intent)
            }
        }
        mWebsite.setOnClickListener {
            var tembea = Intent(this@MainActivity, WebsiteActivity::class.java)
            startActivity(tembea)
        }
        mMap.setOnClickListener {
            val ramani = Intent(this, MapsActivity::class.java)
            startActivity(ramani)
        }
    }
}