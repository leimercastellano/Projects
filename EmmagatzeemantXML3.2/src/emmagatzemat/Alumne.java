package emmagatzemat;

import org.w3c.dom.*;

public class Alumne {
    private String nom;
    private String dni;
    private boolean repetidor;

    public Alumne(String nom, String dni, boolean repetidor) {
        this.nom = nom;
        this.dni = dni;
        this.repetidor = repetidor;
    }

    public Alumne() {
    }

    public void imprimir() {
        System.out.println("Nom: "+this.nom);
        System.out.println("Dni: "+this.dni);
        System.out.println("Repetidor: "+ repetidor);
        System.out.println("---");
    }


    public void escribirXmlAlumnes(Node nodeAlumnes, Document document){
        Element nodeAlumne = document.createElement("alumne");
        nodeAlumne.setAttribute("nom", this.nom);
        nodeAlumne.setAttribute("dni", this.dni);
        nodeAlumne.setAttribute("repetidor", String.valueOf(this.repetidor));
        nodeAlumnes.appendChild(nodeAlumne);

    }
    public void llegir (Node nodeLlibre) {
        NamedNodeMap atributs = nodeLlibre.getAttributes();
        this.nom = atributs.getNamedItem("nom").getTextContent();
        this.dni = atributs.getNamedItem("numero").getTextContent();
        this.repetidor = Boolean.parseBoolean(atributs.getNamedItem("durada").getTextContent());
    }
}
