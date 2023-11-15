
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 22;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Encrypts the content of a file and writes the result to another file.
     *`
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
        //TODO: Call the read method, encrypt the file contents, and then write to new file
    	String content = readFile(inputFilePath);
    		  StringBuilder encryptedFile = new StringBuilder();
    			
    			for( char cha: content.toCharArray()) {
    				if(Character.isLetter(cha)) {
    					char base = Character.isLowerCase(cha) ? 'a':'A';
    					cha = (char) (((cha - base + shift) % 26) + base);
    				}
    		    	encryptedFile.append(cha);
    			}
    		writeFile(this.encrypted ,encryptedFilePath);
    }

    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
        //TODO: Call the read method, decrypt the file contents, and then write to new file
    	
    	 String content = readFile(messageFilePath);
		  StringBuilder encryptedFile = new StringBuilder();
			
			for( char cha: content.toCharArray()) {
				if(Character.isLetter(cha)) {
					char base = Character.isLowerCase(cha) ? 'a':'A';
					cha = (char) (((cha - base + shift) % 26) + base);
				}
		    	encryptedFile.append(cha);
			}
			this.encrypted = encryptedFile.toString();
		writeFile(this.encrypted ,decryptedFilePath);
			
    }

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
        String message = "";
        //TODO: Read file from filePath
        byte[] output = Files.readAllBytes(Paths.get(filePath));
   
     return new String(output);
    }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     * @throws IOException 
     */
    private static void writeFile(String data, String filePath) throws IOException {
        //TODO: Write to filePath
    	Files.write(Paths.get(filePath),data.getBytes());
    	}

    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}
