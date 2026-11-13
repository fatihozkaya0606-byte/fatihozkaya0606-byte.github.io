package com.zekamozaik.game;
import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
public class MainActivity extends Activity {
    private WebView webView;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(16,21,41));
        getWindow().setNavigationBarColor(Color.rgb(16,21,41));
        webView = new WebView(this);
        webView.setBackgroundColor(Color.rgb(16,21,41));
        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(false);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        setContentView(webView);
        webView.loadUrl("file:///android_asset/index.html");
    }
    @Override public void onBackPressed() {
        if (webView != null && webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }
    @Override protected void onDestroy() {
        if (webView != null) { webView.destroy(); webView=null; }
        super.onDestroy();
    }
}