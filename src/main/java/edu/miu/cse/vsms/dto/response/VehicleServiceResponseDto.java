package edu.miu.cse.vsms.dto.response;

import edu.miu.cse.vsms.model.Employee;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record VehicleServiceResponseDto(
        Long id,
        String serviceName,
        double cost,
        String vehicleType,
        Employee employee
        )
{

}




