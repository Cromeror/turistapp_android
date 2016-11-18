package com.turistory.android.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jota on 24/09/2016.
 * Para efectos de pruebas locales.
 */

public class PlacesDataProvider {

    private static final Place[] places = new Place[]{
            new Place(1, "Muelle de los Pegasos", "El Muelle de los Pegasos es hoy un centro de " +
                    "actividades culturales y un embarcadero turístico. Su decoración muestra dos " +
                    "esculturas de pegasos...", 10.422166, -75.548703),
            new Place(2, "Torre del Reloj", "El reloj además de ser el símbolo representativo " +
                    "de Cartagena es la entrada a la ciudad. Esta torre fue instaurada en el" +
                    " siglo XIX...", 10.423037, -75.549180),
            new Place(3, "Palacio de la Inquisicion", "Este edificio es considerado una de las " +
                    "casas típicas de la arquitectura civil de la Cartagena de Indias del " +
                    "siglo XVIII.", 10.422902, -75.551356),
            new Place(4, "India catalina", "La India Catalina es uno de los personajes " +
                    "indígenas de la historia de Colombia, conocida por ser la amante de don " +
                    "Pedro de Heredia. ",10.426468, -75.544040)
    };

    public static List<Place> getPlaces() {
        List<Place> placesList = new ArrayList();
        for (int i = 0; i < places.length; i++) {
            placesList.add(places[i]);
        }
        return placesList;
    }

}
