package emmagatzemat;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Operations {
    private static Scanner in = new Scanner(System.in);


    public static void agregarAsignatura(List<Assignatura> asignaturas) {
        String nom;
        int numero = 0;
        int durada;
        int existe = 0;
        boolean continuar =false;
        String textDurada = "el numero de l'durada";
        String textAsignatura = "el numero de l'asignatura";

        System.out.println("Ingrese el nombre de la asignatura");
        nom = in.next();


        do {
           continuar = false;
            numero = Validaciones.onlyNumeric(textAsignatura);
            for (Assignatura a : asignaturas) {
                if (a.numero == numero) {
                    continuar=true;
                    System.out.println("Error ya existe en la lista");
                }
            }
        }while (continuar==true);
//en el while va la condicion para que se vuelva a repetir

     /*   do {
            existe =0;
            numero = Validaciones.onlyNumeric(textAsignatura);
        for (Assignatura a : asignaturas) {
            if (a.numero == numero) {
                existe++;
                System.out.println("Error ya existe en la lista");
            }
        }
    }while (existe!=0);*/

            durada = Validaciones.onlyNumeric(textDurada);

        Assignatura assignatura = new Assignatura(numero, nom, durada);
        asignaturas.add(assignatura);
    }


    public static Alumne agregarAlumno() {
        String strRepLowerCase;
        String nom;
        String dni;
        String strRepetidor;
        boolean repetir;
        boolean repetidor = true;
        System.out.println("Ingrese el nombre del alumno ");
        nom = in.nextLine();

        System.out.println("Ingrese el dni del alumno: " + nom);
        dni = in.nextLine();

        do {
            repetir = false;
            System.out.println("Ingrese si , si es repetidor o no en caso negativo ");
            strRepetidor = in.nextLine();


            switch (strRepetidor.toLowerCase()) {
                case "si":
                    repetidor = true;
                    break;
                case "no":
                    repetidor = false;
                    break;
                default:
                    repetir = true;
                    break;
            }


        } while (repetir);

        Alumne alumne = new Alumne(nom, dni, repetidor);

        return alumne;
    }


    public static void demanarId(List<Assignatura> asignaturas) {
        int numAsignatura;
        boolean existe = false;
        int indice = 0;
        String textAsignatura ="el numero de la asignatura";
        numAsignatura =Validaciones.onlyNumeric(textAsignatura);

        in.nextLine();
        for (Assignatura asignatura : asignaturas
        ) {
            if (asignatura.numero == numAsignatura) {
                existe = true;
                indice = asignaturas.indexOf(asignatura);
                asignaturas.get(indice).alumnes.add(agregarAlumno());
                break;
            }

        }
        if (existe == false) {
            System.out.println("Asignatura no encontrada");
        } else {
            System.out.println("Asignatura encontrada");
        }

    }

}
