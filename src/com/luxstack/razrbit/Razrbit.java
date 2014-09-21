package com.luxstack.razrbit;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

import com.luxstack.razrbit.RazrbitCallParams;

public class Razrbit {

	public static final String RAZRBIT_PROTOCOL_HOST_PREFIX = "https://api.luxstack.com";
	
	private
		String m_strAppId;
		String m_strAppSecret;
		RazrbitCallParams m_razrbitCallParams;
		
	public Razrbit(String strAppId, String strAppSecret){
		m_strAppId = new String(strAppId);
		m_strAppSecret = new String(strAppSecret);
	}
	
	public void walletCreateNewAddress(RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "walletCreateNewAddress");
		String m_url = "/api/v1/wallet/createNewAddress";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(0);
		
        Log.d("trial", "getBalanceFromAddress step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, true, callback);
        Log.d("trial", "getBalanceFromAddress step 2");
		RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "getBalanceFromAddress before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);

	}

	public void walletSendAmount(String strFromAddressPrivateKey, String strToAddress, String strSatoshiAmount, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "walletSendAmount");
		String m_url = "/api/v1/wallet/sendAmount";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(3);
		listParams.add(new BasicNameValuePair("fromAddressPrivateKey", strFromAddressPrivateKey));
		listParams.add(new BasicNameValuePair("toAddress", strToAddress));
		listParams.add(new BasicNameValuePair("amount", strSatoshiAmount));
		
        Log.d("trial", "walletSendAmount step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, true, callback);
        Log.d("trial", "walletSendAmount step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "walletSendAmount before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);

	}

	public void walletGetBalanceFromAddress(String strAddress, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "getBalanceFromAddress");
		String m_url = "/api/v1/wallet/getbalancefromaddress";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(1);
		listParams.add(new BasicNameValuePair("address", strAddress));
		
        Log.d("trial", "getBalanceFromAddress step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, true, callback);
        Log.d("trial", "getBalanceFromAddress step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "getBalanceFromAddress before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);

	}

	public void explorerBlock(String strBlockHash, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "explorerBlock");
		String m_url = "/api/v1/explorer/block";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(1);
		listParams.add(new BasicNameValuePair("blockHash", strBlockHash));
		
        Log.d("trial", "explorerBlock step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, false, callback);
        Log.d("trial", "explorerBlock step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "explorerBlock before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);

	}

	public void explorerTransaction(String strTransactionHash, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "explorerTransaction");
		String m_url = "/api/v1/explorer/transaction";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(1);
		listParams.add(new BasicNameValuePair("transactionHash", strTransactionHash));
		
        Log.d("trial", "explorerTransaction step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, false, callback);
        Log.d("trial", "explorerTransaction step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "explorerTransaction before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);

	}

	public void explorerAddress(String strAddress, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "explorerAddress");
		String m_url = "/api/v1/explorer/address";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(1);
		listParams.add(new BasicNameValuePair("address", strAddress));
		
        Log.d("trial", "explorerAddress step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, false, callback);
        Log.d("trial", "explorerAddress step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "explorerAddress before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);

	}
	
	public void explorerAddressUnspentOutputs(String strAddress, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "explorerAddressUnspentOutputs");
		String m_url = "/api/v1/explorer/addressUnspentOutputs";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(1);
		listParams.add(new BasicNameValuePair("address", strAddress));
		
        Log.d("trial", "explorerAddressUnspentOutputs step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, false, callback);
        Log.d("trial", "explorerAddressUnspentOutputs step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "explorerAddressUnspentOutputs before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);

	}
	
	public void networkGetDifficulty(RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "networkGetDifficulty");
		String m_url = "/api/v1/network/getDifficulty";
		
        Log.d("trial", "networkGetDifficulty step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, null, true, callback);
        Log.d("trial", "networkGetDifficulty step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "networkGetDifficulty before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);

	}

	public void networkPushTransaction(String strTransaction, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "networkPushTransaction");
		String m_url = "/api/v1/network/pushTransaction";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(1);
		listParams.add(new BasicNameValuePair("transaction", strTransaction));
		
        Log.d("trial", "networkPushTransaction step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, true, callback);
        Log.d("trial", "networkPushTransaction step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "networkPushTransaction before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);

	}
	
	public void marketsPrice(String strCurrencyCode, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "marketsPrice");
		String m_url = "/api/v1/markets/price";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(1);
		listParams.add(new BasicNameValuePair("currencyCode", strCurrencyCode));
		
        Log.d("trial", "marketsPrice step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, true, callback);
        Log.d("trial", "marketsPrice step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "marketsPrice before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);
	}

	public void marketsDayPrice(String strCurrencyCode, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "marketsDayPrice");
		String m_url = "/api/v1/markets/dayPrice";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(1);
		listParams.add(new BasicNameValuePair("currencyCode", strCurrencyCode));
		
        Log.d("trial", "marketsDayPrice step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, true, callback);
        Log.d("trial", "marketsDayPrice step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "marketsDayPrice before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);
	}

	public void marketsHistoricalPrice(String strCurrencyCode, String strDate, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "marketsHistoricalPrice");
		String m_url = "/api/v1/markets/historicalPrice";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(2);
		listParams.add(new BasicNameValuePair("currencyCode", strCurrencyCode));
		listParams.add(new BasicNameValuePair("date", strDate));
		
        Log.d("trial", "marketsHistoricalPrice step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, true, callback);
        Log.d("trial", "marketsHistoricalPrice step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "marketsHistoricalPrice before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);
	}

	public void notificationsAddress(String strAddress, String strEmail, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "notificationsAddress");
		String m_url = "/api/v1/notifications/address";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(2);
		listParams.add(new BasicNameValuePair("address", strAddress));
		listParams.add(new BasicNameValuePair("email", strEmail));
		
        Log.d("trial", "notificationsAddress step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, true, callback);
        Log.d("trial", "notificationsAddress step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "notificationsAddress before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);
	}

	public void notificationsBlock(String strBlockHash, String strEmail, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "notificationsBlocks");
		String m_url = "/api/v1/notifications/block";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(2);
		listParams.add(new BasicNameValuePair("blockHash", strBlockHash));
		listParams.add(new BasicNameValuePair("email", strEmail));
		
        Log.d("trial", "notificationsBlocks step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, true, callback);
        Log.d("trial", "notificationsBlocks step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "notificationsBlocks before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);
	}
	
	public void notificationsTransaction(String strTransactionHash, String strEmail, RazrbitCallParams.FnRazrbitCallback callback){
        Log.d("trial", "notificationsTransaction");
		String m_url = "/api/v1/notifications/transaction";
		
		List<NameValuePair> listParams = new ArrayList<NameValuePair>(2);
		listParams.add(new BasicNameValuePair("transactionHash", strTransactionHash));
		listParams.add(new BasicNameValuePair("email", strEmail));
		
        Log.d("trial", "notificationsTransaction step 1");
		RazrbitCallParams razrbitCallParams = new RazrbitCallParams(RAZRBIT_PROTOCOL_HOST_PREFIX+m_url, m_strAppId, m_strAppSecret, listParams, true, callback);
        Log.d("trial", "notificationsTransaction step 2");
        RazrbitCallAsyncHandler razrbitCallAsyncHandler = new RazrbitCallAsyncHandler();
		
        Log.d("trial", "notificationsTransaction before handler execute");
		razrbitCallAsyncHandler.execute(razrbitCallParams);
	}
	
}
