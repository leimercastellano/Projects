package emmagatzemat;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Assignatura {
    int numero;
    String nom;
    int durada;
    List<Alumne> alumnes = new ArrayList<>();


    public Assignatura(int numero, String nom, int durada) {
        this.numero = numero;
        this.nom = nom;
        this.durada = durada;
    }

    public Assignatura() {
    }

    public void imprimir() {
        System.out.println("===== DADES DE LA ASIGNATURA ====");
        System.out.println("Numero: " + this.numero);
        System.out.println("Nom: " + this.nom);
        System.out.println("Durada: " + this.durada);
        System.out.println("Alumnes:");
        for (Alumne alumne : this.alumnes) {
            alumne.imprimir();
        }
        System.out.println("================================");
    }


    public void escribirXml(String ruta) {
        try {
            //aqui abajo le digo que voy a crear un documento, que sera en este caso el XML
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Document documentListA = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            //Aqui  Expone propiedades y métodos para manipular los elementos del documento y sus atributos.
         /*   Element nodeAsignatura = document.createElement("asignatura");
            document.appendChild(nodeAsignatura);*/


            Element nodeAsignatura = document.createElement("asignatura");
            document.appendChild(nodeAsignatura);

            //Aqui despues de crear el Elemento le indico que va a ser el tagName
            Element nodeNumero = document.createElement("numero");
            //Luego aqui abajo en el nodeNumero, le indico cual es el valor que tiene que cojer
            nodeNumero.setTextContent(String.valueOf(this.numero));
            //Aqui abajo le digo que a node aginatura, le añado un  hijo que seria nodeNumero
            nodeAsignatura.appendChild(nodeNumero);

            Element nodeNom = document.createElement("nom");
            nodeNom.setTextContent(this.nom);
            nodeAsignatura.appendChild(nodeNom);

            Element nodeDurada = document.createElement("durada");
            nodeDurada.setTextContent(String.valueOf(this.durada));
            nodeAsignatura.appendChild(nodeDurada);
            //Agregamos los Alumnos
            //creo un elemento con alumnes
            //Luego le digo en en nodeAsignatura agregare hijos del node Alumne;
            Element nodeAlumnes = document.createElement("alumnes");
            nodeAsignatura.appendChild(nodeAlumnes);
            //Aqui recorro mi arrayList de alumnes
            for (Alumne alumne : alumnes) {
                alumne.escribirXmlAlumnes(nodeAlumnes, document);
            }
            //Guardar en disco
            TransformerFactory.newInstance().newTransformer().
                    transform(new DOMSource(document), new StreamResult(new File(ruta)));

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();

        }
    }

    public void llegirXmlSeq(String ruta) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(ruta));
            NodeList listaAsignaturas = document.getElementsByTagName("asignatura");

            for (int i = 0; i < listaAsignaturas.getLength(); i++) {
                Node node = listaAsignaturas.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    NodeList hijos = e.getChildNodes();
                    System.out.println("asignatura");
                    for (int j = 0; j < hijos.getLength(); j++) {
                        Node hijo = hijos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            Element eHijo = (Element) hijo;
                            //leerAlumnos(ruta);
                            System.out.println("" + eHijo.getNodeName() + " : " + eHijo.getTextContent());
                        }
                    }
                    System.out.println("--------------");
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
/*        public void leerAlumnos(String ruta) throws ParserConfigurationException, IOException, SAXException {
// Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
// Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
// Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File(ruta));
            NodeList listaAlumnes = documento.getElementsByTagName("alumnes");
            // Recorro las etiquetas
            for (int i = 0; listaAlumnes.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listaCoches.item(i);

            }

            }*/







   public void llegir_sintactic(String ruta) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ruta);

        XPathExpression expr = XPathFactory.newInstance().newXPath().compile("/asignatura/numero");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        this.numero = Integer.parseInt(node.getTextContent());

        expr = XPathFactory.newInstance().newXPath().compile("/asignatura/nom");
        node = (Node) expr.evaluate(doc, XPathConstants.NODE);
        this.nom = node.getTextContent();

        XPathExpression expr2 = XPathFactory.newInstance().newXPath().compile("/asignatura/durada");
        Node node2 = (Node) expr.evaluate(doc, XPathConstants.NODE);
        this.durada = Integer.parseInt(node.getTextContent());


        expr = XPathFactory.newInstance().newXPath().compile("/asignatura/alumnes/alumne");
        NodeList llistaNodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < llistaNodes.getLength(); i++) {
            Alumne alumne = new Alumne();
            alumne.llegir(llistaNodes.item(i));
            alumnes.add(alumne);
        }


    }





}

/* public void llegirXmlSeq(List <Assignatura> assignaturas, String ruta) throws ParserConfigurationException, IOException, SAXException {

 *//*     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(ruta));
            NodeList listaAsignaturas = document.getElementsByTagName("asignatura");

            for (int i = 0; i < listaAsignaturas.getLength(); i++) {
                if (listaAsignaturas.item(i).getNodeName().equals("numero"))
                    this.numero = Integer.parseInt(listaAsignaturas.item(i).getTextContent());
                else if (listaAsignaturas.item(i).getNodeName().equals("nom"))
                    this.nom = listaAsignaturas.item(i).getTextContent();
                else if (listaAsignaturas.item(i).getNodeName().equals("durada")) {
                    this.durada = Integer.parseInt(listaAsignaturas.item(i).getTextContent());

                    NodeList llistaNodes = listaAsignaturas.item(i).getChildNodes();
                    for (int j = 0; j < llistaNodes.getLength(); j++) {
                        Alumne alumne = new Alumne();
                        alumne.llegir(llistaNodes.item(j));
                        alumnes.add(alumne);
                        }

                    }
                }
            }*/
