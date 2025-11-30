import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        // Create database connection
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/students.odb");
        EntityManager em = emf.createEntityManager();

        // Persist some objects
        em.getTransaction().begin();
        em.persist(new Student("Alice", 20));
        em.persist(new Student("Bob", 22));
        em.getTransaction().commit();

        // Query the database
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        for (Student s : query.getResultList()) {
            System.out.println(s);
        }

        em.close();
        emf.close();
    }
}
