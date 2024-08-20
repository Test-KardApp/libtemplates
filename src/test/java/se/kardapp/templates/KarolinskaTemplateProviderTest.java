package se.Test-KardApp.templates;

import org.junit.jupiter.api.Assertions;
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;

import java.io.FileNotFoundException;
import java.util.Optional;

class KarolinskaTemplateProviderTest {

    @org.junit.jupiter.api.Test
    void testFind() {
        KarolinskaTemplateProvider p = new KarolinskaTemplateProvider();
        Optional<OPERATIONALTEMPLATE> result = p.find("Lab_MBA");
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Lab_MBA", result.get().getTemplateId().getValue());
    }

    @org.junit.jupiter.api.Test
    void testNotFind() {
        KarolinskaTemplateProvider p = new KarolinskaTemplateProvider();
        Optional<OPERATIONALTEMPLATE> result = p.find("Nonsens");
        Assertions.assertTrue(result.isEmpty());
    }
}