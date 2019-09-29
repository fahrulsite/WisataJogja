package com.fahrul.wisatajogja.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fahrul.wisatajogja.R
import com.fahrul.wisatajogja.adapter.CardViewWisataAdapter
import com.fahrul.wisatajogja.model.Wisata
import com.fahrul.wisatajogja.model.dataWisata

class MainActivity : AppCompatActivity() {
    private lateinit var rvWisata:RecyclerView
    private var title = "Wisata Jogja"
    private var list:ArrayList<Wisata> = arrayListOf()

    private fun showRecyclerCardView() {
        rvWisata.layoutManager= LinearLayoutManager(this)
        val cardViewWisataAdapter= CardViewWisataAdapter(list)
        rvWisata.adapter = cardViewWisataAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Wisata Jogja"
        rvWisata = findViewById(R.id.rv_wisata)
        rvWisata.setHasFixedSize(true)

        list.addAll(dataWisata.listData)
        showRecyclerCardView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        setAbout(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setAbout(selectedMode: Int) {
        when (selectedMode) {
            R.id.icProfile -> {
                val iAbout = Intent(this@MainActivity, about::class.java)
                startActivity(iAbout)
            }
        }
    }
}
