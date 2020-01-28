package com.example.leodelmiroms.inventoryapp

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.leodelmiroms.inventoryapp.data.StockContract
import com.example.leodelmiroms.inventoryapp.data.StockReaderDbHelper
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.SQLInput

class StockActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}
