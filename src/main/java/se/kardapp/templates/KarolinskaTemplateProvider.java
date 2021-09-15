package se.kardapp.templates;

import org.apache.xmlbeans.XmlException;
import org.ehrbase.webtemplate.templateprovider.TemplateProvider;
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;
import org.openehr.schemas.v1.TemplateDocument;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * TemplateProvider for packaged templates
 */
public class KarolinskaTemplateProvider implements TemplateProvider {

    public static final String TEMPLATES = "/templates";
    public static final String TEMPLATE_SUFFIX = ".opt";

    @Override
    public Optional<OPERATIONALTEMPLATE> find(String templateId) {
        String fullName = TEMPLATES + "/" + templateId + TEMPLATE_SUFFIX;
        InputStream inputStream = getClass().getResourceAsStream(fullName);
        try {
            TemplateDocument td = TemplateDocument.Factory.parse(inputStream);
            return Optional.ofNullable(td.getTemplate());
        } catch (XmlException | IOException e) {
            System.err.println("Cannot find template file: " + fullName);
            return Optional.empty();
        }
    }
}
