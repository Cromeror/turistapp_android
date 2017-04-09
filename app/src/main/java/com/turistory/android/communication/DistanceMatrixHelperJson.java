package com.turistory.android.communication;

import android.util.JsonReader;
import android.util.Log;

import com.turistory.android.communication.dto.distance_matrix.*;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristóbal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0
 */

public class DistanceMatrixHelperJson {
    public DistanceMatrix readJsonStream(Reader in) throws IOException {

        JsonReader reader = new JsonReader(in);
        try {
            return readDistance(reader);
        } finally {
            reader.close();
        }
    }

    /**
     * Lee un objeto JSON Distance Matrix
     *
     * @param reader
     * @return
     * @throws IOException
     */
    public DistanceMatrix readDistance(JsonReader reader) throws IOException {
        DistanceMatrix distance;

        reader.beginObject();
        //while (reader.hasNext()) {
        distance = readDistanceMatrix(reader);
        //}
        reader.endObject();
        return distance;
    }

    public DistanceMatrix readDistanceMatrix(JsonReader reader) throws IOException {
        List<String> destination_addresses = null;
        List<String> origin_addresses = null;
        List<Element> rows = null;
        String status = null;

        List<Double> geo = null;

        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case ("destination_addresses"):
                    destination_addresses = readStringsArray(reader);
                    break;
                case ("origin_addresses"):
                    origin_addresses = readStringsArray(reader);
                    break;
                case ("rows"):
                    rows = readRowsArray(reader);
                    break;
                case ("status"):
                    status = reader.nextString();
                    break;
                default:
                    reader.skipValue();
            }
        }
        return new DistanceMatrix(destination_addresses, origin_addresses, rows, status);
    }

    private List<Element> readRowsArray(JsonReader reader) throws IOException {
        List<Element> elements = new ArrayList<Element>();

        reader.beginArray();
        while (reader.hasNext()) {
            elements.add(readElementArray(reader));
        }
        reader.endArray();
        return elements;
    }

    private Element readElementArray(JsonReader reader) throws IOException {
        Item distance = null;
        Item duration = null;
        String status = null;
        reader.beginObject();
        while (reader.hasNext()) {
            switch (reader.nextName()) {
                case ("elements"):
                    reader.beginArray();
                    while (reader.hasNext()) {
                        reader.beginObject();
                        while (reader.hasNext()) {
                            switch (reader.nextName()) {
                                case ("distance"):
                                    distance = readItem(reader);
                                    break;
                                case ("duration"):
                                    duration = readItem(reader);
                                    break;
                                case ("status"):
                                    status = reader.nextString();
                                    break;
                                default:
                                    reader.skipValue();
                            }
                        }
                        reader.endObject();
                    }
                    reader.endArray();
                    break;
            }
        }
        reader.endObject();
        return new Element(distance, duration, status);
    }

    private Item readItem(JsonReader reader) throws IOException {
        String text = null;
        Integer value = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case ("text"):
                    text = reader.nextString();
                    break;
                case ("value"):
                    value = reader.nextInt();
                    break;
                default:
                    reader.skipValue();
            }
        }
        reader.endObject();
        return new Item(text, value);
    }

    public List<String> readStringsArray(JsonReader reader) throws IOException {
        List<String> strings = new ArrayList<String>();

        reader.beginArray();
        while (reader.hasNext()) {
            strings.add(reader.nextString());
        }
        reader.endArray();
        return strings;
    }
}
