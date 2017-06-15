package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by awdesh on 6/14/17.
 */

public class Client
{
    private static final String SIZE = "SIZE";
    private static final String OK = "OK";
    private static final String GET = "GET";
    private static final String SET = "SET";
    private static final String ERROR = "ERROR";
    private static final String EXIT = "EXIT";


    public static void main(String[] args) {
        LRU cache = null;
        Scanner scanner = new Scanner(System.in);
        String cmdString = scanner.next();
        int myInt = scanner.nextInt();
        if (cmdString.equals(SIZE))
        {
            cache = new LRU(myInt);
            System.out.println(SIZE.concat(" ").concat(OK));
        }

        try {
            // Iterate until user enters break.
            while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String ip = br.readLine();

                String[] ips = ip.split(" ");

                // getting value from key.
                if (ip.contains(GET)) {
                    if (ips.length > 2)
                    {
                        System.out.println(ERROR);
                        continue;
                    }
                    String retItem = cache.get(ips[1]);
                    System.out.println(retItem);
                }

                // Setting key and value.
                else if (ip.contains(SET)) {
                    if (ips.length < 3)
                    {
                        System.out.println(ERROR);
                        continue;
                    }
                    cache.set(ips[1], ips[2]);
                    System.out.println(SET.concat(" ").concat(OK));
                }

                // Exits the program if user enters "EXIT".
                else if (ip.contains(EXIT)) {
                    break;
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
