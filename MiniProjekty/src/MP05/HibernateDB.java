package MP05;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateDB {
    private static SessionFactory sessionFactory = null;
    private static StandardServiceRegistry registry = null;

    public HibernateDB() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("Mp05/hibernate.cfg.xml");
            registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(registry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
