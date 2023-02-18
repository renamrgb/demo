package com.renamrgb.demo.api;

import com.renamrgb.demo.application.OsRepository;
import com.renamrgb.demo.domain.Os;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/os")
public class OsController {

    @Autowired
    private OsRepository repository;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Os os) {
        return ResponseEntity.ok(repository.save(os));
    }

}
