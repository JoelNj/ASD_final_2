package edu.miu.cse.vsms.service.impl;

import edu.miu.cse.vsms.dto.request.EmployeeRequestDto;
import edu.miu.cse.vsms.dto.response.EmployeeResponseDto;
import edu.miu.cse.vsms.dto.response.VehicleServiceResponseDto;
import edu.miu.cse.vsms.exception.ResourceNotFoundException;
import edu.miu.cse.vsms.mapper.EmployeeMapper;
import edu.miu.cse.vsms.model.Employee;
import edu.miu.cse.vsms.repository.EmployeeRepository;
import edu.miu.cse.vsms.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Optional<EmployeeResponseDto> addEmployee(EmployeeRequestDto request) {
        Employee employeetoSave =  employeeMapper.employeeRequestDtoToEmployee(request);
        Employee employeeSaved = employeeRepository.save(employeetoSave);
        return Optional.of(employeeMapper.employeeToEmployeeResponseDto(employeeSaved));
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDto> employeeResponseDtos = employees.stream().
                map(employeeMapper::employeeToEmployeeResponseDto).toList();

        return employeeResponseDtos;
    }

    @Override
    public Optional<EmployeeResponseDto> getEmployeeById(Long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if(employee != null){
            EmployeeResponseDto employeeResponseDto = employeeMapper.employeeToEmployeeResponseDto(employee);
            return Optional.of(employeeResponseDto);
        }
        throw new ResourceNotFoundException("Employee with id " + id + " not found");

    }

    @Override
    public Optional<EmployeeResponseDto> partiallyUpdateEmployee(Long id, EmployeeRequestDto employeeRequestDto) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if(employee != null){
            employee.setEmail(employeeRequestDto.email());
            employee.setPhone(employeeRequestDto.phone());
            employee.setName(employeeRequestDto.name());
            employee.setHireDate(employeeRequestDto.hireDate());
            employeeRepository.save(employee);
            return Optional.of(employeeMapper.employeeToEmployeeResponseDto(employee));
        }
        throw new ResourceNotFoundException("Employee with id " + id + " not found");

    }
}
