package com.turistory.android.data;

import com.turistory.android.testactivity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jota on 24/09/2016.
 * Para efectos de pruebas locales.
 */

public class PlacesDataProvider {

    private static final Place[] places = new Place[]{
            //10.444602, -75.522984
            new Place(1, "Bahía de las ánimas", "Con la disminución de la mano de obra indígena, se hizo necesaria la importación de mano de obra africana, traída por la fuerza en penosas condiciones para trabajar en labores del campo, minería, construcción y tareas domésticas.\n" +
                    "En La región de África Occidental entre Senegal y Angola, se encontraban los tres grandes reinos  de Mali, Benín y Kongo,  los cuales comprendían el área geográfica donde se inició la trata negrera que transportó a los esclavos que llegaron a puerto en el Caribe colombiano.\n" +
                    "La trata de esclavos estuvo controlada por Portugal, Holanda e Inglaterra, y fueron ellos quienes capturaban a los negros y los transportaban hasta el puerto cartagenero. Incluso muchos esclavos eran cazados por personas de la misma raza negra y estos eran vendidos a los portugueses. \n" +
                    "Como las condiciones de navegabilidad no permitían a las grandes embarcaciones arribar a la  bahía de las Ánimas, se anclaban fuera de la bahía y desde allí desembarcaban a los esclavos en embarcaciones más pequeñas y estas eran transportadas hasta la ciudad. Los esclavos llegaban a tierra firme luego de dos meses de travesía, encadenados y en pésimas  condiciones de salud.\n" +
                    "Aunque esta primera travesía terminaba en Cartagena, para  la gran mayoría no era su destino final, pues en el mercado de la ciudad serían vendidos a mercaderes, mineros y hacendados que  esperaban con entusiasmo la llegada de la mano de obra africana y la apertura de la feria comercial.",
                    10.4447742, -75.5229662, R.mipmap.torre_del_reloj_portada),
            new Place(2, "PLAZA DE LA ADUANA", "10.444602, -75.522984El principal organismo de control sobre las importaciones y exportaciones que se hacían en Cartagena  de indias, tenía como epicentro principal a la Plaza de la Antigua Real Contaduría o Plaza  de la Aduana. En ella se encontraba la Casa Real,  lugar donde se legalizaban todas las mercancías que entraban al puerto.\n" +
                    "El Gobernador y los oficiales reales revisaban los navíos, acompañados por un teniente, un representante de la compañía negrera y un notario. Se procedía a interrogar a la persona al mando de la embarcación, sobre la cantidad de negros esclavizados que sobrevivieron a la travesía,  los decesos durante el viaje y las mercancías que acompañaban a la embarcación.\n" +
                    "Luego eran sacados en lanchones hasta la plaza de la aduana donde se hacía un reconteo. El avalúo y medición de la carga de esclavizados era conocido como “palmeo”,  operación que se ejecutaba con la presencia de cirujanos, quienes hacían la revisión de las “piezas de indias”.  Un esclavo podía valer en promedio entre 150 y 350 pesos,  dependiendo su condición como etnia,  edad,  sexo y resistencia física. Si tenía alguna  tacha o defecto,  si era menor de edad o cría, el valor disminuía, pero si por el contrario el esclavo tenía especialización en alguna actividad el precio aumentaba.\n",
                    10.423037, -75.549180),
            new Place(3, "Plaza de la Paz", "La Plaza de la Paz fue conocida como Plaza de las negras, porque allí, autorizadas  u obligadas por sus dueños, negras esclavas y libres vendían  frutas, verduras y carnes al menudeo. Los viajeros de la ciudad de finales del siglo XVIII ubican esta plaza en el terreno que queda por fuera de la Torre del Reloj.\n" +
                    "En  este sector denominado  La Plaza de la paz el proceso  de esclavización  estuvo relacionado con el proceso de venta y servicios en los que eran usadas las esclavizadas para realizar actividades relacionadas con la vida  cotidiana.\n" +
                    "La memoria  de la esclavización está relacionada  con la forma en que a través del comercio, muchos negras libres lograron mejorar sus condiciones de vida y fueron forjando una resistencia que, sin duda alguna, contribuyó en el proceso independentista.",
                    10.422902, -75.551356),
            new Place(4, "CALLE DE SANTO DOMINGO", "Las negrerías eran almacenes donde los esclavos eran depositados en condiciones infrahumanas, para así, ser mostrados y vendidos. Eran construcciones rectangulares, de muros desnudos,  con una  sola puerta y una ventana en lo alto, estos almacenes podían albergar hasta 200 esclavos. En Cartagena de indias se registraron alrededor de 24 construidas cerca de los sitios de desembarco, en las calles de Santa Clara, San Diego y Santo Domingo.\n" +
                    "Los esclavos llegaban a estas negrerías hechos unos esqueletos, llenos de llagas y raspones, y los alojaban en un gran patio o corral donde acudía la gente,  unos  llevados por codicia, otros por curiosidad y otros por compasión. \n" +
                    "En las negrerías se dedicaban a engordar a los esclavos para poderlos vender a un precio más alto.  Estos aposentos estaban rodeados de tablas y en la noche separaban en corrales a los hombres de las mujeres, para que estos no pudieran tener relaciones sexuales, debido que una negra esclava embarazada costaba menos.\n" +
                    " Debido a los materiales en que eran construidas las negrerías ninguna se conservó, por tanto en la actualidad, no hay referencia que haga alusión a la existencia de estas construcciones donde se guardaba por un tiempo a los esclavizados. ",
                    10.426468, -75.544040),
            new Place(5, "Casas de Cabildos", "De acuerdo a la información  contenida  en el Censo  de 1.777,  se sabe  que en el barrio de Santo Toribio  (hoy barrio San  Diego), en las calles que daban  hacía lo que hoy día son la calle del Jardín y la calle de las Bóvedas, se encontraban las casas de los cabildos  de negros esclavizados.\n" +
                    "Estos cabildos eran asociaciones que congregaban a la población negra esclavizada,  originaria de un mismo grupo  cultural. Fueron  lugares  para la  conservación  de  sus propias  lenguas africanas,  la memoria y la resistencia  cultural. Las casas de cabildo, eran lugares donde se realizaban encuentros de esta población para  tocar el tambor, realizar festejos y llevar a cabo llantos y cantos fúnebres.  Se expresaban a través de la música y la danza, y Quienes asistían  también aportaban recursos para apoyar a los más necesitados  o para las mismas  fiestas. Según datos recopilados en Cartagena de Indias  existieron  dos Cabildos  de gran  importancia que  fueron  registrados  por los cronistas. Se  trata  de  los  Cabildos  Arará  y Mina."
                    , 10.426468, -75.544040),
            new Place(6, "Plaza de los coches", "En  esa  zona  se  estableció  un  fluido  intercambio  entre mercaderes  y consumidores, y fue el lugar por excelencia donde se desarrolló la compra  y venta  de  esclavos.  Esta  plaza,  era el  principal escenario para el comercio de esclavizados. En la época de mayor afluencia de gente negra a la ciudad a la Plaza de los Coches se le conoció como Plaza del Esclavo",
                    10.426468, -75.544040),
            new Place(7, "Plaza Fernández Madrid", "Esta plaza fue conocida mucho tiempo como «Plaza de Santo Toribio», por su cercanía con la iglesia del mismo nombre. En este lugar existían varios jagüeyes o pozos en donde la población esclavizada y los criados iban a recoger agua que habrían de llevar a sus lugares de alojamiento o a las residencias donde prestaban servicio doméstico. Por este motivo fue conocida como «Plaza de los Jagüeyes» durante gran parte del periodo colonial.",
                    10.426468, -75.544040)
    };

    public static List<Place> getPlaces() {
        List<Place> placesList = new ArrayList();
        for (int i = 0; i < places.length; i++) {
            placesList.add(places[i]);
        }
        return placesList;
    }

}
