package com.asif.showoptionmenuonfragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment()
    }

    private fun loadFragment() {
        val transaction: FragmentTransaction =
            supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layoutContainer, HomeFragment())
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        //get item id to handle item clicks
        val id = item.itemId
        //handle item clicks
        if (id == R.id.item1) {
            //do your action here, im just showing toast
        }
        if (id == R.id.item2) {
            //do your action here, im just showing toast
        }
        if (id == R.id.item3) {
            //do your action here, im just showing toast
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }
}
