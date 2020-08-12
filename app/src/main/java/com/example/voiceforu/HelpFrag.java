package com.example.voiceforu;

import android.app.DialogFragment;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

public class HelpFrag extends DialogFragment implements TextToSpeech.OnInitListener {

    public static TextView tvd;
    String text = "";
    IsSpeaking i;
    String module = MainActivity.module;
    private TextToSpeech tts;
    String main = "say MAIL to go to mail module ";
    String gmail = "To read mails say SHOW INBOX \n To send a mail say COMPOSE MAIL \n To search mail say SEARCH SUBJECT your subject \n " +
            "To open a specific category say SHOW INBOX category";



    public HelpFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help, container, false);
        tvd = (TextView) view.findViewById(R.id.tv_displayh);
        tts = new TextToSpeech(getActivity().getBaseContext(), this);
        i = new IsSpeaking(tts, this);
        appropriateHelp(module);
        return view;
    }

    private void appropriateHelp(String whichModule) {
        switch (whichModule) {
            case "main":
                text = main;
                tvd.setText(text);
                speakOut();
                break;
            case "gmail":
                text = gmail;
                tvd.setText(text);
                speakOut();
                break;

            default:
                text = "Invalid command";
                speakOut();
        }
    }

    //Speak Out

    private void speakOut() {
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.getDefault());

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                speakOut();
                i.start();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    @Override
    public void onDestroy() {
        // Shuts Down TTS
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}