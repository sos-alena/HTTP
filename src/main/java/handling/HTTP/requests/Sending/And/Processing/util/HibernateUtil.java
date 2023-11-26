package handling.HTTP.requests.Sending.And.Processing.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import handling.HTTP.requests.Sending.And.Processing.models.ActivityTable;

public class HibernateUtil {

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;

        try {
            Configuration configuration = new Configuration().configure();

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.addAnnotatedClass(ActivityTable.class).buildSessionFactory(builder.build());

        } catch (Exception e) {
            System.out.println("Исключение!" + e);
        }
        return sessionFactory;
    }
}
