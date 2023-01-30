package ru.testproj.book.backend.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.testproj.book.backend.api.constant.UrlConstants;
import ru.testproj.book.backend.api.dto.ExampleDto;
import ru.testproj.book.backend.api.resource.ExampleResource;


import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(UrlConstants.MAIN_URL)
public class ExampleResourceImpl implements ExampleResource {

    @Override
    @GetMapping("/{uuid}")
    public ExampleDto getExampleByID(@PathVariable UUID uuid) {
        return null;
    }

    @Override
    @PostMapping("/create")
    public ExampleDto createExample(@RequestBody @Valid ExampleDto accountDTO) {
        return null;
    }
}
