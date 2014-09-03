<img src="http://cdn.luxstack.com/assets/razrbit-github-banner-dark-beta.png" style="width:100%"/>

Official SDKs: 
Android | 
[iOS](https://github.com/LUXSTACK/razrbit-sdk-ios) | 
[Javascript](https://github.com/LUXSTACK/razrbit-sdk-javascript) | 
[PHP](https://github.com/LUXSTACK/razrbit-sdk-php) | 
[Ruby](https://github.com/LUXSTACK/razrbit-sdk-ruby)

**[Razrbit](https://razrbit.com) Bitcoin Platform and SDKs — build, test and scale bitcoin apps faster with Razrbit. Plug in our powerful SDKs to supercharge your bitcoin toolbox.**

# Razrbit SDK for Android (Beta)

## Installation

### Eclipse

1. Setup a library package named com.luxstack.razrbit
2. Copy all the sources in git repository src folder to src/com/luxstack/razrbit folder in the project folder
3. Configure the package to depend on the library package org.java_websocket

(github path: https://github.com/TooTallNate/Java-WebSocket)

3.1 Mark the project of library package org.java_websocket as Library reference project in Android tab of Properties window, OR;

3.2 Add the following line in project.properties file of project to refer to project folder of library package org.java_websocket

android.library.reference.1=../java_websocket

## Usage

The following code use MainActivity class as example.

```java
import com.luxstack.razrbit.Razrbit;

public class MainActivity extends Activity implements RazrbitCallParams.FnRazrbitCallback, RazrbitWebSocketClient.FnRazrbitWebSocketClientCallback {

	// initialize a Razrbit object by appId and appSecret
	private Razrbit m_razrbit = new Razrbit("MyAppId", "MyAppSecret");

	@Override
	public void onDownloadFinished(List<NameValuePair> listNVPairResult) {
		// This interface is compulsory for class using Razrbit object
		// implements code to handle information returned upon Razrbit call in name value pair listNVPairResult
	}

	@Override
	public void onDownloadFinishedString(String strResult) {
		// This interface is compulsory for class using Razrbit object
		// implements code to handle information returned upon Razrbit call in raw JSON format string strResult
	}
	
	@Override
	public void onRazrbitPostError(String strResult) {
		// This interface is compulsory for class using Razrbit object
		// implements code to handle information returned in strResult upon Razrbit call results in error
	}	
	
	@Override
	public void onWebSocketClientMessage(String strMessage) {
		// This interface is compulsory for class using Razrbit object
		// implements code to handle information received from websocket opened in strMessage
	}
	
	...
	
	// To call a Razrbit
	m_razrbit.walletGetBalanceFromAddress("MyAddress", this);
	
	// To open a transaction stream Razrbit websocket
	m_razrbit.openTransactionStream(this);
	
	// To close the transaction stream Razrbit websocket
	m_razrbit.closeTransactionStream(this);

	...
}
```

## API

### Public constructor

```
Razrbit(String strAppId, String strAppSecret)
```

### Public methods

### Wallet
```
void walletSendAmount(String strFromAddress, String strToAddress, String strAmount, RazrbitCallParams.FnRazrbitCallback callback)
```
Sends bitcoin from one of your addresses to the destination addresses. `amount` is in bits.

```
void walletGetBalanceFromAddress(String strAddress, RazrbitCallParams.FnRazrbitCallback callback)
```
Returns the balance of the given address in bits.

```

### Explorer
```
void explorerBlock(String strBlockHash, RazrbitCallParams.FnRazrbitCallback callback)
```
Retrieve details about a given block

```
void explorerTransaction(String strTransactionHash, RazrbitCallParams.FnRazrbitCallback callback)
```
Retrieve details about a given transaction

```
void explorerAddress(String strAddress, RazrbitCallParams.FnRazrbitCallback callback)
```
Retrieve details about a given address

```
void explorerAddressUnspentOutputs(String strAddress, RazrbitCallParams.FnRazrbitCallback callback)
```
Returns the list of unspent outputs for a given address

### Network

```
void networkGetDifficulty(RazrbitCallParams.FnRazrbitCallback callback)
```
Retrieve the current network difficulty

```
void networkPushTransaction(String strTransaction, RazrbitCallParams.FnRazrbitCallback callback)
```
Push a transaction on to the network

### Market

```
void marketsPrice(String strCurrencyCode, RazrbitCallParams.FnRazrbitCallback callback)
```
`currencyCode` is a valid ISO 4217 code such as `USD` or `EUR`.
Returns the current bitcoin price

```
void marketsDayPrice(String strCurrencyCode, RazrbitCallParams.FnRazrbitCallback callback)
```
Returns the day price in the specified currency

```
void marketsHistoricalPrice(String strCurrencyCode, String strDate, RazrbitCallParams.FnRazrbitCallback callback)
```
Returns the historical bitcoin price for the given date.
`date` must be a date in the `yyyy-mm-dd` format.

### Notifications

```
void notificationsAddress(String strAddress, String strEmail, RazrbitCallParams.FnRazrbitCallback callback)
```
Setup a notification email for a given address

```
void notificationsBlock(String strBlockHash, String strEmail, RazrbitCallParams.FnRazrbitCallback callback)
```
Setup a notification email for a given block

```
void notificationsTransaction(String strTransactionHash, String strEmail, RazrbitCallParams.FnRazrbitCallback callback)
```
Setup a notification email for a given transaction

# Support

Feel free to request a feature and make suggestions for our [product team](mailto:team@luxstack.com).

* [GitHub Issues](https://github.com/luxstack/razrbit-sdk-android/issues)

# License

**Code released under [the MIT license](https://github.com/LUXSTACK/razrbit-sdk-android/blob/master/LICENSE).**

Copyright 2012-2014 LUXSTACK Inc. Razrbit is a trademark maintained by LUXSTACK Inc.

# Razrbit Bitcoin SDKs for other platforms

* Android
* [iOS](https://github.com/LUXSTACK/razrbit-sdk-ios)
* [Javascript](https://github.com/LUXSTACK/razrbit-sdk-javascript)
* [PHP](https://github.com/LUXSTACK/razrbit-sdk-php)
* [Ruby](https://github.com/LUXSTACK/razrbit-sdk-ruby)