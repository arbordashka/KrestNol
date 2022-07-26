package KrestNol;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final char X_DOT = 'X';
    private static final char O_DOT = 'O';
    private static final char EMPTY_DOT = '.';

    private static final char[][] FIELD = new char[3][3];
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static Random RANDOM = new Random();

    public static void main(String[] args) {

        initField();
        showField();
        while (true) {

            humanTurn();

            if (checkWinner()) {
                System.out.println("победа человека!");
                break;
            }

            if (isFull()) {
                System.out.println("ничья!");
                break;
            }

            iiTurn();

            if (checkWinner()) {
                System.out.println("победа ии!");
                break;
            }

            if (isFull()) {
                System.out.println("ничья!");
                break;
            }

        }
        System.out.println("игра окончена");

    }

    private static boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (FIELD[i][j] == EMPTY_DOT)
                    return false;
            }
        }
        return true;
    }



    private static boolean checkWinner() {
        if (FIELD[0][0] == FIELD[1][1] && FIELD[1][1] == FIELD[2][2] && (!(FIELD[0][0] == EMPTY_DOT)))
            return true;
        else if (FIELD[0][2] == FIELD[1][1] && FIELD[1][1] == FIELD[2][0] && (!(FIELD[0][2] == EMPTY_DOT)))
            return true;
        else if (FIELD[0][0] == FIELD[0][1] && FIELD[0][1] == FIELD[0][2] && (!(FIELD[0][0] == EMPTY_DOT)))
            return true;
        else if (FIELD[1][0] == FIELD[1][1] && FIELD[1][1] == FIELD[1][2] && (!(FIELD[1][0] == EMPTY_DOT)))
            return true;
        else if (FIELD[2][0] == FIELD[2][1] && FIELD[2][1] == FIELD[2][2] && (!(FIELD[2][0] == EMPTY_DOT)))
            return true;
        else if (FIELD[0][0] == FIELD[1][0] && FIELD[1][0] == FIELD[2][0] && (!(FIELD[0][0] == EMPTY_DOT)))
            return true;
        else if (FIELD[0][1] == FIELD[1][1] && FIELD[1][1] == FIELD[2][1] && (!(FIELD[0][1] == EMPTY_DOT)))
            return true;
        else if (FIELD[0][2] == FIELD[1][2] && FIELD[1][2] == FIELD[2][2] && (!(FIELD[0][2] == EMPTY_DOT)))
            return true;
        else
            return false;
    }  //работет

    private static void iiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(3);
            y = RANDOM.nextInt(3);
        } while (!checkFree(x, y));
        FIELD[x][y]=O_DOT;
        System.out.println("ход ии:");
        showField();
    }

    private static boolean checkFree(int x, int y) {
        if (FIELD[x][y] == EMPTY_DOT) {
            return true;
        } else {
            return false;
        }
    } //работет

    private static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите Х и Y:");
            x = SCANNER.nextInt();
            y = SCANNER.nextInt();
        }
        while (!checkFree(x-1, y-1));
        FIELD[x - 1][y - 1] = X_DOT;
        System.out.println("ход человека:");
        showField();
    }  //работает

    private static void showField() {
        System.out.println("0 1 2 3 ");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(FIELD[i][j] + " ");
                ;
            }
            System.out.println();
        }
    }  //работает

    private static void initField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                FIELD[i][j] = EMPTY_DOT;
            }
        }
    }  //работает
}
