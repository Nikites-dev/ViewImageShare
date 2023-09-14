package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.os.Environment
import android.view.View
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


//        val img: ImageView = binding.linearLayout as ImageView



//        // Get the view or layout you want to convert
//        val view = findViewById<View>(R.id.linearLayout)
//
//        // Create a bitmap and draw the view on it
////        val bitmap = Bitmap.createBitmap(100, 60, Bitmap.Config.ARGB_8888)
////        val canvas = Canvas(bitmap)
////        view.draw(canvas)
//
//
//        val bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888)
//
//        // Create a new Canvas object using the Bitmap
//
//        // Create a new Canvas object using the Bitmap
//        val canvas = Canvas(bitmap)
//
//        // Draw the View into the Canvas
//
//        // Draw the View into the Canvas
//        view.draw(canvas)
//
//
//
//        binding.image.setImageBitmap(bitmap);
//


//        val filename = "image.png"
//        val file = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), filename)
//
//        // Save the bitmap to the file
//        var outputStream: FileOutputStream? = null
//        try {
//            outputStream = FileOutputStream(file)
//            if (bitmap != null) {
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
//            }
//            outputStream.flush()
//        } catch (e: Exception) {
//            e.printStackTrace()
//        } finally {
//            outputStream?.close()
//        }
//
//
//
//
//
//
//        // Create an intent with appropriate action and type
//        val intent = Intent(Intent.ACTION_SEND)
//        intent.type = "image/*"
//
//        // Attach the image file to the intent
//        val uri = FileProvider.getUriForFile(this, "com.example.myapplication", file)
//        intent.putExtra(Intent.EXTRA_STREAM, uri)
//
//        // Add any text or subject if needed
//        intent.putExtra(Intent.EXTRA_TEXT, "Sharing an image")
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Shared Image")
//
//        // Grant permission to the receiver app to read the shared file
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//
//        // Start the intent
//        startActivity(Intent.createChooser(intent, "Share Image"))
//
//




    }

    fun getBitmapFromView(view: View): Bitmap? {
        //Define a bitmap with the same size as the view
        val returnedBitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888)
        //Bind a canvas to it
        val canvas = Canvas(returnedBitmap)
        //Get the view's background
        val bgDrawable = view.background
        if (bgDrawable != null) //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas) else  //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE)
        // draw the view on the canvas
        view.draw(canvas)
        //return the bitmap
        return returnedBitmap
    }

    private fun getBitmapFromViewUsingCanvas(view: View): Bitmap? {
        // Create a new Bitmap object with the desired width and height
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)

        // Create a new Canvas object using the Bitmap
        val canvas = Canvas(bitmap)

        // Draw the View into the Canvas
        view.draw(canvas)

        // Return the resulting Bitmap
        return bitmap
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val view = findViewById<View>(R.id.linearLayout)

        // Create a bitmap and draw the view on it
//        val bitmap = Bitmap.createBitmap(100, 60, Bitmap.Config.ARGB_8888)
//        val canvas = Canvas(bitmap)
//        view.draw(canvas)


        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)

        // Create a new Canvas object using the Bitmap

        // Create a new Canvas object using the Bitmap
        val canvas = Canvas(bitmap)

        // Draw the View into the Canvas

        // Draw the View into the Canvas
        view.draw(canvas)

        binding.image.setImageBitmap(bitmap);









                val filename = "image2.png"
        val file = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), filename)

        // Save the bitmap to the file
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






        // Create an intent with appropriate action and type
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "image/*"

        // Attach the image file to the intent
        val uri = FileProvider.getUriForFile(this, "com.example.myapplication", file)
        intent.putExtra(Intent.EXTRA_STREAM, uri)

        // Add any text or subject if needed
        intent.putExtra(Intent.EXTRA_TEXT, "Sharing an image")
        intent.putExtra(Intent.EXTRA_SUBJECT, "Shared Image")

        // Grant permission to the receiver app to read the shared file
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        // Start the intent
        startActivity(Intent.createChooser(intent, "Share Image"))



    }

}