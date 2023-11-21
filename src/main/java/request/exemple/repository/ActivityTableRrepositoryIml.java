package request.exemple.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import request.exemple.models.ActivityTable;

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
