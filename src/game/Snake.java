package game;

public class Snake {
    public int direction = 0;
    public int snakeLength = 1;

    public int[] snakePositionX = new int[Launcer.HEIGHT * Launcer.WIDTH];
    public int[] snakePositionY = new int[Launcer.HEIGHT * Launcer.WIDTH];

    public Snake(int x, int y) {
        snakePositionX[0] = x;
        snakePositionY[0] = y;
    }

    public void movement() {
        for (int i = snakeLength; i > 0; i--) {
            snakePositionX[i] = snakePositionX[i - 1];
            snakePositionY[i] = snakePositionY[i - 1];
        }
        if (direction == 0) {
            snakePositionX[0]++;
        }
        if (direction == 1) {
            snakePositionY[0]++;
        }
        if (direction == 2) {
            snakePositionX[0]--;
        }
        if (direction == 3) {
            snakePositionY[0]--;
        }
        for (int i = snakeLength; i > 0; i--) {
            if (snakePositionX[0] == snakePositionX[i] && snakePositionY[0] == snakePositionY[i]) {
                snakeLength = i - 2;
            }
        }
        if (snakePositionX[0] > Launcer.WIDTH) {
            snakePositionX[0] = 0;
            System.out.println("1");
        }
        if (snakePositionY[0] > Launcer.HEIGHT) {
            snakePositionY[0] = 0;
            System.out.println("2");
        }
        if (snakePositionX[0] < 0) {
            snakePositionX[0] = Launcer.HEIGHT;
            System.out.println("3");
        }
        if (snakePositionY[0] < 0) {
            snakePositionY[0] = Launcer.WIDTH;
            System.out.println("4");
        }
    }
}
