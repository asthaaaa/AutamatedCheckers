package checkers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Game {
    static int[][] ib1;
    static int[][] ib2;
    static int[][] ib3;
    static int[][] ib4;
    static int moveFromXcoordinate, moveToXcoordinate, moveFromYcoordinate, moveToYcoordinate;

    static boolean checkCapture(int[][] b, int pl) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (b[i][j] == pl && i + 2 * pl >= 0 && j + 2 * pl >= 0 && i + 2 * pl < 8 && j + 2 * pl < 8 &&
                        b[i + pl][j + pl] * pl < 0 && b[i + 2 * pl][j + 2 * pl] == 0) return true;
                if (b[i][j] == pl && i + 2 * pl >= 0 && j - 2 * pl >= 0 && i + 2 * pl < 8 && j - 2 * pl < 8 &&
                        b[i + pl][j - pl] * pl < 0 && b[i + 2 * pl][j - 2 * pl] == 0) return true;
                if (b[i][j] == 2 * pl && i + 2 * pl >= 0 && j + 2 * pl >= 0 && i + 2 * pl < 8 && j + 2 * pl < 8 &&
                        b[i + pl][j + pl] * pl < 0 && b[i + 2 * pl][j + 2 * pl] == 0) return true;
                if (b[i][j] == 2 * pl && i + 2 * pl >= 0 && j - 2 * pl >= 0 && i + 2 * pl < 8 && j - 2 * pl < 8 &&
                        b[i + pl][j - pl] * pl < 0 && b[i + 2 * pl][j - 2 * pl] == 0) return true;
                if (b[i][j] == 2 * pl && i - 2 * pl >= 0 && j + 2 * pl >= 0 && i - 2 * pl < 8 && j + 2 * pl < 8 &&
                        b[i - pl][j + pl] * pl < 0 && b[i - 2 * pl][j + 2 * pl] == 0) return true;
                if (b[i][j] == 2 * pl && i - 2 * pl >= 0 && j - 2 * pl >= 0 && i - 2 * pl < 8 && j - 2 * pl < 8 &&
                        b[i - pl][j - pl] * pl < 0 && b[i - 2 * pl][j - 2 * pl] == 0) return true;

            }
        }
        return false;
    }

    static ArrayList < int[][] > getallOrdinaryMove(int[][] bo, int pl) {
        ArrayList < int[][] > arr = new ArrayList < int[][] > ();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int[][] b = new int[8][8];
                for (int i1 = 0; i1 < 8; i1++) {
                    for (int j1 = 0; j1 < 8; j1++) {
                        b[i1][j1] = bo[i1][j1];
                    }
                }
                if (b[i][j] == pl && i + pl >= 0 && j - pl >= 0 && i + pl < 8 && j - pl < 8 && b[i + pl][j - pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i + pl][j - pl] = pl;
                    if (pl == 1 && i + pl == 7) {
                        b1[i + pl][j - pl] = 2 * pl;

                    }
                    if (pl == -1 && i + pl == 0) {
                        b1[i + pl][j - pl] = 2 * pl;

                    }
                    arr.add(b1);

                }

                if (b[i][j] == pl && i + pl >= 0 && j + pl >= 0 && i + pl < 8 && j + pl < 8 && b[i + pl][j + pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i + pl][j + pl] = pl;
                    if (pl == 1 && i + pl == 7) {
                        b1[i + pl][j + pl] = 2 * pl;

                    }
                    if (pl == -1 && i + pl == 0) {
                        b1[i + pl][j + pl] = 2 * pl;

                    }
                    arr.add(b1);

                }

                if (b[i][j] == 2 * pl && i + pl >= 0 && j - pl >= 0 && i + pl < 8 && j - pl < 8 && b[i + pl][j - pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i + pl][j - pl] = 2 * pl;
                    arr.add(b1);

                }

                if (b[i][j] == 2 * pl && i + pl >= 0 && j + pl >= 0 && i + pl < 8 && j + pl < 8 && b[i + pl][j + pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i + pl][j + pl] = 2 * pl;

                    arr.add(b1);


                }



                if (b[i][j] == 2 * pl && i - pl >= 0 && j - pl >= 0 && i - pl < 8 && j - pl < 8 && b[i - pl][j - pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i - pl][j - pl] = 2 * pl;
                    arr.add(b1);

                }

                if (b[i][j] == 2 * pl && i - pl >= 0 && j + pl >= 0 && i - pl < 8 && j + pl < 8 && b[i - pl][j + pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i - pl][j + pl] = 2 * pl;

                    arr.add(b1);
                    b1 = bo;

                }

            }
        }

        return arr;
    }

    static boolean isValidMoveForNegativePlayer(int[][] bo) {
        if (moveFromXcoordinate == -1 || moveToXcoordinate == -1 || moveFromYcoordinate == -1 || moveToYcoordinate == -1) return false;
        if (checkCapture(bo, -1)) {
            if (bo[moveFromXcoordinate][moveFromYcoordinate] == -1) {
                if (moveToXcoordinate == moveFromXcoordinate - 2 && moveToYcoordinate == moveFromYcoordinate - 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate - 1][moveFromYcoordinate - 1] > 0) {
                    return true;
                }
                if (moveToXcoordinate == moveFromXcoordinate - 2 && moveToYcoordinate == moveFromYcoordinate + 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate - 1][moveFromYcoordinate + 1] > 0) {
                    return true;
                }
                return false;
            }
            if (bo[moveFromXcoordinate][moveFromYcoordinate] == -2) {
                if (moveToXcoordinate == moveFromXcoordinate - 2 && moveToYcoordinate == moveFromYcoordinate - 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate - 1][moveFromYcoordinate - 1] > 0) {
                    return true;
                }
                if (moveToXcoordinate == moveFromXcoordinate - 2 && moveToYcoordinate == moveFromYcoordinate + 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate - 1][moveFromYcoordinate + 1] > 0) {
                    return true;
                }
                if (moveToXcoordinate == moveFromXcoordinate + 2 && moveToYcoordinate == moveFromYcoordinate - 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate + 1][moveFromYcoordinate - 1] > 0) {
                    return true;
                }
                if (moveToXcoordinate == moveFromXcoordinate + 2 && moveToYcoordinate == moveFromYcoordinate + 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate + 1][moveFromYcoordinate + 1] > 0) {
                    return true;
                }
                return false;
            }
            return false;

        }
        if (bo[moveFromXcoordinate][moveFromYcoordinate] == -1) {
            if (moveToXcoordinate == moveFromXcoordinate - 1 && moveToYcoordinate == moveFromYcoordinate - 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }
            if (moveToXcoordinate == moveFromXcoordinate - 1 && moveToYcoordinate == moveFromYcoordinate + 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }

        }
        if (bo[moveFromXcoordinate][moveFromYcoordinate] == -2) {
            if (moveToXcoordinate == moveFromXcoordinate - 1 && moveToYcoordinate == moveFromYcoordinate - 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }
            if (moveToXcoordinate == moveFromXcoordinate - 1 && moveToYcoordinate == moveFromYcoordinate + 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }
            if (moveToXcoordinate == moveFromXcoordinate + 1 && moveToYcoordinate == moveFromYcoordinate - 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }
            if (moveToXcoordinate == moveFromXcoordinate + 1 && moveToYcoordinate == moveFromYcoordinate + 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }

        }
        return false;
    }

    static boolean isValidMoveForPositivePlayer(int[][] bo) {
        if (moveFromXcoordinate == -1 || moveToXcoordinate == -1 || moveFromYcoordinate == -1 || moveToYcoordinate == -1) return false;
        if (checkCapture(bo, 1)) {
            if (bo[moveFromXcoordinate][moveFromYcoordinate] == 1) {
                if (moveToXcoordinate == moveFromXcoordinate + 2 && moveToYcoordinate == moveFromYcoordinate - 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate + 1][moveFromYcoordinate - 1] < 0) {
                    return true;
                }
                if (moveToXcoordinate == moveFromXcoordinate + 2 && moveToYcoordinate == moveFromYcoordinate + 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate + 1][moveFromYcoordinate + 1] < 0) {
                    return true;
                }
                return false;
            }
            if (bo[moveFromXcoordinate][moveFromYcoordinate] == 2) {
                if (moveToXcoordinate == moveFromXcoordinate - 2 && moveToYcoordinate == moveFromYcoordinate - 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate - 1][moveFromYcoordinate - 1] < 0) {
                    return true;
                }
                if (moveToXcoordinate == moveFromXcoordinate - 2 && moveToYcoordinate == moveFromYcoordinate + 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate - 1][moveFromYcoordinate + 1] < 0) {
                    return true;
                }
                if (moveToXcoordinate == moveFromXcoordinate + 2 && moveToYcoordinate == moveFromYcoordinate - 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate + 1][moveFromYcoordinate - 1] < 0) {
                    return true;
                }
                if (moveToXcoordinate == moveFromXcoordinate + 2 && moveToYcoordinate == moveFromYcoordinate + 2 && bo[moveToXcoordinate][moveToYcoordinate] == 0 && bo[moveFromXcoordinate + 1][moveFromYcoordinate + 1] < 0) {
                    return true;
                }
                return false;
            }
            return false;

        }
        if (bo[moveFromXcoordinate][moveFromYcoordinate] == 1) {
            if (moveToXcoordinate == moveFromXcoordinate + 1 && moveToYcoordinate == moveFromYcoordinate - 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }
            if (moveToXcoordinate == moveFromXcoordinate + 1 && moveToYcoordinate == moveFromYcoordinate + 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }

        }
        if (bo[moveFromXcoordinate][moveFromYcoordinate] == 2) {
            if (moveToXcoordinate == moveFromXcoordinate - 1 && moveToYcoordinate == moveFromYcoordinate - 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }
            if (moveToXcoordinate == moveFromXcoordinate - 1 && moveToYcoordinate == moveFromYcoordinate + 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }
            if (moveToXcoordinate == moveFromXcoordinate + 1 && moveToYcoordinate == moveFromYcoordinate - 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }
            if (moveToXcoordinate == moveFromXcoordinate + 1 && moveToYcoordinate == moveFromYcoordinate + 1 && bo[moveToXcoordinate][moveToYcoordinate] == 0) {
                return true;
            }

        }
        return false;
    }
    static int[][] minimax(int[][] bo, int pl) {
        int[][] a = new int[8][8];
        ArrayList < int[][] > ac;
        if (checkCapture(bo, pl)) {
            ac = getallCapture(bo, pl);
        } else ac = getallOrdinaryMove(bo, pl);
        if (ac.isEmpty()) return null;
        a = ac.get(0);
        int ma = Integer.MIN_VALUE;
        for (int[][] b: ac) {

            int x = mini(b, pl, 0);
            if (x > ma) {
                a = b;
                ma = x;
            }
        }
        System.out.println("pl " + pl + " heuristic " + ma);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return a;
    }

    static int mini(int[][] bo, int pl, int d) {
        if ((d >= 5 && pl == 1) || (d >= 5 && pl == -1)) {
            int c = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (bo[i][j] == 1) {
                        if (i < 4) c += 5;
                        else c += 7;
                    }
                    if (bo[i][j] == -1) {
                        if (i > 3) c -= 5;
                        else c -= 7;
                    }
                    if (bo[i][j] == 2) {
                        c += 10;
                    }
                    if (bo[i][j] == -2) {
                        c -= 10;
                    }

                }
            }

            return c * pl;
        }
        int mi = Integer.MAX_VALUE;
        ArrayList < int[][] > ac;
        if (checkCapture(bo, (-1) * pl)) {
            ac = getallCapture(bo, (-1) * pl);
        } else ac = getallOrdinaryMove(bo, (-1) * pl);
        for (int[][] b: ac) {
            mi = Math.min(mi, maxi(b, pl, d + 1));
        }

        return mi;
    }

    static int maxi(int[][] bo, int pl, int d) {

        if ((d >= 5 && pl == 1) || (d >= 5 && pl == -1)) {
            int c = 0;
            // System.out.println("future");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (bo[i][j] == 1) {
                        if (i < 4) c += 5;
                        else c += 7;
                    }
                    if (bo[i][j] == -1) {
                        if (i > 3) c -= 5;
                        else c -= 7;
                    }
                    if (bo[i][j] == 2) {
                        c += 10;
                    }
                    if (bo[i][j] == -2) {
                        c -= 10;
                    }
                }
            }

            return c * pl;
        }
        int mi = Integer.MIN_VALUE;
        ArrayList < int[][] > ac;
        if (checkCapture(bo, pl)) ac = getallCapture(bo, pl);
        else ac = getallOrdinaryMove(bo, pl);
        for (int[][] b: ac) {
            mi = Math.max(mi, mini(b, pl, d + 1));
        }
        return mi;
    }

    static boolean capturePossibleForPiece(int[][] b, int pl, int i, int j) {
        if (b[i][j] == pl && i + 2 * pl >= 0 && j + 2 * pl >= 0 && i + 2 * pl < 8 && j + 2 * pl < 8 &&
                b[i + pl][j + pl] * pl < 0 && b[i + 2 * pl][j + 2 * pl] == 0) return true;
        if (b[i][j] == pl && i + 2 * pl >= 0 && j - 2 * pl >= 0 && i + 2 * pl < 8 && j - 2 * pl < 8 &&
                b[i + pl][j - pl] * pl < 0 && b[i + 2 * pl][j - 2 * pl] == 0) return true;
        if (b[i][j] == 2 * pl && i + 2 * pl >= 0 && j + 2 * pl >= 0 && i + 2 * pl < 8 && j + 2 * pl < 8 &&
                b[i + pl][j + pl] * pl < 0 && b[i + 2 * pl][j + 2 * pl] == 0) return true;
        if (b[i][j] == 2 * pl && i + 2 * pl >= 0 && j - 2 * pl >= 0 && i + 2 * pl < 8 && j - 2 * pl < 8 &&
                b[i + pl][j - pl] * pl < 0 && b[i + 2 * pl][j - 2 * pl] == 0) return true;
        if (b[i][j] == 2 * pl && i - 2 * pl >= 0 && j + 2 * pl >= 0 && i - 2 * pl < 8 && j + 2 * pl < 8 &&
                b[i - pl][j + pl] * pl < 0 && b[i - 2 * pl][j + 2 * pl] == 0) return true;
        if (b[i][j] == 2 * pl && i - 2 * pl >= 0 && j - 2 * pl >= 0 && i - 2 * pl < 8 && j - 2 * pl < 8 &&
                b[i - pl][j - pl] * pl < 0 && b[i - 2 * pl][j - 2 * pl] == 0) return true;
        return false;
    }

    static int xtemp = -1;
    static int ytemp = -1;

    static int[][] captureIfPossible(int[][] b, int pl, int i, int j) {
        int[][] b1 = new int[8][8];
        for (int i1 = 0; i1 < 8; i1++) {
            for (int j1 = 0; j1 < 8; j1++) {
                b1[i1][j1] = b[i1][j1];
            }
        }
        if (b[i][j] == pl && i + 2 * pl >= 0 && j + 2 * pl >= 0 && i + 2 * pl < 8 && j + 2 * pl < 8 &&
                b[i + pl][j + pl] * pl < 0 && b[i + 2 * pl][j + 2 * pl] == 0) {

            b1[i][j] = 0;
            b1[i + pl][j + pl] = 0;
            b1[i + 2 * pl][j + 2 * pl] = pl;
            if (pl == 1 && i + 2 * pl == 7) {
                b1[i + 2 * pl][j + 2 * pl] = 2 * pl;

            }
            if (pl == -1 && i + 2 * pl == 0) {
                b1[i + 2 * pl][j + 2 * pl] = 2 * pl;

            }
            xtemp = i + 2 * pl;
            ytemp = j + 2 * pl;
            return b1;

        }

        if (b[i][j] == pl && i + 2 * pl >= 0 && j - 2 * pl >= 0 && i + 2 * pl < 8 && j - 2 * pl < 8 &&
                b[i + pl][j - pl] * pl < 0 && b[i + 2 * pl][j - 2 * pl] == 0) {

            b1[i][j] = 0;
            b1[i + pl][j - pl] = 0;
            b1[i + 2 * pl][j - 2 * pl] = pl;
            if (pl == 1 && i + 2 * pl == 7) {
                b1[i + 2 * pl][j - 2 * pl] = 2 * pl;

            }
            if (pl == -1 && i + 2 * pl == 0) {
                b1[i + 2 * pl][j - 2 * pl] = 2 * pl;

            }
            xtemp = i + 2 * pl;
            ytemp = j - 2 * pl;
            return b1;

        }

        if (b[i][j] == 2 * pl && i + 2 * pl >= 0 && j + 2 * pl >= 0 && i + 2 * pl < 8 && j + 2 * pl < 8 &&
                b[i + pl][j + pl] * pl < 0 && b[i + 2 * pl][j + 2 * pl] == 0) {

            b1[i][j] = 0;
            b1[i + pl][j + pl] = 0;
            b1[i + 2 * pl][j + 2 * pl] = 2 * pl;
            xtemp = i + 2 * pl;
            ytemp = j + 2 * pl;
            return b1;

        }

        if (b[i][j] == 2 * pl && i + 2 * pl >= 0 && j - 2 * pl >= 0 && i + 2 * pl < 8 && j - 2 * pl < 8 &&
                b[i + pl][j - pl] * pl < 0 && b[i + 2 * pl][j - 2 * pl] == 0) {

            b1[i][j] = 0;
            b1[i + pl][j - pl] = 0;
            b1[i + 2 * pl][j - 2 * pl] = 2 * pl;
            xtemp = i + 2 * pl;
            ytemp = j - 2 * pl;
            return b1;

        }

        if (b[i][j] == 2 * pl && i - 2 * pl >= 0 && j + 2 * pl >= 0 && i - 2 * pl < 8 && j + 2 * pl < 8 &&
                b[i - pl][j + pl] * pl < 0 && b[i - 2 * pl][j + 2 * pl] == 0) {

            b1[i][j] = 0;
            b1[i - pl][j + pl] = 0;
            b1[i - 2 * pl][j + 2 * pl] = 2 * pl;
            xtemp = i - 2 * pl;
            ytemp = j + 2 * pl;
            return b1;

        }

        if (b[i][j] == 2 * pl && i - 2 * pl >= 0 && j - 2 * pl >= 0 && i - 2 * pl < 8 && j - 2 * pl < 8 &&
                b[i - pl][j - pl] * pl < 0 && b[i - 2 * pl][j - 2 * pl] == 0) {

            b1[i][j] = 0;
            b1[i - pl][j - pl] = 0;
            b1[i - 2 * pl][j - 2 * pl] = 2 * pl;
            xtemp = i - 2 * pl;
            ytemp = j - 2 * pl;
            return b1;

        }




        return b1;
    }
    static ArrayList < int[][] > getallCapture(int[][] bo, int pl) {
        ArrayList < int[][] > arr = new ArrayList < int[][] > ();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int[][] b = bo;
                if (b[i][j] == pl && i + 2 * pl >= 0 && j + 2 * pl >= 0 && i + 2 * pl < 8 && j + 2 * pl < 8 &&
                        b[i + pl][j + pl] * pl < 0 && b[i + 2 * pl][j + 2 * pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i + pl][j + pl] = 0;
                    b1[i + 2 * pl][j + 2 * pl] = pl;
                    if (pl == 1 && i + 2 * pl == 7) {
                        b1[i + 2 * pl][j + 2 * pl] = 2 * pl;

                    }
                    if (pl == -1 && i + 2 * pl == 0) {
                        b1[i + 2 * pl][j + 2 * pl] = 2 * pl;

                    }
                    xtemp = i + 2 * pl;
                    ytemp = j + 2 * pl;
                    while (capturePossibleForPiece(b1, pl, xtemp, ytemp)) {
                        b1 = captureIfPossible(b1, pl, xtemp, ytemp);
                    }

                    arr.add(b1);
                }

                if (b[i][j] == pl && i + 2 * pl >= 0 && j - 2 * pl >= 0 && i + 2 * pl < 8 && j - 2 * pl < 8 &&
                        b[i + pl][j - pl] * pl < 0 && b[i + 2 * pl][j - 2 * pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i + pl][j - pl] = 0;
                    b1[i + 2 * pl][j - 2 * pl] = pl;
                    if (pl == 1 && i + 2 * pl == 7) {
                        b1[i + 2 * pl][j - 2 * pl] = 2 * pl;

                    }
                    if (pl == -1 && i + 2 * pl == 0) {
                        b1[i + 2 * pl][j - 2 * pl] = 2 * pl;

                    }
                    xtemp = i + 2 * pl;
                    ytemp = j - 2 * pl;
                    while (capturePossibleForPiece(b1, pl, xtemp, ytemp)) {
                        b1 = captureIfPossible(b1, pl, xtemp, ytemp);
                    }
                    arr.add(b1);
                }

                if (b[i][j] == 2 * pl && i + 2 * pl >= 0 && j + 2 * pl >= 0 && i + 2 * pl < 8 && j + 2 * pl < 8 &&
                        b[i + pl][j + pl] * pl < 0 && b[i + 2 * pl][j + 2 * pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i + pl][j + pl] = 0;
                    b1[i + 2 * pl][j + 2 * pl] = 2 * pl;
                    xtemp = i + 2 * pl;
                    ytemp = j + 2 * pl;
                    while (capturePossibleForPiece(b1, pl, xtemp, ytemp)) {
                        b1 = captureIfPossible(b1, pl, xtemp, ytemp);
                    }
                    arr.add(b1);
                }

                if (b[i][j] == 2 * pl && i + 2 * pl >= 0 && j - 2 * pl >= 0 && i + 2 * pl < 8 && j - 2 * pl < 8 &&
                        b[i + pl][j - pl] * pl < 0 && b[i + 2 * pl][j - 2 * pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i + pl][j - pl] = 0;
                    b1[i + 2 * pl][j - 2 * pl] = 2 * pl;
                    xtemp = i + 2 * pl;
                    ytemp = j - 2 * pl;
                    while (capturePossibleForPiece(b1, pl, xtemp, ytemp)) {
                        b1 = captureIfPossible(b1, pl, xtemp, ytemp);
                    }
                    arr.add(b1);
                }

                if (b[i][j] == 2 * pl && i - 2 * pl >= 0 && j + 2 * pl >= 0 && i - 2 * pl < 8 && j + 2 * pl < 8 &&
                        b[i - pl][j + pl] * pl < 0 && b[i - 2 * pl][j + 2 * pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i - pl][j + pl] = 0;
                    b1[i - 2 * pl][j + 2 * pl] = 2 * pl;
                    xtemp = i - 2 * pl;
                    ytemp = j + 2 * pl;
                    while (capturePossibleForPiece(b1, pl, xtemp, ytemp)) {
                        b1 = captureIfPossible(b1, pl, xtemp, ytemp);
                    }
                    arr.add(b1);
                }

                if (b[i][j] == 2 * pl && i - 2 * pl >= 0 && j - 2 * pl >= 0 && i - 2 * pl < 8 && j - 2 * pl < 8 &&
                        b[i - pl][j - pl] * pl < 0 && b[i - 2 * pl][j - 2 * pl] == 0) {
                    int[][] b1 = new int[8][8];
                    for (int i1 = 0; i1 < 8; i1++) {
                        for (int j1 = 0; j1 < 8; j1++) {
                            b1[i1][j1] = bo[i1][j1];
                        }
                    }
                    b1[i][j] = 0;
                    b1[i - pl][j - pl] = 0;
                    b1[i - 2 * pl][j - 2 * pl] = 2 * pl;
                    xtemp = i - 2 * pl;
                    ytemp = j - 2 * pl;
                    while (capturePossibleForPiece(b1, pl, xtemp, ytemp)) {
                        b1 = captureIfPossible(b1, pl, xtemp, ytemp);
                    }
                    arr.add(b1);
                }

            }
        }

        return arr;
    }
    public static State play(State s, GridBoard g) {
        int pl = s.player;
        int[][] b = s.board;
        int[][] b1 = minimax(b, pl);
        if (b1 == null) return null;
        State ns = new State(b1, (-1) * pl);

        g.changeBoardState(b1);
        g.repaint();
        return ns;
    }


    public static boolean equal(int[][] a1, int[][] a2) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (a1[i][j] != a2[i][j]) return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = {
                {
                        0,
                        1,
                        0,
                        1,
                        0,
                        1,
                        0,
                        1
                },
                {
                        1,
                        0,
                        1,
                        0,
                        1,
                        0,
                        1,
                        0
                },
                {
                        0,
                        1,
                        0,
                        1,
                        0,
                        1,
                        0,
                        1
                },
                {
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0
                },
                {
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0,
                        0
                },
                {-1,
                        0,
                        -1,
                        0,
                        -1,
                        0,
                        -1,
                        0
                },
                {
                        0,
                        -1,
                        0,
                        -1,
                        0,
                        -1,
                        0,
                        -1
                },
                {-1,
                        0,
                        -1,
                        0,
                        -1,
                        0,
                        -1,
                        0
                },
        };
        ib1 = board;
        getallOrdinaryMove(board, 1);
        State st = new State(board, 1);
        int c = 0;
        GridBoard gridBoard = new GridBoard(8, 8, board);
        Mouse m = new Mouse();
        gridBoard.addMouseListener(m);
        final JLabel l = new JLabel();
        gridBoard.repaint();
        JDialog d;
        int mode = 2;

        System.out.println("Press 1 for computer vs computer");
        System.out.println("Press 2 for computer vs human");
        System.out.println("Press 3 for human vs human");

        Scanner sc = new Scanner(System.in);
        mode = sc.nextInt();
        if (mode == 2) {
            while (true) {
                // System.out.println("computer's chance");
                //gridBoard.m.setText("Computer's chance");
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                int pl = st.player;

                st = play(st, gridBoard);
                // gridBoard.m.setText("your Chance");

                if (st == null) {
                    if (pl == 1) {
                        gridBoard.m.setText("Red Won");

                        System.out.println("Red Won");
                    } else {
                        gridBoard.m.setText("White Won");

                        System.out.println("Red Won");
                    }

                    break;
                }

                System.out.println("your chance");
                moveFromXcoordinate = -1;
                moveToXcoordinate = -1;
                moveFromYcoordinate = -1;
                moveToYcoordinate = -1;
                int timeCount = 0;
                while (!isValidMoveForNegativePlayer(st.board) && timeCount < 20) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    timeCount++;
                }
                if (timeCount >= 20) {
                    System.out.println("TIMEOUT COMPUTER WINS");
                    gridBoard.m.setText("TIMEOUT-COMPUTER WINS");
                    break;
                }
                int[][] b = st.board;
                if (Math.abs(moveToXcoordinate - moveFromXcoordinate) == 1) {
                    b[moveToXcoordinate][moveToYcoordinate] = b[moveFromXcoordinate][moveFromYcoordinate];
                    if (moveToXcoordinate == 0 && Math.abs(b[moveToXcoordinate][moveToYcoordinate]) == 1)
                        b[moveToXcoordinate][moveToYcoordinate] = 2 * b[moveFromXcoordinate][moveFromYcoordinate];
                    b[moveFromXcoordinate][moveFromYcoordinate] = 0;
                } else {
                    int tempx = moveFromXcoordinate;
                    int tempy = moveFromYcoordinate;

                    while (tempx != -1 && tempy != -1 && capturePossibleForPiece(b, -1, tempx, tempy)) {
                        int tc = 0;
                        while (!(tempx == moveFromXcoordinate && tempy == moveFromYcoordinate && isValidMoveForNegativePlayer(b))) {
                            try {
                                TimeUnit.MILLISECONDS.sleep(1000);
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            tc++;
                        }
                        if (tc >= 30) {
                            gridBoard.m.setText("TIMEOUT: RED WINS");
                            System.out.println("TIMEOUT RED WINS");
                            break;
                        }
                        if (Math.abs(moveToXcoordinate - moveFromXcoordinate) == 2) {
                            b[moveToXcoordinate][moveToYcoordinate] = b[moveFromXcoordinate][moveFromYcoordinate];
                            if (moveToXcoordinate == 0 && Math.abs(b[moveToXcoordinate][moveToYcoordinate]) == 1)
                                b[moveToXcoordinate][moveToYcoordinate] = 2 * b[moveFromXcoordinate][moveFromYcoordinate];
                            b[(moveFromXcoordinate + moveToXcoordinate) / 2][(moveFromYcoordinate + moveToYcoordinate) / 2] = 0;
                            b[moveFromXcoordinate][moveFromYcoordinate] = 0;
                        }
                        tempx = moveToXcoordinate;
                        tempy = moveToYcoordinate;

                        moveFromXcoordinate = -1;
                        moveToXcoordinate = -1;
                        moveFromYcoordinate = -1;
                        moveToYcoordinate = -1;
                        gridBoard.changeBoardState(b);
                        gridBoard.repaint();
                    }
                }
                st = new State(b, 1);
                gridBoard.changeBoardState(b);
                gridBoard.repaint();




                if (pl == 1 && ib1 != null && equal(ib1, st.board)) {
                    gridBoard.m.setText("DRAW");
                    System.out.println("Draw");
                    //gridBoard.repaint();
                    break;

                }
                if (pl == 1) {
                    ib1 = ib3;
                    ib3 = st.board;

                }

                if (pl == -1 && ib2 != null && equal(ib2, st.board)) {
                    gridBoard.m.setText("DRAW");
                    System.out.println("Draw");
                    //gridBoard.repaint();
                    break;
                }
                if (pl == -1) {
                    ib2 = ib4;
                    ib4 = st.board;
                }


                c++;
            }

        }
        if (mode == 1) {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                int pl = st.player;
                st = play(st, gridBoard);
                if (st == null) {
                    if (pl == 1) {
                        gridBoard.m.setText("Red Won");
                        d = new JDialog(gridBoard, "White");
                        System.out.println("Red Won");
                    } else {
                        gridBoard.m.setText("Red Won");
                        System.out.println("Red Won");
                    }
                    // gridBoard.repaint();
                    break;
                }


                if (pl == 1 && ib1 != null && equal(ib1, st.board)) {
                    gridBoard.m.setText("DRAW");
                    System.out.println("Draw");
                    //gridBoard.repaint();
                    break;

                }
                if (pl == 1) {
                    ib1 = ib3;
                    ib3 = st.board;

                }

                if (pl == -1 && ib2 != null && equal(ib2, st.board)) {
                    gridBoard.m.setText("DRAW");
                    System.out.println("Draw");
                    //gridBoard.repaint();
                    break;
                }
                if (pl == -1) {
                    ib2 = ib4;
                    ib4 = st.board;
                }

                c++;
            }

        }

        if (mode == 3) {
            while (true) {
                int pl = 1;
                System.out.println("Red chance");
                moveFromXcoordinate = -1;
                moveToXcoordinate = -1;
                moveFromYcoordinate = -1;
                moveToYcoordinate = -1;
                int timeCount = 0;
                while (!isValidMoveForPositivePlayer(st.board) && timeCount < 30) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    timeCount++;
                }
                if (timeCount >= 30) {
                    gridBoard.m.setText("TIMEOUT: WHITE WINS");
                    System.out.println("TIMEOUT: WHITE WINS");
                    break;
                }
                int[][] b = st.board;
                if (Math.abs(moveToXcoordinate - moveFromXcoordinate) == 1) {
                    b[moveToXcoordinate][moveToYcoordinate] = b[moveFromXcoordinate][moveFromYcoordinate];
                    if (moveToXcoordinate == 7 && Math.abs(b[moveToXcoordinate][moveToYcoordinate]) == 1) b[moveToXcoordinate][moveToYcoordinate] = 2 * b[moveFromXcoordinate][moveFromYcoordinate];
                    b[moveFromXcoordinate][moveFromYcoordinate] = 0;
                } else {
                    int tempx = moveFromXcoordinate;
                    int tempy = moveFromYcoordinate;
                    while (tempx != -1 && tempy != -1 && capturePossibleForPiece(b, 1, tempx, tempy)) {
                        int tc = 0;
                        while (!(tempx == moveFromXcoordinate && tempy == moveFromYcoordinate && isValidMoveForPositivePlayer(b))) {
                            try {
                                TimeUnit.MILLISECONDS.sleep(1000);
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            tc++;
                        }
                        if (tc >= 30) {
                            gridBoard.m.setText("TIMEOUT: RED WINS");
                            System.out.println("TIMEOUT RED WINS");
                            break;
                        }
                        if (Math.abs(moveToXcoordinate - moveFromXcoordinate) == 2) {
                            b[moveToXcoordinate][moveToYcoordinate] = b[moveFromXcoordinate][moveFromYcoordinate];
                            if (moveToXcoordinate == 7 && Math.abs(b[moveToXcoordinate][moveToYcoordinate]) == 1)
                                b[moveToXcoordinate][moveToYcoordinate] = 2 * b[moveFromXcoordinate][moveFromYcoordinate];
                            b[(moveFromXcoordinate + moveToXcoordinate) / 2][(moveFromYcoordinate + moveToYcoordinate) / 2] = 0;
                            b[moveFromXcoordinate][moveFromYcoordinate] = 0;
                        }
                        tempx = moveToXcoordinate;
                        tempy = moveToYcoordinate;

                        moveFromXcoordinate = -1;
                        moveToXcoordinate = -1;
                        moveFromYcoordinate = -1;
                        moveToYcoordinate = -1;
                        gridBoard.changeBoardState(b);
                        gridBoard.repaint();
                    }
                }
                st = new State(b, -1);
                gridBoard.changeBoardState(b);
                gridBoard.repaint();


                System.out.println("White's chance");
                moveFromXcoordinate = -1;
                moveToXcoordinate = -1;
                moveFromYcoordinate = -1;
                moveToYcoordinate = -1;
                timeCount = 0;
                while (!isValidMoveForNegativePlayer(st.board) && timeCount < 30) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    timeCount++;
                }
                if (timeCount >= 30) {
                    gridBoard.m.setText("TIMEOUT: RED WINS");
                    System.out.println("TIMEOUT RED WINS");
                    break;
                }
                b = st.board;
                if (Math.abs(moveToXcoordinate - moveFromXcoordinate) == 1) {
                    b[moveToXcoordinate][moveToYcoordinate] = b[moveFromXcoordinate][moveFromYcoordinate];
                    if (moveToXcoordinate == 0 && Math.abs(b[moveToXcoordinate][moveToYcoordinate]) == 1)
                        b[moveToXcoordinate][moveToYcoordinate] = 2 * b[moveFromXcoordinate][moveFromYcoordinate];
                    b[moveFromXcoordinate][moveFromYcoordinate] = 0;
                } else {
                    int tempx = moveFromXcoordinate;
                    int tempy = moveFromYcoordinate;

                    while (tempx != -1 && tempy != -1 && capturePossibleForPiece(b, -1, tempx, tempy)) {
                        int tc = 0;
                        while (!(tempx == moveFromXcoordinate && tempy == moveFromYcoordinate && isValidMoveForNegativePlayer(b))) {
                            try {
                                TimeUnit.MILLISECONDS.sleep(1000);
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                            tc++;
                        }
                        if (tc >= 30) {
                            gridBoard.m.setText("TIMEOUT: RED WINS");
                            System.out.println("TIMEOUT RED WINS");
                            break;
                        }
                        if (Math.abs(moveToXcoordinate - moveFromXcoordinate) == 2) {
                            b[moveToXcoordinate][moveToYcoordinate] = b[moveFromXcoordinate][moveFromYcoordinate];
                            if (moveToXcoordinate == 0 && Math.abs(b[moveToXcoordinate][moveToYcoordinate]) == 1)
                                b[moveToXcoordinate][moveToYcoordinate] = 2 * b[moveFromXcoordinate][moveFromYcoordinate];
                            b[(moveFromXcoordinate + moveToXcoordinate) / 2][(moveFromYcoordinate + moveToYcoordinate) / 2] = 0;
                            b[moveFromXcoordinate][moveFromYcoordinate] = 0;
                        }
                        tempx = moveToXcoordinate;
                        tempy = moveToYcoordinate;

                        moveFromXcoordinate = -1;
                        moveToXcoordinate = -1;
                        moveFromYcoordinate = -1;
                        moveToYcoordinate = -1;
                        gridBoard.changeBoardState(b);
                        gridBoard.repaint();
                    }
                }
                st = new State(b, 1);
                gridBoard.changeBoardState(b);
                gridBoard.repaint();

                c++;
            }

        }
    }


}