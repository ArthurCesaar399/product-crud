package com.senac.ads4.product.service;

import com.senac.ads4.product.dto.ProductDto;
import com.senac.ads4.product.interfaces.IService;
import com.senac.ads4.product.mapper.ProductMapper;
import com.senac.ads4.product.model.ProductModel;
import com.senac.ads4.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProductService implements IService<ProductDto, Integer> {

    @Autowired
    public ProductMapper productMapper;

    @Autowired
    public ProductRepository productRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ProductDto create(ProductDto dto) {
        log.info("ProductService::create");

        ProductModel productModel = productMapper.toModel(dto);

        ProductModel productModelGravado = productRepository.save(productModel);

        return productMapper.toDto(productModelGravado);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto read(Integer id) {
        log.info("ProductService::read(id)");
        ProductModel productPesquisado = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id pesquisado não existe:{}"));

        return productMapper.toDto(productPesquisado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> read() {
        log.info("ProductService::read()");
        List<ProductModel> productModelList = productRepository.findAll();

        return productMapper.toDtoList(productModelList);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public ProductDto update(Integer id, ProductDto entity) {
        log.info("ProductService::update(id,entity");

        ProductModel productPesquisado = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id pesquisado não existe:{}"));

        //carPesquisado.setAno(entity.getAno());

        productPesquisado.setDescricao(entity.getDescricao());
        productPesquisado.setNome(entity.getNome());
        productPesquisado.setPreco(entity.getPreco());
        productPesquisado.setMarca(entity.getMarca());

        ProductModel productAtualizado = productRepository.save(productPesquisado);

        return productMapper.toDto(productAtualizado);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        log.info("ProductService::delete(id)");

        productRepository.deleteById(id);
    }
}
