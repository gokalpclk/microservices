package com.torukobyte.inventoryservice.api.controllers;

import com.torukobyte.inventoryservice.business.abstracts.BrandService;
import com.torukobyte.inventoryservice.business.dto.requests.create.CreateBrandRequest;
import com.torukobyte.inventoryservice.business.dto.requests.update.UpdateBrandRequest;
import com.torukobyte.inventoryservice.business.dto.responses.create.CreateBrandResponse;
import com.torukobyte.inventoryservice.business.dto.responses.get.GetAllBrandsResponse;
import com.torukobyte.inventoryservice.business.dto.responses.get.GetBrandResponse;
import com.torukobyte.inventoryservice.business.dto.responses.update.UpdateBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandsController {
    private final BrandService service;

    @GetMapping
    public List<GetAllBrandsResponse> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CreateBrandResponse add(@RequestBody CreateBrandRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse update(@RequestBody UpdateBrandRequest request, @PathVariable String id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public GetBrandResponse getById(@PathVariable String id) {
        return service.getById(id);
    }
}
