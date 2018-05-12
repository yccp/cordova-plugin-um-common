package news.chen.yu.ionic;

import android.Manifest;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;

import org.apache.cordova.*;

public class UMCommon extends CordovaPlugin {
    public static final String TAG = "cordova.plugin.um";
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        String secret = preferences.getString("um_push_android_secret", "");
        Log.i(TAG, "Secret: " + secret);
        UMConfigure.init(cordova.getActivity(), UMConfigure.DEVICE_TYPE_PHONE, secret);
        UMConfigure.setLogEnabled(true);

        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS
            };
            ActivityCompat.requestPermissions(cordova.getActivity(), mPermissionList, 123);
        }
    }
}