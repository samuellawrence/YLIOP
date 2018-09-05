package com.arvato.jesy.lifematters.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.arvato.jesy.lifematters.entities.Personnel;
import com.arvato.jesy.lifematters.repositories.PersonnelRepository;
import com.arvato.jesy.lifematters.services.SheetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@Api(value = "/arvato", produces = "application/json")
public class PersonnelResource {

    @Autowired
    private PersonnelRepository personnelRepository;
    
    @Autowired
    private SheetService sheetService;
  
    @GetMapping("/arvato/employees")
    @ApiOperation(value = "List employees", response = Personnel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All employee details retrived", response = Personnel.class),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Employee not found") })
    public List<Personnel> get() {
        return personnelRepository.findAll();
    } 
    
    @GetMapping("/arvato/alarm")
    @ApiOperation(value = "Panic alarm")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Panic situation altered"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public ResponseEntity<Object> alarm() throws IOException {
    	sheetService.fillSheet();
		return ResponseEntity.ok("Panic situation altered");
    }
    
    @PostMapping("/arvato/register/employee")
    @ApiOperation(value = "Register employee")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Employee Details Created"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public ResponseEntity<Object> create(@RequestBody Personnel personnel) {
        Personnel savedPersonnel = personnelRepository.save(personnel);
        return ResponseEntity.ok(savedPersonnel);
    }
    
    
    @GetMapping("/arvato/employee/{id}")
    @ApiOperation(value = "Get employee", response = Personnel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Employee Details Retrived", response = Personnel.class),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Employee not found") })
    public Personnel get(@PathVariable long id) {
        Optional<Personnel> student = personnelRepository.findById(id);

        if (!student.isPresent())
            throw new RuntimeException("id=" + id);

        return student.get();
    }

    @DeleteMapping("/arvato/employee/{id}")
    @ApiOperation(value = "Delete employee")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Employee Details Deleted"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Employee not found") })
    public void delete(@PathVariable long id) {
        personnelRepository.deleteById(id);
    }

    @PutMapping("/arvato/employee/{id}")
    @ApiOperation(value = "Update employee")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Employee Details Updated"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public ResponseEntity<Object> update(@RequestBody Personnel personnel, @PathVariable long id) {
        Optional<Personnel> personnelOptional = personnelRepository.findById(id);

        if (!personnelOptional.isPresent())
            return ResponseEntity.notFound().build();

        personnel.setId(id);
        personnelRepository.save(personnel);
        return ResponseEntity.ok(personnel);
    }

}