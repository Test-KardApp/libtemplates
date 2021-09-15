# Libtemplates

Is a packaging of generated Java classes for operational templates. 
It is based on the tooling from EHRBase [https://github.com/ehrbase/openEHR_SDK](https://github.com/ehrbase/openEHR_SDK)

## Building

1. Put .opt-files into `src/main/resources/templates`
2. `maven clean package`

The resulting jar will have generated java classes

## Usage
There is a `TemplateProvider` class you can use to unflatten template objects:
```
Unflattener cut = new Unflattener(new KarolinskaTemplateProvider());
LabMBAComposition composition = new LabMBAComposition();
composition.setLanguage(Language.EN_US);
RMObject obj = cut.unflatten(composition);
CanonicalJson json = new CanonicalJson();
System.out.println(json.marshal(obj));
```