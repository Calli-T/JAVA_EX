import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] RSP = {"가위", "바위", "보"};

        while (true) {
            System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)>>");
            int temp1 = -1;
            try {
                temp1 = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("똑바로 입력");
                continue;
            }

            if (temp1 < 1 || temp1 > 4) {
                System.out.println("똑바로 입력");
            }
            if (temp1 == 4) break;
            int temp2 = (int) (Math.random() * 3 + 1);

            System.out.println("철수(" + RSP[temp1 - 1] + ") : 컴퓨터(" + RSP[temp2 - 1] + ")");

            if ((temp2 - temp1) == 1 || (temp2 - temp1) == -2)
                System.out.println("컴퓨터가 이겼습니다.");
            else if ((temp2 - temp1) == -1 || (temp2 - temp1) == 2)
                System.out.println("철수가 이겼습니다.");
            else
                System.out.println("비겼습니다.");

        }

        System.out.println("프로그램 종료");
    }
}