package com.luxstack.razrbit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.List;

import org.apache.http.NameValuePair;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;

import android.util.Log;

public class RazrbitWebSocketClient extends WebSocketClient {
	interface FnRazrbitWebSocketClientCallback {
		void onWebSocketClientMessage(String strMessage);
	}
	
	private FnRazrbitWebSocketClientCallback m_fnCallback = null;

	public RazrbitWebSocketClient( URI serverURI, FnRazrbitWebSocketClientCallback fnCallback ) {
		super( serverURI );
		Log.d("trial", "RazrbitWebSocketClient constructor starts!!!: URI: " + serverURI.toString());
		m_fnCallback = fnCallback;
	}

	@Override
	public void onOpen( ServerHandshake handshakedata ) {
		Log.d("trial", "RazrbitWebSocketClient onOpen starts!!!");
		System.out.println( "opened connection" );
		// if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
	}

	@Override
	public void onMessage( String message ) {
		System.out.println( "received: " + message );
		if(m_fnCallback != null) {
			m_fnCallback.onWebSocketClientMessage(message);
		}
	}
	@Override
	public void onFragment( Framedata fragment ) {
		Log.d("trial", "RazrbitWebSocketClient onFragment starts!!!");		
		System.out.println( "received fragment: " + new String( fragment.getPayloadData().array() ) );
	}

	@Override
	public void onClose( int code, String reason, boolean remote ) {
		Log.d("trial", "RazrbitWebSocketClient onClose starts!!! " + "Connection closed by " + ( remote ? "remote peer" : "us" ));
		// The codes are documented in class org.java_websocket.framing.CloseFrame
		System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) );
	}

	@Override
	public void onError( Exception ex ) {
		ex.printStackTrace();
		//If the error is fatal then onClose will be called too
	}
}
