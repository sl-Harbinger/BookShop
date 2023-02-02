package ru.testproj.book.backend.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.testproj.book.backend.api.constant.UrlConstants;
import ru.testproj.book.backend.api.dto.ExampleDto;
import ru.testproj.book.backend.api.resource.BookResource;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(UrlConstants.MAIN_URL)
public class BookResourceImpl implements BookResource {

    private List<ExampleDto> proverka = new ArrayList<>();
    @Override
    @GetMapping("/{uuid}")
    public ResponseEntity<ExampleDto> getExampleByID(@PathVariable UUID uuid) {
        for (ExampleDto name:proverka) {
           if (name.getId().equals(uuid)){
               return ResponseEntity.ok(name);
           }

        }
        return null;
    }



    @Override
    @PostMapping("/create")
    public ExampleDto createExample(@RequestBody @Valid ExampleDto accountDTO) {
        proverka.add(accountDTO);


        return accountDTO;
    }
}
