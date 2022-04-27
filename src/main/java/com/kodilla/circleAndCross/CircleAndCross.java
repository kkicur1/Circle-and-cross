package com.kodilla.circleAndCross;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CircleAndCross extends Application {
    public int index=0;
    private Label gameName = new Label("Circle and Cross");
    private Label yourScore = new Label("Your score:");
    private Label computerScore = new Label("Computer score:");
    private Label yourResult = new Label();
    private Label computerResult = new Label();
    private Label status = new Label();
    private GridPane board = new GridPane();
    private Field[][] fields = new Field[3][3];
    private GridPane menu = new GridPane();
    private Image turn = Field.CIRCLE;

    //Stworzenie pól
    public void fieldCreation() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final Field field = new Field(Field.EMPTY);
                fields[i][j] = field;
                board.add(field, i, j);

                field.setOnAction((ActionEvent actionEvent) -> {
                    Field source = (Field) actionEvent.getSource();

                    if (source.isEmpty()) {
                        if (turn.equals(Field.CIRCLE)) {
                            source.setImage(Field.CIRCLE);
                            turn = Field.CROSS;
                        } else {
                            source.setImage(Field.CROSS);
                            turn = Field.CIRCLE;
                        }
                    }
                    winCheck();
                });
            }
        }
    }


    //weryfikacja wygranej
    public void winCheck () {

        if (fields[1][1].isCircle()&&fields[1][2].isCircle()&&fields[1][3].isCircle()||
                fields[2][1].isCircle()&&fields[2][2].isCircle()&&fields[3][3].isCircle()||
                fields[3][1].isCircle()&&fields[3][2].isCircle()&&fields[3][3].isCircle()||
                fields[1][1].isCircle()&&fields[2][1].isCircle()&&fields[3][1].isCircle()||
                fields[1][2].isCircle()&&fields[2][2].isCircle()&&fields[3][2].isCircle()||
                fields[1][3].isCircle()&&fields[2][3].isCircle()&&fields[3][3].isCircle()||
                fields[1][1].isCircle()&&fields[2][2].isCircle()&&fields[3][3].isCircle()||
                fields[3][1].isCircle()&&fields[2][2].isCircle()&&fields[1][3].isCircle()) {
                index++;
                StringBuilder total= new StringBuilder();
                total.append(index);
                yourResult.setText(total.toString());
                status.setText("YOU WIN!");
                System.out.println("YOU WIN!");
        }

            if (fields[1][1].isCross()&&fields[1][2].isCross()&&fields[1][3].isCross()||
                    fields[2][1].isCross()&&fields[2][2].isCross()&&fields[3][3].isCross()||
                    fields[3][1].isCross()&&fields[3][2].isCross()&&fields[3][3].isCross()||
                    fields[1][1].isCross()&&fields[2][1].isCross()&&fields[3][1].isCross()||
                    fields[1][2].isCross()&&fields[2][2].isCross()&&fields[3][2].isCross()||
                    fields[1][3].isCross()&&fields[2][3].isCross()&&fields[3][3].isCross()||
                    fields[1][1].isCross()&&fields[2][2].isCross()&&fields[3][3].isCross()||
                    fields[3][1].isCross()&&fields[2][2].isCross()&&fields[1][3].isCross()) {
                    index++;
                    StringBuilder total= new StringBuilder();
                    total.append(index);
                    yourResult.setText(total.toString());
                    status.setText("YOU WIN!");
                    System.out.println("YOU WIN!");
            }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        gameName.setFont(new Font("Arial", 14));
        gameName.setTextFill(Color.web("#0000FF"));
        yourScore.setFont(new Font("Arial", 14));
        yourScore.setTextFill(Color.web("#0000FF"));
        computerScore.setFont(new Font("Arial", 14));
        computerScore.setTextFill(Color.web("#0000FF"));
        yourResult.setFont(new Font("Arial", 14));
        yourResult.setTextFill(Color.web("#0000FF"));
        computerResult.setFont(new Font("Arial", 14));
        computerResult.setTextFill(Color.web("#0000FF"));
        status.setFont(new Font("Arial", 14));
        status.setTextFill(Color.web("red"));

        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(2.5);
        grid.setVgap(2.5);
        grid.setGridLinesVisible(true);

        Button newbtn = new Button();
        newbtn.setText("New game");
        newbtn.setFont(new Font("Arial", 14));
        newbtn.setTextFill(Color.web("red"));
        newbtn.setOnAction((e) -> {
            fieldCreation();
            });


        //Plansza
        board.setAlignment(Pos.CENTER);
        board.setPadding(new Insets(2.5, 12.5, 13.5, 14.5));
        board.setHgap(2.5);
        board.setVgap(2.5);
        board.setGridLinesVisible(true);

        //Stworzenie pól
        fieldCreation();

        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(1.5, 1.5, 1.5, 1.5));
        menu.setHgap(2.5);
        menu.setVgap(2.5);
        menu.setGridLinesVisible(true);

        menu.add(newbtn,0,0);
        menu.add(gameName,1,0);
        menu.add(yourScore,2,0);
        menu.add(yourResult,3,0);
        menu.add(computerScore,4,0);
        menu.add(computerResult,5,0);
        menu.add(status,2,1);

        grid.add(board, 0, 0);
        grid.add(menu, 0, 1);

        Scene scene = new Scene(grid, 1400, 800, Color.BLACK);

        primaryStage.setTitle("CircleAndCross");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}