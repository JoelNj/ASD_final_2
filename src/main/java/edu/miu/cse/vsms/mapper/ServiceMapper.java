package edu.miu.cse.vsms.mapper;

import edu.miu.cse.vsms.dto.request.EmployeeRequestDto;
import edu.miu.cse.vsms.dto.request.ServiceRequestDto;
import edu.miu.cse.vsms.dto.response.EmployeeResponseDto;
import edu.miu.cse.vsms.dto.response.VehicleServiceResponseDto;
import edu.miu.cse.vsms.model.Employee;
import edu.miu.cse.vsms.model.VService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    @Mapping(source = "serviceRequestDto.employee",target="employee" )
    VService serviceRequestDto2VService(ServiceRequestDto serviceRequestDto);

    VehicleServiceResponseDto serviceRequestDto2VehicleServiceResponseDto(VService service);


}
