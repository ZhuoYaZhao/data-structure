package test.io;

import main.utils.RunTime;
import main.utils.TimerUtil;

import java.io.File;
import java.util.Objects;

public class testIO {
    String path = this.getClass().getClassLoader().getResource("").getPath();

    @RunTime
    public void testFileDir() {

        File file = new File(path);
        System.out.println(file.isDirectory());

    }

    @RunTime
    public void testFile() {
        File file = new File(path);
        for (String s : Objects.requireNonNull(file.list())) {
            System.out.println(s);
        }
    }
    @RunTime
    public  void  testMkdir(){
        File file = new File(path+"new_file");
        file.mkdir();
    }

    public static void main(String[] args) {
        TimerUtil timerUtil = new TimerUtil();
        timerUtil.getTime();
    }

}
