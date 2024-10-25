package com.vizor.test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ImagePanel extends JPanel {
    private final int imageWidth;
    private final int imageHeight;

    public ImagePanel(int imageWidth, int imageHeight) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        setLayout(new GridLayout(0, 3)); // Устанавливаем сетку (3 колонки)
    }

    public void updateImages(ArrayList<ImageIcon> images) {
        removeAll(); // Очищаем панель перед добавлением новых изображений
        for (ImageIcon imageIcon : images) {
            // Изменяем размер изображения
            Image scaledImage = imageIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            add(imageLabel); // Добавляем изображение на панель
        }
        revalidate(); // Обновляем панель
        repaint(); // Перерисовываем панель
    }
}
