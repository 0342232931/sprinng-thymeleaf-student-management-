package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.SchoolRepository;
import vn.ths.BTCuoiKhoa.dao.StarterBookRepository;
import vn.ths.BTCuoiKhoa.entity.School;
import vn.ths.BTCuoiKhoa.entity.StarterBook;

import java.util.List;
import java.util.Optional;

@Service
public class StarterBookService implements MyService<StarterBook>{
    private StarterBookRepository starterBookRepository;

    @Autowired
    public StarterBookService(StarterBookRepository starterBookRepository) {
        this.starterBookRepository = starterBookRepository;
    }

    @Override
    public List<StarterBook> getAll() {
        return starterBookRepository.findAll();
    }

    @Override
    public StarterBook getById(int id) {
        Optional<StarterBook> optionalStarterBook = starterBookRepository.findById(id);
        return optionalStarterBook.orElse(null);
    }

    @Override
    @Transactional
    public StarterBook add(StarterBook starterBook) {
        return starterBookRepository.saveAndFlush(starterBook);
    }

    @Override
    @Transactional
    public StarterBook update(StarterBook starterBook) {
        Optional<StarterBook> optionalStarterBook = starterBookRepository.findById(starterBook.getId());
        if(optionalStarterBook.isPresent()){
            return starterBookRepository.saveAndFlush(starterBook);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        starterBookRepository.deleteById(id);
    }

    @Override
    public StarterBook findByName(String name) {
        return null;
    }
}
