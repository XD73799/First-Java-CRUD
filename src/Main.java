import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService service = new StudentService();

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("===== Student Manage System (Classic Java Final Project) =====");
            System.out.println("1. Add Student");
            System.out.println("2. Check all Students");
            System.out.println("3. Select from Student ID");
            System.out.println("4. Change smth for Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Please Select (0-5): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> add();
                case "2" -> listAll();
                case "3" -> findOne();
                case "4" -> update();
                case "5" -> delete();
                case "0" -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Please choose a correct number");
            }
        }
    }

    private static void add() {
        System.out.print("Name and Surname: ");
        String name = scanner.nextLine().trim();
        int age = readInt("Age: ");
        Student s = service.add(name, age);
        System.out.println("Add Successfully -> " + s);
    }

    private static void listAll() {
        List<Student> list = service.findAll();
        if (list.isEmpty()) {
            System.out.println("Temporarily no student");
            return;
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }

    private static void findOne() {
        int id = readInt("Student ID: ");
        Student s = service.findById(id);
        System.out.println(s == null ? "Didn't find this student" : s.toString());
    }

    private static void update() {
        int id = readInt("Student ID you want to change: ");
        if (service.findById(id) == null) {
            System.out.println("Didn't find this student");
            return;
        }
        System.out.print("New name: ");
        String name = scanner.nextLine().trim();
        int age = readInt("New age: ");
        service.update(id, name, age);
        System.out.println("Change Successfully");
    }

    private static void delete() {
        int id = readInt("Student ID you want to delete: ");
        System.out.println(service.delete(id) ? "Delete Successfully" : "Didn't find this student");
    }

    // Read an integer; ask again until the input is a valid number
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
    }
}
