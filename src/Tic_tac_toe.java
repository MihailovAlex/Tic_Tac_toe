import java.util.Scanner;

public class Tic_tac_toe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] enter = new char[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                enter[i][j] = ' ';
                k++;
            }
        }
        showResult(enter);
        int x = 0, y = 0;
        boolean dobro = true;
        int hod = 0;
        while (dobro) {
            System.out.print("Enter the coordinates (x y): ");
            if (sc.hasNextInt() && sc.hasNextInt()) {
                x = sc.nextInt();
                y = sc.nextInt();
                if (x > 3 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (x > 0 && y > 0) {
                    int poz = enter[3 - y][x - 1];

                    if (poz == ' ') {
                        if (hod%2==0) {
                            enter[3 - y][x - 1] = 'X';
                            hod++;
                        } else {
                            enter[3 - y][x - 1] = 'O';
                            hod++;
                        }
                        showResult(enter);
                    } else if (poz == 'X' || poz == 'O') {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            } else if (!sc.hasNextInt() && !sc.hasNextInt()) {
                System.out.println("You should enter numbers!");
                sc.next();
                sc.next();
            } else if ( !sc.hasNextInt()) {
                System.out.println("You should enter numbers!");
                sc.next();
            }

            if (checkWinsX(enter) && checkWinsO(enter)) {
                System.out.println("Impossible");
                break;
            } else if (impossible(enter)) {
                System.out.println("Impossible");
                break;
            } else if (checkWinsX(enter)) {
                System.out.println("Wins X");
                break;
            } else if (checkWinsO(enter)) {
                System.out.println("Wins O");
                break;
            } else if (notFinished(enter)) {
//                System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
                break;
            }
        }
    }

    public static void showResult(char[][] array) {
        System.out.println("---------");
        System.out.println("| " + array[0][0] + " " + array[0][1] + " " + array[0][2] + " |");
        System.out.println("| " + array[1][0] + " " + array[1][1] + " " + array[1][2] + " |");
        System.out.println("| " + array[2][0] + " " + array[2][1] + " " + array[2][2] + " |");
        System.out.println("---------");
    }

    public static boolean checkWinsX(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 'X' && array[i][1] == 'X' && array[i][2] == 'X') {
                return true;
            } else if (array[0][i] == 'X' && array[1][i] == 'X' && array[2][i] == 'X') {
                return true;
            }
        }
        if (array[0][0] == 'X' && array[1][1] == 'X' && array[2][2] == 'X') {
            return true;
        } else if (array[0][2] == 'X' && array[1][1] == 'X' && array[2][0] == 'X') {
            return true;
        }
        return false;
    }

    public static boolean checkWinsO(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == 'O' && array[i][1] == 'O' && array[i][2] == 'O') {
                return true;
            } else if (array[0][i] == 'O' && array[1][i] == 'O' && array[2][i] == 'O') {
                return true;
            }
        }
        if (array[0][0] == 'O' && array[1][1] == 'O' && array[2][2] == 'O') {
            return true;
        } else if (array[0][2] == 'O' && array[1][1] == 'O' && array[2][0] == 'O') {
            return true;
        }
        return false;
    }


    public static boolean impossible(char[][] array) {
        int countX = 0;
        int countO = 0;
        for (char[] vector : array) {
            for (char symbol : vector) {
                if (symbol == 'X') {
                    countX++;
                } else if (symbol == 'O') {
                    countO++;
                }
            }
        }
        if (countO - countX >= 2 || countX - countO >= 2) {
            return true;
        }
        return false;
    }

    public static boolean notFinished (char[][] array) {
        for (char[] vector : array) {
            for (char symbol : vector) {
                if (symbol == ' ' || symbol == '_') {
                    return true;
                }
            }
        }
        return false;
    }

}

