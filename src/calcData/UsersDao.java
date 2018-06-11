package calcData;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

public class UsersDao {

    public boolean register(UsersEntity user){
        Session session = HibernateUtil.openSession();
        if(isUserExists(user)) return false;

        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    public boolean isUserExists(UsersEntity user){
        Session session = HibernateUtil.openSession();
        boolean result = false;
        Transaction tx = null;
        try{
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from UsersEntity where email='"+user.getEmail()+"'");
            UsersEntity u = (UsersEntity)query.uniqueResult();
            tx.commit();
            if(u!=null) result = true;
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }
}
