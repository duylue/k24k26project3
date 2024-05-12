package com.example.K2426Project3.service.impl;

import com.example.K2426Project3.model.Customer;
import com.example.K2426Project3.model.Zone;
import com.example.K2426Project3.service.CustomerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private EntityManager entityManager;
    @Autowired
    EntityManagerFactory factory;

    @Override
    public List<Customer> list() {
        entityManager = factory.createEntityManager();
        List<Customer> list = entityManager.createNativeQuery("SELECT * FROM CUSTOMER", Customer.class).getResultList();
        return list;
    }

    @Override
    public List<Zone> listZone() {
        entityManager = factory.createEntityManager();
        List<Zone> list = entityManager.createNativeQuery("SELECT * FROM zone ", Zone.class).getResultList();
        return list;
    }


    @Override
    public void save(Customer customer) {
        entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        if (customer.getCid() > 0) {
//            entityManager.createNativeQuery("update customer set cname = ?1 ," +
//                    "birthday = ?2, zid = ?3 where cid = ?4").
//                    setParameter(1, customer.getCname())
//                    .setParameter(2, customer.getBirthday())
//                    .setParameter(3,customer.getZid())
//                    .setParameter(4, customer.getCid())
//                    .executeUpdate();
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
        transaction.commit();

    }

    @Override
    public Customer findById(int id) {
        entityManager = factory.createEntityManager();
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    @Override
    public void delete(int id) {
        entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
        transaction.commit();

    }
}
