package edu.upc.dsa;

import edu.upc.dsa.models.User;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class UsersManagerImpl implements UsersManager {
    private static UsersManager instance;
    protected List<User> users;
    final static Logger logger = Logger.getLogger(UsersManagerImpl.class);

    private UsersManagerImpl() {
        this.users = new LinkedList<>();
    }

    public static UsersManager getInstance() {
        if (instance==null) instance = new UsersManagerImpl();
        return instance;
    }

    public int size() {
        int ret = this.users.size();
        logger.info("size " + ret);

        return ret;
    }

    public User addUser(User t) {
        logger.info("new User " + t);

        this.users.add (t);
        logger.info("new User added");
        return t;
    }

    public User addUser(String username, String pwd) {
        return this.addUser(new User(username, pwd));
    }

    public User getUser(String id) {
        logger.info("getUser("+id+")");

        for (User t: this.users) {
            if (t.getId().equals(id)) {
                logger.info("getUser("+id+"): "+t);

                return t;
            }
        }

        logger.warn("user not found " + id);
        return null;
    }

    public List<User> findAll() {
        return this.users;
    }

    @Override
    public void deleteUser(String id) {

        User t = this.getUser(id);
        if (t==null) {
            logger.warn("user not found " + t);
        }
        else logger.info(t+"User deleted ");

        this.users.remove(t);

    }

    @Override
    public User updateUser(User p) {
        User u = this.getUser(p.getId());

        if (u!=null) {
            logger.info(p+" rebut!!!! ");

            u.setPwd(p.getPwd());
            u.setUsername(p.getUsername());

            logger.info(u+"User updated ");
        }
        else {
            logger.warn("User not found "+p);
        }

        return u;
    }
}