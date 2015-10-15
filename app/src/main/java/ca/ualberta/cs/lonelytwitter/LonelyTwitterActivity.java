package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";     //model
	private Button clearButton;
	private LonelyTwitterActivity activity=this;

	public EditText getBodyText() {
		return bodyText;
	}

	private EditText bodyText;         //controller

	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();    //model

	public ListView getOldTweetsList() {
		return oldTweetsList;
	}

	private ListView oldTweetsList;       //view
	private ArrayAdapter<Tweet> adapter;       //controller

	public Button getSaveButton() {
		return saveButton;
	}

	private Button saveButton;


	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {   //model

		super.onCreate(savedInstanceState);       //view
		setContentView(R.layout.main);      //view

		bodyText = (EditText) findViewById(R.id.body);        //controller
		saveButton = (Button) findViewById(R.id.save);    //controller
		clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);//controller

		saveButton.setOnClickListener(new View.OnClickListener() { //controller/view

			public void onClick(View v) {    //controller
				setResult(RESULT_OK);        //controller
				String text = bodyText.getText().toString();    //controller
				tweets.add(new NormalTweet(text));            //model
				saveInFile();            //model
				// dataObject.saveInFile() 		//controller
				adapter.notifyDataSetChanged();            //view

			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() { //contoller/view

			public void onClick(View v) {      //controller
				setResult(RESULT_OK);    //controller
				tweets.clear();        //model
				saveInFile();    //model
				adapter.notifyDataSetChanged();        //view

			}
		});

		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent=new Intent(activity,EditTweetActivity.class);
				startActivity(intent);
			}
		});
		}


	@Override
	protected void onStart() {      //view
		// TODO Auto-generated method stub
        loadFromFile();          //model
		super.onStart();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);//view
		oldTweetsList.setAdapter(adapter);    //controller
		adapter.notifyDataSetChanged();         //view
	}

	private void loadFromFile() {        //model
		try {
			FileInputStream fis = openFileInput(FILENAME);     //model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));     //model
			Gson gson = new Gson();     //model
			// https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com
			Type arrayListType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();   //model
			tweets = gson.fromJson(in,arrayListType);    //model

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();    //model
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);      //controller
		}
	}
	
	private void saveInFile() {     //model
		try {
			FileOutputStream fos = openFileOutput(FILENAME,0);       //model
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));   //model
			Gson gson = new Gson();           //model
			gson.toJson(tweets, out);      //model
			out.flush();   //controller
			fos.close();  //model
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);       //controller
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}