package in.kuari.spark_tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class Titles extends Activity {

    private ListView titleList;
    private List<String> listOfTitles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titles);
        titleList = (ListView) findViewById(R.id.titleList);

        populateListView();
        loadAd();
    }
private void loadAd(){
    AdView adView= (AdView) findViewById(R.id.adTit);
    AdRequest adRequest=new AdRequest.Builder().build();
    adView.loadAd(adRequest);
}
    private void populateTitleList() {
        listOfTitles = new ArrayList<>();

        listOfTitles.add("Overview");
        listOfTitles.add("Linking with Spark");
        listOfTitles.add("Initializing Spark");
        listOfTitles.add("Resilient Distributed Datasets (RDDs)");
        listOfTitles.add("Shared Variables");
        listOfTitles.add("Deploying to a Cluster");
        listOfTitles.add("Launching Spark jobs from Java / Scala");
        listOfTitles.add("Unit Testing");
        listOfTitles.add("Migrating from pre-1.0 Versions of Spark");
        listOfTitles.add("Where to Go from Here");
    }

    private void populateListView() {
        populateTitleList();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.title_row, R.id.titleName, listOfTitles);
    titleList.setAdapter(adapter);

        titleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String topic=(String)titleList.getItemAtPosition(position);
                openSubTopic(position);
            }
        });

    }
    private void openSubTopic(int pos){
        String topic;
        //Toast.makeText(getApplicationContext(),pos+"dd",Toast.LENGTH_SHORT).show();
        switch (pos){
            case 0:
                topic="overview";
                break;
            case 1:topic="linking-with-spark";
                break;
            case 2:
                topic="initializing-spark";
                break;
            case 3:
                topic="resilient-distributed-datasets-rdds";
                break;
            case 4:
                topic="shared-variables";
                break;
            case 5:topic="deploying-to-a-cluster";
                break;
            case 6:topic="launching-spark-jobs-from-java--scala";
                break;
            case 7:topic="unit-testing";
                break;
            case 8:
                topic="migrating-from-pre-10-versions-of-spark";
                break;
            case 9:
                topic="where-to-go-from-here";
                break;
            default:
                topic="";
                break;


        }


        Intent intent=new Intent(Titles.this,SubTopic.class);
        intent.putExtra("topic",topic);
        startActivity(intent);

    }
}
