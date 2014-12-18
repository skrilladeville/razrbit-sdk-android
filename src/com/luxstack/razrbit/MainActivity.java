package com.luxstack.razrbit;

import java.util.List;

import org.apache.http.NameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity implements RazrbitCallParams.FnRazrbitCallback,OnItemSelectedListener{

	private Razrbit m_razrbit = new Razrbit("", ""); //ADD YOUR APPID AND APPSECRET HERE!

	public void onItemSelected(AdapterView<?> arg0, View view,
			int position, long row_id) {
		switch(position+1){
		case 1:
			m_razrbit.walletCreateNewAddress(this);            		
			break;
		case 2:
			m_razrbit.walletSendAmount("5exampleFromAddressPrivateKey", "1exampleToAddress", "123456", this);
			break;
		case 3:
			m_razrbit.walletGetBalanceFromAddress("12sENwECeRSmTeDwyLNqwh47JistZqFmW8", this);
			break;
		case 4:
			m_razrbit.explorerBlock("000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f", this);
			break;
		case 5:
			m_razrbit.explorerTransaction("f3e34abcc9da7d35eab5d2c2deaf54d7b3092ad478b1e12183cc07a1dbcb3784", this);
			break;
		case 6:
			m_razrbit.explorerAddress("12sENwECeRSmTeDwyLNqwh47JistZqFmW8", this);
			break;
		case 7:
			m_razrbit.explorerAddressUnspentOutputs("12sENwECeRSmTeDwyLNqwh47JistZqFmW8", this);
			break;
		case 8:
			m_razrbit.networkGetDifficulty(this);
			break;
		case 9:
			m_razrbit.networkPushTransaction("exampleTransaction", this);
			break;
		case 10:
			m_razrbit.marketsPrice("USD", this);
			break;
		case 11:
			m_razrbit.marketsDayPrice("USD", this);
			break;
		case 12:
			m_razrbit.marketsHistoricalPrice("USD","2013-08-13", this);
			break;
		case 13:
			m_razrbit.notificationsAddress("12sENwECeRSmTeDwyLNqwh47JistZqFmW8","me@example.com", this);
			break;
		case 14:
			m_razrbit.notificationsBlock("000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f","me@example.com", this);
			break;
		case 15:
			m_razrbit.notificationsTransaction("f3e34abcc9da7d35eab5d2c2deaf54d7b3092ad478b1e12183cc07a1dbcb3784","me@example.com", this);
			break;
		}

	}

	public void onNothingSelected(AdapterView<?> parent) {
		// Another interface callback
	}


	//POST  /api/v1/wallet/createNewAddress
	public void walletCreateNewAddress() {
		m_razrbit.walletCreateNewAddress(this);
	}

	//POST  /api/v1/wallet/sendAmount
	public void walletSendAmount() {
		m_razrbit.walletSendAmount("5exampleFromAddressPrivateKey", "1exampleToAddress", "123456", this);
	}

	//POST  /api/v1/wallet/getBalanceFromAddress
	public void walletGetBalanceFromAddress() {
		m_razrbit.walletGetBalanceFromAddress("12sENwECeRSmTeDwyLNqwh47JistZqFmW8", this);
	}


	//POST  /api/v1/explorer/block
	public void explorerBlock() {
		m_razrbit.explorerBlock("000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f", this);
	}

	//POST  /api/v1/explorer/transaction
	public void explorerTransaction() {
		m_razrbit.explorerTransaction("f3e34abcc9da7d35eab5d2c2deaf54d7b3092ad478b1e12183cc07a1dbcb3784", this);
	}

	//POST  /api/v1/explorer/address
	public void explorerAddress() {
		m_razrbit.explorerAddress("12sENwECeRSmTeDwyLNqwh47JistZqFmW8", this);
	}

	//POST  /api/v1/explorer/addressUnspentOutputs
	public void explorerAddressUnspentOutputs() {
		m_razrbit.explorerAddressUnspentOutputs("12sENwECeRSmTeDwyLNqwh47JistZqFmW8", this);
	}


	//POST  /api/v1/network/getDifficulty
	public void networkGetDifficulty() {
		m_razrbit.networkGetDifficulty(this);
	}

	//POST  /api/v1/network/pushTransaction
	public void networkPushTransaction() {
		m_razrbit.networkPushTransaction("exampleTransaction", this);
	}


	//POST  /api/v1/markets/price
	public void marketsPrice() {
		m_razrbit.marketsPrice("USD", this);
	}

	//POST  /api/v1/markets/dayPrice
	public void marketsDayPrice() {
		m_razrbit.marketsDayPrice("USD", this);
	}

	//POST  /api/v1/markets/historicalPrice
	public void marketsHistoricalPrice() {
		m_razrbit.marketsHistoricalPrice("USD","2013-08-13", this);
	}


	//POST  /api/v1/notifcations/address
	public void notificationsAddress() {
		m_razrbit.notificationsAddress("12sENwECeRSmTeDwyLNqwh47JistZqFmW8","me@example.com", this);
	}

	//POST  /api/v1/notifcations/address
	public void notificationsBlock() {
		m_razrbit.notificationsBlock("000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f","me@example.com", this);
	}

	//POST  /api/v1/notifcations/address
	public void notificationsTransaction() {
		m_razrbit.notificationsTransaction("f3e34abcc9da7d35eab5d2c2deaf54d7b3092ad478b1e12183cc07a1dbcb3784","me@example.com", this);
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setOnItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onDownloadFinished(List<NameValuePair> listNVPairResult) {
		String strResult = "";
		if(listNVPairResult != null) {
			for (int i = 0; i < listNVPairResult.size(); i++)
			{
				NameValuePair nvPair = listNVPairResult.get(i);
				strResult += "\r\n" + String.valueOf(i) + ": " + nvPair.getName() + ": " + nvPair.getValue(); 
			}
		}
		else
		{
			strResult += "[Empty]";
		}
		final EditText simpleEditText = (EditText) findViewById(R.id.resultOutput);
		simpleEditText.setText(strResult.toCharArray(), 0, strResult.length());	    	
	}

	@Override
	public void onDownloadFinishedString(String strResult) {
		final EditText simpleEditText = (EditText) findViewById(R.id.resultOutput);
		simpleEditText.setText(strResult.toCharArray(), 0, strResult.length());	

	}

	@Override
	public void onRazrbitPostError(String strResult) {
		final EditText simpleEditText = (EditText) findViewById(R.id.resultOutput);
		simpleEditText.setText("Error: ");	
		simpleEditText.append(strResult.subSequence(0, strResult.length()));	
	}	

}
