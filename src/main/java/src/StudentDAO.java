package src;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class StudentDAO {

    public Student get(Long id) {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public void save() {
        Session session = HibernateSession.INSTANCE.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(new Student(1L, "Adrian", "Kapuscik", GroupId.MATH, LocalDate.of(2000, 1, 1)));
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        session.close();
    }
}
