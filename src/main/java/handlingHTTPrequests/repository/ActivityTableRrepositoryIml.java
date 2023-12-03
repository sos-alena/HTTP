package handlingHTTPrequests.repository;

import handlingHTTPrequests.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import handlingHTTPrequests.models.ActivityTable;

public class ActivityTableRrepositoryIml implements ActivityTableRepository {

    @Override
    public void add(ActivityTable model) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session = session.getSession();
        session.save(model);
        transaction.commit();
        session.close();
    }
}
