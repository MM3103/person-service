package liga.medical.medicalpersonservice.core.service;

import liga.medical.medicalpersonservice.core.model.Address;
import liga.medical.medicalpersonservice.core.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public Address getAddressById(long id) {
        return addressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Address not found for id: " + id));
    }

    public void addAddress(Address address) {
        addressRepository.save(address);
    }

}
