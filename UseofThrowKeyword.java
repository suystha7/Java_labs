
import java.util.Scanner;

public class UseofThrowKeyword {
    public static void main(String[] args) {
        int age;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your age");
        age = s.nextInt();
        if (age > 60) {
            try {
                throw new InvaidAgeExceeption(age);
            } catch (InvaidAgeExceeption e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Your age is in required range: " + age);
        }
    }
}

class InvaidAgeExceeption extends Exception {
    int age;

    public InvaidAgeExceeption(int age) {
        this.age = age;
    }

    @Override
    public String getMessage() {
        return ("Invalid age excpetion " + age);
    }
}
