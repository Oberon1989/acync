import Gui.MyWindow;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MyWindow window = new MyWindow();
        File source = window.selectSourceFile();
        String destination = source.getAbsolutePath();
        destination=window.selectDestinationPath()+destination.substring(destination.lastIndexOf("\\"));

        ExecutorService ex = Executors.newCachedThreadPool();
        String finalDestination = destination;
        ex.execute(()->{
            try {
                Util.copyFileUsingStream(source,new File(finalDestination),window.getOutput());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
