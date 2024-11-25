package edu.miu.cse.vsms.service.impl;

import edu.miu.cse.vsms.dto.request.ServiceRequestDto;
import edu.miu.cse.vsms.dto.response.VehicleServiceResponseDto;
import edu.miu.cse.vsms.exception.ResourceNotFoundException;
import edu.miu.cse.vsms.mapper.ServiceMapper;
import edu.miu.cse.vsms.model.Employee;
import edu.miu.cse.vsms.model.VService;
import edu.miu.cse.vsms.repository.EmployeeRepository;
import edu.miu.cse.vsms.repository.VehicleServiceRepository;
import edu.miu.cse.vsms.service.VehicleService;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleServiceRepository vehicleServiceRepository;
    private final EmployeeRepository employeeRepository;
    private final ServiceMapper serviceMapper;

    @Override
    public Optional<VehicleServiceResponseDto>  assignService(ServiceRequestDto request) throws ResourceNotFoundException {
        // Write your code here
        Employee employee = employeeRepository.findById(request.employee().getId()).orElseThrow(() -> new ResourceNotFoundException("Employee"));
        VService vservice = new VService(
                request.serviceName(),request.cost(),request.vehicleType(),employee
        );
        return Optional.of(serviceMapper.serviceRequestDto2VehicleServiceResponseDto(vehicleServiceRepository.save(vservice))) ;

    }
}
