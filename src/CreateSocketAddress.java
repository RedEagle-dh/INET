import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class CreateSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress socketAddress;

        socketAddress = new InetSocketAddress(80);
        output(socketAddress);

        try{
            InetAddress address = InetAddress.getByName("www.google.de");
            socketAddress = new InetSocketAddress(address, 80);
            output(socketAddress);
        } catch (UnknownHostException e){
            System.out.println(e);
        }

        socketAddress = new InetSocketAddress("www.google.de", 80);
        output(socketAddress);

        socketAddress = new InetSocketAddress("localhost", 80);
        output(socketAddress);
    }

    private static void output(InetSocketAddress socketAddress) {
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getPort());
        System.out.println();
    }
}