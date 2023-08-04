package service;

import model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.VendorRepository;
import service.impl.ImplVendorService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService implements ImplVendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public Vendor getVendorById(Long id) {
        Optional<Vendor> optional = vendorRepository.findById(id);
        Vendor vendor = null;
        if(optional.isPresent()){
            vendor = optional.get();
        }else{
            //exception
        }
        return vendor;
    }

    @Override
    public Vendor getVendorByName(String name) {
        List<Vendor> vendorList = vendorRepository.findAll();
        Vendor vendor = null;
        for(Vendor v : vendorList){
            if (v.getName().equalsIgnoreCase(name)){
                vendor = v;
                break;
            }
        }
        return vendor;
    }

    @Override
    public String validateVendorId(Long id) {
        String errorMessage = "";
        Vendor vendor = getVendorById(id);
        if (vendor == null){
            errorMessage = "Vendor ID does not exist";
        }
        return errorMessage;
    }

    @Override
    public String validateVendorName(String vendorName) {
        String errorMessage = "";
        Vendor vendor = getVendorByName(vendorName);
        if (vendor == null){
            errorMessage = "Vendor with name: " + vendorName + " does not exists.";
        }
        return errorMessage;
    }
}
