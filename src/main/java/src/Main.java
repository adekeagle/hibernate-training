package src;

public class Main {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.save();
        System.out.println(studentDAO.get(1L));
    }
}
