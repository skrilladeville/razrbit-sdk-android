package com.luxstack.razrbit;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

public class RazrbitCallParams {
	
	interface FnRazrbitCallback {
		void onDownloadFinished(List<NameValuePair> listNVPairResult);
		void onDownloadFinishedString(String strResult);
		void onRazrbitPostError(String strResult);
	}
	
	private
		String m_strUrl;
		List<NameValuePair> m_listParams;
		FnRazrbitCallback m_fnCallback;
		Boolean m_bResultTypeIsNvp;
		
	public RazrbitCallParams (String strUrl, String strAppId, String strAppSecret, List<NameValuePair> listParams, Boolean bResultTypeIsNvp, FnRazrbitCallback fnCallback){
        Log.d("trial", "RazrbitCallParams constructor starts!!!");
		m_strUrl = new String(strUrl);
		m_fnCallback = fnCallback;
		m_bResultTypeIsNvp = bResultTypeIsNvp;
		int iListParamSize = 2;
		if(listParams != null)
		{
			iListParamSize += listParams.size();
		}
		m_listParams = new ArrayList<NameValuePair>(2+iListParamSize);
		m_listParams.add(new BasicNameValuePair("appId", strAppId));
		m_listParams.add(new BasicNameValuePair("appSecret", strAppSecret));
		
		for (int i = 0; i < iListParamSize - 2; i++)
		{
			m_listParams.add(new BasicNameValuePair(listParams.get(i).getName(), listParams.get(i).getValue()));	
		}
	}
	
	public String GetUrl(){
		return m_strUrl;
	}
	
	public List<NameValuePair> GetParamList(){
		return m_listParams;
	}
	
	public FnRazrbitCallback GetCallback(){
		return m_fnCallback;
	}
	
	public Boolean GetResultTypeIsNvp(){
		return m_bResultTypeIsNvp;
	}
}
