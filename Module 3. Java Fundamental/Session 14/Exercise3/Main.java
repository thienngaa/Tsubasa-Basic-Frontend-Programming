package exercise03;

import exercise01.StudentManager;
import utils.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.deleteStudentByAge(Scanner.scanner);
    }
}
