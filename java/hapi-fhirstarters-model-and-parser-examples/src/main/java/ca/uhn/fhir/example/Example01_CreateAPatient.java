package ca.uhn.fhir.example;

import static org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.MALE;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Identifier;
//import org.hl7.fhir.dstu3.model.HumanName;
//import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Patient;

import ca.uhn.fhir.context.FhirContext;

public class Example01_CreateAPatient {
   public static void main(String[] theArgs) {

      // Create a resource instance
      Patient pat = new Patient();
      pat.setId("test_id");
      pat.setActive(true);
      //pat.addIdentifier();
      
      FhirContext fhirContext = FhirContext.forR4();
      //List<Identifier> ids = new ArrayList<>();
      pat.addIdentifier().setValue("Value 1").setSystem("http://foo");
      pat.addIdentifier().setValue("Value 2").setSystem("http://faa");
      pat.addName().addGiven("Monoto").setFamily("Halala");
      pat.setGender(AdministrativeGender.MALE);
      //pat.addExtension().setUrl("http://tribe").setValue(value:"Mofokeng");
      System.out.println("....................................");
      System.out.println(fhirContext.newJsonParser().setPrettyPrint(true).encodeResourceToString(pat));
      System.out.println("....................................");
      
      // Add a "name" element
      //HumanName name = pat.addName();
      //name.setFamily("Simpson").addGiven("Homer").addGiven("J");

      // Add an "identifier" element
      //Identifier identifier = pat.addIdentifier();
      //identifier.setSystem("http://acme.org/MRNs").setValue("7000135");

      // Model is designed to be chained
      //pat.addIdentifier().setSystem("http://acme.org/MRNs").setValue("12345");

   }
}
