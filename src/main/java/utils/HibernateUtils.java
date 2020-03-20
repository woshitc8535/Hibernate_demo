package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static Configuration cfg = null;
    private static SessionFactory sessionFactory = null;
    //static code block
    static {
        cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }
    //provide call back function
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
