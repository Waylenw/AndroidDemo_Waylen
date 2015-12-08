package com.example.waylenw.aysntasktest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar progressBar,progressBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar= (ProgressBar) findViewById(R.id.pbar_one);
        progressBar1= (ProgressBar) findViewById(R.id.pbar_two);



    }

    @Override
    public void onClick(View v) {
        new MyAysnTask().execute();
        new MyAysnTask2().execute();
    }

    class MyAysnTask extends AsyncTask<Void,Integer,Void>{
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }

    @Override
    protected Void doInBackground(Void... params) {
        for(int i=0;i<100;i++){
            publishProgress(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

    class MyAysnTask2 extends AsyncTask<Void,Integer,Void>{
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar1.setProgress(values[0]);
        }

        @Override
        protected Void doInBackground(Void... params) {
            for(int i=0;i<100;i++){
                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }



}
