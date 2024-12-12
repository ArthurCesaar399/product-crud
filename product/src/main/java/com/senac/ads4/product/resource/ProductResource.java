package com.senac.ads4.product.resource;

import com.senac.ads4.product.dto.ProductDto;
import com.senac.ads4.product.interfaces.IResource;
import com.senac.ads4.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "api/products")
@Tag(name = "Product API", description = "API para gerenciamento de product")
public class ProductResource implements IResource<ProductDto, Integer> {

    @Autowired
    public ProductService productService;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    @Operation(summary = "Criação de um novo product", description = "Endpoint para criação de product", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product criado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao criar o product")
    })
    public ProductDto create(@RequestBody ProductDto entity) {
        log.info("ProductResource::create");
        return productService.create(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    @Operation(summary = "Busca product pelo ID", description = "Busca um product específico baseado no ID informado", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Product não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar o Product")
    })
    public ProductDto get(@PathVariable Integer id) {
        log.info("ProductResource::get(id)");
        return productService.read(id);
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Override
    @Operation(summary = "Busca todos os products", description = "Busca todos os products cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products encontrados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar os products")
    })
    public List<ProductDto> get() {
        log.info("ProductResource::get()");
        return productService.read();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
     *
     * @param id
     * @param entity
     * @return
     */
    @PutMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    @Operation(summary = "Atualiza um product", description = "Atualiza um product com base no ID informado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Product não encontrado"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar o Product")
    })
    public ProductDto update(@PathVariable Integer id, @RequestBody ProductDto entity) {
        log.info("ProductResource::update(id,entity)");
        return productService.update(id, entity);
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @Override
    @Operation(summary = "Deleta um product", description = "Deleta um product com base no ID informado", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Product não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar o product")
    })
    public void delete(@PathVariable Integer id) {
        log.info("ProductResource::delete(id)");
        productService.delete(id);
    }
}
