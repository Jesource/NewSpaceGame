package com.example.spacgame.game;

import java.util.Random;

public class Asteroid extends Polygon {
    public Asteroid(Point pos) {
        super(astShape(), pos, setRot(pos));
    }

    public void reset() {
        this.position = pos();
        this.rotation = setRot(this.position);
    }

    public static Point[] astShape() {
        Random random = new Random();
        return new Point[]{
                new Point((int) 0.0, (int) 0.0),
                new Point(random.nextInt(6) + 5, -(random.nextInt(6) + 10)),
                new Point((int) (random.nextInt(6) + 15), (int) -random.nextInt(5)),
                new Point((int) (random.nextInt(6) + 25), (int) random.nextInt(5)),
                new Point((int) (random.nextInt(6) + 15), (int) (random.nextInt(6) + 15)),
                new Point((int) (random.nextInt(5) - 5), (int) (random.nextInt(5) + 10))
        };
    }

    public static Point pos() {
        Random random = new Random();
        int x = 0;
        int y = 0;
        int pos = random.nextInt(4);

        switch (pos) {
            case 0:
                x = 0;
                y = random.nextInt(601);
                break;
            case 1:
                x = random.nextInt(801);
                y = 0;
                break;
            case 2:
                x = 800;
                y = random.nextInt(601);
                break;
            case 3:
                x = random.nextInt(801);
                y = 600;
                break;
        }

        Point point = new Point(x, y);
        return point;
    }

    public static double setRot(Point position) {
        Random random = new Random();
        if (position.x < 400.0) {
            return position.y < 300.0 ? (double)(random.nextInt(31) + 30) : (double)(random.nextInt(31) + 300);
        } else {
            return position.y < 300.0 ? (double)(random.nextInt(31) + 120) : (double)(random.nextInt(31) + 210);
        }
    }

    public static Asteroid[] arrAst(int n) {
        Asteroid[] arrAst = new Asteroid[n];

        for(int i = 0; i < n; ++i) {
            arrAst[i] = new Asteroid(pos());
        }

        return arrAst;
    }

    public void move() {
        double prevPosX = this.position.x;
        double prevPosY = this.position.y;
        this.position = new Point((int) (this.position.x + 2.0 * Math.cos(Math.toRadians(this.rotation))), (int) (this.position.y + 2.0 * Math.sin(Math.toRadians(this.rotation))));
        if (this.position.x > 800.0 && prevPosX < this.position.x) {
            this.position = new Point((int) -10.0, this.position.y);
        } else if (this.position.x < 0.0 && prevPosX > this.position.x) {
            this.position = new Point((int) 810.0, this.position.y);
        }

        if (this.position.y > 600.0 && prevPosY < this.position.y) {
            this.position = new Point(this.position.x, (int) -10.0);
        } else if (this.position.y < 0.0 && prevPosY > this.position.y) {
            this.position = new Point(this.position.x, (int) 610.0);
        }
    }
}
