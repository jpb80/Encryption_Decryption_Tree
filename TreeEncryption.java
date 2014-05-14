/** Jordan Buttkevitz
 *  University of Pittsburgh
 *  Data Structures
 *  Project: Tree
 * */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.lang.StringBuilder;
import java.util.*;

public class TreeEncryption {
    private static Scanner infile, encodeFile, decodeFile;
    private String[] strArray;
    private HashMap<Character, String> encodeMap = new HashMap<Character, String>();
    private HashMap<String, Character> decodeMap = new HashMap<String, Character>();
    
    public TreeEncryption(String fileName) throws IOException {     
        infile = new Scanner(new File(fileName));
        BinaryNode<Character> firstNode = new BinaryNode<Character>();   
        buildTree(firstNode);
        infile.close();
        buildCodeMaps(firstNode,"");
    } 
    
    public String loadEncodeFile(String fileName) throws IOException {
        encodeFile = new Scanner(new File(fileName));
        String input = encodeFile.nextLine();
        encodeFile.close();
        return encode(input);
    }// end loadEncodeFile

    public String loadDecodeFile(String fileName) throws IOException {
        String input = "";
        StringBuilder strOutput = new StringBuilder();
        decodeFile = new Scanner(new File(fileName));
        while (decodeFile.hasNext()) {
            strOutput.append(decode(decodeFile.nextLine()));
        }
        decodeFile.close();
        return strOutput.toString();
    }//end loadDecodeFile

    public void buildTree(BinaryNode<Character> currNode) {
        String input = infile.nextLine();
        currNode.setData(input.charAt(1));
        if (input.charAt(0) == 'L') {
            currNode.setData(input.charAt(1));
            return;
        } else {
            currNode.left = new BinaryNode<Character>(input.charAt(1));
            buildTree(currNode.left);
            currNode.right = new BinaryNode<Character>(input.charAt(1));
            buildTree(currNode.right);
        }
    }//end buildTree

    public void buildCodeMaps(BinaryNode<Character> currNode, String code) {
      if (currNode == null) {
          return;
      }
      encodeMap.put(currNode.getData(), code);
      decodeMap.put(code, currNode.getData());
      buildCodeMaps(currNode.getLeftChild(), code + "0");
      buildCodeMaps(currNode.getRightChild(), code + "1");
    } //end buildCodemaps

    public String encode(String input) {
      StringBuilder code = new StringBuilder();
      for (int i = 0; i < input.length(); i++) {
        if (encodeMap.containsKey(input.charAt(i))) {
          code.append(encodeMap.get(input.charAt(i)));
          code.append("\n");
        } else {
          break;
        }
      }//end for
      return code.toString();
    }//end encode
        
    public String decode(String binaryInput) {
        StringBuilder code = new StringBuilder();
        if (decodeMap.containsKey(binaryInput)) { 
            code.append(decodeMap.get(binaryInput));  
        }
        return code.toString();
    }// end decode
 }//end of TreeEncryption
