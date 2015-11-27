package com.example.awaaz;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

import com.example.aawaaz.R;



//import android.support.v7.app.ActionBarActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


public class contacts extends Activity implements OnItemClickListener {
    ListView list;
    LinearLayout ll;
    Button loadBtn;
    AlertDialog.Builder alertDialogBuilder;
    ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> number = new ArrayList<String>();
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
        final Context context = this;
        alertDialogBuilder = new AlertDialog.Builder(context);
        ll = (LinearLayout) findViewById(R.id.LinearLayout1);

        list = (ListView) findViewById(R.id.listView1);
        list.setOnItemClickListener(this);

        loadBtn = (Button) findViewById(R.id.button1);
        loadBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                LoadContactsAyscn lca = new LoadContactsAyscn();
                lca.execute();
            }
        });

    }

    class LoadContactsAyscn extends AsyncTask<Void, Void, ArrayList<String>> {
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();

            pd = ProgressDialog.show(contacts.this, "Loading Contacts",
                    "Please Wait");
        }

        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            // TODO Auto-generated method stub
            ArrayList<String> contacts = new ArrayList<String>();

            Cursor c = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                    null, null, null);
            while (c.moveToNext()) {

                String contactName = c
                        .getString(c
                                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phNumber = c
                        .getString(c
                                .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                contacts.add(contactName + ":" + phNumber);
name.add(contactName);
number.add(phNumber);
            }
            c.close();

            return contacts;
        }

        @Override
        protected void onPostExecute(ArrayList<String> contacts) {
            // TODO Auto-generated method stub
            super.onPostExecute(contacts);

            pd.cancel();

            ll.removeView(loadBtn);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    getApplicationContext(), R.layout.text, contacts);

            list.setAdapter(adapter);

        }

    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, final int position,long id) 
	{
		// TODO Auto-generated method stub
		String data=(String)parent.getItemAtPosition(position);
		Toast.makeText(this, position+"", Toast.LENGTH_SHORT).show();
		
		alertDialogBuilder.setTitle("Contact");

			// set dialog message
			alertDialogBuilder
				.setMessage(name.get(position)+"\n"+number.get(position))
				.setCancelable(false)
				.setNegativeButton("Call",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						
						Intent callIntent = new Intent(Intent.ACTION_CALL);
						callIntent.setData(Uri.parse("tel:"+number.get(position)));
						startActivity(callIntent);
					}
				  })
				.setPositiveButton("Close",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
		
 
	}
}