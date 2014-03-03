package com.example.oblig3patrick;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView httpStuff;
	HttpClient client;
	JSONObject jsonObj;
	private String title = "";
	private double rating = 0.0;
	private int year = 0;
	//

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		httpStuff = (TextView) findViewById(R.id.httpStuff);
		
		client = new DefaultHttpClient();
		new Read().execute("rating");
 	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public class Read extends AsyncTask<String, Integer, String>{

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			try {
				JSONParser j = new JSONParser();
				jsonObj = j.loadMovie();
				title = jsonObj.getString(params[0]); //samme som "text"
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			httpStuff.setText(title);
		}
		
	}
}
