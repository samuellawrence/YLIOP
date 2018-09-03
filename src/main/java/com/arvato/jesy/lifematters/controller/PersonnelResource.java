package com.arvato.jesy.lifematters.controller;

import java.util.List;
import java.util.Optional;

import com.arvato.jesy.lifematters.entities.Personnel;
import com.arvato.jesy.lifematters.repositories.PersonnelRepository;

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
@Api(value = "/", description = "Personnel Profile", produces = "application/json")
public class PersonnelResource {

    @Autowired
    private PersonnelRepository personnelRepository;

    @GetMapping("/personnel")
    @ApiOperation(value = "List personnel", response = Personnel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All personnel details retrived", response = Personnel.class),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Personnel not found") })
    public List<Personnel> get() {
        return personnelRepository.findAll();
    }

    @GetMapping("/personnel/{id}")
    @ApiOperation(value = "Get personnel", response = Personnel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Personnel Details Retrived", response = Personnel.class),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Personnel not found") })
    public Personnel get(@PathVariable long id) {
        Optional<Personnel> student = personnelRepository.findById(id);

        if (!student.isPresent())
            throw new RuntimeException("id=" + id);

        return student.get();
    }

    @DeleteMapping("/personnel/{id}")
    @ApiOperation(value = "Delete personnel")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Personnel Details Deleted"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Personnel not found") })
    public void delete(@PathVariable long id) {
        personnelRepository.deleteById(id);
    }

    @PostMapping("/personnel")
    @ApiOperation(value = "Create personnel")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Personnel Details Created"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    public ResponseEntity<Object> create(@RequestBody Personnel personnel) {
        Personnel savedPersonnel = personnelRepository.save(personnel);
        return ResponseEntity.ok(savedPersonnel);
    }

    @PutMapping("/personnel/{id}")
    @ApiOperation(value = "Update personnel")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Personnel Details Updated"),
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