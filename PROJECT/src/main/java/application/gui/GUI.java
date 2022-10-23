package application.gui;

import application.model.Position;

import java.io.IOException;

public interface GUI {

    void drawPlayer(Position position);
    void drawMargins(Position position);
    void drawEnemies(Position position);
    void drawBullet(Position position);
    void drawBombs(Position position);
    void drawCovers(Position position);
    void drawArrowRight(Position position);
    void drawArrowLeft(Position position);
    void drawSpaceBar(Position position);
    void drawText(Position position, String text, String color);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
    ACT getNextAction() throws IOException;

    enum ACT {RIGHT, LEFT, UP, DOWN, SHOOT, NONE, QUIT, SELECT}

}
