package com.k.android;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by RAHUL CHAUHAN on 15-06-2015.
 */
public class myviewclient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;

    }
}
