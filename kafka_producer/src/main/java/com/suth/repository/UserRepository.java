package com.suth.repository;

import com.suth.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    private static Logger logger = LogManager.getLogger(UserRepository.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    public User findUserById(int id) {
        logger.debug("id {}", id);
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        return user;
    }

    public List<User> findAll() {
        logger.debug("fetching all active users");
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class, "user");
        criteria.add(Restrictions.eq("user.status", "active"));
        return criteria.list();
    }
}
