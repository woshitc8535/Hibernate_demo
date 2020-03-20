package test;


import entity.Instructor;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import utils.HibernateUtils;

import javax.persistence.Table;


public class HibernateDemo {
    @Test
    public void TestAdd() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = new User();
        user.setUsername("Yinnan Li");
        user.setPassword("234");
        session.save(user);
//
//        Instructor instructor = new Instructor();
//        instructor.setFirstName("li");
//        instructor.setLastName("yifeng");
//        instructor.setEmail("hahahah");
        tx.commit();
        session.close();
        sessionFactory.close();

    }

    @Test
    public void queryTest() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = (User) session.get(User.class, 2);
        System.out.println(user);
        tx.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void updateTest() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User user = (User) session.get(User.class, 1);
        user.setUsername("Zimu");
        session.update(user);
        System.out.println(user);
        tx.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void deleteTest() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User user = (User) session.get(User.class, 3);
        session.delete(user);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
