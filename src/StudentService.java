import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private int nextId = 1;

    // Create
    public Student add(String name, int age) {
        Student s = new Student(nextId++, name, age);
        students.add(s);
        return s;
    }

    // Read (all)
    public List<Student> findAll() {
        return students;
    }

    // Read (by ID)
    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // Update
    public boolean update(int id, String name, int age) {
        Student s = findById(id);
        if (s == null) {
            return false;
        }
        s.setName(name);
        s.setAge(age);
        return true;
    }

    // Delete
    public boolean delete(int id) {
        Student s = findById(id);
        if (s == null) {
            return false;
        }
        students.remove(s);
        return true;
    }
}
