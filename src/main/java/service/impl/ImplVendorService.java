package service.impl;

import model.Vendor;

public interface ImplVendorService {
    Vendor getVendorById(Long id);
    Vendor getVendorByName(String name);
    String validateVendorId(Long id);
    String validateVendorName(String vendorName);

}
