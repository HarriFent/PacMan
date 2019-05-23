package com.pac.man.GameObjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pac.man.GameObject;
import com.pac.man.Main;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Wall{

    private int[][] wallCollisions;

    public Wall() {
        /*
        try {
            wallCollisions = new int[31][24];
            BufferedWriter bw = new BufferedWriter(new FileWriter("level.txt"));

            for (int i = 0; i < wallCollisions.length; i++) {
                for (int j = 0; j < wallCollisions[i].length; j++) {
                    bw.write(wallCollisions[i][j] + ((j == wallCollisions[i].length-1) ? "" : ","));
                }
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {}*/

        Scanner input = null;
        try {
            input = new Scanner(new BufferedReader(new FileReader("level.txt")));
            int n = 24;
            int m = 31;
            wallCollisions = new int[m][n];
            while(input.hasNextLine()) {
                for (int i=0; i<wallCollisions.length; i++) {
                    String[] line = input.nextLine().trim().split(",");
                    for (int j=0; j<line.length; j++) {
                        wallCollisions[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void render(SpriteBatch batch) {

        Texture img = new Texture("level.jpg");
        int w = img.getWidth();
        batch.draw(img, Main.WIDTH - (w * 2), 0, w * 2,img.getHeight() * 2);
    }

    public boolean hitTest(int x, int y) {
        return true;
    }

    public void loadGameObjects(List<GameObject> objs) {
        for (int i = 0; i < wallCollisions.length; i++) {
            for (int j = 0; j < wallCollisions[i].length; j++) {
                switch (wallCollisions[i][j]) {
                    case 2:
                        objs.add(new Dot(j,i));
                        break;
                    case 3:
                        objs.add(new Power(j,i));
                    default:
                        break;
                }
            }
        }
    }
}
