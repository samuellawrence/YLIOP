package com.arvato.jesy.lifematters.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.arvato.jesy.lifematters.entities.Personnel;
import com.arvato.jesy.lifematters.repositories.PersonnelRepository;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

@Service
public class SheetService {

	@Autowired
	private PersonnelRepository personnelRepository;

	@Autowired
	private Sheets sheetsService;

	public static final String SHEET_ID = "1Bz4YXMvGjPUAVMZ_TscXrJsOkusByoWA5EdcnQADwEw";

	public void fillSheet() throws IOException {
		List<Personnel> personnels = personnelRepository.findAll(new Sort(Sort.Direction.ASC, "rfLog.status"));
		int i = 1;
		
		List<List<Object>> list = new ArrayList<>();
		list.add(Arrays.asList("#","Name", "Emg Contact", "Emg Contact No.", "Contact No", "Status", "Last Modified"));
		for (Personnel personnel : personnels) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
			
			String lastDateModified = format.format(personnel.getRfLog().getLastModified());
			list.add(Arrays.asList(i++, personnel.getName(), personnel.getEmergencyContact(),
					personnel.getEmergencyContactNumber(), personnel.getPhoneNumber(),
					//lastDateModified, 
					personnel.getRfLog().getStatus(), lastDateModified)); 
		}
		ValueRange body = new ValueRange().setValues(list);
		UpdateValuesResponse result = sheetsService.spreadsheets().values().update(SHEET_ID, "A1", body)
				.setValueInputOption("RAW").execute();
	}
}