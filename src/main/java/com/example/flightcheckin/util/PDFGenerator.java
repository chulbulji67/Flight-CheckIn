package com.example.flightcheckin.util;

import com.example.flightcheckin.dto.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


@Component
public class PDFGenerator {

    public void generateItinerary(Reservation reservation, String filePath){
        Document document = new Document();

        try{
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();
            
            document.add(generateTable(reservation));

            document.close();
        }catch (FileNotFoundException | DocumentException e){
            e.printStackTrace();
        }

    }

    private PdfPTable generateTable(Reservation reservation) {
        PdfPTable pdfPTable = new PdfPTable(2);

        PdfPCell cell;

        cell = new PdfPCell(new Phrase("flight Itinerary"));
        cell.setColspan(2);
        pdfPTable.addCell(cell);



        cell = new PdfPCell(new Phrase("Flight Details"));
        cell.setColspan(2);
        pdfPTable.addCell(cell);

        pdfPTable.addCell("AirLInes: ");
        pdfPTable.addCell(reservation.getFlight().getOperatingAirlines());

        pdfPTable.addCell("Departure City");
        pdfPTable.addCell(reservation.getFlight().getDepartureCity());

        pdfPTable.addCell("Arrival City");
        pdfPTable.addCell(reservation.getFlight().getArrivalCity());

        pdfPTable.addCell("Flight Number");
        pdfPTable.addCell(reservation.getFlight().getFlightNumber());

        pdfPTable.addCell("Departure Date");
        pdfPTable.addCell(reservation.getFlight().getDateOfDeparture().toString());

        pdfPTable.addCell("Departure Time");
        pdfPTable.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

        cell = new PdfPCell(new Phrase("Passenger Details"));
        cell.setColspan(2);
        pdfPTable.addCell(cell);

        pdfPTable.addCell("First Name");
        pdfPTable.addCell(reservation.getPassenger().getFirstName());

        pdfPTable.addCell("Last Name: ");
        pdfPTable.addCell(reservation.getPassenger().getLastName());

        pdfPTable.addCell("Email: ");
        pdfPTable.addCell(reservation.getPassenger().getEmail());

        pdfPTable.addCell("Phone");
        pdfPTable.addCell(reservation.getPassenger().getPhone());

        return pdfPTable;

    }
}
