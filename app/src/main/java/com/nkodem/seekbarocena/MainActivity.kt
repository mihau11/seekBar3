package com.nkodem.seekbarocena

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.nkodem.seekbarocena.databinding.ActivityMainBinding
import java.lang.StrictMath.round

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val piony = arrayListOf<SeekBar>(findViewById(R.id.sb1pion),
            findViewById(R.id.sb2pion),
            findViewById(R.id.sb3pion))
        val poziomy = arrayListOf<SeekBar>(findViewById(R.id.sb1poziom),
            findViewById(R.id.sb2poziom),
            findViewById(R.id.sb3poziom))
        val obrazki = arrayListOf<ImageView>(binding.imageView6,binding.imageView7,binding.imageView10)

        for (x in 0..2) {
            piony[x].progress = 100
            piony[x].setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    var licznik2 = 0
                    for (y in piony) {
                        licznik2 += y.progress
                    }
                    findViewById<ProgressBar>(R.id.progressBar2).progress = licznik2 / 3
                    findViewById<TextView>(R.id.textView).setText((licznik2/3).toString())
                    var wys=252*progress/100
                    obrazki[x].getLayoutParams().height =wys
                    obrazki[x].requestLayout()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // Write code to perform some action when touch is started.
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // Write code to perform some action when touch is stopped.
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
                    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                        var licznik = 0
                        for (y in poziomy) {
                            licznik += y.progress
                        }
                        findViewById<ProgressBar>(R.id.progressBar).progress = licznik / 3
                        findViewById<TextView>(R.id.progtext).setText((licznik/3).toString())
                        var wys=181*progress/100
                        obrazki[x].getLayoutParams().width =wys
                        obrazki[x].requestLayout()
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
                    }
                })
            }

        }
    }
