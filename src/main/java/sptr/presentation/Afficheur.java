/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptr.presentation;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import sptr.domaine.simulation.Default;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import sptr.controleur.Simulateur;
import sptr.domaine.Environnement.Coordonnee;
import sptr.domaine.reseaux.*;
/**
 *
 * @author bhacaz
 */
public class Afficheur {
        
    private static final String VEHICULE_IMAGE_PATH = "/src"+Default.VEHICULE_PATH;
    private static final String FEU_JAUNE_PATH = "/src"+Default.FEU_JAUNE_PATH;
    private static final String FEU_ROUGE_PATH = "/src"+Default.FEU_ROUGE_PATH;
    private static final String FEU_VERT_PATH = "/src"+Default.FEU_VERT_PATH;
    private static final String ROUTE_PATH = "/src"+Default.ROUTE_PATH;
    
    private Image imageVehicule = null; 
    private Image imageFeuJaune = null;
    private Image imageFeuRouge = null;
    private Image imageFeuVert  = null;
    private Image imageDeFond = null;
    private static GestionnairReseau gestionnaireReseau;
    private static float m_zoom;
    private int maxWidth = 0;
    private int maxHeight = 0;
    private boolean toggleUrgence = true;
    private int stateVehicule = 0;
    
    
    public Afficheur(){
        
        try{
            
            imageVehicule = ImageIO.read(new File(VEHICULE_IMAGE_PATH));
            imageFeuJaune = ImageIO.read(new File(FEU_JAUNE_PATH));
            imageFeuRouge = ImageIO.read(new File(FEU_ROUGE_PATH));
            imageFeuVert  = ImageIO.read(new File(FEU_VERT_PATH));
            
            
        
	} catch (IOException e) {
            e.printStackTrace();
	}
    }
    
    public void afficherReseau(Graphics g, Simulateur simulateur,CarteGraphique carteGraphique){
        
        gestionnaireReseau = simulateur.getGestionaireReseaux();
        
        this.afficherCarte(g,  carteGraphique);
    }

   

    private void afficherCarte(Graphics g, CarteGraphique carteGraphique) { 
                this.imageDeFond = gestionnaireReseau.getImageDeFong();
		if (this.imageDeFond != null) {

			afficherAvecImageDeFond(g, carteGraphique);
		} else {
			afficherSansImageDeFond(g, carteGraphique);
		}

		carteGraphique.revalidate();

        
    }

    private void afficherAvecImageDeFond(Graphics g, CarteGraphique carte) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		BufferedImage img = (BufferedImage) imageDeFond;
		float scale;
		if (m_zoom >= 1) {
			scale = m_zoom;
		} else {
			scale = 1;
		}

		double imageWidth = scale * img.getWidth();
		double imageHeight = scale * img.getHeight();
		carte.setPreferredSize(new Dimension((int) Math.round(imageWidth),
				(int) Math.round(imageHeight)));
		double x = (carte.getWidth() - imageWidth) / 2;
		double y = (carte.getHeight() - imageHeight) / 2;
		AffineTransform at = AffineTransform.getTranslateInstance(x, y);
		at.scale(scale, scale);
		g2.drawRenderedImage(img, at);
	}


    	private void afficherSansImageDeFond(Graphics g, CarteGraphique carte) {
		int newWidth;
		int newHeight;

		if (maxWidth > Default.CARTE_WIDTH) {
			newWidth = maxWidth;
		} else {
			newWidth = Default.CARTE_WIDTH;
		}
		
		if (maxHeight > Default.CARTE_HEIGHT) 
		{


			newHeight = maxHeight;
		} else {
			newHeight = Default.CARTE_HEIGHT;
		}

		maxWidth = Default.CARTE_WIDTH;
		maxHeight = Default.CARTE_HEIGHT;

		carte.setPreferredSize(new Dimension(newWidth, newHeight));
	}
        
    
        private void afficherGrille(Graphics g, CarteGraphique carteGraphique) {
		Graphics2D g2d = (Graphics2D) g;
		int width = (int) carteGraphique.getWidth();
		int height = (int) carteGraphique.getHeight();
		int pixel_per_step = Math.round(gestionnaireReseau.reqPixelParStep());

		for (int i = pixel_per_step; i < width; i += pixel_per_step) {
			for (int j = pixel_per_step; j < height; j += pixel_per_step) {
				g2d.setStroke(new BasicStroke(m_zoom));
				g2d.draw(new Line2D.Double(i, j, i, j));
			}
		}
	}
        
        private void afficherVehicule(Graphics g, Coordonnee position,
			double direction) {
		if (position != null) {
			// position = m_gestionnaireReseau.reqPositionEnPixel(position);
			Graphics2D g2d = (Graphics2D) g;

			BufferedImage img =(BufferedImage) imageVehicule;
			
			
			
			double locationX = img.getWidth() / 2;
			double locationY = img.getHeight() / 2;
			AffineTransform tx = AffineTransform.getRotateInstance(direction,
					locationX, locationY);
			AffineTransformOp op = new AffineTransformOp(tx,
					AffineTransformOp.TYPE_BILINEAR);

		}
	}
    
}
