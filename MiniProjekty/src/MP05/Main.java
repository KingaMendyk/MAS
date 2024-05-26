package MP05;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HibernateDB hdb = new HibernateDB();
        Animal animal1, animal2;
        animal1 = createAnimal("Mruczek");
        animal2 = createAnimal("Burek");
        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);

        createOwner("Adam", "Adamski");
        createOwner("Beata", "Beatska", animals);

        createWorker( "Cecylia", "Cecylska");
        createHotel("Zwierzakowo");

        HibernateDB.getSessionFactory().close();
    }

    private static Animal createAnimal(String name) {
        Session session = HibernateDB.getSessionFactory().getCurrentSession();
        if(!session.isOpen())
            session = HibernateDB.getSessionFactory().openSession();
        session.beginTransaction();

        Animal animal = new Animal(name);

        session.save(animal);
        session.getTransaction().commit();
        System.out.println("Animal added to database");
        return animal;
    }

    private static Person createPerson(String name, String surname, PersonType personType){
        Session session = HibernateDB.getSessionFactory().getCurrentSession();
        if(!session.isOpen())
            session = HibernateDB.getSessionFactory().openSession();
        session.beginTransaction();

        Person person = new Person(name, surname, personType);

        session.save(person);
        session.getTransaction().commit();
        System.out.println("Person added to database");

        return person;
    }
    private static Owner createOwner(String name, String surname){
        Person person = createPerson(name, surname, PersonType.Owner);

        Session session = HibernateDB.getSessionFactory().getCurrentSession();
        if(!session.isOpen())
            session = HibernateDB.getSessionFactory().openSession();
        session.beginTransaction();

        Owner owner = new Owner();
        owner.setPerson(person);

        session.save(owner);
        session.getTransaction().commit();
        System.out.println("Owner added to database");
        return  owner;
    }

    private static Owner createOwner(String name, String surname, List<Animal> animals){
        Person person = createPerson(name, surname, PersonType.Owner);

        Session session = HibernateDB.getSessionFactory().getCurrentSession();
        if(!session.isOpen())
            session = HibernateDB.getSessionFactory().openSession();
        session.beginTransaction();

        Owner owner = new Owner();
        owner.setPerson(person);
        for (Animal animal :animals) {
            owner.addAnimal(animal);
        }

        session.save(owner);
        session.getTransaction().commit();
        System.out.println("Owner with animals added to database");
        return owner;
    }

    private static Worker createWorker(String name, String surname){
        Person person = createPerson(name, surname, PersonType.Worker);

        Session session = HibernateDB.getSessionFactory().getCurrentSession();
        if(!session.isOpen())
            session = HibernateDB.getSessionFactory().openSession();
        session.beginTransaction();

        Worker worker = new Worker();
        worker.setPerson(person);

        session.save(worker);
        session.getTransaction().commit();
        System.out.println("Worker added to database");
        return worker;
    }

    private static Hotel createHotel(String name){
        Session session = HibernateDB.getSessionFactory().getCurrentSession();
        if(!session.isOpen())
            session = HibernateDB.getSessionFactory().openSession();
        session.beginTransaction();

        Hotel hotel = new Hotel(name);

        session.save(hotel);
        session.getTransaction().commit();
        System.out.println("Hotel added to database");

        return hotel;
    }
}
