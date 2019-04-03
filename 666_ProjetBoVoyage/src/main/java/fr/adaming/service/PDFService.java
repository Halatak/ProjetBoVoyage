package fr.adaming.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import fr.adaming.model.Client;
import fr.adaming.model.Dossier;

@Service("pdfService")
@Transactional

public class PDFService implements IPDFService {

	private String pattern = "MM/dd/yyyy HH:mm:ss";

	// Create an instance of SimpleDateFormat used for formatting
	// the string representation of date according to the chosen pattern
	DateFormat df = new SimpleDateFormat(pattern);

	// Get the today date using Calendar object.
	Date today = Calendar.getInstance().getTime();
	// Using DateFormat format method we can create a string
	// representation of a date with the defined format.
	String todayAsString = df.format(today);

	// Méthode pour créer le PDF et le placer à l'emplacement ci-dessus
	// public int creerPDF(Produit prod) {
	public int creerPDF(Dossier dossier, Client client, int numero) {
		String chemin = "C:\\Users\\IN-BR-006\\PDFVoyage\\FicheVoyage" + Integer.toString(numero) + ".pdf";

		// Vérificateur de fonctionnement
		int verifPDF = 0;

		Document doc = new Document();
		try {
			// créer le pdf à l'endroit voulu sur le pc (chemin)
			PdfWriter.getInstance(doc, new FileOutputStream(chemin));

			// ouvrir le doc pour faire des modifs
			doc.open();

			// Ajout du contenu
			doc.addTitle("Fiche de commande");
			doc.add(new Paragraph(client.toString()));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(todayAsString));
			doc.add(new Paragraph("Bonjour,"));
			doc.add(new Paragraph("Voici votre dossier : "));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(dossier.toString()));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(dossier.getVoyage().toString()));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(dossier.getVoyage().getListeFormule().toString()));
			doc.add(new Paragraph(" "));

			doc.add(new Paragraph(
					"Nous vous remerçions d'avoir passé votre commande chez Surf'n Sail, en espérant vous revoir bientôt"));
			verifPDF++;

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException eio) {
			eio.printStackTrace();
		}

		// Fermeture du document
		doc.close();
		numero++;

		// 1 si tout va bien
		return verifPDF;
	}

}