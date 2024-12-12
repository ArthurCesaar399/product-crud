package com.senac.ads4.product.mapper;

import com.senac.ads4.product.dto.ProductDto;
import com.senac.ads4.product.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    //Converte entidade para DTO
    ProductDto toDto(ProductModel entity);

    //Converte DTO para entidade
    ProductModel toModel(ProductDto dto);

    //Converter a lista de entidades para lista de DTos
    List<ProductDto> toDtoList(List<ProductModel> entity);

    //Converter lista de DTOs para lista de entidades
    List<ProductModel> toModelList(List<ProductDto> dto);
}
