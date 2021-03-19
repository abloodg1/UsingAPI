package com.example.usingapi;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextToSpeech t1;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1= findViewById(R.id.editText);
        b1= findViewById(R.id.button);

        t1=new TextToSpeech(getApplicationContext(), status -> {
            if(status != TextToSpeech.ERROR) {
                t1.setLanguage(Locale.UK);
            }
        });

        //b1.setOnClickListener(v -> {
          //  String toSpeak = ed1.getText().toString();
          //  Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
         //   t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
        //});
    }

    public void buttonClicked(View view){
        String toSpeak = ed1.getText().toString();
        Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
        t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}