package com.trading;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class ConfirmationController {

    private final ConfirmationRepository confirmationRepository;

    private static final String LONDON_STOCK_EXCHANGE_MIC_CODE = "XLON";

    @Autowired
    public ConfirmationController(ConfirmationRepository confirmationRepository) {
        this.confirmationRepository = confirmationRepository;
    }

    @ApiOperation(value = "getConfirmation", nickname = "getConfirmation")
    @RequestMapping(value = "confirmation/{id}", method = RequestMethod.GET)
    public Confirmation getConfirmation(
            @ApiParam(name = "id", required = true, value = "Confirmation id")
            @PathVariable String id
    ) {
        return confirmationRepository.queryById(id);
    }

    @ApiOperation(value = "addConfirmation", nickname = "addOperation")
    @RequestMapping(value = "confirmation", method = RequestMethod.POST)
    public ResponseEntity addConfirmation(
            @ApiParam(name = "confirmation", required = true)
            @RequestBody Confirmation confirmation) {

        confirmationRepository.save(confirmation);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @ApiOperation(value = "getConfirmationType", nickname = "getConfirmationType")
    @RequestMapping(value = "confirmation/type/{micCode}", method = RequestMethod.GET)
    public ConfirmationType getConfirmationType(
            @ApiParam(name = "micCode", value = "Exchange Mic Code", required = true, defaultValue = "XLON", example = "XNAS")
            @PathVariable String micCode
    ) {
        return LONDON_STOCK_EXCHANGE_MIC_CODE.equals(micCode)
                ? ConfirmationType.SWIFT
                : ConfirmationType.EMAIL;
    }
}
