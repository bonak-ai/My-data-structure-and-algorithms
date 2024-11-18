import java.util.Scanner;
class Student {
    int id;
    String name;
    String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Course: " + course;
    }
}

class Node {
    Student student;
    Node left, right;

    public Node(Student student) {
        this.student = student;
        this.left = null;
        this.right = null;
    }
}
class StudentTree {
    private Node root;

    public void add(Student student) {
        root = addRecursive(root, student);
    }

    private Node addRecursive(Node current, Student student) {
        if (current == null) {
            return new Node(student);
        }
        if (student.id < current.student.id) {
            current.left = addRecursive(current.left, student);
        } else if (student.id > current.student.id) {
            current.right = addRecursive(current.right, student);
        } else {
            System.out.println("Student with this ID already exists.");
        }
        return current;
    }

    public Student search(int id) {
        Node node = searchRecursive(root, id);
        return node == null ? null : node.student;
    }

    private Node searchRecursive(Node current, int id) {
        if (current == null || current.student.id == id) {
            return current;
        }
        return id < current.student.id 
                ? searchRecursive(current.left, id) 
                : searchRecursive(current.right, id);
    }

    public void display() {
        displayRecursive(root);
    }

    private void displayRecursive(Node node) {
        if (node != null) {
            displayRecursive(node.left);
            System.out.println(node.student);
            displayRecursive(node.right);
        }
    }
}

public class StudentInfoApp {
    public static void main(String[] args) {
        StudentTree tree = new StudentTree();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
      System.out.println("\n=== Student Information System ===");
            System.out.println("1. Add Student");
         System.out.println("2. Search Student ID");
        System.out.println("3. Display All Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    tree.add(new Student(id, name, course));
                    break;
                case 2:
                    System.out.print("Enter ID to search: ");
                    int searchId = scanner.nextInt();
                    Student found = tree.search(searchId);
                    if (found != null) {
                        System.out.println("Student Found: " + found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.println("All Students:");
                    tree.display();
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
