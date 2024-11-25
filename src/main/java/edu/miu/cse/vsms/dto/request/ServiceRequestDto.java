package edu.miu.cse.vsms.dto.request;

import edu.miu.cse.vsms.model.Employee;

public record ServiceRequestDto(
        Long id,
        String serviceName,
        double cost,
        String vehicleType,
        Employee employee
) {
}

