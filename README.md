# sonar_submarine
#  SUBMARINE Radar Project - Cold War UI in Java Swing 

## Overview

This project is a demonstration of a radar User Interface (UI), inspired by classic submarine displays from the Cold War era. Developed in **Java Swing**, it features a rotating scanning beam, concentric rings, and grid lines, simulating an active radar in real-time.

The primary goal of this project is to solidify fundamental Java programming concepts, Graphical User Interface (GUI) manipulation, and animation and event handling principles within a desktop application environment.

##  Features

* **Animated Radar Display:** A green beam continuously rotates, simulating the radar scan.
* **Graphical Elements:** Concentric circles and dividing lines in green on a black background, recreating the classic radar aesthetic.
* **Immersive Full-Screen:** The radar is displayed in full-screen mode without borders for an immersive experience.

## Technologies Used

* **Java Development Kit (JDK)**
* **Java Swing:** For building the graphical user interface.
* **Java AWT (Abstract Window Toolkit):** For 2D drawing operations and graphics manipulation.
* **Eclipse IDE:** Integrated Development Environment used for development.

##  How to Run the Project

To run the SUBMARINE Radar on your system:

1.  **Prerequisites:**
    * Ensure you have the **Java Development Kit (JDK)** (version 11 or higher is recommended) installed.
    * Have **Eclipse IDE** configured for Java development.

2.  **Eclipse Setup:**
    * **Create a new Java Project:**
        * In Eclipse, go to `File > New > Java Project`.
        * Name the project (e.g., `RadarSubmarine` or `Portfolio`). Click `Finish`.
    * **Create a new Package:**
        * In the `Package Explorer`, right-click on the `src` folder of your new project.
        * Go to `New > Package`.
        * In the `Name` field, type `URSS_SUBMARINE` (this name must match the `package` declared in the code). Click `Finish`.
    * **Create the SUBMARINE Class:**
        * Right-click on the `URSS_SUBMARINE` package you just created.
        * Go to `New > Class`.
        * In the `Name` field, type `SUBMARINE` (with an uppercase 'S').
        * Ensure the `Package` field is automatically filled with `URSS_SUBMARINE`.
        * Click `Finish`.
    * **Paste the Code:**
        * Open the newly created `SUBMARINE.java` file.
        * **Delete all content** that Eclipse automatically generated.
        * **Paste the complete radar code** (including the `package URSS_SUBMARINE;` line at the top). The code is available below or in separate files.

3.  **Execute:**
    * Save the file (`Ctrl + S`).
    * In the `Package Explorer`, right-click on the `SUBMARINE.java` file.
    * Go to `Run As > Java Application`.

##  Lessons Learned and Challenges

This project was a journey of learning and overcoming common challenges in desktop Java development and environment configuration:

* **Java Fundamentals:** Reinforced understanding of Object-Oriented Programming, inheritance (`extends JPanel`), interfaces (`implements ActionListener`), and multithreading concepts (with `SwingUtilities.invokeLater` and `Timer`).
* **GUI Work (Swing/AWT):** Practical experience with components like `JFrame`, `JPanel`, and the 2D drawing API (`Graphics2D`).
* **Event Handling:** Understanding the Swing event model and the use of `ActionListener` for animations.
* **Environment Configuration:** Dealing with the strict relationship between `package` declarations in code and the file structure in the file system, a common challenge for beginners in Eclipse and Java Modules.
* **Debugging:** The practice of identifying and resolving compilation and runtime errors, such as the `serialVersionUID` warning.

##  Next Steps (Improvement Ideas)

* Add "echoes" or trails to the radar beam for a more realistic visual effect.
* Implement random targets (white/green dots) that appear and disappear.
* Add "ping" sound effects.
* Allow user interaction (e.g., resize the radar, change rotation speed).
* Refactor the code to separate responsibilities (e.g., separate classes for the beam, for targets).

##  About the Developer

This project was developed as part of a career transition journey into the technology field. My previous experience in sectors such as **Occupational Safety (Construction), Logistics, Customer Service (McDonald's)**, and **Health Plan Benefits Processing** has provided me with a solid foundation in:

* **Practical Problem Solving:** Addressing complex challenges and finding effective solutions in the field.
* **Risk Management and Analysis:** Identifying vulnerabilities and implementing security measures.
* **Process Optimization and Efficiency:** Thinking about workflows and continuous improvements.
* **Adaptability and Resilience:** Moving between different environments and learning rapidly.
* **Customer Service and Communication:** Understanding needs and interacting with diverse individuals.

My passion for engineering and security has driven me into the world of programming. This Java Swing project reflects my commitment to learning and applying concepts, and my ability to use tools to overcome barriers and deliver results. I believe my diverse background makes me a professional with a unique perspective and a strong eagerness for continuous learning.
