import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lookup {

    public static void main(String[] args) throws IOException {

        boolean isIP;
        boolean isName;

        char[] c = args[0].toCharArray();
        int zaehler = 0;
        for (int k = 0; k < 4; k++){
            if (Character.isDigit(c[k])) {
                zaehler++;
            }
        }

        if (zaehler == 3 || zaehler == 4) {
            isIP = true;
            isName = false;
        } else {
            isName = true;
            isIP = false;
        }

        InetAddress address = InetAddress.getByName(args[0]);
        InetAddress nums = InetAddress.getByName(args[0]);
        if (!address.isReachable(100)) {
            System.out.println("Error: Website isn't reachable. \n");
        } else if ((nums.isReachable(100) && isIP)){
            System.out.printf("Looking up %s -> %s \n", args[0], nums.getCanonicalHostName());
        } else if(address.isReachable(100) && isName) {
            System.out.printf("Looking up %s -> %s \n", args[0], address.getHostAddress());
        }


        try {
            if (isName) {
                InetAddress[] array = InetAddress.getAllByName(args[0]);
                if (array.length > 1) {
                    for(InetAddress host : array) {
                        System.out.println(host);
                    }
                }
            }


        } catch(UnknownHostException e) {
            System.out.println(e);
        }

    }
}