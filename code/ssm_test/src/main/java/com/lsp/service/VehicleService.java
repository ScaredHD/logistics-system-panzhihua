package com.lsp.service;

import com.lsp.domain.Vehicle;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface VehicleService {
    public boolean AddVehicleInfo(Vehicle vehicle);
}
