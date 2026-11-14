package com.example.plmungo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.github.chrisbanes.photoview.PhotoView


class CampusMapActivity : AppCompatActivity() {

    private lateinit var ivCampusMap: PhotoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campus_map)

        ivCampusMap = findViewById(R.id.ivCampusMap)

        val btnZoomIn = findViewById<Button>(R.id.btnZoomIn)
        val btnZoomOut = findViewById<Button>(R.id.btnZoomOut)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnLocations = findViewById<Button>(R.id.btnLocations)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Zoom settings
        ivCampusMap.minimumScale = 1.0f
        ivCampusMap.mediumScale = 2.0f
        ivCampusMap.maximumScale = 4.0f

        // Zoom In button
        btnZoomIn.setOnClickListener {
            val newScale = (ivCampusMap.scale + 0.5f)
                .coerceAtMost(4.0f)

            ivCampusMap.setScale(newScale, true)
        }

        // Zoom Out button
        btnZoomOut.setOnClickListener {
            val newScale = (ivCampusMap.scale - 0.5f)
                .coerceAtLeast(1.0f)

            ivCampusMap.setScale(newScale, true)
        }

        // Reset button
        btnReset.setOnClickListener {
            ivCampusMap.setScale(1.0f, true)
        }

        // Campus Locations button
        btnLocations.setOnClickListener {
            showLocations()
        }

        // Back button
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun showLocations() {

        val locations = arrayOf(
            "Student Center",
            "Main Building",
            "Admin Building",
            "Covered Court",
            "North Park",
            "Gazebo",
            "RLRC Building",
            "Serenity Garden",
            "Centennial Park"
        )

        val descriptions = arrayOf(
            "Student Center - Campus location information.",
            "Main Building - Campus location information.",
            "Admin Building - Campus location information.",
            "Covered Court - Campus location information.",
            "North Park - Campus location information.",
            "Gazebo - Campus location information.",
            "RLRC Building - Campus location information.",
            "Serenity Garden - Campus location information.",
            "Centennial Park - Campus location information."
        )

        AlertDialog.Builder(this)
            .setTitle("Campus Locations")
            .setItems(locations) { _, which ->

                AlertDialog.Builder(this)
                    .setTitle(locations[which])
                    .setMessage(descriptions[which])
                    .setPositiveButton("OK", null)
                    .show()
            }
            .setNegativeButton("Close", null)
            .show()
    }
}
