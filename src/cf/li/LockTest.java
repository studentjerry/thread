package cf.li;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by li on 1/6/16.
 */
    public class LockTest {

    int a=2;
    ReentrantLock lock=new ReentrantLock();



    public void write(){
        lock.lock();
        try{
            a=a*4+5;
        }finally {
            lock.unlock();
        }

    }

    public void read(){
        lock.lock();
        try{
            int i=a;
            System.out.println("i value :"+i);
        }finally {
            lock.unlock();
        }
    }

}
