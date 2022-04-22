package gay.charon;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        if(args.length > 2) {
            System.out.println("[x] Usage: java -jar proxyscraper.jar <type(socks4/socks5/http)> <timeout>");
        } else {
            String type = args[0];
            int timeout = parseInt(args[1]);
            if (type.equalsIgnoreCase("socks4")) {
                String URL = "https://api.proxyscrape.com/v2/?request=displayproxies&protocol=socks4&timeout=" + timeout + "&country=all&ssl=all&anonymity=all";
                BufferedInputStream in = new BufferedInputStream(new URL(URL).openStream());
                FileOutputStream fos = new FileOutputStream("proxies.txt");
                byte dataBuffer[] = new byte[2048];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 2048)) != -1){
                    fos.write(dataBuffer, 0, bytesRead);
                }
                System.out.println("[!] Successfully downloaded SOCKS4 list!");
            } else if (type.equalsIgnoreCase("socks5")) {
                String URL = "https://api.proxyscrape.com/v2/?request=displayproxies&protocol=socks5&timeout=" + timeout + "&country=all&ssl=all&anonymity=all";
                BufferedInputStream in = new BufferedInputStream(new URL(URL).openStream());
                FileOutputStream fos = new FileOutputStream("proxies.txt");
                byte dataBuffer[] = new byte[2048];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 2048)) != -1){
                    fos.write(dataBuffer, 0, bytesRead);
                }
                System.out.println("[!] Successfully downloaded SOCKS5 list!");
            } else if (type.equalsIgnoreCase("http")){
                String URL = "https://api.proxyscrape.com/v2/?request=displayproxies&protocol=http&timeout=" + timeout + "&country=all&ssl=all&anonymity=all";
                BufferedInputStream in = new BufferedInputStream(new URL(URL).openStream());
                FileOutputStream fos = new FileOutputStream("proxies.txt");
                byte dataBuffer[] = new byte[2048];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 2048)) != -1){
                    fos.write(dataBuffer, 0, bytesRead);
                }
                System.out.println("[!] Successfully downloaded HTTP list!");
            }
        }
    }
}
