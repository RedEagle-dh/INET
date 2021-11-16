import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ping {
    public static void main(String[] args) throws IOException {
        try {


            if (InetAddress.getByName(args[0]).isReachable(100)) {
                System.out.printf("Adresse %s mit der IP %s wurde erreicht!", InetAddress.getByName(args[0]).getHostName(),
                        InetAddress.getByName(args[0]).getHostAddress());
            } else {
                System.out.println(args[0] + " wurde nicht erreicht.");
            }
        } catch (UnknownHostException e) {
            System.out.println(args[0] + " wurde nicht erreicht.");
        }
    }
}