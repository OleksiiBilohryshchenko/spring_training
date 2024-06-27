package com.example.service.impl;

import com.example.dto.GenreDTO;
import com.example.entity.Genre;
import com.example.repository.GenreRepository;
import com.example.service.GenreService;
import com.example.util.MapperUtil;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final MapperUtil mapperUtil;

    public GenreServiceImpl(GenreRepository genreRepository, MapperUtil mapperUtil) {
        this.genreRepository = genreRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public GenreDTO save(GenreDTO genreDTO) {
        return mapperUtil.convert(genreRepository.save(mapperUtil.convert(genreDTO, new Genre())), new GenreDTO());
    }

    @Override
    public void deleteById(Long id) {
        Genre genre = genreRepository.findById(id).get();
        genre.setDeleted(true);
        genreRepository.save(genre);
    }

}
