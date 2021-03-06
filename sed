<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android" 
    package="com.tinygame.lianliankan" 
    android:versionCode="11" 
    android:versionName="2.1">
	<uses-sdk android:minSdkVersion="7" />
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	<!-- add permissions for umeng -->
	<uses-permission android:name="android.permission.READ_LOGS" />
	<uses-permission android:name="android.permission.READ_LOGS" />
	
	<application android:icon="@drawable/icon" android:label="@string/app_name">
		<meta-data android:value="4f26afbe52701526bc0000be" android:name="UMENG_APPKEY" />
		<meta-data android:value="google" android:name="UMENG_CHANNEL" />
		<meta-data android:name="YOUMI_CHANNEL" android:value="10020" />
		
		<activity android:name="net.youmi.android.appoffers.YoumiOffersActivity" android:configChanges="keyboard|keyboardHidden|orientation" />
		<activity android:name=".SplashActivity" android:label="@string/app_name" android:screenOrientation="portrait">
			<intent-filter>
				<action android:name="android.intent.action.MAIN" />
				<category android:name="android.intent.category.LAUNCHER" />
			</intent-filter>
		</activity>
		
		<activity android:name=".MenuActivity" android:label="@string/app_name" android:screenOrientation="portrait" />
		<activity android:name=".LevelActivity" android:label="@string/app_name" android:screenOrientation="portrait" />
		<activity android:name=".LinkLink" android:label="@string/app_name" android:screenOrientation="portrait" />
		<activity android:name=".ResultActivity" android:label="@string/app_name" android:screenOrientation="portrait" android:theme="@style/Theme.Translucent" />
		<uses-library android:name="com.google.android.maps" android:required="false" />
		<activity android:name="com.wiyun.game.AccountRetrieval" android:theme="@android:style/Theme.Dialog" />
		<activity android:name="com.wiyun.game.BidPicker" android:theme="@android:style/Theme.Dialog" />
		<activity android:name="com.wiyun.game.ChangeMyPortrait" android:screenOrientation="portrait" android:configChanges="keyboardHidden|orientation" />
		<activity android:name="com.wiyun.game.ComposeTopic" android:configChanges="keyboardHidden|orientation" android:windowSoftInputMode="stateHidden|adjustResize" android:screenOrientation="portrait" />
		<activity android:name="com.wiyun.game.CropImage" android:configChanges="keyboardHidden|orientation" android:screenOrientation="portrait" />
		<activity android:name="com.wiyun.game.DLCDownloader" android:theme="@android:style/Theme.Dialog" />
		<activity android:name="com.wiyun.game.DownloadBlob" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.FullImageGallery" />
		<activity android:name="com.wiyun.game.SaveGameDialog" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.Home" android:launchMode="singleTask" android:configChanges="keyboardHidden|orientation" android:windowSoftInputMode="stateHidden|adjustUnspecified" />
		<activity android:name="com.wiyun.game.LoadGameDialog" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.Login" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.Mopay" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.MyBagDialog" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.OAuth" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.PurchaseDialog" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.SendChallenge" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.SubmitScore" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.SwitchAccount" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.UseAnotherAccount" android:windowSoftInputMode="stateHidden|adjustUnspecified" android:theme="@style/WiGame.Borderless.Dialog" />
		<activity android:name="com.wiyun.game.UserMap" />
	</application>
	<uses-permission android:name="android.permission.READ_PHONE_STATE" />
	<uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
	<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	<uses-permission android:name="com.android.launcher.permission.INSTALL_SHORTCUT" />
</manifest>

