package checkers;

import javax.swing.*;
import java.awt.*;

class GridBoard extends JFrame {
    int rows;
    int columns;
    int[][] mat;
    JLabel m = new JLabel();

    public GridBoard(int x, int y, int[][] gridBoard) {
        rows = x;
        columns = y;
        mat = gridBoard;
        setLayout(null);
        m.setFont(new Font("Verdana", Font.PLAIN, 18));
        setSize(700, 700);
        setVisible(true);

        add(m);

        m.setForeground(Color.green);
        m.setBounds(300, 500, 300, 40);

    }

    public void changeBoardState(int[][] gridBoard) {
        mat = gridBoard;
    }


    @Override
    public void paint(Graphics g) {
        int i = 0;


        for (int x = 100; x <= 50 + 50 * rows; x += 50) {
            int j = 0;
            for (int y = 100; y <= 50 + 50 * columns; y += 50) {
                g.drawRect(x, y, 50, 50);
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.GRAY);
                    g.fillRect(x, y, 50, 50);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, 50, 50);
                }
                if (mat[j][i] == 1) {
                    g.setColor(Color.RED);
                    g.fillOval(x + 10, y + 10, 30, 30);
                } else if (mat[j][i] == -1) {
                    g.setColor(Color.WHITE);
                    g.fillOval(x + 10, y + 10, 30, 30);
                }
                if (mat[j][i] == 2) {
                    g.setColor(Color.ORANGE);
                    g.fillOval(x + 10, y + 10, 30, 30);
                } else if (mat[j][i] == -2) {
                    g.setColor(Color.GRAY);
                    g.fillOval(x + 10, y + 10, 30, 30);
                }


                j++;
            }
            i++;
        }
    }
}
