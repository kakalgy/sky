package com.yusj.magpie.jvm.gc;

/**
 * @Description <ul><li>1.对象在GC时可复活</li><li>2.这种机会只有一次，finalize方法最多只会被执行一次</li></ul>
 * @Author kakalgy
 * @Date 2018/12/15 11:10
 **/
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("Yes, I am still alive!");
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，因此等待0.5s
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I am dead!");
        }

        //再次gc
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，因此等待0.5s
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("No, I am dead!");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize method start!");
        super.finalize();
        FinalizeEscapeGC.SAVE_HOOK = this;
    }
}
