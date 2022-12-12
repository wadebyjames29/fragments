package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Suppress("UNUSED_EXPRESSION")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(homeFragment())

        binding.bottomnavigationview.setOnItemReselectedListener {


            when(it.itemId){

                R.id.Home -> replaceFragment(homeFragment())
                R.id.Play -> replaceFragment(PlayFragment())
                R.id.Remove -> replaceFragment(removeFragment())

                else -> {



                }


            }

            true

        }

    }


    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}
