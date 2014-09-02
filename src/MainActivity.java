package com.luxstack.razrbit;

import java.util.List;
import org.apache.http.NameValuePair;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.luxstack.razrbit.Razrbit;

public class MainActivity extends Activity implements RazrbitCallParams.FnRazrbitCallback, RazrbitWebSocketClient.FnRazrbitWebSocketClientCallback {

	private Razrbit m_razrbit = new Razrbit("", "");
	
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
	
	
	public void postData() {
//		m_razrbit.walletGetBalanceFromAddress("", this);
		m_razrbit.networkGetDifficulty(this);
	}
	
	public void openBlockStream(View view) {
		m_razrbit.openTransactionStream(this);
	}
	
	public void closeBlockStream(View view) {
		m_razrbit.closeTransactionStream();
	}

	/** Called when the user clicks the Send button */
	public void testPost(View view) {
	    // Do something in response to button
		postData();
	}

	public void testExplorerBlock(View view) {
	    // Do something in response to button
		m_razrbit.explorerBlock("000000000000000021c40d35f9c317d2e8c9ead4dec3e24b8d1919862bd8f89d", this);
	}

	public void testWalletSendAmount(View view) {
	    // Do something in response to button
		m_razrbit.walletSendAmount("5exampleFromAddressPrivateKey", "1exampleToAddress", "123456", this);
	}
	
	public void testExplorerAddress(View view) {
	    // Do something in response to button
		m_razrbit.explorerAddress("1K8ZCd8xpbKZXj2QotFSzPGrgb1YNQV1yT", this);
	}

	@Override
	public void onDownloadFinished(List<NameValuePair> listNVPairResult) {
		String strResult = "NVP result:";
		if(listNVPairResult != null) {
			for (int i = 0; i < listNVPairResult.size(); i++)
			{
				NameValuePair nvPair = listNVPairResult.get(i);
				strResult += "\r\n" + String.valueOf(i) + ": " + nvPair.getName() + ": " + nvPair.getValue(); 
			}
		}
		else
		{
			strResult += " Empty NVP!";
		}
		final EditText simpleEditText = (EditText) findViewById(R.id.editText1);
		simpleEditText.setText(strResult.toCharArray(), 0, strResult.length());	    	
	}

	@Override
	public void onDownloadFinishedString(String strResult) {
		final EditText simpleEditText = (EditText) findViewById(R.id.editText1);
		simpleEditText.setText(strResult.toCharArray(), 0, strResult.length());	
		
	}
	
	@Override
	public void onRazrbitPostError(String strResult) {
		final EditText simpleEditText = (EditText) findViewById(R.id.editText1);
		simpleEditText.setText("Post Error received: ");	
		simpleEditText.append(strResult.subSequence(0, strResult.length()));	
	}	
	
	@Override
	public void onWebSocketClientMessage(String strMessage) {
		final EditText simpleEditText = (EditText) findViewById(R.id.editText1);
		simpleEditText.append(strMessage);
	}
}
