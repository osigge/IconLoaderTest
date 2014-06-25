package de.oliversigge.iconloader.test;

import com.bulenkov.iconloader.IconLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.BorderLayout.*;
import static javax.swing.JFrame.*;

public class IconLoaderTest {

    public static void main(String[] args) {
        final MyIcon myIcon = new MyIcon();
        final Dimension frameSize = new Dimension(500, 400);
        final JFrame frame = new JFrame("Iconloader Test");
        frame.setLayout(new BorderLayout());

        final JMenuBar menuBar = new JMenuBar();
        final JMenu menu = new JMenu("My Menu");
        final JMenuItem menuItem1 = new JMenuItem(myIcon.getMyImageIcon());
        final JMenuItem menuItem2 = new JMenuItem(myIcon.getMyIconLoaderIcon());

        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        frame.add(menuBar, NORTH);

        frame.setPreferredSize(frameSize);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

class MyIcon{

    public static final String ICON_PATH = "/copy.png";

    public Icon getMyImageIcon() {
        final Image img = IconLoader.loadFromResource(ICON_PATH);

        int w = img.getWidth(null);
        int h = img.getHeight(null);

        BufferedImage bufImg = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = bufImg.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return new ImageIcon(img);
    }

    public Icon getMyIconLoaderIcon(){
        return IconLoader.getIcon(ICON_PATH);
    }
}
