package com.luxstack.razrbit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import com.luxstack.razrbit.RazrbitCallParams;

public class RazrbitCallAsyncHandler extends AsyncTask<RazrbitCallParams, Void, String> {

	private 
		RazrbitCallParams.FnRazrbitCallback m_fnCallback = null;
		String m_strResult = null;
		List<NameValuePair> m_listNvpResult = null;
		Boolean m_bResultTypeIsNvp = false;
		Boolean m_bError = false;

	private List<NameValuePair> ParseJsonFlatListToListNvp(ByteArrayOutputStream out) throws IOException {
		List<NameValuePair> listNvpResult = null;
		JsonReader reader = new JsonReader(new InputStreamReader(new ByteArrayInputStream(out.toByteArray()), "UTF-8"));
		try {
			reader.beginObject();
			while (reader.hasNext()) {
				if(listNvpResult == null)
				{
					listNvpResult = new LinkedList<NameValuePair>();
				}
				String name = reader.nextName();
				String text = reader.nextString();
				Log.d("trial", "before adding "+name+":"+text);
				listNvpResult.add(new BasicNameValuePair(name, text));
			}
			reader.endObject();
		}
		finally {
			reader.close();
		}
		return listNvpResult;
	}
		
	@Override
	protected String doInBackground(RazrbitCallParams... params) {

        Log.d("trial", "doInBackground starts");
		RazrbitCallParams razrbitCallParams = params[0];
		
		m_fnCallback = razrbitCallParams.GetCallback();
		
	    HttpClient httpclient = new DefaultHttpClient();
	    HttpPost httppost = new HttpPost(razrbitCallParams.GetUrl());

        Log.d("trial", "doInBackground before try");
	    try {
	        // Add your data
	        httppost.setEntity(new UrlEncodedFormEntity(razrbitCallParams.GetParamList()));

	        Log.d("trial", "doInBackground before execute");
	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        
	        StatusLine statusLine = response.getStatusLine();
            //Check the Http Request for success
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                m_bResultTypeIsNvp = razrbitCallParams.GetResultTypeIsNvp();
                if(m_bResultTypeIsNvp)
                {
                	m_listNvpResult = ParseJsonFlatListToListNvp(out);
                }
                else
                {
                    m_strResult = out.toString();
                }
            }
            else{
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException("status code NOT OK: "+statusLine.toString());
            }
	    }
	    catch (ClientProtocolException e) {
	        Log.w("HTTP2:",e );
	        m_strResult = e.getMessage();
	        m_bError = true;
	        cancel(true);
	    } 
	    catch (IOException e) {
	        Log.w("HTTP3:",e );
	        m_strResult = e.getMessage();
	        m_bError = true;
	        cancel(true);
	    }
	    catch (Exception e) {
	        Log.w("HTTP4:",e );
	        m_strResult = e.getMessage();
	        m_bError = true;
	        cancel(true);
	    }

    return m_strResult;
	}

    @Override
    protected void onCancelled() {
		if(m_fnCallback != null) {
			m_fnCallback.onRazrbitPostError(m_strResult);
		}
    }

    @Override
	protected void onPostExecute(String strResult) {
		if(m_fnCallback != null) {
	        Log.d("trial", "onPostExecute starts");
	        if(m_bResultTypeIsNvp){
	        	m_fnCallback.onDownloadFinished(m_listNvpResult);
	        }
	        else {
	        	m_fnCallback.onDownloadFinishedString(strResult);
	        }
		}
	}

}
