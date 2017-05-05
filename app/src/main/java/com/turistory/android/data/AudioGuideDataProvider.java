package com.turistory.android.data;

import com.turistory.android.activity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 21/02/2017.
 */

public class AudioGuideDataProvider {

    public AudioGuideDataProvider() {
    }

    private static final AudioGuide[] audioguides = new AudioGuide[]{

            new AudioGuide(0, "Torre del reloj", "Información general", R.mipmap.torre_del_reloj_cover, R.mipmap.torre_del_reloj_portada, R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua.\n" +
                    "La torre,  queda entre las plaza de los coches y la plaza de la paz, su creación tuvo lugar en el año de 1601 y en sus inicios fue llamada “la puerta del puente”, debido al puente de madera que pasaba por encima del caño de San Anastasio, uniendo así, la isla de Getsemaní, con la isla de Calamarí, esta última es hoy en día el barrio centro.\n" +
                    "Con el transcurso de los años esta construcción adquiere distintos nombres; inicialmente llamada “puerta del puente” más tarde “puerta del reloj” y por último “torre del reloj” o “reloj público”; como es conocida actualmente.\n" +
                    "A lo largo de la historia, la arquitectura de la torre y el diseño del reloj han sufrido cambios y modificaciones por diversas razones. \n" +
                    "En 1631 esta obra se convirtió en la puerta principal de la ciudad desde que se concluyó la construcción del cerco amurallado. Años más tarde, fue parcialmente destruida por el barón de Pointis quien fue un pirata Francés responsable del saqueo pirata de cartagena en el año 1697. \n" +
                    "En 1704 la restauración de la torre estuvo en manos del ingeniero Juan Herrera y Sotomayor, quien fue el responsable de agregar una fachada barroca y las cuatro columnas toscanas que la adornan.\n" +
                    "En el año 1874, el reloj fue reemplazado por un reloj traído desde Estados Unidos.\n" +
                    "En el año de 1888 por orden de la autoridad local, se le realizó una nueva restauración a la torre, el encargado de esta labor fue el arquitecto Luis Felipe Jaspe Franco, quien reemplazó la estructura cuadrada por un diseño octagonal. Cambiando visiblemente de un estilo barroco a un estilo gótico. \n" +
                    "En 1937 se incorpora a la torre un reloj importado de Suiza.\n" +
                    "En el año 2014 con el ánimo de recuperar el diseño original del reloj, se reincorporaron  los números romanos, con la particularidad de representar el número 4 con 4 líneas. Hay muchas historias sobre el origen del número cuatro en los relojes con cuatro líneas, una de ellas cuenta que un relojero se equivocó y el rey lo mandó a decapitar, entonces en oposición a ese acto de crueldad, los demás relojeros decidieron seguir con el número con 4 líneas.\n", 0, 10.4230533, -75.549212,
                    null
            ),


            new AudioGuide(1, "Plaza de la Aduana", "Información general", R.mipmap.plaza_de_la_aduana_cover, R.mipmap.plaza_de_la_aduana_portada, R.raw.audio_plaza_de_la_aduana, "La Plaza de la Aduana es una de las más amplias y elegantes plazas de Cartagena de Indias. En un principio la plaza fue construida cerca al viejo muelle de la ciudad y abierta hacia el mar. Pero en el siglo XVI después del ataque inglés en cabeza de Francis Drake y de los constantes ataques piratas que recibía la ciudad, se ordenó la construcción de la icónica muralla de piedra que recubre el centro histórico de Cartagena de Indias.\n" +
                    "Con la construcción de la muralla el espacio se definió como un ámbito cerrado de planta triangular, delicadamente articulado con las plazas de los Coches. y de San Juan de Dios, actualmente Plaza de San Pedro Claver. \n" +
                    "Como la mayoría de las plazas cartageneras, esta ha tenido varios nombres que nos recuerdan su historia. \n" +
                    "En la antigüedad, la plaza de la aduana se conocía como plaza del mar, debido a su cercanía al muelle viejo de la ciudad. También se le conoció como la Antigua Real Contaduría, ya que en ella estaban instauradas las oficinas de los oficiales reales.\n" +
                    "En pleno auge económico de Cartagena, en el siglo XVIII, se construyó el edificio de la Aduana, montado sobre la muralla y abierto en pórticos hacia la plaza. en ese mismo edificación vivió un prestigioso pirata inglés. \n" +
                    "En el edificio de la Aduana, que abarca todo un costado de la plaza, vivió el fundador de Cartagena don Pedro de Heredia. \n" +
                    "\n" +
                    "Don Pedro fue, junto con su hermano don Alonso, quien resistió el feroz ataque del pirata francés Roberto Baal, en 1544.\n" +
                    "En 1894, el Cabildo Con motivo del aniversario del Descubrimiento de América la denominó la plaza  Colón, por lo cual, se instaló la estatua del descubridor Cristóbal Colón. \n" +
                    "En 1970 el nombre de la plaza fue cambiado a plaza de la aduana, por estar ubicada en el mismo edificio en el que operaba la administración de la aduana.\n" +
                    "Sin embargo, a inicios del siglo XX, por orden del ayuntamiento fue llamada plaza de Rafael Núñez, en homenaje al cartagenero, el cual  fue 4 veces presidente de la república y quien fue la persona encargada de escribir la letra del actual himno de republica de Colombia. Pero a pesar de los distintos nombres que le colocaron a la plaza, la gente seguía llamándola la plaza de la Aduana. Esta plaza es la más grande de todas en Cartagena, y también la más bonita en arquitectura.\n" +
                    "Antiguamente existió en el marco de esta plaza el Portal de los Moros, una galería con arcos donde funcionaban las tiendas y comercios de los musulmanes que llegaron a Cartagena a principios del siglo XVII.\n" +
                    "Plaza de la Aduana", 0, 10.422166, -75.5504599,
                    null
            ),


            new AudioGuide(2, "Muelle de los pegasos", "Información general", R.mipmap.muelle_de_los_pegasos_portada, R.mipmap.muelle_de_los_pegasos_portada, R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", 1, 10.4222998, -75.5488254,
                    null
            ),
            new AudioGuide(3, "Plaza de Santo Domingo", "Información general", R.mipmap.plaza_santo_domingo, R.mipmap.plaza_santo_domingo, R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", 1, 10.4242147, -75.5542509,
                    null
            ),
            new AudioGuide(4, "Iglesia San Pedro Claver", "Información general", R.mipmap.iglesia_san_pedro_claver_portada, R.mipmap.iglesia_san_pedro_claver_portada, R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", 1, 10.422013, -75.5518895,
                    null
            ),
            new AudioGuide(5, "Plaza de los coches", "Información general", R.mipmap.plaza_de_los_coches_portada, R.mipmap.plaza_de_los_coches_portada, R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", 1, 10.4229373, -75.5493749,
                    null
            ),
            new AudioGuide(6, "Plaza de la paz", "Información general", R.mipmap.plaza_de_la_paz_portada, R.mipmap.plaza_de_la_paz_portada, R.raw.audio_torre_del_reloj, "La torre del reloj con una altura total de 30 metros, constituye uno de los símbolos arquitectónicos más conocidos de la ciudad de Cartagena de indias; está ubicada en pleno corazón de la heroica, y podríamos considerarla, la fachada de la ciudad antigua", 1, 10.4230217, -75.5489867,
                    null
            )
    };


