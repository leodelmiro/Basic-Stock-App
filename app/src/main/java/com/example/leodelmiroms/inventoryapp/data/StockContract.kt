package com.example.leodelmiroms.inventoryapp.data

import android.provider.BaseColumns

object StockContract {

    object StockEntry : BaseColumns {
        const val TABLE_NAME = "stock"
        const val COLUMN_NAME = "name"
        const val COLUMN_QUANTITY = "quantity"
        const val COLUMN_IMAGE = "image"

        const val CREATE_STOCK_SQL =
            "CREATE TABLE $TABLE_NAME (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_NAME TEXT NOT NULL," +
                    "$COLUMN_QUANTITY INTEGER NOT NULL DEFAULT 0," +
                    "$COLUMN_IMAGE TEXT)"

        const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}