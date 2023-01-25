package com.ag.grid.demo.controller;


import com.ag.grid.demo.model.CompanyResponse;
import com.ag.grid.demo.model.RequestWithFilterAndSort;
import com.ag.grid.demo.repository.CompanyRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class CompanyRestController {

    @Autowired
    CompanyRepositoryCustom companyRepositoryCustom;

    @PostMapping("/get-companies")
    public Page<CompanyResponse> register(@RequestParam("page") int page, @RequestParam("size") int size, @RequestBody RequestWithFilterAndSort requestWithFilterAndSort) {
        Pageable pageable= PageRequest.of(page,size);
        return companyRepositoryCustom.getCompanies(pageable,requestWithFilterAndSort);
    }
}
