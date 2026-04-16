package org.example.pruebafx;

import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class SegundaControler {

    @FXML
    private TableView<Persona> personasTableVew;

    @FXML
    private TableColumn<Persona,String>nameTable;

    @FXML
    private TableColumn<Persona,Integer>edadTable;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField edadTextField;

    @FXML
    private void initialize(){


        nameTable.setCellValueFactory(datos -> new SimpleStringProperty(datos.getValue().getNombre()));
        edadTable.setCellValueFactory(datos-> new SimpleIntegerProperty(datos.getValue().getEdad()).asObject());
        personasTableVew.setItems(DatsoPersonas.getListaPersona());

    }



    public void retrocesoClickButton() throws IOException {
        HelloApplication.setRoot("hello-view");
    }


    public void guardarButton() {
        String nombre = nombreTextField.getText();
        Integer edad = Integer.parseInt(edadTextField.getText());
        nombreTextField.clear();
        edadTextField.clear();

        Persona persona = new Persona(nombre,edad);

        System.out.println("Persona creada: " + nombre + " - " + edad);

        DatsoPersonas.insertarPersona(persona);

        System.out.println(DatsoPersonas.getListaPersona());

    }
}
