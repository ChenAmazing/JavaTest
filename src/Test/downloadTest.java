package Test;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class downloadTest {
    public static void main(String[] args) {
        String filepath = new String("G:\\test");
        File file = new File(filepath);
        Queue<File> queue = new LinkedList<>();
        queue.offer(file);
        while(!queue.isEmpty()){
            File f = queue.poll();
            File[] files = f.listFiles();
            for(File ff:files){
                System.out.println(ff.getName());
            }
        }
    }
}