    public static List<AudioGuide> getAudioGuide() {
        List<AudioGuide> audioguideList = new ArrayList();
        for (int i = 0; i < audioguides.length; i++) {
                       if (i==0){
                ArrayList<Integer> gallery= new ArrayList<Integer>();
                gallery.add(R.mipmap.torre_del_reloj_cover);
                gallery.add(R.mipmap.torre_del_reloj_historico_1);
                gallery.add(R.mipmap.torre_del_reloj_3);
                gallery.add(R.mipmap.torre_del_reloj_historico_2);
                gallery.add(R.mipmap.torre_del_reloj_2);

                audioguides[i].setGallery(gallery);
                audioguideList.add(audioguides[i]);
            }
            if (i==1){
                ArrayList<Integer> gallery= new ArrayList<Integer>();
                gallery.add(R.mipmap.plaza_de_la_aduana_1);
                gallery.add(R.mipmap.plaza_de_la_aduana_cover);
                gallery.add(R.mipmap.plaza_de_la_aduana_2);
                gallery.add(R.mipmap.plaza_de_la_aduana_historico_1);

                audioguides[i].setGallery(gallery);
                audioguideList.add(audioguides[i]);
            }
            if (i>1){
                ArrayList<Integer> gallery= new ArrayList<Integer>();
                gallery.add(R.mipmap.torre_del_reloj_portada);
                gallery.add(R.mipmap.torre_del_reloj_cover);
                gallery.add(R.mipmap.torre_del_reloj_historico_1);

                audioguides[i].setGallery(gallery);
                audioguideList.add(audioguides[i]);
            }
        }
        return audioguideList;
    }

    AudioGuide searchAudioGuide(int position) {
        AudioGuide audioguide = null;
        for (int i = 0; i < audioguides.length; i++) {

            if (position == audioguides[i].getId()) {
                audioguide = audioguides[i];
            }
        }
        return audioguide;
    }
}
