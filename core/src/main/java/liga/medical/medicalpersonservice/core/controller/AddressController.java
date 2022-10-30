package liga.medical.medicalpersonservice.core.controller;

import io.swagger.v3.oas.annotations.Operation;
import liga.medical.medicalpersonservice.core.model.Address;
import liga.medical.medicalpersonservice.core.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAllAddress")
    @Operation(summary = "Get all address")
    public List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    @GetMapping("/getAddressById/{id}")
    @Operation(summary = "Get city by id")
    public ResponseEntity<Address> getAddressById(@PathVariable(value = "id") Long id) throws EntityNotFoundException {
        return ResponseEntity.ok().body(addressService.getAddressById(id));
    }

    @PostMapping("/add")
    @Operation(summary = "Add new address")
    public void addAddress(@RequestBody Address newAddress) {
        addressService.addAddress(newAddress);
    }
}
