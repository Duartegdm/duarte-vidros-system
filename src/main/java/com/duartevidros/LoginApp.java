package com.duartevidros;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label userLabel = new Label("Usuário:");
        TextField userField = new TextField();

        Label passLabel = new Label("Senha:");
        PasswordField passField = new PasswordField();

        Button loginButton = new Button("Login");
        Label messageLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();

            if (authenticateUser(username, password)) {
                messageLabel.setText("Login bem-sucedido!");
                // Aqui você pode abrir a interface principal do sistema
            } else {
                messageLabel.setText("Usuário ou senha incorretos.");
            }
        });

        VBox layout = new VBox(10, userLabel, userField, passLabel, passField, loginButton, messageLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(15);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login - Sistema de Gerenciamento");
        primaryStage.show();
    }

    private boolean authenticateUser(String username, String password) {
        // Aqui você pode chamar seu backend usando HttpClient
        // Exemplo básico fictício:
        return "admin".equals(username) && "1234".equals(password);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
