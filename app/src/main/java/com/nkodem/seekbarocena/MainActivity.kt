package com.nkodem.seekbarocena

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.drawToBitmap
import com.nkodem.seekbarocena.databinding.ActivityMainBinding
import java.lang.StrictMath.round

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    fun resizePhotoW(bitmap: Bitmap,prog:Int,dom:Int): Bitmap {
        var newW=prog*100.1
        val b = Bitmap.createScaledBitmap(bitmap, round(newW).toInt(),bitmap.height, true)
        return b
    }
    fun resizePhotoH(bitmap: Bitmap,prog:Int,dom:Int): Bitmap {
        var newH=prog*100.1
        val b = Bitmap.createScaledBitmap(bitmap,bitmap.width,round(newH).toInt(),true)
        return b
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val piony = arrayListOf(binding.sb1pion,binding.sb2pion,binding.sb3pion)
        val poziomy = arrayListOf(binding.sb1poziom,binding.sb2poziom,binding.sb3poziom)
        val obrazki = arrayListOf(binding.imageView6,binding.imageView7,binding.imageView10)
        val domWys = 1
        val domSze = 662

        for (x in 0..2) {
            piony[x].progress = 100
            piony[x].setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progres: Int, fromUser: Boolean) {
                    val progress=progres+1
                    var licznik2 = 0
                    for (y in piony){ licznik2 += y.progress}
                    binding.progressBar2.progress = licznik2 / 3
                    binding.textView.setText((licznik2/3).toString())

                    obrazki[x].setImageBitmap(resizePhotoH(obrazki[x].drawToBitmap(),progress,domWys))
                }
                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // Write code to perform some action when touch is started.
                }
                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    Toast.makeText(
                        this@MainActivity,
                        "Wysokość " + seekBar.progress + "%",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            })
        }
            for (x in 0..2) {
                poziomy[x].progress = 100
                poziomy[x].setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar, progres: Int, fromUser: Boolean) {
                        val progress = progres+1
                        var licznik= 0
                        for (y in poziomy){licznik += y.progress}
                        binding.progressBar.progress = licznik / 3
                        binding.progtext.setText((licznik/3).toString())

                        obrazki[x].setImageBitmap(resizePhotoW(obrazki[x].drawToBitmap(),progress,domSze))
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar) {
                        // Write code to perform some action when touch is started.
                    }
                    override fun onStopTrackingTouch(seekBar: SeekBar) {
                        // Write code to perform some action when touch is stopped.
                        Toast.makeText(
                            this@MainActivity,
                            "Szerokość " + seekBar.progress + "%",
                            Toast.LENGTH_SHORT
                        ).show()
}})}}}
