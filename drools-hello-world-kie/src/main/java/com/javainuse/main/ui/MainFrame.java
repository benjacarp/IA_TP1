package com.javainuse.main.ui;

import com.javainuse.main.rulesengine.DroolsEngine;
import com.javainuse.main.rulesengine.JFuzzyEngine;
import com.javainuse.model.Emprendedor;
import com.javainuse.model.Pareja;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFrame extends Stage {

    private Button calcularBtn;
    private CheckBox aIsInversionistaCheckBox = new CheckBox();
    private CheckBox aIsEmprendedorCheckBox = new CheckBox();
    private CheckBox bIsInversionistaCheckBox = new CheckBox();
    private CheckBox bIsEmprendedorCheckBox = new CheckBox();
    private TextField aExperienceField = new TextField();
    private TextField aPatrimonioField = new TextField();
    private TextField bExperienceField = new TextField();
    private TextField bPatrimonioField = new TextField();

    public MainFrame() {
        initComponents();
        createStage();
    }

    private void initComponents() {
        calcularBtn = new Button("Calcular");
        calcularBtn.setOnAction(event -> calcular());
    }

    private void calcular() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation Needed");
        alert.setHeaderText("Points: ");
        try {
            alert.setContentText("" + DroolsEngine.calculate(createPareja()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        alert.show();
    }

    private Pareja createPareja() {
        Pareja p = new Pareja();

        Emprendedor a = new Emprendedor();
        a.setEmprendedor(aIsEmprendedorCheckBox.isSelected());
        a.setInversionista(aIsInversionistaCheckBox.isSelected());
        a.setExperience(Integer.parseInt(aExperienceField.getText()));
        a.setPatrimonio(Double.parseDouble(aPatrimonioField.getText()));
        a.setRaiting(JFuzzyEngine.calculate(a.getExperience(), a.getPatrimonio()));
        System.out.println(a.getRaiting());

        Emprendedor b = new Emprendedor();
        b.setEmprendedor(bIsEmprendedorCheckBox.isSelected());
        b.setInversionista(bIsInversionistaCheckBox.isSelected());
        b.setExperience(Integer.parseInt(bExperienceField.getText()));
        b.setPatrimonio(Double.parseDouble(bPatrimonioField.getText()));
        b.setRaiting(JFuzzyEngine.calculate(b.getExperience(), b.getPatrimonio()));
        System.out.println(b.getRaiting());

        p.setEmpA(a);
        p.setEmpB(b);

        return p;
    }

    private void createStage() {
        BorderPane pane = new BorderPane();
        HBox centerLayOut = new HBox();

        ///////////// 1er panel
        VBox maleLayout = new VBox();

        HBox inversionistaALayout = new HBox();
        inversionistaALayout.getChildren().addAll(new Label("Inversionista: "), aIsInversionistaCheckBox);

        HBox emprendedorALayout = new HBox();
        emprendedorALayout.getChildren().addAll(new Label("Emprendedor: "), aIsEmprendedorCheckBox);

        HBox experienceALayout = new HBox();
        experienceALayout.getChildren().addAll(new Label("Experiencia: "), aExperienceField);

        HBox patrimonioALayout = new HBox();
        patrimonioALayout.getChildren().addAll(new Label("Patrimonio: "), aPatrimonioField);

        maleLayout.getChildren().addAll(inversionistaALayout, emprendedorALayout, experienceALayout,patrimonioALayout);

        ////////////// separador
        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);

        ////////////// 2do panel
        VBox femaleLayout = new VBox();

        HBox inversionistaBLayout = new HBox();
        inversionistaBLayout.getChildren().addAll(new Label("Inversionista: "), bIsInversionistaCheckBox);

        HBox emprendedorBLayout = new HBox();
        emprendedorBLayout.getChildren().addAll(new Label("Emprendedor: "), bIsEmprendedorCheckBox);

        HBox experienceBLayout = new HBox();
        experienceBLayout.getChildren().addAll(new Label("Experiencia: "), bExperienceField);

        HBox patrimonioBLayout = new HBox();
        patrimonioBLayout.getChildren().addAll(new Label("Patrimonio: "), bPatrimonioField);

        femaleLayout.getChildren().addAll(inversionistaBLayout, emprendedorBLayout, experienceBLayout,patrimonioBLayout);


        //////////// armar los 2 paneles
        centerLayOut.getChildren().addAll(maleLayout, separator,femaleLayout);
        pane.setCenter(centerLayOut);

        ///////////// boton calcular
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(calcularBtn);
        pane.setBottom(stackPane);

        Scene scene = new Scene(pane,300,200);
        this.setScene(scene);
    }


}
