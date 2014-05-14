/** Jordan Buttkevitz
 *  University of Pittsburgh
 *  Data Structures
 *  Project: Tree
 * */

import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class TreeEncryptionTester {
    public static void main(String[] args) throws IOException {
    Scanner lineInput = new Scanner(System.in);
    String inputCommands = "";
    System.out.print("Enter 1 for encryption and 2 for decryption or enter exit to quit: ");
    String[] commands;
    
    while (!inputCommands.equals("exit")) { 
        inputCommands = lineInput.nextLine();
        commands = inputCommands.split(" ");
        if (commands[0].equals("1")) {            
            System.out.print("Please enter the tree file: ");
            TreeEncryption newTree = new TreeEncryption(lineInput.nextLine());
            System.out.print("Please enter the encrypted file: ");
            String encodeFileName = lineInput.nextLine();
            System.out.print("Please enter the output file: " );
            PrintWriter outfile = new PrintWriter(lineInput.nextLine());
            outfile.println(newTree.loadEncodeFile(encodeFileName));
            outfile.close();
        }

        if (commands[0].equals("2")) {
            System.out.print("Please enter the tree file: ");
            TreeEncryption newTree2 = new TreeEncryption(lineInput.nextLine());
            System.out.print("Please enter the decrypted file: ");
            String decodeFileName = lineInput.nextLine();
            System.out.print("Please enter the output file: " );
            PrintWriter outfile2 = new PrintWriter(lineInput.nextLine());
            outfile2.println(newTree2.loadDecodeFile(decodeFileName));
            outfile2.close();
        }
        if (inputCommands.equals("exit")) {
            System.exit(0);
        }
        System.out.print("Enter 1 for encryption and 2 for decryption or enter exit to quit: ");
    }//end while
    }//EOM
}//end of tester
