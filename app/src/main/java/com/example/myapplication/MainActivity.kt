package com.example.myapplication

import android.R.attr.button
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.myapplication.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val viewRoot = binding.root
        setContentView(viewRoot)

//        binding.button.setOnClickListener(View.OnClickListener {
//            Toast.makeText(this, "Click!!!", Toast.LENGTH_SHORT).show()
//          //  shareBitmapFile(file)
//        })
    }



    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val view = binding.linearLayout

        val bitmap = getBitmapFromView(view)
        binding.image.setImageBitmap(bitmap);

        val filename = "image.png"
        val file = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), filename)
        saveBitmapFile(bitmap, file)

        binding.textView.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Click!!!", Toast.LENGTH_SHORT).show()
            shareBitmapFile(file)
        })
    }

    fun getBitmapFromView(view: View): Bitmap? {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)

        return bitmap
    }

    fun saveBitmapFile(bitmap: Bitmap?, file: File) {
        var outputStream: FileOutputStream? = null
        try {
            outputStream = FileOutputStream(file)
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            }
            outputStream.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            outputStream?.close()
        }
    }

    fun shareBitmapFile(file: File) {
        // Create an intent with appropriate action and type
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/*"

        // Attach the image file to the intent
        val uri = FileProvider.getUriForFile(this, "com.example.myapplication", file)
        intent.putExtra(Intent.EXTRA_STREAM, uri)

        // Add any text or subject if needed
//        intent.putExtra(Intent.EXTRA_TEXT, "Sharing Image")
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Shared Image")

        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        // Start the intent
        startActivity(Intent.createChooser(intent, "Share Image"))
    }
}