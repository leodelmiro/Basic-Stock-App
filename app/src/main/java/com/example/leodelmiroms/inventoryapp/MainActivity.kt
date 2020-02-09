package com.example.leodelmiroms.inventoryapp

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.leodelmiroms.inventoryapp.data.StockContract
import com.example.leodelmiroms.inventoryapp.data.StockReaderDbHelper
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.SQLInput

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: StockReaderDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbHelper = StockReaderDbHelper(this)
        displayDatabase()
    }

    fun displayDatabase(){
        val mDbHelper:StockReaderDbHelper = StockReaderDbHelper(this)

        val db: SQLiteDatabase = mDbHelper.readableDatabase

        val cursor: Cursor = db.rawQuery("SELECT * FROM ${StockContract.StockEntry.TABLE_NAME}", null)
        cursor.use { cursor ->
            textView.text = "Number Of rows in database table: ${cursor.count}"
        }
    }

    fun insertDummyProduct(){
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(StockContract.StockEntry.COLUMN_NAME, "Teste")
            put(StockContract.StockEntry.COLUMN_QUANTITY, 10)
        }

        val newRowId = db?.insert(StockContract.StockEntry.TABLE_NAME, null, values)

        Log.v("$applicationContext", "New Row ID $newRowId")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_all_addnewproduct -> {
                true
            }
            R.id.menu_all_deleteallproducts -> {
                true
            }
            R.id.menu_all_insertdummyproduct -> {
                insertDummyProduct()
                displayDatabase()
                true
            }
            R.id.menu_all_settings -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
