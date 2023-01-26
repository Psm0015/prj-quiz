package org.senai.prjquiz.controller;

import java.util.Optional;

import org.senai.prjquiz.entity.Quiz;
import org.senai.prjquiz.entity.placar;
import org.senai.prjquiz.repository.PlacarRepository;
import org.senai.prjquiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    QuizRepository qRepository;

    @Autowired
    PlacarRepository pRepository;

    @PostMapping("/")
    public @ResponseBody Integer addQuiz(@RequestBody Quiz objQuiz) {
        qRepository.save(objQuiz);
        return objQuiz.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Quiz> buscarQuiz() {
        return qRepository.findAll();
    }

    @PutMapping("/")
    public @ResponseBody Quiz atualizarQuiz(@RequestBody Quiz objQuiz) {
        qRepository.save(objQuiz);
        return objQuiz;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagarQuiz(@PathVariable Integer id) {
        qRepository.deleteById(id);
        return "Ok ao apagar";
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Quiz> localizarQuiz(@PathVariable Integer id) {
        return qRepository.findById(id);
    }

    @GetMapping("/placar")
    public @ResponseBody Iterable<placar> buscarplacar(){
        return pRepository.findAll();
    }
    @PostMapping("/placar")
    public @ResponseBody String addplacar(@RequestBody placar novo){
        pRepository.save(novo);
        return "adicionado com sucesso!";
    }

}
