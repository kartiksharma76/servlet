import java.util.*;

class Student {
	private String name;
	private int id;
	private double[] marks = new double[3];
	private double total;
	private double average;
	private char grade;

	public Student(String name, int id, double[] marks) {
		this.name = name;
		this.id = id;
		this.marks = marks.clone();
		calculateTotalAndAverage();
		assignGrade();
	}

	private void calculateTotalAndAverage() {
		total = Arrays.stream(marks).sum();
		average = total / marks.length;
	}

	private void assignGrade() {
		if (average >= 90)
			grade = 'A';
		else if (average >= 80)
			grade = 'B';
		else if (average >= 70)
			grade = 'C';
		else if (average >= 60)
			grade = 'D';
		else
			grade = 'F';
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double[] getMarks() {
		return marks.clone();
	}

	public double getTotal() {
		return total;
	}

	public double getAverage() {
		return average;
	}

	public char getGrade() {
		return grade;
	}
}

public class GradeManager {
	private static List<Student> students = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	private static int nextId = 1;

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n===== STUDENT GRADE MANAGER =====");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1 -> addStudent();
			case 2 -> viewAllStudents();
			case 3 -> searchStudent();
			case 4 -> {
				System.out.println("Goodbye!");
				System.exit(0);
			}
			default -> System.out.println("Invalid option!");
			}
		}
	}

	private static void addStudent() {
		System.out.print("Enter student name: ");
		String name = scanner.nextLine();

		double[] marks = new double[3];
		for (int i = 0; i < 3; i++) {
			System.out.print("Enter marks for Subject " + (i + 1) + ": ");
			marks[i] = scanner.nextDouble();
			if (marks[i] < 0 || marks[i] > 100) {
				System.out.println("Invalid marks! Must be between 0-100.");
				i--; // Retry current subject
			}
		}
		scanner.nextLine(); // Consume newline

		students.add(new Student(name, nextId++, marks));
		System.out.println("Student added successfully! ID: " + (nextId - 1));
	}

	private static void viewAllStudents() {
		if (students.isEmpty()) {
			System.out.println("No students found!");
			return;
		}

		System.out.printf("\n%-5s %-15s %-10s %-10s %-6s\n", "ID", "Name", "Total", "Average", "Grade");
		System.out.println("---------------------------------------------");
		for (Student s : students) {
			System.out.printf("%-5d %-15s %-10.2f %-10.2f %-6c\n", s.getId(), s.getName(), s.getTotal(), s.getAverage(),
					s.getGrade());
		}
	}

	private static void searchStudent() {
		System.out.print("Enter student ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Optional<Student> student = students.stream().filter(s -> s.getId() == id).findFirst();

		if (student.isPresent()) {
			Student s = student.get();
			System.out.println("\n--- STUDENT DETAILS ---");
			System.out.println("ID: " + s.getId());
			System.out.println("Name: " + s.getName());
			System.out.println("Marks: " + Arrays.toString(s.getMarks()));
			System.out.println("Total: " + s.getTotal());
			System.out.println("Average: " + String.format("%.2f", s.getAverage()));
			System.out.println("Grade: " + s.getGrade());
		} else {
			System.out.println("Student not found!");
		}
	}
}