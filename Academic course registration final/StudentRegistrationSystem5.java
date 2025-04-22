import java.util.*;

class Student {
    private String studentId;
    private String fullName;
    private String gender;
    private String dob;
    private String email;
    private String socialStatus;
    private String aadhaar;
    private String state;
    private String district;
    private String city;
    private String address1;
    private String address2;
    private List<String> registeredCourses;
    
    // Main constructor that takes user input
   public Student(Scanner scanner) {
        System.out.println("\n--- Student Registration Form ---");
        
        // Student ID validation
        while (true) {
            try {
                System.out.print("Enter Student ID: ");
                this.studentId = scanner.nextLine();
                if (!this.studentId.matches("^[A-Za-z0-9]{8,12}$")) {
                    throw new IllegalArgumentException("Invalid Student ID! Must be 8-12 alphanumeric characters.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Full Name validation
        while (true) {
            try {
                System.out.print("Enter Full Name: ");
                this.fullName = scanner.nextLine();
                if (!this.fullName.matches("^[A-Za-z ]+$")) {
                    throw new IllegalArgumentException("Invalid Name! Only letters and spaces allowed.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Gender validation
        while (true) {
            try {
                System.out.print("Enter Gender (M/F/O): ");
                this.gender = scanner.nextLine().toUpperCase();
                if (!this.gender.matches("^[MFO]$")) {
                    throw new IllegalArgumentException("Invalid Gender! Must be M, F, or O.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Date of Birth validation
        while (true) {
            try {
                System.out.print("Enter Date of Birth (DD-MM-YYYY): ");
                this.dob = scanner.nextLine();
                if (!this.dob.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
                    throw new IllegalArgumentException("Invalid Date of Birth! Use DD-MM-YYYY format.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Email validation
        while (true) {
            try {
                System.out.print("Enter Email: ");
                this.email = scanner.nextLine();
                if (!this.email.matches("^[^@]+@[^@]+\\.[^@]+$")) {
                    throw new IllegalArgumentException("Invalid Email! Must be in format user@domain.com");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Social Status validation
        while (true) {
            try {
                System.out.print("Enter Social Status (GEN/OBC/SC/ST/EWS): ");
                this.socialStatus = scanner.nextLine().toUpperCase();
                if (!this.socialStatus.matches("^(GEN|OBC|SC|ST|EWS)$")) {
                    throw new IllegalArgumentException("Invalid Social Status! Must be GEN/OBC/SC/ST/EWS.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Aadhaar validation
        while (true) {
            try {
                System.out.print("Enter Aadhaar Number: ");
                this.aadhaar = scanner.nextLine();
                if (!this.aadhaar.matches("^\\d{12}$")) {
                    throw new IllegalArgumentException("Invalid Aadhaar! Must be 12 digits.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Non-validated fields (remain exactly the same)
        System.out.print("Enter State: ");
        this.state = scanner.nextLine();
        
        System.out.print("Enter District: ");
        this.district = scanner.nextLine();
        
        System.out.print("Enter City: ");
        this.city = scanner.nextLine();
        
        System.out.print("Enter Address Line 1: ");
        this.address1 = scanner.nextLine();
        
        System.out.print("Enter Address Line 2 (Optional): ");
        this.address2 = scanner.nextLine();
        
        this.registeredCourses = new ArrayList<>();
        System.out.println("\nStudent '" + this.fullName + "' added successfully!\n");
    }        
            
    
    // Course Registration Functions
    public void registerCourse(String course) {
        if (!this.registeredCourses.contains(course)) {
            this.registeredCourses.add(course);
            System.out.println(this.fullName + " successfully registered for " + course + ".");
        } else {
            System.out.println(this.fullName + " is already registered for " + course + ".");
        }
    }
    
    public void dropCourse(String course) {
        if (this.registeredCourses.contains(course)) {
            this.registeredCourses.remove(course);
            System.out.println(this.fullName + " dropped " + course + ".");
        } else {
            System.out.println(this.fullName + " is not registered for " + course + ".");
        }
    }
    
    public void viewRegisteredCourses() {
        if (!this.registeredCourses.isEmpty()) {
            System.out.print(this.fullName + "'s Registered Courses: ");
            System.out.println(String.join(", ", this.registeredCourses));
        } else {
            System.out.println(this.fullName + " is not registered for any courses.");
        }
    }
    
    public void displayStudentDetails() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Full Name: " + this.fullName);
        System.out.println("Gender: " + this.gender);
        System.out.println("Date of Birth: " + this.dob);
        System.out.println("Email: " + this.email);
        System.out.println("Social Status: " + this.socialStatus);
        System.out.println("Aadhaar: " + this.aadhaar);
        System.out.println("Address: " + this.address1 + ", " + this.address2);
        System.out.println("City: " + this.city);
        System.out.println("District: " + this.district);
        System.out.println("State: " + this.state);
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
    public String getStudentId() {
        return this.studentId;
    }
    
    public List<String> getRegisteredCourses() {
        return this.registeredCourses;
    }
}

/**
 * Course Class
 */
class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private List<Student> enrolledStudents;
    private List<Student> waitlist;
    private List<String> prerequisites;
    
    public Course(Scanner scanner) {
         System.out.println("\n--- Add New Course ---");
        
        // Course Code validation
        while (true) {
            try {
                System.out.print("Enter Course Code: ");
                this.courseCode = scanner.nextLine().toUpperCase();
                if (!this.courseCode.matches("^[A-Z]{2,4}\\d{3,4}$")) {
                    throw new IllegalArgumentException("Invalid Course Code! Format: DepartmentCode+Number (e.g., CS101, MATH2001)");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Course Name validation
        while (true) {
            try {
                System.out.print("Enter Course Name: ");
                this.courseName = scanner.nextLine();
                if (this.courseName.length() < 5 || !this.courseName.matches("^[A-Za-z0-9 &\\-]+$")) {
                    throw new IllegalArgumentException("Invalid Course Name! Must be at least 5 characters (letters, numbers, spaces, &, -)");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        // Capacity validation
        while (true) {
            try {
                System.out.print("Enter Maximum Capacity: ");
                String capacityInput = scanner.nextLine();
                this.maxCapacity = Integer.parseInt(capacityInput);
                if (this.maxCapacity < 5 || this.maxCapacity > 200) {
                    throw new IllegalArgumentException("Capacity must be between 5 and 200");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 5 and 200");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        this.enrolledStudents = new ArrayList<>();
        this.waitlist = new ArrayList<>();
        this.prerequisites = new ArrayList<>();
        System.out.println("Course " + this.courseName + " (" + this.courseCode + ") added successfully.");
    }    
    public void addPrerequisite(String prerequisiteCourse) {
        if (!this.prerequisites.contains(prerequisiteCourse)) {
            this.prerequisites.add(prerequisiteCourse);
        }
    }
    
    public void enrollStudent(Student student) {
        if (this.enrolledStudents.size() < this.maxCapacity) {
            this.enrolledStudents.add(student);
            System.out.println(student.getFullName() + " successfully enrolled in " + this.courseName + ".");
        } else {
            this.waitlist.add(student);
            System.out.println("Course full! " + student.getFullName() + " added to waitlist for " + this.courseName + ".");
        }
    }
    
    public void dropStudent(Student student) {
        if (this.enrolledStudents.contains(student)) {
            this.enrolledStudents.remove(student);
            System.out.println(student.getFullName() + " dropped from " + this.courseName + ".");
            
            if (!this.waitlist.isEmpty()) {
                Student nextStudent = this.waitlist.remove(0);
                this.enrolledStudents.add(nextStudent);
                System.out.println(nextStudent.getFullName() + " enrolled from waitlist into " + this.courseName + ".");
            }
        } else {
            System.out.println(student.getFullName() + " is not enrolled in " + this.courseName + ".");
        }
    }
    
    public void viewCourseDetails() {
        System.out.println("\nCourse: " + this.courseName + " (" + this.courseCode + ")");
        System.out.println("Capacity: " + this.enrolledStudents.size() + "/" + this.maxCapacity);
        
        System.out.print("Prerequisites: ");
        if (this.prerequisites.isEmpty()) {
            System.out.println("None");
        } else {
            System.out.println(String.join(", ", this.prerequisites));
        }
        
        System.out.print("Enrolled Students: ");
        if (this.enrolledStudents.isEmpty()) {
            System.out.println("None");
        } else {
            List<String> studentNames = new ArrayList<>();
            for (Student s : this.enrolledStudents) {
                studentNames.add(s.getFullName());
            }
            System.out.println(String.join(", ", studentNames));
        }
        
        System.out.print("Waitlisted Students: ");
        if (this.waitlist.isEmpty()) {
            System.out.println("None");
        } else {
            List<String> studentNames = new ArrayList<>();
            for (Student s : this.waitlist) {
                studentNames.add(s.getFullName());
            }
            System.out.println(String.join(", ", studentNames));
        }
    }
    
    public String getCourseCode() {
        return this.courseCode;
    }
    
    public String getCourseName() {
        return this.courseName;
    }
    
    public List<String> getPrerequisites() {
        return this.prerequisites;
    }
}

/**
 * Course Registration System
 */
class CourseRegistrationSystem {
    private Map<String, Course> courses;
    private Map<String, Student> students;
    private Map<String, List<String>> prerequisiteGraph;
    
    public CourseRegistrationSystem() {
        this.courses = new HashMap<>();
        this.students = new HashMap<>();
        this.prerequisiteGraph = new HashMap<>();
    }
    
    public void addCourse(Course course) {
        if (!this.courses.containsKey(course.getCourseCode())) {
            this.courses.put(course.getCourseCode(), course);
            this.prerequisiteGraph.put(course.getCourseCode(), new ArrayList<>());
        } else {
            System.out.println("Course already exists!");
        }
    }
    
    public void addStudent(Student student) {
        if (!this.students.containsKey(student.getStudentId())) {
            this.students.put(student.getStudentId(), student);
        } else {
            System.out.println("Student ID already exists!");
        }
    }
    
    public void addPrerequisite(String courseCode, String prerequisiteCode) {
        if (this.courses.containsKey(courseCode) && this.courses.containsKey(prerequisiteCode)) {
            this.courses.get(courseCode).addPrerequisite(prerequisiteCode);
            this.prerequisiteGraph.get(courseCode).add(prerequisiteCode);
            System.out.println("Prerequisite " + prerequisiteCode + " added to " + courseCode + ".");
        } else {
            System.out.println("Invalid course codes!");
        }
    }
    
    public void registerStudent(Student student, String courseCode) {
        if (this.courses.containsKey(courseCode)) {
            Course course = this.courses.get(courseCode);
            List<String> unmetPrerequisites = new ArrayList<>();
            
            for (String p : course.getPrerequisites()) {
                if (!student.getRegisteredCourses().contains(p)) {
                    unmetPrerequisites.add(p);
                }
            }
            
            if (!unmetPrerequisites.isEmpty()) {
                System.out.println("Cannot register! " + student.getFullName() + " is missing prerequisites: " + 
                                  String.join(", ", unmetPrerequisites));
            } else {
                course.enrollStudent(student);
                student.registerCourse(courseCode);
            }
        } else {
            System.out.println("Course not found!");
        }
    }
    
    public void dropStudent(Student student, String courseCode) {
        if (this.courses.containsKey(courseCode)) {
            Course course = this.courses.get(courseCode);
            course.dropStudent(student);
            student.dropCourse(courseCode);
        } else {
            System.out.println("Course not found!");
        }
    }
    
    public void viewAllCourses() {
        if (this.courses.isEmpty()) {
            System.out.println("No courses available in the system.");
            return;
        }
        
        for (Course course : this.courses.values()) {
            course.viewCourseDetails();
        }
    }
    
    public void viewAllStudents() {
        if (this.students.isEmpty()) {
            System.out.println("No students registered in the system.");
            return;
        }
        
        System.out.println("\n--- All Registered Students ---");
        for (Student student : this.students.values()) {
            System.out.println(student.getStudentId() + ": " + student.getFullName());
        }
    }
    
    public Student findStudentById(String studentId) {
        return this.students.get(studentId);
    }
    
    public Course findCourseByCode(String courseCode) {
        return this.courses.get(courseCode);
    }
}

/**
 * Main Class for the Student Registration System 
 */
public class StudentRegistrationSystem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseRegistrationSystem system = new CourseRegistrationSystem();
        
        while (true) {
            displayMainMenu();
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        studentManagement(scanner, system);
                        break;
                    case 2:
                        courseManagement(scanner, system);
                        break;
                    case 3:
                        registrationManagement(scanner, system);
                        break;
                    case 4:
                        System.out.println("Exiting system. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    private static void displayMainMenu() {
        System.out.println("\n--- Student Registration System ---");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Registration Management");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void studentManagement(Scanner scanner, CourseRegistrationSystem system) {
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add New Student");
            System.out.println("2. View Student Details");
            System.out.println("3. View All Students");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        Student newStudent = new Student(scanner);
                        system.addStudent(newStudent);
                        break;
                    case 2:
                        System.out.print("Enter Student ID: ");
                        String studentId = scanner.nextLine();
                        Student student = system.findStudentById(studentId);
                        if (student != null) {
                            student.displayStudentDetails();
                            student.viewRegisteredCourses();
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;
                    case 3:
                        system.viewAllStudents();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    private static void courseManagement(Scanner scanner, CourseRegistrationSystem system) {
        while (true) {
            System.out.println("\n--- Course Management ---");
            System.out.println("1. Add New Course");
            System.out.println("2. Add Prerequisite");
            System.out.println("3. View All Courses");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        Course newCourse = new Course(scanner);
                        system.addCourse(newCourse);
                        break;
                    case 2:
                        System.out.print("Enter Course Code: ");
                        String courseCode = scanner.nextLine();
                        
                        if (system.findCourseByCode(courseCode) == null) {
                            System.out.println("Course not found!");
                            break;
                        }
                        
                        System.out.print("Enter Prerequisite Course Code: ");
                        String prereqCode = scanner.nextLine();
                        
                        if (system.findCourseByCode(prereqCode) == null) {
                            System.out.println("Prerequisite course not found!");
                            break;
                        }
                        
                        system.addPrerequisite(courseCode, prereqCode);
                        break;
                    case 3:
                        system.viewAllCourses();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
    private static void registrationManagement(Scanner scanner, CourseRegistrationSystem system) {
        while (true) {
            System.out.println("\n--- Registration Management ---");
            System.out.println("1. Register Student for Course");
            System.out.println("2. Drop Student from Course");
            System.out.println("3. View Student's Registered Courses");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter Student ID: ");
                        String studentId1 = scanner.nextLine();
                        Student student1 = system.findStudentById(studentId1);
                        
                        if (student1 == null) {
                            System.out.println("Student not found!");
                            break;
                        }
                        
                        System.out.print("Enter Course Code: ");
                        String courseCode1 = scanner.nextLine();
                        
                        if (system.findCourseByCode(courseCode1) == null) {
                            System.out.println("Course not found!");
                            break;
                        }
                        
                        system.registerStudent(student1, courseCode1);
                        break;
                    case 2:
                        System.out.print("Enter Student ID: ");
                        String studentId2 = scanner.nextLine();
                        Student student2 = system.findStudentById(studentId2);
                        
                        if (student2 == null) {
                            System.out.println("Student not found!");
                            break;
                        }
                        
                        System.out.print("Enter Course Code: ");
                        String courseCode2 = scanner.nextLine();
                        
                        if (system.findCourseByCode(courseCode2) == null) {
                            System.out.println("Course not found!");
                            break;
                        }
                        
                        system.dropStudent(student2, courseCode2);
                        break;
                    case 3:
                        System.out.print("Enter Student ID: ");
                        String studentId3 = scanner.nextLine();
                        Student student3 = system.findStudentById(studentId3);
                        
                        if (student3 == null) {
                            System.out.println("Student not found!");
                            break;
                        }
                        
                        student3.viewRegisteredCourses();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}