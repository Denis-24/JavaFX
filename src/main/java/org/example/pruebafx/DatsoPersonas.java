package org.example.pruebafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatsoPersonas {

    private static ObservableList<Persona> listaPersona = FXCollections.observableArrayList();

    public static void insertarPersona(Persona persona){
        listaPersona.add(persona);

    }


    public static ObservableList<Persona> getListaPersona() {
        return listaPersona;
    }
}
