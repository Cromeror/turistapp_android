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
                    "En el año 2014 con el ánimo de recuperar el diseño original del reloj, se reincorporaron  los números romanos, con la particularidad de representar el número 4 con 4 líneas. Hay muchas historias sobre el origen del número cuatro en los relojes con cuatro líneas, una de ellas cuenta que un relojero se equivocó y el rey lo mandó a decapitar, entonces en oposición a ese acto de crueldad, los demás relojeros decidieron seguir con el número con 4 líneas.\n", "GRATIS"),


            new AudioGuide(1,"Calle de las Mercedes", "Información general",R.mipmap.calle, R.mipmap.calle,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(2,"Castillo de Bocachica", "Información general", R.mipmap.castillo, R.mipmap.castillo,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(3,"Plaza de los coches", "Información general",R.mipmap.plaza_de_los_coches, R.mipmap.plaza_de_los_coches,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(4,"Bahia de las animas", "Información general", R.mipmap.bahia_de_las_animas,R.mipmap.bahia_de_las_animas,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(5,"Plaza de Simon Bolívar", "Información general", R.mipmap.plaza_simon_bolivar,R.mipmap.plaza_simon_bolivar,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(6,"Plaza de Santo Domingo", "Información general", R.mipmap.plaza_santo_domingo,R.mipmap.plaza_santo_domingo,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(7,"Iglesia San Pedro Claver", "Información general", R.mipmap.iglesia_san_pedro_claver,R.mipmap.iglesia_san_pedro_claver,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(8,"India Catalina", "Información general", R.mipmap.india_catalina,R.mipmap.india_catalina,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(9,"Museo del oro Zenú", "Información general", R.mipmap.museo_del_oro_zenu,R.mipmap.museo_del_oro_zenu,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(10,"Castillo de San Felipe de Baraja", "Información general", R.mipmap.castillo_de_san_felipe,R.mipmap.castillo_de_san_felipe,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(11,"Botas viejas", "Información general", R.mipmap.botas_viejas, R.mipmap.botas_viejas,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(12,"Pedro Claver", "Información general", R.mipmap.pedro_claver,R.mipmap.pedro_claver,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(13,"Parque del Centenario", "Información general", R.mipmap.parque_del_centenario,R.mipmap.parque_del_centenario,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(14,"Parque Jose Fernández de Madrid", "Información general", R.mipmap.parque_jose_fernandez_de_madrid,R.mipmap.parque_jose_fernandez_de_madrid,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(15,"Parque de las Flores", "Información general", R.mipmap.parque_de_las_flores,R.mipmap.parque_de_las_flores,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(16,"Palacio de la inquisición", "Información general", R.mipmap.palacio_de_la_inquisicion,R.mipmap.palacio_de_la_inquisicion,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),
            new AudioGuide(17,"Plaza de la paz", "Información general", R.mipmap.plaza_de_la_paz,R.mipmap.plaza_de_la_paz,R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", "BLOQUEADO"),


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
