package com.yushin.recyclerviewpractice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yushin.recyclerviewpractice.R
import com.yushin.recyclerviewpractice.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(
            R.id.container_main_fragment,
            MainFragment()
        ).commit()
    }
}