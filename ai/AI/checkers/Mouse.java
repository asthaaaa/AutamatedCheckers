package checkers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Mouse implements MouseListener {
    @Override
    public void mousePressed(MouseEvent e) {
        int col = (e.getX() - 100) / 50;
        int row = (e.getY() - 100) / 50;
        if (col >= 0 && col < 8 && row >= 0 && row < 8) {
            Game.moveFromXcoordinate = row;
            Game.moveFromYcoordinate = col;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int row = (e.getY() - 100) / 50;
        int col = (e.getX() - 100) / 50;
        if (col >= 0 && col < 8 && row >= 0 && row < 8) {
            Game.moveToXcoordinate = row;
            Game.moveToYcoordinate = col;
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
    }

    @Override
    public void mouseEntered(MouseEvent evt) {
    }

    @Override
    public void mouseExited(MouseEvent evt) {
    }
}
