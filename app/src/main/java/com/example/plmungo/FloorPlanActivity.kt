package com.example.plmungo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FloorPlanActivity : AppCompatActivity() {

    private lateinit var tvRooms: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floor_plan)

        val btnGround = findViewById<Button>(R.id.btnGround)
        val btnSecond = findViewById<Button>(R.id.btnSecond)
        val btnThird = findViewById<Button>(R.id.btnThird)
        val btnFourth = findViewById<Button>(R.id.btnFourth)
        val btnBack = findViewById<Button>(R.id.btnBack)

        tvRooms = findViewById(R.id.tvRooms)

        btnGround.setOnClickListener {
            showRooms(
                "GROUND FLOOR",
                "CCJ/CTE/CBA/CAS Faculty\nBusiness Center\nAssessment Office\nPlmun HDRMO\nRecords Office\nUniversity Office"
            )
        }

        btnSecond.setOnClickListener {
            showRooms(
                "2ND FLOOR",
                "Room 201 - Computer Lab\nRoom 203 - Computer Lab\nCITCS Faculty\nBAPOL AND BAPAD Faculty\nMultimedia And Laboratory Management Office\nSpeech Lab\nICT Office"
            )
        }

        btnThird.setOnClickListener {
            showRooms(
                "3RD FLOOR",
                "Room 301\nRoom 302\nRoom 303\nRoom 304\nRoom 305\nRoom 306\nRoom 307\nRoom 308\nCAS Faculty\nCAS Dean's Office\nPsychology Laboratory\nPsychology Clinic\nRadio Room"
            )
        }

        btnFourth.setOnClickListener {
            showRooms(
                "4TH FLOOR",
                "Room 401\nRoom 402\nRoom 403\nRoom 404\nRoom 405\nCTE Faculty\nPlmun AVR\nSatelite Library"
            )
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun showRooms(floor: String, rooms: String) {
        tvRooms.text = "$floor\n\n$rooms"
    }
}
