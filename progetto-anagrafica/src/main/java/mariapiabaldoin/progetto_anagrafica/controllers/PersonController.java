package mariapiabaldoin.progetto_anagrafica.controllers;

import mariapiabaldoin.progetto_anagrafica.entities.Person;
import mariapiabaldoin.progetto_anagrafica.exceptions.BadRequestException;
import mariapiabaldoin.progetto_anagrafica.payloads.PersonDTO;
import mariapiabaldoin.progetto_anagrafica.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person savePerson(@RequestBody @Validated PersonDTO body, BindingResult validationResult) {


        if (validationResult.hasErrors()) {
            String message = validationResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Ci sono stati errori nel payload! " + message);
        }

        // Salvataggio persona
        return this.personService.savePerson(body);
    }

    @GetMapping
    public Page<Person> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "codiceFiscale") String sortBy
    ) {
        return this.personService.findAll(page, size, sortBy);
    }


    @GetMapping("/{codiceFiscale}")
    public Person findByCodiceFiscale(@PathVariable String codiceFiscale) {
        return this.personService.findByCodiceFiscale(codiceFiscale);
    }


    @PutMapping("/{codiceFiscale}")
    public Person updatePerson(
            @PathVariable String codiceFiscale,
            @RequestBody @Validated PersonDTO body,
            BindingResult validationResult
    ) {
        if (validationResult.hasErrors()) {
            String message = validationResult.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Ci sono stati errori nel payload! " + message);
        }

        return this.personService.updatePerson(codiceFiscale, body);
    }


    @DeleteMapping("/{codiceFiscale}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable String codiceFiscale) {
        this.personService.deletePerson(codiceFiscale);
    }

}
