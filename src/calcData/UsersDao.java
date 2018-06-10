package calcData;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

public class UsersDao {
    public static int register(UsersEntity u){
        int i=0;

        Session session;
        try {
            session = new Configuration().
                    configure().buildSessionFactory().openSession();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }

        Transaction t=session.beginTransaction();
        t.begin();

        i=(Integer)session.save(u);

        t.commit();
        session.close();

        return i;
    }

    public void addUserDetails(String email, String password) {
        try {
            // 1. configuring hibernate
            Configuration configuration = new Configuration().configure();

            // 2. create sessionfactory
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            // 3. Get Session object
            Session session = sessionFactory.openSession();

            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
            UsersEntity user = new UsersEntity();
            user.setPassword(password);
            user.setEmail(email);
            session.save(user);
            transaction.commit();
            System.out.println("\n\n Details Added \n");

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }

    }
}
