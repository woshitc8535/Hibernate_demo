import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class test {
    @Test
    public void fun() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin");
        session.save(user);
        session.beginTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
