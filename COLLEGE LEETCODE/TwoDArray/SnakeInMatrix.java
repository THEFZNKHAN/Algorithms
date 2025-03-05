
import java.util.List;

public class SnakeInMatrix {

    public static void main(String[] args) {
        int n = 3;
        List<String> commands = List.of("DOWN", "RIGHT", "UP");
        System.out.println(finalPositionOfSnake2(n, commands));
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        int res = 0;
        for (String s : commands) {
            switch (s) {
                case "LEFT" -> res--;
                case "RIGHT" -> res++;
                case "DOWN" -> res += n;
                default -> res -= n;
            }
        }
        return res;
    }

    // MORE OPTIMIZED CODE:
    public static int finalPositionOfSnake2(int n, List<String> commands) {
        int i = 0, j = 0;
        for (String s : commands) {
            switch (s.charAt(0)) {
                case 'U' -> i--;
                case 'D' -> i++;
                case 'L' -> j--;
                default -> j++;
            }
        }
        return (i * n) + j;
    }
}
