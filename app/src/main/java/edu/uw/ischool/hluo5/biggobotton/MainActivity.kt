package edu.uw.ischool.hluo5.biggobotton

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var pushCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val layout = findViewById<ConstraintLayout>(R.id.main)
        val button = findViewById<Button>(R.id.big_button)

        button.setOnClickListener {
            pushCount++

            //button text
            val text = if (pushCount == 1) {
                "You have pushed me 1 time!"
            } else {
                "You have pushed me $pushCount times!"
            }
            button.text = text

            // background color
            val backgroundColor = Color.rgb(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )
            layout.setBackgroundColor(backgroundColor)

            // change text color
            val textColor = Color.rgb(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )
            button.setTextColor(textColor)
        }

        ViewCompat.setOnApplyWindowInsetsListener(layout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
