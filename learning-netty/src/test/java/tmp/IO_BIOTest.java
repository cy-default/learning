package tmp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/9/19
 */
public class IO_BIOTest {

    public static void main(String[] args) throws IOException {

        final ServerSocket serverSocket = new ServerSocket(8888);
        final ExecutorService executorService = Executors.newFixedThreadPool(5);


        while (true) {
            final Socket accept = serverSocket.accept();

            executorService.execute(() -> {
                final InputStream inputStream;
                try {
                    inputStream = accept.getInputStream();
                    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String msg;
                    msg = bufferedReader.readLine();
                    System.out.println("receive msg:" + msg);

                    final OutputStream outputStream = accept.getOutputStream();
                    msg = "hello world \n";
                    outputStream.write(msg.getBytes());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            });

        }

    }
}
