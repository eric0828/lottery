package com.lottery.component;

import java.awt.*;

/**
 * Created by tasly on 2014/10/22.
 */
public class ImageButton extends CrystalComponent {
    private String name;      //Ãû³Æ
    private Image image;     //Í¼±ê

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
