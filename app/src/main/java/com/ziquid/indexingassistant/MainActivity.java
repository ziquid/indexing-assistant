package com.ziquid.indexingassistant;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

  MyWebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    webView = (MyWebView) findViewById(R.id.browser);
    webView.setWebViewClient(new MyWebViewClient());

    webView.getSettings().setJavaScriptEnabled(true);
    webView.setVerticalScrollBarEnabled(false);
    webView.setHorizontalScrollBarEnabled(false);
    webView.loadUrl("https://www.familysearch.org/indexing/my-indexing");
  }

  public static int getInputTypeForNoSuggestsInput() {
//    if (android.os.Build.MANUFACTURER.equalsIgnoreCase("Samsung")) {
//      return InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
//        | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
//    } else {
      return InputType.TYPE_TEXT_VARIATION_FILTER;
//    }
  }

  public static class MyWebView extends WebView {

    public MyWebView(Context context) {
      super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
      super(context, attrs);
    }

//    @Override
//    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
//      InputConnection inputConnection = new BaseInputConnection(this, false);
//      outAttrs.inputType = outAttrs.inputType | InputType.TYPE_TEXT_VARIATION_FILTER;
//      return inputConnection;
//    }

  }

  private class MyWebViewClient extends WebViewClient {

  }
}
