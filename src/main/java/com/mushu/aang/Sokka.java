package com.mushu.aang;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/notes")
public class Sokka {
    List<Note> notes = new ArrayList<Note>();

    public Sokka() {
        notes.add(new Note(1, "test", "First", "me"));
        notes.add(new Note(2, "test", "Second", "me"));
        notes.add(new Note(3, "test", "Third", "me"));
    }

    @GetMapping
    public List<Note> getNotes(){
        return notes;
    }

    @GetMapping(value="/{id}")
    public Note getNotes(@PathVariable("id") long id){
        return notes.stream()
                .filter(note -> note.getId() == id).findFirst()
                .orElse(null);
    }

    @GetMapping(params ="q")
    public List<Note> getNotes(@RequestParam(value="q") String matchstring){
        return notes.stream()
                .filter(note -> note.getNote().toLowerCase().contains((matchstring.toLowerCase()))
                             || note.getTitle().toLowerCase().contains(matchstring.toLowerCase()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Note note){
        //add validation
        notes.add(note);
        return new ResponseEntity(note, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity addOrUpdate(@RequestBody Note n){
        ResponseEntity resp;

        if(notes.contains(n)){
            int index = notes.indexOf(n);
            notes.set(index, n);
            resp = new ResponseEntity(n, HttpStatus.OK);
        } else {
            notes.add(n);
            resp = new ResponseEntity(n, HttpStatus.CREATED);
        }
        return resp;
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity delete(@PathVariable("id")long id){
        boolean found = false;
        Note note = getNotes(id);
        if(notes.contains(note)){
            notes.remove(note);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
