package com.devsuperior.dsvendas.controllers;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SalesSuccessDTO;
import com.devsuperior.dsvendas.dto.SalesSumDTO;
import com.devsuperior.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
        Page<SaleDTO> listAll = service.findAll(pageable);
        return ResponseEntity.ok().body(listAll);
    }

    @GetMapping(value = "/sum-by-seller")
    public ResponseEntity<List<SalesSumDTO>>  amountGroupedBySeller(){
        List<SalesSumDTO> listAll = service.amountGroupedBySeller();
        return ResponseEntity.ok().body(listAll);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SalesSuccessDTO>>  successGroupedBySeller(){
        List<SalesSuccessDTO>  listSuccess = service.successGroupedBySeller();
        return ResponseEntity.ok().body(listSuccess);
    }
}
