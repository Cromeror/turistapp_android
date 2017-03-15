package com.turistory.android.data;

import com.turistory.android.activity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 21/02/2017.
 */

public class AudioGuideDataProvider {

    private static final AudioGuide[] audioguides = new AudioGuide[]{
            new AudioGuide(0,"Plaza de los coches", "Información general", R.mipmap.plaza_de_los_coches,R.raw.audio_tower_clock),
            new AudioGuide(1,"Palacio de la inquisicion", "Información general", R.mipmap.palacio_de_la_inquisicion,R.raw.audio_tower_clock),
            new AudioGuide(2,"Torre del reloj", "Información general", R.mipmap.torre_del_reloj,R.raw.audio_tower_clock),
            new AudioGuide(3,"Plaza de la paz", "Información general", R.mipmap.plaza_de_la_paz,R.raw.audio_tower_clock),
            new AudioGuide(4,"Bahia de las animas", "Información general", R.mipmap.bahia_de_las_animas,R.raw.audio_tower_clock),
            new AudioGuide(5,"Plaza de Simon Bolivar", "Información general", R.mipmap.plaza_simon_bolivar,R.raw.audio_tower_clock),
            new AudioGuide(6,"Plaza de Santo Domingo", "Información general", R.mipmap.plaza_santo_domingo,R.raw.audio_tower_clock),
            new AudioGuide(7,"Iglesia San Pedro Claver", "Información general", R.mipmap.iglesia_san_pedro_claver,R.raw.audio_tower_clock),
            new AudioGuide(8,"India Catalina", "Información general", R.mipmap.india_catalina,R.raw.audio_tower_clock),
            new AudioGuide(9,"Museo del oro Zenú", "Información general", R.mipmap.museo_del_oro_zenu,R.raw.audio_tower_clock),
            new AudioGuide(10,"Castillo de San Felipe de Baraja", "Información general", R.mipmap.castillo_de_san_felipe,R.raw.audio_tower_clock),
            new AudioGuide(11,"Botas viejas", "Información general", R.mipmap.botas_viejas,R.raw.audio_tower_clock),
            new AudioGuide(12,"Pedro Claver", "Información general", R.mipmap.pedro_claver,R.raw.audio_tower_clock),
            new AudioGuide(13,"Parque del Centenario", "Información general", R.mipmap.parque_del_centenario,R.raw.audio_tower_clock),
            new AudioGuide(14,"Parque Jose Fernández de Madrid", "Información general", R.mipmap.parque_jose_fernandez_de_madrid,R.raw.audio_tower_clock),
            new AudioGuide(15,"Parque de las Flores", "Información general", R.mipmap.parque_de_las_flores,R.raw.audio_tower_clock),
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
