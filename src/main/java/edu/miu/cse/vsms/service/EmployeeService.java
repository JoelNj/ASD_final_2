package edu.miu.cse.vsms.service;

import edu.miu.cse.vsms.dto.request.EmployeeRequestDto;
import edu.miu.cse.vsms.dto.response.EmployeeResponseDto;
import edu.miu.cse.vsms.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {
    Optional<EmployeeResponseDto> addEmployee(EmployeeRequestDto request);
    List<EmployeeResponseDto> getAllEmployees();
    Optional<EmployeeResponseDto>  getEmployeeById(Long id) throws ResourceNotFoundException;
    Optional<EmployeeResponseDto>  partiallyUpdateEmployee(Long id, EmployeeRequestDto employeeRequestDto) throws ResourceNotFoundException;;
}
