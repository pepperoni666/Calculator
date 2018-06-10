package calcData;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class LoginService {
    public boolean authenticateUser(String email, String password) {
        UsersEntity user = getUserByEmail(email);
        if(user!=null && user.getEmail().equals(email) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    public UsersEntity getUserByEmail(String email) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        UsersEntity user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from UsersEntity where email='" + email + "'");
            user = (UsersEntity)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    public List<UsersEntity> getListOfUsers(){
        List<UsersEntity> list = new ArrayList<UsersEntity>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from UsersEntity").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
