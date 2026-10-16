import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService service = new StudentService();

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("===== 学生管理系统 =====");
            System.out.println("1. 添加学生");
            System.out.println("2. 查看所有学生");
            System.out.println("3. 按学号查询");
            System.out.println("4. 修改学生");
            System.out.println("5. 删除学生");
            System.out.println("0. 退出");
            System.out.print("请选择: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> add();
                case "2" -> listAll();
                case "3" -> findOne();
                case "4" -> update();
                case "5" -> delete();
                case "0" -> {
                    System.out.println("再见！");
                    return;
                }
                default -> System.out.println("无效选项，请重新输入");
            }
        }
    }

    private static void add() {
        System.out.print("姓名: ");
        String name = scanner.nextLine().trim();
        int age = readInt("年龄: ");
        Student s = service.add(name, age);
        System.out.println("添加成功 -> " + s);
    }

    private static void listAll() {
        List<Student> list = service.findAll();
        if (list.isEmpty()) {
            System.out.println("暂无学生");
            return;
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }

    private static void findOne() {
        int id = readInt("学号: ");
        Student s = service.findById(id);
        System.out.println(s == null ? "没有找到该学生" : s.toString());
    }

    private static void update() {
        int id = readInt("要修改的学号: ");
        if (service.findById(id) == null) {
            System.out.println("没有找到该学生");
            return;
        }
        System.out.print("新姓名: ");
        String name = scanner.nextLine().trim();
        int age = readInt("新年龄: ");
        service.update(id, name, age);
        System.out.println("修改成功");
    }

    private static void delete() {
        int id = readInt("要删除的学号: ");
        System.out.println(service.delete(id) ? "删除成功" : "没有找到该学生");
    }

    // 读取整数，输错了就重新输入
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("请输入数字");
            }
        }
    }
}
