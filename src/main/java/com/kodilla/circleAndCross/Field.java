package com.kodilla.circleAndCross;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Field extends Button {

    public static final Image CROSS = new Image("file:src/main/resources/cross.jpg");
    public static final Image CIRCLE = new Image("file:src/main/resources/circle.jpg");
    public static final Image EMPTY = new Image("file:src/main/resources/empty.jpg");

    private Image image;

    public Field(Image image) {
        this.image = image;
        updateGraphic();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        updateGraphic();
    }

    public boolean isEmpty() {
        return image.equals(EMPTY);
    }

    public boolean isCircle() {
        return image.equals(CIRCLE);
    }

    public boolean isCross() {
        return image.equals(CROSS);
    }

    private void updateGraphic() {
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);
        this.setGraphic(imageView);
    }

}
