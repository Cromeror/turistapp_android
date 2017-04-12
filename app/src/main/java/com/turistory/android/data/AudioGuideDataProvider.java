package com.turistory.android.data;

import com.turistory.android.activity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 21/02/2017.
 */

public class AudioGuideDataProvider {

    private static final AudioGuide[] audioguides = new AudioGuide[]{

            new AudioGuide(0,"Torre del reloj", "Información general", R.mipmap.torre_del_reloj_cover, R.mipmap.torre_del_reloj_portada,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua.\n" +
                    "La torre,  queda entre las plaza de los coches y la plaza de la paz, su creación tuvo lugar en el año de 1601 y en sus inicios fue llamada “la puerta del puente”, debido al puente de madera que pasaba por encima del caño de San Anastasio, uniendo así, la isla de Getsemaní, con la isla de Calamarí, esta última es hoy en día el barrio centro.\n" +
                    "Con el transcurso de los años esta construcción adquiere distintos nombres; inicialmente llamada “puerta del puente” más tarde “puerta del reloj” y por último “torre del reloj” o “reloj público”; como es conocida actualmente.\n" +
                    "A lo largo de la historia, la arquitectura de la torre y el diseño del reloj han sufrido cambios y modificaciones por diversas razones. \n" +
                    "En 1631 esta obra se convirtió en la puerta principal de la ciudad desde que se concluyó la construcción del cerco amurallado. Años más tarde, fue parcialmente destruida por el barón de Pointis quien fue un pirata Francés responsable del saqueo pirata de cartagena en el año 1697. \n" +
                    "En 1704 la restauración de la torre estuvo en manos del ingeniero Juan Herrera y Sotomayor, quien fue el responsable de agregar una fachada barroca y las cuatro columnas toscanas que la adornan.\n" +
                    "En el año 1874, el reloj fue reemplazado por un reloj traído desde Estados Unidos.\n" +
                    "En el año de 1888 por orden de la autoridad local, se le realizó una nueva restauración a la torre, el encargado de esta labor fue el arquitecto Luis Felipe Jaspe Franco, quien reemplazó la estructura cuadrada por un diseño octagonal. Cambiando visiblemente de un estilo barroco a un estilo gótico. \n" +
                    "En 1937 se incorpora a la torre un reloj importado de Suiza.\n" +
                    "En el año 2014 con el ánimo de recuperar el diseño original del reloj, se reincorporaron  los números romanos, con la particularidad de representar el número 4 con 4 líneas. Hay muchas historias sobre el origen del número cuatro en los relojes con cuatro líneas, una de ellas cuenta que un relojero se equivocó y el rey lo mandó a decapitar, entonces en oposición a ese acto de crueldad, los demás relojeros decidieron seguir con el número con 4 líneas.\n", 0,10.4241924,-75.5484545),


            new AudioGuide(1,"Plaza de la Aduana", "Información general",  R.mipmap.torre_del_reloj_cover, R.mipmap.torre_del_reloj_portada,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", 1,10.421744,-75.5514052),
            new AudioGuide(2,"Muelle de los pegasos", "Información general",  R.mipmap.torre_del_reloj_cover, R.mipmap.torre_del_reloj_portada,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", 1,10.422289,-75.5496622),
            new AudioGuide(3,"Plaza de Santo Domingo", "Información general",  R.mipmap.torre_del_reloj_cover, R.mipmap.torre_del_reloj_portada,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", 1,10.421744,-75.5514052),
            new AudioGuide(4,"Iglesia San Pedro Claver", "Información general",  R.mipmap.torre_del_reloj_cover, R.mipmap.torre_del_reloj_portada,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", 1,10.421744,-75.5514052),
            new AudioGuide(5,"Plaza de los coches", "Información general", R.mipmap.torre_del_reloj_cover, R.mipmap.torre_del_reloj_portada,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", 1,10.4230377,-75.5492878),


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
