/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.controleur;

import java.io.IOException;
import java.util.ArrayList;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sptr.domaine.Environnement.*;
import sptr.domaine.reseaux.GestionnairReseau;
import sptr.presentation.CarteGraphique;
/**
 * 
 * @author Erco
 */
public class Simulateur {
    private Bris bris;
    private Conducteur conducteur;
    private ArrayList<Feu> listFeu = new ArrayList<>();
    private ArrayList<Route> listRoute = new ArrayList<>();
    private ArrayList<Trafic> listTrafic = new ArrayList<>();
    private Parametres parametres = new Parametres();
    private Temperature temperature = new Temperature();
    private String filePath;

  
    
    
    public Simulateur(){}
    
    public Simulateur(String filePath)
    {
        this.filePath = filePath;
        readXML();
    }
    
      public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Bris getBris() {
        return bris;
    }

    public void setBris(Bris bris) {
        this.bris = bris;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public Parametres getParametres() {
        return parametres;
    }

    public void setParametres(Parametres parametres) {
        this.parametres = parametres;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
    

    public ArrayList<Feu> getListFeu() {
        return listFeu;
    }

    public void setListFeu(ArrayList<Feu> listFeu) {
        this.listFeu = listFeu;
    }

    public ArrayList<Route> getListRoute() {
        return listRoute;
    }

    public void setListRoute(ArrayList<Route> listRoute) {
        this.listRoute = listRoute;
    }

    public ArrayList<Trafic> getListTrafic() {
        return listTrafic;
    }

    public void setListTrafic(ArrayList<Trafic> listTrafic) {
        this.listTrafic = listTrafic;
    }

    public Parametres getParametre() {
        return parametres;
    }

    public void setParametre(Parametres parametre) {
        this.parametres = parametre;
    }
 
    
    
    public void readXML()
    {
        try
        {
            DOMParser parser = new DOMParser();
            parser.parse(filePath);
            Document doc = parser.getDocument();

            NodeList root = doc.getChildNodes();
            Node sptr = getNode("SPTR", root);
            Node para = getNode("Parametres", sptr.getChildNodes());
            
            
            
            
            //Node Parametre
            NodeList nodes = para.getChildNodes();
//            String s = getNodeValue("Simulation", nodes);
            this.parametres.setSimulation(Integer.parseInt(getNodeValue("Simulation", nodes)));
            this.parametres.setCommunication(Integer.parseInt(getNodeValue("Communication", nodes)));
            this.parametres.setAutoReparation(Integer.parseInt(getNodeValue("AutoReparation", nodes)));
            this.parametres.setCollision(Integer.parseInt(getNodeValue("Collision", nodes)));
            this.parametres.setEchelle(Integer.parseInt(getNodeValue("Echelle", nodes)));
            this.parametres.setPositionDepartX(Integer.parseInt(getNodeValue("XDepart", nodes)));
            this.parametres.setPositionDepartY(Integer.parseInt(getNodeValue("YDepart", nodes)));
            this.parametres.setPositionArriveX(Integer.parseInt(getNodeValue("XArrivee", nodes)));
            this.parametres.setPositionArriveY(Integer.parseInt(getNodeValue("YArrivee", nodes)));
            this.parametres.setVitesse(Integer.parseInt(getNodeValue("Vitesse", nodes)));
            this.parametres.setAcceleration(Integer.parseInt(getNodeValue("Acceleration", nodes)));
            this.parametres.setConsommation(Integer.parseInt(getNodeValue("Consommation", nodes)));
            this.parametres.setFeuJaune(Integer.parseInt(getNodeValue("FeuJaune", nodes)));
            this.parametres.setTemperatureMin(Integer.parseInt(getNodeValue("TemperatureMin", nodes)));
            this.parametres.setTemperatureMax(Integer.parseInt(getNodeValue("TemperatureMax", nodes)));
            this.parametres.setStrategie(getNodeValue("Strategie", nodes));
            
            NodeList lnode = doc.getElementsByTagName("Route");
            for(int i = 0; i < lnode.getLength(); i++)
            {
                Node nr = lnode.item(i);
                NodeList lnr = nr.getChildNodes();
                int num = Integer.parseInt(getNodeAttr("numero", nr));
                Coordonnee cd = new Coordonnee(Integer.parseInt(getNodeValue("XDebut", lnr)), Integer.parseInt(getNodeValue("YDebut", lnr)));
                Coordonnee cf = new Coordonnee(Integer.parseInt(getNodeValue("XFin", lnr)), Integer.parseInt(getNodeValue("YFin", lnr)));
                int v = Integer.parseInt(getNodeValue("Vitesse", lnr));
                this.listRoute.add(new Route(num, cd, cf, v));
            }
            
            lnode = doc.getElementsByTagName("Feu");
            for(int i = 0; i < lnode.getLength(); i++)
            {
                Node nf = lnode.item(i);
                NodeList lnf = nf.getChildNodes();
                int num = Integer.parseInt(getNodeAttr("numero", nf));
                Coordonnee c = new Coordonnee(Integer.parseInt(getNodeValue("CoordonneeX", lnf)),Integer.parseInt(getNodeValue("CoordonneeY", lnf)));
                String p = getNodeValue("Position", lnf);
                int d = Integer.parseInt(getNodeValue("Duree", lnf));
                PositionGeographique pg = PositionGeographique.EST;
                switch(p)
                {
                    case "E":
                        pg = PositionGeographique.EST;
                        break;
                    case "N":
                        pg = PositionGeographique.NORD;
                        break;
                    case "O":
                        pg = PositionGeographique.OUEST;
                        break;
                    case "S":
                        pg = PositionGeographique.SUD;
                        break;
                }
                
                this.listFeu.add(new Feu(num, c, pg, d));            
            }
            
            lnode = doc.getElementsByTagName("Parcours");
            for(int i = 0; i < lnode.getLength(); i++)
            {
                Node np = lnode.item(i);
                NodeList lnp = np.getChildNodes();
                int num = Integer.parseInt(getNodeAttr("numero", np));
                Coordonnee cd = new Coordonnee(Integer.parseInt(getNodeValue("XDebut", lnp)), Integer.parseInt(getNodeValue("YDebut", lnp)));
                Coordonnee cf = new Coordonnee(Integer.parseInt(getNodeValue("XFin", lnp)), Integer.parseInt(getNodeValue("YFin", lnp)));
                int vit = Integer.parseInt(getNodeValue("Vitesse", lnp));
                int periode = Integer.parseInt(getNodeValue("Periode", lnp));
                int delai = Integer.parseInt(getNodeValue("Phase", lnp));
                
                this.listTrafic.add(new Trafic(num, cd, cf, vit, periode, delai));
            }
            
            NodeList childSPTR = sptr.getChildNodes();
            this.temperature.setTemperature(Integer.parseInt(getNodeValue("Temperature",childSPTR)));
            
            NodeList lbris = getNode("Bris", sptr.getChildNodes()).getChildNodes();
            this.bris = new Bris(Integer.parseInt(getNodeValue("Periode", lbris)), Integer.parseInt(getNodeValue("Phase", lbris)));

            NodeList lConducteur = getNode("Conducteur", sptr.getChildNodes()).getChildNodes();
            this.conducteur = new Conducteur(Integer.parseInt(getNodeValue("Periode", lConducteur)), Integer.parseInt(getNodeValue("Phase", lConducteur)));
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    protected Node getNode(String tagName, NodeList nodes) 
    {
    for ( int x = 0; x < nodes.getLength(); x++ ) {
        Node node = nodes.item(x);
        if (node.getNodeName().equalsIgnoreCase(tagName)) {
            return node;
        }
    }
 
    return null;
    }
 
    protected String getNodeValue( Node node ) 
    {
        NodeList childNodes = node.getChildNodes();
        for (int x = 0; x < childNodes.getLength(); x++ ) {
            Node data = childNodes.item(x);
            if ( data.getNodeType() == Node.TEXT_NODE )
                return data.getNodeValue();
        }
        return "";
    }
 
    protected String getNodeValue(String tagName, NodeList nodes ) 
    {
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++ ) {
                    Node data = childNodes.item(y);
                    if ( data.getNodeType() == Node.TEXT_NODE )
                        return data.getNodeValue();
                }
            }
        }
        return "";
    }
 
protected String getNodeAttr(String attrName, Node node ) {
    NamedNodeMap attrs = node.getAttributes();
    for (int y = 0; y < attrs.getLength(); y++ ) {
        Node attr = attrs.item(y);
        if (attr.getNodeName().equalsIgnoreCase(attrName)) {
            return attr.getNodeValue();
        }
    }
    return "";
}
 
protected String getNodeAttr(String tagName, String attrName, NodeList nodes ) {
    for ( int x = 0; x < nodes.getLength(); x++ ) {
        Node node = nodes.item(x);
        if (node.getNodeName().equalsIgnoreCase(tagName)) {
            NodeList childNodes = node.getChildNodes();
            for (int y = 0; y < childNodes.getLength(); y++ ) {
                Node data = childNodes.item(y);
                if ( data.getNodeType() == Node.ATTRIBUTE_NODE ) {
                    if ( data.getNodeName().equalsIgnoreCase(attrName) )
                        return data.getNodeValue();
                }
            }
        }
    }
 
    return "";
}

    @Override
    public String toString() {
        return "Simulateur{" + "bris=" + bris + ", conducteur=" + conducteur + ", listFeu=" + listFeu + ", listRoute=" + listRoute + ", listTrafic=" + listTrafic + ", parametres=" + parametres + ", temperature=" + temperature + ", filePath=" + filePath + '}';
    }

    public GestionnairReseau getGestionaireReseaux() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public CarteGraphique getGrille() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
}
