package in.kuari.spark_tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class SubTopic extends Activity {

    private WebView webView;
    private String topic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_topic);
Intent intent=getIntent();
        if(intent!=null){
            topic=intent.getStringExtra("topic");
        }
      //  Toast.makeText(this,topic+"b",Toast.LENGTH_SHORT).show();
        webView= (WebView) findViewById(R.id.webId);
        String url="file:///android_asset/Spark Programming Guide - Spark 1.6.1 Documentation.html#"+topic;
            webView.loadUrl(url);
       loadAd();

    }
    private void loadAd(){
        AdView adView= (AdView) findViewById(R.id.adSub);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
}
