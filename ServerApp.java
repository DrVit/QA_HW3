import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] ar) {
        while (true) {
            try {
                ServerSocket ss = new ServerSocket(6666);
                System.out.println("Waiting for a client...");

                Socket socket = ss.accept();
                System.out.println("Client connected");
                System.out.println();

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                System.out.println("Type in something and press enter.");
                System.out.println();
                while (true) {
                    line = in.readUTF();
                    System.out.println("Client response:" + line);
                    out.flush();
                    line = keyboard.readLine();
                    System.out.println("Sending this line to the client...");
                    out.writeUTF(line);
                    out.flush();
                    System.out.println();
                }
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }
}
