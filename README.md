# Academic Course Registration System

A console-based Academic Course Registration System developed using **Java and Data Structures & Algorithms (DSA)**. The application manages students, courses, enrollments, course prerequisites, and waitlists using fundamental data structures.

## Overview

The Academic Course Registration System is designed to simplify academic course enrollment and management.

The project demonstrates the practical application of data structures such as **HashMaps, Graphs, and ArrayLists** to solve real-world problems involving data storage, searching, prerequisite management, and student registration.

It also incorporates object-oriented programming concepts, input validation, and modular menu-driven functionality.

## Features

### Student Management
- Register new students with personal and academic information.
- Validate student IDs, names, email addresses, and other fields.
- Search for students using their unique Student ID.
- View individual student details.
- Display all registered students.

### Course Management
- Add new courses with unique course codes.
- Define maximum enrollment capacity.
- Add prerequisite courses.
- View course details, enrolled students, and waitlisted students.
- Prevent duplicate course codes.

### Course Registration
- Register students for available courses.
- Validate course prerequisites before enrollment.
- Manage course enrollment capacity.
- Add students to a waitlist when a course reaches maximum capacity.
- Allow students to drop courses.
- Automatically promote the next waitlisted student when an enrolled student drops a course.

## Data Structures & Algorithms

A major focus of this project is implementing data structures to manage registration operations efficiently.

| Data Structure | Implementation | Application |
|---|---|---|
| HashMap | Java HashMap | Stores and retrieves students and courses using unique IDs and codes |
| Graph | Adjacency List | Represents relationships between courses and their prerequisites |
| ArrayList | Java ArrayList | Maintains student registrations, enrolled students, prerequisites, and waitlists |

### 1. HashMap

Two HashMaps are implemented:

- `HashMap<String, Student>` – Maps Student IDs to Student objects.
- `HashMap<String, Course>` – Maps Course Codes to Course objects.

These provide efficient average-case lookup, insertion, and retrieval operations.

### 2. Graph – Adjacency List

A graph represents the prerequisite relationships between courses.

- Each course represents a vertex.
- A directed edge connects a course to its prerequisite.
- An adjacency list stores the prerequisite relationships.

This representation helps organize course dependencies and supports prerequisite validation during registration.

### 3. ArrayList

ArrayLists are used to maintain:

- Registered courses for each student.
- Students enrolled in each course.
- Students waiting for available seats.
- Prerequisite course codes.

The waitlist follows FIFO (First In, First Out) behavior. When a seat becomes available, the first student in the waitlist is promoted.

## Object-Oriented Programming Concepts

The project also demonstrates:

- **Classes and Objects:** Separate classes for Student, Course, and CourseRegistrationSystem.
- **Encapsulation:** Student and course attributes are maintained using private fields.
- **Constructors:** Initialize student and course objects.
- **Exception Handling:** Handles invalid inputs and numerical conversion errors.
- **Input Validation:** Uses conditional checks and regular expressions to validate user information.

## Technologies Used

- Java
- Java Collections Framework
- Data Structures & Algorithms
- Object-Oriented Programming
- Java Scanner for console input

## Project Structure

The main Java implementation is organized into the following classes:

| Class | Responsibility |
|---|---|
| `Student` | Student information, validation, and registration records |
| `Course` | Course details, capacity, enrollment, prerequisites, and waitlist |
| `CourseRegistrationSystem` | Student and course management, prerequisite validation, and registration operations |
| `StudentRegistrationSystem5` | Main application and menu-driven interface |

## Getting Started

### Prerequisites

- Java Development Kit (JDK 8 or later)
- Any Java-compatible IDE or terminal

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/diyadineep/Academic-Course-Registration-System.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Academic-Course-Registration-System
   ```

3. Compile the Java application:

   ```bash
   javac StudentRegistrationSystem5.java
   ```

4. Run the application:

   ```bash
   java StudentRegistrationSystem5
   ```

## Application Menu

The application provides three main management modules:

1. Student Management
2. Course Management
3. Registration Management

Users can navigate through the console menu to perform the available operations.

## Learning Outcomes

Through this project, we explored:

- Practical implementation of fundamental data structures.
- Efficient searching and retrieval using HashMaps.
- Graph representation using adjacency lists.
- Managing enrollment and waitlists using ArrayLists.
- Applying FIFO principles to waitlist management.
- Implementing prerequisite validation.
- Applying object-oriented programming concepts in Java.

## Future Enhancements

- Implement persistent database storage.
- Develop a graphical user interface.
- Introduce student and administrator authentication.
- Improve waitlist and enrollment validation.
- Add automated testing and reporting functionality.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
