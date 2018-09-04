package com.arvato.jesy.lifematters.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.arvato.jesy.lifematters.entities.Personnel;
import com.arvato.jesy.lifematters.repositories.PersonnelRepository;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SheetService{
    
    @Autowired
    private PersonnelRepository personnelRepository;

    @Autowired
    private Sheets sheetsService;

    public static final String SHEET_ID = "1Bz4YXMvGjPUAVMZ_TscXrJsOkusByoWA5EdcnQADwEw"; 

    public void fillSheet() throws IOException {
        List<Personnel> personnels = personnelRepository.findAll();


//        Spreadsheet spreadSheet = new Spreadsheet().setProperties(new SpreadsheetProperties().setTitle("My Spreadsheet"));
  //      Spreadsheet result = sheetsService.spreadsheets().create(spreadSheet).execute();

        ValueRange body = new ValueRange()
        .setValues(Arrays.asList(
        Arrays.asList("Expenses January"), 
        Arrays.asList("books", "30"), 
        Arrays.asList("pens", "10"),
        Arrays.asList("Expenses February"), 
        Arrays.asList("clothes", "20"),
        Arrays.asList("shoes", "5")));
        UpdateValuesResponse result = sheetsService.spreadsheets().values()
        .update(SHEET_ID, "A1", body)
        .setValueInputOption("RAW")
        .execute();
       // assertThat(result.getSpreadsheetId()).isNotNull();
    }
}