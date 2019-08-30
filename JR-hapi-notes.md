# JR Notes on using HAPIFHIR

August 12, 2019 12:56 PM
JR-hapi-notes.md
## Various instruction pieces

* [Hacking Hapi FHIR](https://hapifhir.io/hacking_hapi_fhir.html)
	* How to download from github and do a command-line build with Maven
	* Importing into Eclipse (basically import existing Maven projects)

### Repositories
https://mvnrepository.com/artifact/ca.uhn.hapi.fhir/hapi-fhir-structures-r4
4.0.0 available - tr

#### Action
* mimiced the Eclipse procedure in IntelliJ
* loaded hapi-fhirstarter-client-skeleton OK

### TODO
* try changing fhirstarters client to reference 4.0.0 in pom.xml on a new branch
* look at other fhirstarters java projects

#### Results

* Ran TestApplication successfully (it ended with an exception due to not finding resource - expected I think)
* Debug runs of TestApplicationHints. Seemed to do as it should, although it didn't appear that the steps found stuff, but I couldn't see any reason the stuff should have been found.

### Client Alternatives
[Annotation-Driven Client](http://hapifhir.io/doc_rest_client_annotation.html)
[Fluent/Generic Client](http://hapifhir.io/doc_rest_client.html)

#### Filling in the fields of Domain Resources such as Device
* Step one might be looking closely at the examples for Patient and figuring how they work for simple data types and more complex ones (BackboneElements)
* [Working with Resources](http://hapifhir.io/doc_fhirobjects.html)


### Deciphering the Annotations

[Java Language Specification SE1.8](https://docs.oracle.com/javase/specs/jls/se8/html/index.html)
[Annotation Types in Java Language Specification](https://docs.oracle.com/javase/specs/jls/se8/html/jls-9.html#jls-9.6)
[Oracle tutorial on Annotations](https://docs.oracle.com/javase/tutorial/java/annotations/)


### TODO:
Look at:
* [References](https://www.hl7.org/fhir/references.html#Reference)
* [Transaction](https://www.hl7.org/fhir/http.html#transaction)
* related PoCD IG text
* [References in bundles](https://www.hl7.org/fhir/bundle.html#bundle-unique)
* [Bundle](https://www.hl7.org/fhir/bundle.html)

### Related files
* [jr-device-resource-notes](file:///Users/jrhoads/Projects/fhirstarters/jr-device-resource-notes.html)