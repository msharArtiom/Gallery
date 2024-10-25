package com.vizor.test;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class ImageLoaderService {
    public ArrayList<ImageIcon> loadImages(String directoryPath) {
        ArrayList<ImageIcon> images = new ArrayList<>();
        File assetsDirectory = new File(directoryPath);
        File[] files = assetsDirectory.listFiles((dir, name) -> name.endsWith(".jpg")
                || name.endsWith(".png")
                || name.endsWith(".gif"));
        if (files != null) {
            for (File file : files) {
                images.add(new ImageIcon(file.getAbsolutePath()));
            }
        }
        return images;
    }
}
