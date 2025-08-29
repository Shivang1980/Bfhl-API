package com.shivang.bajajproject.controller;

import com.shivang.bajajproject.dto.DTOrequest;
import com.shivang.bajajproject.dto.DTOresponse;
import com.shivang.bajajproject.service.BfhlService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*")
public class BfhlController {

    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<DTOresponse> handleRequest(@Valid @RequestBody DTOrequest req) {
        return ResponseEntity.ok(bfhlService.process(req));
    }


}
