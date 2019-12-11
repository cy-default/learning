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
public abstract class AbstractActivityInfoConvertor {

    /**
        * 类型转换
        * @Title: boToDO
        * @Description: 类型转换
        * @param @param centerInfoBO
        * @return ActivityInfoDO    返回类型
     */
    public abstract ActivityInfoDO boToDO(ActivityInfoBO centerInfoBO);
    
    /**
        * 类型转换
        * @Title: doToDTO
        * @Description: 类型转换
        * @param @param centerInfoDO
        * @return ActivityInfoDTO    返回类型
     */
    public abstract ActivityInfoDTO doToDTO(ActivityInfoDO centerInfoDO);


    public abstract List<ActivityInfoDTO> dosToDTOs(List<ActivityInfoDO> centerInfoDOs);

    @Mappings({
            @Mapping(source = "user.id", target = "id"),
            @Mapping(source = "user.firstName", target = "firstName"),
            @Mapping(source = "user.lastName", target = "lastName"),
            @Mapping(source = "address.city", target = "city"),
            @Mapping(source = "address.state", target = "state"),
            @Mapping(source = "address.id", target = "aid")
    })
    public abstract UserView userAndAddressToView(User user, Address address);


}
