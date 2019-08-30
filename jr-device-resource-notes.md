

## Device - contained BackboneElements
* udiCarrier 0..*
	* deviceIdentifier
    * issuer
    * jursidiction
    * carrierAIDC
    * carrierHRF
    * entryType
* deviceName
	* name - string
	* type - code
* specialization
	* systemType
    * version
* version
    * type  CodeableConcept
    * component  Identifier
    * value  string
* property
    * type CodeableConcept
    * valueQuantity Quantity
 * patient
 * owner
 * contact ContactPoint
 * location
 * url
 * note Annotation
 * safety 0..* CodeableConcept
 * parent

## Device - addX, etc. methods
* addContect
* addIdentifier
* addNote
* addSafety
* makeProperty
* setProperty
* setContact(list<ContactPoint>)
* setExpirationDate(Date)
* setIdentifier(List<identifier>>)
* setLocation(Reference)
* setLocationTarget(Location)
* setLotNumber(String)
* setLotNumberElement(StringType)
* setManfactureDate(Date)
* setManufacturer(String)
* setModel(String)
* setPatient(Reference)
* setPatientTarget(Patient)
* setProperty(int, String, Base):Base
* setSafety(List<CodeableConcept>)
* setStatus(FHIRDeviceStatus)
* setType(CodeableConcept)
* setUdi(DeviceUdiComponent): Device
* setURL
* setVersion(String)


## DataTypes Used
* [ContactPoint](https://www.hl7.org/fhir/datatypes.html#ContactPoint)
* [Annotation](http://www.hl7.org/fhir/datatypes.html#annotation)

```
<[name] xmlns="http://hl7.org/fhir">
 <!-- from Element: extension -->
 <author[x]><!-- 0..1 Reference(Practitioner|Patient|RelatedPerson|Organization)|
   string Individual responsible for the annotation --></author[x]>
 <time value="[dateTime]"/><!-- 0..1 When the annotation was made -->
 <text value="[markdown]"/><!-- 1..1 The annotation  - text content (as markdown) -->
</[name]>

```


* [id](http://www.hl7.org/fhir/datatypes.html#id)
  Any combination of upper- or lower-case ASCII letters ('A'..'Z', and 'a'..'z', numerals ('0'..'9'), '-' and '.', with a length limit of 64 characters. (This might be an integer, an un-prefixed OID, UUID or any other identifier pattern that meets these constraints.)	xs:string	JSON string
Regex: [A-Za-z0-9\-\.]{1,64}

* [identifier](http://www.hl7.org/fhir/datatypes.html#identifier)

```
<[name] xmlns="http://hl7.org/fhir">
 <!-- from Element: extension -->
 <use value="[code]"/><!-- 0..1 usual | official | temp | secondary | old (If known) -->
 <type><!-- 0..1 CodeableConcept Description of identifier --></type>
 <system value="[uri]"/><!-- 0..1 The namespace for the identifier value -->
 <value value="[string]"/><!-- 0..1 The value that is unique -->
 <period><!-- 0..1 Period Time period when id is/was valid for use --></period>
 <assigner><!-- 0..1 Reference(Organization) Organization that issued id (may be just text) --></assigner>
</[name]>
</[name]>
```

[Reference](https://www.hl7.org/fhir/references.html)

```
<[name] xmlns="http://hl7.org/fhir">
 <!-- from Element: extension -->
 <reference value="[string]"/><!-- ?? 0..1 Literal reference, Relative, internal or absolute URL -->
 <type value="[uri]"/><!-- 0..1 Type the reference refers to (e.g. "Patient") -->
 <identifier><!-- 0..1 Identifier Logical reference, when literal reference is not known --></identifier>
 <display value="[string]"/><!-- 0..1 Text alternative for the resource -->
</[name]>

```

### Related files
* [JR-hapi-notes](file:///Users/jrhoads/projects/fhirstarters/JR-hapi-notes.html)
* [Working with Resources](http://hapifhir.io/doc_fhirobjects.html)
* [Fluent/Generic Client](http://hapifhir.io/doc_rest_client.html)