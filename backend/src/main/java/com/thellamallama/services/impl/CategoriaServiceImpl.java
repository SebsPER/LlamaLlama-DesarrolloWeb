package com.thellamallama.services.impl;

import com.thellamallama.dtos.CategoriaDto;
import com.thellamallama.dtos.ClienteDto;
import com.thellamallama.dtos.CreateCategoriaDto;
import com.thellamallama.dtos.CreateClienteDto;
import com.thellamallama.entities.Categoria;
import com.thellamallama.entities.Cliente;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.CategoriaRepository;
import com.thellamallama.repositories.ClienteRepository;
import com.thellamallama.services.CategoriaService;
import com.thellamallama.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    private static final ModelMapper modelMapper= new ModelMapper();

    @Override
    public CategoriaDto getCategoriaById(Long categoriaid) throws BookingException {
        return modelMapper.map(getCategoriaById(categoriaid),CategoriaDto.class) ;
    }

    @Override
    public List<CategoriaDto> getCategorias() throws BookingException {
        List<Categoria> categoriaEntity=categoriaRepository.findAll();
        return categoriaEntity.stream().map(categoria -> modelMapper.map(categoria,CategoriaDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CategoriaDto createCategoria(CreateCategoriaDto createCategoriaDto) throws BookingException {
        Categoria categoria = new Categoria();
        categoria.setNombre(createCategoriaDto.getDescripcion());
        categoria.setDescripcion(createCategoriaDto.getDescripcion());
        try{
            categoria=categoriaRepository.save(categoria);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_sERVER_ERROR","INTERNAL_sERVER_ERROR");

        }
        return modelMapper.map(getCategoriasEntity(categoria.getId()),CategoriaDto.class);

    }
    private Categoria getCategoriasEntity(Long categoriaid) throws BookingException{
        return categoriaRepository.findById(categoriaid)
                .orElseThrow(()->new NotFoundException("Not_Found-404","Not-Found-404"));
    }
}
