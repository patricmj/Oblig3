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

public class JSONParser {
	
	HttpClient client;
	public static final String URL = "http://deanclatworthy.com/imdb/?q=The+Green+Mile";

	public JSONParser() {
		client = new DefaultHttpClient();
	}

	public JSONObject loadMovie() throws ClientProtocolException, IOException, JSONException {
		StringBuilder url = new StringBuilder(URL);
		//url.append(username);
		
		HttpGet get = new HttpGet(url.toString());
		HttpResponse r = client.execute(get);
		int status = r.getStatusLine().getStatusCode();
		if(status == 200) {
			HttpEntity e = r.getEntity();
			String data = EntityUtils.toString(e);
			//JSONArray timeline = new JSONArray(data);
			JSONObject last = new JSONObject(data);
			//JSONObject last = timeline.getJSONObject(0);
			return last;
		} else {
			return null;
		}
	}
	
	
}
