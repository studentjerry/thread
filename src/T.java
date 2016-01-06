import cf.li.LockTest;

/**
 * Created by li on 1/6/16.
 */
public class T {

    public static void main(String[]  arg){
      T t=new T();
      //测试加锁
      t.runOneHundred();
    }

    private void runOneHundred(){
        for(int i=0;i<100;i++){
          testLock();
        }
    }

    private void testLock(){
        final LockTest lockTest=new LockTest();
       Thread one= new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.write();
            }
        });
        one.start();
       Thread two= new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.read();
            }
        });

        Thread three=new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.write();
            }
        });
        three.start();
        two.start();
        try {
            one.join();
            two.join();
            three.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
