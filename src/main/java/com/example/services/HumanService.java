package com.example.services;

import com.example.models.Book;
import com.example.models.Human;
import com.example.repositories.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HumanService {

    private final HumanRepository humanRepository;

    @Autowired
    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }
    public Human getHumanByBook(Human human){
        if(human == null) return null;
        return humanRepository.findById(human.getId()).orElse(null);
    }
    public List<Human> getAllHuman(){
        return humanRepository.findAll();
    }
    @Transactional
    public void addNewHuman(Human human){
        humanRepository.save(human);
    }

    public Human getHumanById(int id){
        return humanRepository.findById(id).orElse(null);
    }
    @Transactional
    public void patchHuman(int id, Human human){
        human.setId(id);
        humanRepository.save(human);
    }
    @Transactional
    public void deleteHuman(int id){
        humanRepository.deleteById(id);
    }
}
