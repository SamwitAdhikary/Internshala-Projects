package com.samwit.temperature;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("INIT");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("START");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0, menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }

    private MenuBar createMenu() {
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(event -> {
            System.out.println("New Menu Clicked");
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenu = new MenuItem("Quit");

        quitMenu.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenu);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");

        aboutApp.setOnAction(event -> aboutapp());

        helpMenu.getItems().addAll(aboutApp);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    public static void aboutapp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("Hi! I am Samwit Adhikary, a developer focused on crafting" +
                " great web/app experiences. Designing and Coding have been my passion since" +
                " the days I started working with computers but I found myself into app" +
                " design/development since 2019.\n" +
                " \tBeing an Engineer," +
                " I believe in using science to find creative practical solutions." +
                " Here is a Temperature Converter I created as a Beginner.");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

        Optional<ButtonType> clickedButton = alertDialog.showAndWait();

        if (clickedButton.isPresent() && clickedButton.get() == yesBtn) {
            System.out.println("Yes Button Pressed");
        } else {
            System.out.println("No Button Pressed");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stop");
        super.stop();
    }
}
