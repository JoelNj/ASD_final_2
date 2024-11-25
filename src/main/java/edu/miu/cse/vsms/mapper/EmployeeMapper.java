package edu.miu.cse.vsms.mapper;

import edu.miu.cse.vsms.dto.request.EmployeeRequestDto;
import edu.miu.cse.vsms.dto.response.EmployeeResponseDto;
import edu.miu.cse.vsms.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {


    Employee employeeRequestDtoToEmployee(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto employeeToEmployeeResponseDto(Employee employee);

}
