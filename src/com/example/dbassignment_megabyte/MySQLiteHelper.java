package com.example.dbassignment_megabyte;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class MySQLiteHelper extends SQLiteOpenHelper 
{

	public MySQLiteHelper(Context context)
	{
		super(context, "P5", null, 1);
	}


	@Override public void onCreate(SQLiteDatabase db)
	{
		//create the database with with a unique id for each entry and a text entry called string with the unique attribute.
		String query = "CREATE TABLE Strings ( id integer not null auto_increment primary key, string text unique)";
		db.execSQL(query);
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
}