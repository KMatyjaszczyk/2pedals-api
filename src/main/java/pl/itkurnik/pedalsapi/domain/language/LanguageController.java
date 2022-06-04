package pl.itkurnik.pedalsapi.domain.language;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService languageService;

    @PutMapping
    private void changeLanguage(@RequestBody LanguageChangeRequest request) {
        languageService.changeLanguage(request);
    }
}
