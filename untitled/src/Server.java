import java.io.*;

 import java.net.*;

        public class Server {

 public static void main(String[] ar) {

         int port = 6888;

         try {

             ServerSocket ss = new ServerSocket(port);

             System.out.println("В ожидании клиента...");

            Socket socket = ss.accept();

             System.out.println("Клиент подключился!");

             System.out.println();

             InputStream sin = socket.getInputStream();

             OutputStream sout = socket.getOutputStream();

             DataInputStream in = new DataInputStream(sin);

             DataOutputStream out = new DataOutputStream(sout);
             float line,line2;

            while(true) {

               line = Integer.parseInt(in.readUTF());

                line2 = Integer.parseInt(in.readUTF());

                 String ServerResult = "Результаты вычислений:\n Сумма: " + (line+line2) + "\n Разность: " + (line-line2)+ "\n Произведение: " + (line*line2)+"\n Деление: "+(line/line2);

                out.writeUTF(ServerResult);

                 out.flush();

                 System.out.println("В ожидании запроса...");

                 System.out.println();

                 }

             } catch(Exception x) { x.printStackTrace(); }

         }
        }