public class StudentDemo {
    public static void main(String[] args){
        DOB dob = new DOB(27, 10, 2001);
        Student s0 = new Student(1, "Suyog", 22, "KTM", dob);
        s0.showInfo();
        System.out.println();
        Student s1= new Student(2, "Samyog", 17, "KTM", new DOB(25, 10, 2007));
        s1.showInfo();
    }
}

class Student {
    int roll, age;
    String name, address;
    DOB dob;    

    public Student(int roll, String name, int age, String address, DOB dob) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.address = address;
        this.dob = dob;
    }

    public Student() {

    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Addeess: " + address);
        System.out.println("Roll no: " + roll);
        System.out.println("Date of Birth: " + dob.getDate());
    }
}

class DOB {
    int dd, mm, yy;

    public DOB(int dd, int mm, int yy) {
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }

    public String getDate() {
        return (dd + "/" + mm + "/" + yy);
    }
}