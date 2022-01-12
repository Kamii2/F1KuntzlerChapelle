package com.example.pamkuntzlerchapelle.Liste

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val frameLayout = FrameLayout(this).apply {
            id = 0x123
        }
        setContentView(frameLayout)
        supportFragmentManager.commit {
            replace(0x123, MaListeFragment())
        }
    }
}