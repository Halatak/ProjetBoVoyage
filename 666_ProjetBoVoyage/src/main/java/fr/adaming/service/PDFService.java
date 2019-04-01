package fr.adaming.service;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

//import fr.adaming.model.Produit;

//@Service("pdfService")
//@Transactional
//
//public class PDFService implements IPDFService {
//
//	public static final String chemin = "C:\\Users\\FicheProduit.pdf";
//
//	// M�thode pour cr�er le PDF et le placer � l'emplacement ci-dessus
//	public int creerPDF(Reservation res) {
//
//		// V�rificateur de fonctionnement
//		int verifPDF = 0;
//		
//		Reservation resTab = res;
//		Document doc = new Document();
//
//		try {
//			// cr�er le pdf � l'endroit voulu sur le pc (chemin)
//			PdfWriter.getInstance(doc, new FileOutputStream(chemin));
//			
//			//ouvrir le doc pour faire des modifs
//			doc.open();
//
//			// Ajout du contenu
//			doc.addTitle("R�sum� de votre r�servation");
//			doc.add(new Paragraph("Bonjour, ci-dessous un tableau r�sumant votre r�servation sur notre site."));
//			doc.add(new Paragraph(" "));
//			doc.add(new Paragraph(" "));
//
//			// ajout du tableau (m�thode en dessous)
//			doc.add(addTableau(resTab));
//
//			verifPDF++;
//
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		} catch (IOException eio) {
//			eio.printStackTrace();
//		}
//
//		// Fermeture du document
//		doc.close();
//
//		// 1 si tout va bien
//		return verifPDF;
//	}
//
//	// M�thode pour cr�er un tableau dans le pdf
//	public static PdfPTable addTableau(Reservation res) {
//
//		// cr�er un tableau (deux colonnes)
//		PdfPTable tableau = new PdfPTable(2);
//
//		// cr�er un objet cellule
//		PdfPCell cellule;
//
//		// Fusion des cellules de la premiere ligne
//		cellule = new PdfPCell(new Phrase("R�sum� de la r�servation"));
//		cellule.setColspan(2);
//		tableau.addCell(cellule);
//
//		// Remplissage du tableau
//		// Tableau de deux colonnes, donc on rempli la colonne de gauche, puis
//		// celle de droite.
//		tableau.addCell("D�signation");
//		tableau.addCell(prod.getDesignation());
//		
//		tableau.addCell("Description");
//		tableau.addCell(prod.getDescription());
//		
//		Produit produit = prod;
////		produit.setImg("data:image/png;base64,"+Base64.encodeBase64String(prod.getPhoto()));
//		tableau.addCell("Image");
//		tableau.addCell(produit.getImg());
//		
//		tableau.addCell("Quantit�");
//		tableau.addCell(Integer.toString(prod.getQuantite()));
//
//		//Transformer double en String
//		double prix = prod.getPrix();
//		String prix1 = String.valueOf(prix);
//		tableau.addCell("Prix");
//		tableau.addCell(prix1);
//
//		tableau.addCell("Num�ro Cat�gorie");
//		tableau.addCell(Integer.toString(prod.getCat().getIdCategorie()));
//		
//		return tableau;
//	}
//
//}
