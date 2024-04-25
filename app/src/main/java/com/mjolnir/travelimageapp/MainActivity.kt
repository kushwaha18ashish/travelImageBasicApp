package com.mjolnir.travelimageapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var currentImage=0
    lateinit var image:ImageView
    var places= arrayOf("Red Fort","India Gate","Lotus Temple","Akshardham Temple","Qutub Minar",
        "Yamuna Ghat","Lodhi Garden","Gurudwara Bangla Sahib")
    var metro= arrayOf("Lal Quila","Central Secretariat","Okhla NSIC","Akshardham","Qutub Minar",
        "Model Town","Jor Bagh","Shivaji Stadium")
    var bgColor= arrayOf("violet","yellow","magenta","blue","yellow","yellow","yellow","orange")
    var distance= arrayOf("Distance: 0.25KM","Distance: 0.9KM","Distance: 0.7KM","Distance: 0.3KM",
        "Distance: 1.7KM","Distance: 0.6KM","Distance: 0.9KM","Distance: 0.28KM")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var next=findViewById<Button>(R.id.btnNext)
        var prev=findViewById<Button>(R.id.btnPrev)
        var placeName=findViewById<TextView>(R.id.tvName)
        var metroStation=findViewById<TextView>(R.id.tvMetro)
        var dist=findViewById<TextView>(R.id.dist)

        next.setOnClickListener {
            var idCurrentImageString= "pic$currentImage"
            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image=findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage = (8+currentImage+1)%8
            var idImageToShowString= "pic$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image=findViewById(idImageToShowInt)
            image.alpha=1f
            placeName.text=places[currentImage]
            metroStation.text=metro[currentImage]
            val colorId = resources.getIdentifier(bgColor[currentImage], "color", packageName)
            metroStation.setBackgroundColor(ContextCompat.getColor(this, colorId))
            dist.text=distance[currentImage]

        }

        prev.setOnClickListener {
            var idCurrentImageString= "pic$currentImage"
            var idCurrentImageInt= this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image=findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage = (8+currentImage-1)%8
            var idImageToShowString= "pic$currentImage"
            var idImageToShowInt= this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image=findViewById(idImageToShowInt)
            image.alpha=1f
            placeName.text=places[currentImage]
            metroStation.text=metro[currentImage]
            val colorId = resources.getIdentifier(bgColor[currentImage], "color", packageName)
            metroStation.setBackgroundColor(ContextCompat.getColor(this, colorId))
            dist.text=distance[currentImage]
        }
    }
}