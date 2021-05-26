import java.util.Scanner;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        setPos(x, y);
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class Main {
    static int[] board = new int[Main.WIDTH * Main.HEIGHT];

    final static int BLANK = 0;
    final static int PLAYER_O = 1;
    final static int PLAYER_X = 2;

    final static int WIDTH = 3;
    final static int HEIGHT = 3;

    static void printBoard(int[] board) {
        System.out.format("    1 2 3\n");
        for (int y = 0; y < HEIGHT; y++) {
            System.out.format("%d | ", y + 1);
            for (int x = 0; x < WIDTH; x++) {
                int val = board[(y * WIDTH) + x];
                char ch = convertItemToChar(val);
                System.out.format("%c ", ch);
            }
            System.out.format("\n");
        }
    }

    static void setBoardItem(Position pos, int player) {
        board[ (pos.y * WIDTH)  + pos.x ] = player;
    }

    static int getBoardItem(Position pos) {
        return board[ (pos.y * WIDTH)  + pos.x ];
    }

    static int getBoardItem(int x, int y) {
        return board[ (y * WIDTH)  + x ];
    }

    static char convertItemToChar(int item) {
        return item == PLAYER_O ? 'O' :
                item == PLAYER_X ? 'X' : ' ';
    }

    public static void main(String[] args) {
        boolean isQuit = false;
        int curPlayer = PLAYER_X;
        // testCheckWin();

        while (!isQuit) {
            printBoard(board);
            if(curPlayer == PLAYER_X)
            {
                boolean hasUpdated = false;
                while(!hasUpdated) {
                    Position nextPos = getPosFromUser(curPlayer);

                    // update board
                    int item = getBoardItem(nextPos);
                    if(item == BLANK) {
                        setBoardItem(nextPos, curPlayer);
                        hasUpdated = true;
                    }
                    else  {
                        System.out.println("Already has stone.");
                    }
                }
            }
            else { //PLAYER_0
                for (int i = 0; i < board.length; ++i)
                {
                    if(board[i] == BLANK)
                    {
                        Postion pos = new Position(x: i%3,)
                    }
                }

            }


            boolean isWin = checkWin(curPlayer);
            if(isWin) {

                char ch = convertItemToChar(curPlayer);
                System.out.format("player %c is Win!!\n", ch);
                isQuit = true;
            }

            if(isBoardFull()) {
                System.out.println("draw!!");
                isQuit = true;
            }

            // change turn
            curPlayer = (curPlayer == PLAYER_O)  ? PLAYER_X: PLAYER_O;
        }

        // print result
        System.out.println("Game over!");
    }

    private static boolean checkWin(int curPlayer) {

        for (int y = 0; y < HEIGHT; y++) {
            int v1 = getBoardItem(0, y);
            int v2 = getBoardItem(1, y);
            int v3 = getBoardItem(2, y);

            if(v1 == v2 && v2 == v3 && v3 == curPlayer) {
                return true;
            }
        }

        for (int x = 0; x < HEIGHT; x++) {
            int v1 = getBoardItem(x, 0);
            int v2 = getBoardItem(x, 1);
            int v3 = getBoardItem(x, 2);

            if(v1 == v2 && v2 == v3 && v3 == curPlayer) {
                return true;
            }
        }

        int v1 = getBoardItem(0, 0);
        int v2 = getBoardItem(1, 1);
        int v3 = getBoardItem(2, 2);

        if(v1 == v2 && v2 == v3 && v3 == curPlayer) {
            return true;
        }

        v1 = getBoardItem(0, 2);
        v2 = getBoardItem(1, 1);
        v3 = getBoardItem(2, 0);

        if(v1 == v2 && v2 == v3 && v3 == curPlayer) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) {
            if(board[i] == BLANK) {
                return false;
            }
        }
        return true;
    }


    private static Position getPosFromUser(int curPlayer) {
        Scanner scanner = new Scanner(System.in);

        char ch = convertItemToChar(curPlayer);

        while (true) {
            System.out.format("\nPlayer [%c] (x y)> ", ch);
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if ((x < 1 || x > 3) || (y < 1 || y > 3)) {
                    throw new RuntimeException();
                }
                return new Position(x-1, y-1);
            } catch (Exception e) {
                scanner.nextLine();
                System.out.format("\nWrong input! try again\n");
            }
        }
    }

    static void testCheckWin() {
        //clearBoard();
        board = new int[]{
                1, 1, 1,
                2, 0, 2,
                0, 2, 0};
        if( !checkWin(PLAYER_O)) {
            System.out.println("test fail");
        }

        board = new int[]{
                1, 0, 0,
                2, 1, 2,
                0, 2, 1};
        if( !checkWin(PLAYER_O)) {
            System.out.println("test fail");
        }
        board = new int[]{
                1, 0, 2,
                1, 0, 2,
                1, 2, 0};
        if( !checkWin(PLAYER_O)) {
            System.out.println("x axis test fail");
        }

        board = new int[]{
                1, 1, 0,
                2, 0, 2,
                0, 2, 0};
        if( checkWin(PLAYER_O) == true) {
            System.out.println("test fail");
        }

        System.out.println("test done!");

    }

    private static void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = BLANK;
        }
    }
}