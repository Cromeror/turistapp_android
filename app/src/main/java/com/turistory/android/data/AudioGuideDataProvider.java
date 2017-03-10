package com.turistory.android.data;

import com.turistory.android.activity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 21/02/2017.
 */

public class AudioGuideDataProvider {

    private static final AudioGuide[] audioguides = new AudioGuide[]{
            new AudioGuide(0,"Plaza de los coches", "General", R.mipmap.plaza_de_los_coches,R.raw.audio_tower_clock),
            new AudioGuide(1,"Palacio de la inquisicion", "General", R.mipmap.palacio_de_la_inquisicion,R.raw.audio_tower_clock),
            new AudioGuide(2,"Torre del reloj", "Los esclavos", R.mipmap.torre_del_reloj,R.raw.audio_tower_clock),
            new AudioGuide(3,"Plaza de la paz", "General", R.mipmap.plaza_de_la_paz,R.raw.audio_tower_clock),
            new AudioGuide(4,"Bahia de las animas", "General", R.mipmap.bahia_de_las_animas,R.raw.audio_tower_clock),
            new AudioGuide(5,"Plaza de Simon Bolivar", "General", R.mipmap.plaza_simon_bolivar,R.raw.audio_tower_clock),
            new AudioGuide(6,"Plaza de Santo Domingo", "General", R.mipmap.home_background,R.raw.audio_tower_clock),
            new AudioGuide(7,"Iglesia San Pedro Claver", "General", R.mipmap.home_background,R.raw.audio_tower_clock),
            new AudioGuide(8,"India Catalina", "General", R.mipmap.home_background,R.raw.audio_tower_clock)

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
