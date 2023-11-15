import java.util.HashMap;
import java.util.Scanner;
import java.util.GregorianCalendar;

public class Report {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        scheduler.run();
    }
}


class Day {
    private String work;

    public void set(String work) {
        this.work = work;
    }

    public String get() {
        return work;
    }

    public void show() {
        if (work == null)
            System.out.println("없습니다. ");
        else
            System.out.println(work + "입니다. ");
    }
}


class Scheduler {
    private HashMap<String, Day> cal;
    private Scanner scanner;
    private GregorianCalendar gregori;

    private String genDayStr(int year, int month, int day) {
        return year + "-" + month + "-" + day;
    }

    private String input_day() {
        int y;
        int m;
        int d;

        while (true) {
            try {
                System.out.print("년도? ");
                y = scanner.nextInt();
                System.out.print("월? ");
                m = scanner.nextInt();
                System.out.print("일? ");
                d = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("실제 년월일을 입력하세요");
                scanner.nextLine();
                continue;
            }
            if (!isAvailable(y, m, d)) {
                System.out.println("실제 년월일을 입력하세요");
                continue;
            }
            break;
        }

        return genDayStr(y, m, d);
    }

    private void input() {
        String temp_day = input_day();

        System.out.print("할일(빈칸없이입력)? ");
        String work;
        while (true) {
            try {
                work = scanner.next();
            } catch (Exception e) {
                System.out.print("올바르게 입력하세요");
                continue;
            }

            break;
        }

        Day temp_work = new Day();
        temp_work.set(work);

        this.cal.put(temp_day, temp_work);
    }

    private void view(String day) {
        Day temp_day = this.cal.get(day);
        String[] ydm = day.split("-");
        System.out.print(ydm[0] + "년 " + ydm[1] + "월 " + ydm[2] + "일의 할일은 ");
        temp_day.show();
    }

    private void finish() {
        System.out.println("프로그램을 종료합니다.");
    }

    private boolean isAvailable(int y, int m, int d) {
        boolean isLeapYear = this.gregori.isLeapYear(y);
        int days_of_month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear) days_of_month[1]++;

        if (y < 1) return false;
        if (m < 1 || m > 12) return false;
        if (d < 1 || d > days_of_month[m - 1]) return false;

        return true;
    }

    Scheduler() {
        this.scanner = new Scanner(System.in);
        this.gregori = new GregorianCalendar();
        this.cal = new HashMap<>();
    }

    public void run() {
        System.out.println();
        System.out.println("스케쥴 관리 프로그램. ");

        while (true) {
            System.out.print("할일(입력:1, 보기:2, 끝내기:3) >> ");
            int todo = 0;

            try {
                todo = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("숫자 1, 2, 3만 허용됨");
                scanner.nextLine();
                continue;
            }

            if (todo == 1) {
                this.input();
            } else if (todo == 2) {
                String day = input_day();
                view(day);
            } else if (todo == 3) {
                finish();
                break;
            } else {
                System.out.println("숫자 1, 2, 3만 허용됨");
                scanner.nextLine();
                continue;
            }

            scanner.nextLine();
            System.out.println();
        }
    }
}