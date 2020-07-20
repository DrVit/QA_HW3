import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] ar) {

        try {
            Socket socket = new Socket("localhost", 6666);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Type in something and press enter.");
            System.out.println();

            while (true) {
                line = keyboard.readLine();
                System.out.println("Sending this line to the server...");
                out.writeUTF(line);
                out.flush();
                line = in.readUTF();
                System.out.println("Server sent me this : " + line);
                System.out.println("Shall we write something else?");
                out.flush();
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
