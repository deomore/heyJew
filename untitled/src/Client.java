import java.io.*;

import java.net.*;

       public class Client {

public static void main(String[] ar) {

     int serverPort = 6888;

       String address = "127.0.0.1";

       try {
            InetAddress ipAddress = InetAddress.getByName(address);

            Socket socket = new Socket(ipAddress, serverPort);

           InputStream sin = socket.getInputStream();

            OutputStream sout = socket.getOutputStream();

           DataInputStream in = new DataInputStream(sin);

             DataOutputStream out = new DataOutputStream(sout);

             BufferedReader keyboard = new BufferedReader(new

                    InputStreamReader(System.in));

             String line,line2 = null;

          System.out.println("\n Калькулятор \n Введите два числа.\n Каждое число должно быть на отдельной строке \n");

            while (true) {

                line = keyboard.readLine();

                line2 = keyboard.readLine();

                 System.out.println("отсылаем строки серверу...");

              out.writeUTF(line);

                out.writeUTF(line2);

                out.flush();

                 String serverline = in.readUTF();

                 System.out.println("Сервер прислал результат:\n" +

                        serverline);

                System.out.println("Введите следующие два числа\n");

                 System.out.println();
                 }
             } catch (Exception x) {
            x.printStackTrace();
             }

         }

 }