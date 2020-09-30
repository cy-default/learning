package tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/19
 */
public class BIOTest {

    public static void main(String[] args) throws IOException {

        final ServerSocket serverSocket = new ServerSocket(8000);

        final ExecutorService executorService = Executors.newCachedThreadPool();


        while (true) {
            final Socket accept = serverSocket.accept();


            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                        String msg;
                        while ((msg = bufferedReader.readLine()) != null) {
                            System.out.println(msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
