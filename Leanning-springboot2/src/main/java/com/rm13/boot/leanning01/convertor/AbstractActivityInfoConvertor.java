package com.rm13.boot.leanning01.convertor;
import com.rm13.boot.leanning01.pojo.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ActivityInfo convertor
 *
 * @author eric
 * @create 2019-11-01 15:35
 * @info best wishes no bug
 **/
@Mapper(componentModel = "spring")
public interface AbstractActivityInfoConvertor {

    /**
        * 类型转换
        * @Title: boToDO
        * @Description: 类型转换
        * @param @param centerInfoBO
        * @return ActivityInfoDO    返回类型
     */
    ActivityInfoDO boToDO(ActivityInfoBO centerInfoBO);
    
    /**
        * 类型转换
        * @Title: doToDTO
        * @Description: 类型转换
        * @param @param centerInfoDO
        * @return ActivityInfoDTO    返回类型
     */
    ActivityInfoDTO doToDTO(ActivityInfoDO centerInfoDO);


    List<ActivityInfoDTO> dosToDTOs(List<ActivityInfoDO> centerInfoDOs);

    @Mappings({
            @Mapping(source = "user.id", target = "id"),
            @Mapping(source = "user.firstName", target = "firstName"),
            @Mapping(source = "user.lastName", target = "lastName"),
            @Mapping(source = "address.city", target = "city"),
            @Mapping(source = "address.state", target = "state"),
            @Mapping(source = "address.id", target = "aid")
    })
    UserView userAndAddressToView(User user, Address address);


    @Mappings({
            @Mapping(source = "roleinfoList", target = "roleInfoDTOList")
    })
    UserInfoDTO infoToDto(UserInfo userInfo);

}
