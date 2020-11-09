package emmagatzemat;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        List<Assignatura> assignaturas = new ArrayList<>();
        int opcion = 0;
        boolean salir = false;
        String textOpcion = "una opcion";
        String ruta = "C:\\Users\\LeimerCastellano\\Desktop\\pruebas\\asignaturas.xml";
        Assignatura asig = new Assignatura();
        while (!salir) {

            System.out.println("0- Sortir\n" +
                    "1- Llegir d'un fitxer XML pel metode sequencial\n" +
                    "2- Llegir d'un fitxer XML pel metode sintactic\n" +
                    "3- Mostrar per pantalla totes les asignatures amb les seves dades (numero, nom, durada i llista d'alumnes\n" +
                    "4- Afegir una assignatura\n" +
                    "5- Afegir un Alumne a una asignatura\n" +
                    "6- Guardar a disc en XML amb les assignatures\n");
            opcion = Validaciones.onlyNumeric(textOpcion);

            switch (opcion) {

                case 0:
                    salir = true;
                    break;
                case 1:
                    asig.llegirXmlSeq(ruta);

                    break;
                case 2:
                    asig.llegir_sintactic(ruta);
                    break;
                case 3:
                    for (Assignatura asignatura : assignaturas) {
                        asignatura.imprimir();
                    }
                    break;
                case 4:
                    Operations.agregarAsignatura(assignaturas);
                    break;
                case 5:
                    Operations.demanarId(assignaturas);
                    break;
                case 6:

                    for (Assignatura asignatura : assignaturas
                    ) {
                        asignatura.escribirXml(ruta);
                    }
                    break;
            }

        }


    }


}
