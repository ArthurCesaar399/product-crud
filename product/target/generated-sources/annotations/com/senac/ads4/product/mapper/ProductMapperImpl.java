package com.senac.ads4.product.mapper;

import com.senac.ads4.product.dto.ProductDto;
import com.senac.ads4.product.model.ProductModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T10:51:52-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto toDto(ProductModel entity) {
        if ( entity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( entity.getId() );
        productDto.setNome( entity.getNome() );
        productDto.setDescricao( entity.getDescricao() );
        productDto.setPreco( entity.getPreco() );
        productDto.setMarca( entity.getMarca() );

        return productDto;
    }

    @Override
    public ProductModel toModel(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductModel productModel = new ProductModel();

        productModel.setId( dto.getId() );
        productModel.setNome( dto.getNome() );
        productModel.setDescricao( dto.getDescricao() );
        productModel.setPreco( dto.getPreco() );
        productModel.setMarca( dto.getMarca() );

        return productModel;
    }

    @Override
    public List<ProductDto> toDtoList(List<ProductModel> entity) {
        if ( entity == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( entity.size() );
        for ( ProductModel productModel : entity ) {
            list.add( toDto( productModel ) );
        }

        return list;
    }

    @Override
    public List<ProductModel> toModelList(List<ProductDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<ProductModel> list = new ArrayList<ProductModel>( dto.size() );
        for ( ProductDto productDto : dto ) {
            list.add( toModel( productDto ) );
        }

        return list;
    }
}
