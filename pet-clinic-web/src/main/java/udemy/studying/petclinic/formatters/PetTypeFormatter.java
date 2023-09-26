package udemy.studying.petclinic.formatters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import udemy.studying.petclinic.model.pet.PetType;
import udemy.studying.petclinic.services.PetTypeService;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> pets = petTypeService.findAll();
        for (PetType petType : pets) {
            if (petType.getName().equals(text)) {
                return petType;
            }
        }
        throw new ParseException("Type not found " + text, 0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
