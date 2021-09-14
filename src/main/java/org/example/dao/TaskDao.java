package org.example.dao;

import org.example.models.HibernateFactory;
import org.example.models.Task;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class TaskDao {
    //metoda zapisujaca zadanie
    public Task save(Task task) {
        final SessionFactory sessionFactory = HibernateFactory.getSessionFactory ( );
        final Session session = sessionFactory.openSession ( );
        final Transaction transaction = session.beginTransaction ( );
        final Long saveID = (Long) session.save (task);
        transaction.commit ( );

        final Task TaskFromDataBase = session.get (Task.class, saveID);
        session.close ( );
        return TaskFromDataBase;
    }

    public Task getId(Long id) {
        final Session session = HibernateFactory.getSessionFactory ( ).openSession ( );
        Task task = session.get (Task.class, id);
        session.close ( );
        return task;
    }

    public Task removeTask(Long id) {
        final Session session_remove = HibernateFactory.getSessionFactory ( ).openSession ( );
        final Transaction transaction = session_remove.beginTransaction ( );
        final Task task = session_remove.get (Task.class, id);
        session_remove.remove (task);
        transaction.commit ( );
        session_remove.close ( );
        return task;

    }

    public void updateTask(Task task) {
        final Session sessionUpdateTask = HibernateFactory.getSessionFactory ( ).openSession ( );
        final Transaction transaction = sessionUpdateTask.beginTransaction ( );
        sessionUpdateTask.update (task);
        transaction.commit ( );
        sessionUpdateTask.close ( );
    }

    public void updateTaskStatusToDone(Task task, boolean UpdateStatus) {
        final Session session = HibernateFactory.getSessionFactory ( ).openSession ( );
        final Transaction transaction = session.beginTransaction ( );
        org.hibernate.query.Query status = session.createQuery ("update status task =  :DONE where status =:false");
        session.update (task);
        transaction.commit ( );
        session.close ( );
    }
}




