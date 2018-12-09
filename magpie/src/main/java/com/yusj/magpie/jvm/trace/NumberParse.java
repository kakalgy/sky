package com.yusj.magpie.jvm.trace;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/12/9 21:41
 **/
public class NumberParse {
    public static void main(String[] args) {
//        String before1 = "715b00000";
//        String before1 = "27e80000";
//        String before1 = "715b00000";
        String before1 = "5c1000000";

        long after1 = Long.parseLong(before1, 16);
        System.out.println(after1);

//        String before2 = "28d80000";
//        String before2 = "7c0000000";
//        String before2 = "71db80000";
        String before2 = "5d6580000";
        long after2 = Long.parseLong(before2, 16);
        System.out.println(after2);

        long size = (after2 - after1) / 1024 / 1024;
        System.out.println("Size: " + size + "M");
    }
    /**
     * Heap
     *  PSYoungGen      total 153088K, used 1316K [0x0000000715b00000, 0x0000000720580000, 0x00000007c0000000)
     *   eden space 131584K, 1% used [0x0000000715b00000,0x0000000715c490d0,0x000000071db80000)
     *   from space 21504K, 0% used [0x000000071db80000,0x000000071db80000,0x000000071f080000)
     *   to   space 21504K, 0% used [0x000000071f080000,0x000000071f080000,0x0000000720580000)
     *  ParOldGen       total 349696K, used 661K [0x00000005c1000000, 0x00000005d6580000, 0x0000000715b00000)
     *   object space 349696K, 0% used [0x00000005c1000000,0x00000005c10a5418,0x00000005d6580000)
     *  Metaspace       used 3476K, capacity 4500K, committed 4864K, reserved 1056768K
     *   class space    used 381K, capacity 388K, committed 512K, reserved 1048576K
     **/
}
