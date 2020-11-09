package emmagatzemat;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validaciones {
    static Scanner in = new Scanner(System.in);

    public static int onlyNumeric(String str) {
        int num = 0;
        boolean salir = true;
        while (salir)
            try {
                System.out.println("Ingrese "+ str);
                num = in.nextInt();
                salir = false;
            } catch (InputMismatchException exception) {
                System.out.println("Integers only, please.");
                in.nextLine();
            }
        return num;
    }













}