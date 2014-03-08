package com.example.dbassignment_megabyte;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button ReadButton = (Button) findViewById(R.id.btnGetText);
	Button WriteButton = (Button) findViewById(R.id.btnAddText);
	EditText input = (EditText) findViewById(R.id.Input);
	EditText output = (EditText) findViewById(R.id.Output);
	TextView TV  = (TextView) findViewById(R.id.msg); 
	
	MySQLiteHelper helper = new MySQLiteHelper(getApplicationContext());
	SQLiteDatabase db = helper.getWritableDatabase();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void AddTextPressed(View v)
	{
		//check for duplicate text before inserting
		ContentValues values = new ContentValues();
		values.put("string", input.toString());
		
		try
		{
			db.insert("strings", null , values);
			Toast toast = Toast.makeText(getApplicationContext(), "Message successfully interted", Toast.LENGTH_SHORT);
			toast.show();
		}
		catch(Exception ex)
		{
			Toast toast = Toast.makeText(getApplicationContext(), "Database error: could not insert.\n" + ex.getLocalizedMessage(), Toast.LENGTH_SHORT);
			toast.show();
		}

	}
	
	public void GetTextPressed(View v)
	{
		//use the select statement to grab all the data, then paste it one element at a time into the EditText Field

		TV.setText("Get Text Pressed");
	}
	
}
