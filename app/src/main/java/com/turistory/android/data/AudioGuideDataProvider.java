package com.turistory.android.data;

import com.turistory.android.activity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 21/02/2017.
 */

public class AudioGuideDataProvider {

    private static final AudioGuide[] audioguides = new AudioGuide[]{

            new AudioGuide(1,"La torre del reloj", "General", R.mipmap.tower_clock,R.raw.audio_tower_clock),
            new AudioGuide(2,"La torre del reloj", "Los esclavos", R.mipmap.esclavos,R.raw.audio_tower_clock),
            new AudioGuide(3,"La torre del reloj", "Los Masones", R.mipmap.tower_clock,R.raw.audio_tower_clock),
            new AudioGuide(4,"La torre del reloj", "La champeta", R.mipmap.tower_clock,R.raw.audio_tower_clock),
    };


    public static List<AudioGuide> getAudioGuide() {
        List<AudioGuide> audioguideList = new ArrayList();
        for (int i = 0; i < audioguides.length; i++) {
            audioguideList.add(audioguides[i]);
        }
        return audioguideList;
    }

      AudioGuide searchAudioGuide (int position) {
        AudioGuide  audioguide = null;
        for (int i = 0; i < audioguides.length; i++) {

            if(position==audioguides[i].getId()) {
                audioguide = audioguides[i];
            }
        }
        return audioguide;
    }
}
