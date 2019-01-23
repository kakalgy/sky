package com.yusj.parrot.idea.memory;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 */
public class ByteBufferTest {

    @Test
    public void test() throws IOException {
        ByteBuffer buff = ByteBuffer.allocate(128);
        FileChannel fin = null;
        FileChannel fout = null;
        try {
            fin = new FileInputStream("filein").getChannel();
            fout = new FileOutputStream("fileout").getChannel();
            while (fin.read(buff) != -1) {
                buff.flip();
                fout.write(buff);
                buff.clear();
            }
        } catch (FileNotFoundException e) {

        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }
    }
}
