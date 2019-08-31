package test;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.hl7.fhir.instance.model.api.IIdType;
import org.hl7.fhir.r4.model.*;

public class TestApplicationHints {

	/*
	 * This class contains hints for the tasks outlined in TestApplication
	 */
	
	public static void main(String[] args) {
//		step1_read_a_resource();
//		step2_search_for_patients_named_test();
//    step3_create_patient();
      create_device();
	}

	public static void step1_read_a_resource() {

		FhirContext ctx = FhirContext.forR4();
		IGenericClient client = ctx.newRestfulGenericClient("http://fhirtest.uhn.ca/baseDstu3");

		Patient patient;
		try {
			// Try changing the ID from 952975 to 999999999999
			patient = client.read().resource(Patient.class).withId("952975").execute();
		} catch (ResourceNotFoundException e) {
			System.out.println("Resource not found!");
			return;
		}

		String string = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(patient);
		System.out.println(string);

	}

	public static void step2_search_for_patients_named_test() {
		FhirContext ctx = FhirContext.forDstu3();
		IGenericClient client = ctx.newRestfulGenericClient("http://fhirtest.uhn.ca/baseDstu3");

		org.hl7.fhir.r4.model.Bundle results = client
			.search()
			.forResource(Patient.class)
			.where(Patient.NAME.matches().value("test"))
			.returnBundle(org.hl7.fhir.r4.model.Bundle.class)
			.execute();

		System.out.println("First page: ");
		System.out.println(ctx.newXmlParser().encodeResourceToString(results));

		// Load the next page
		org.hl7.fhir.r4.model.Bundle nextPage = client
			.loadPage()
			.next(results)
			.execute();

		System.out.println("Next page: ");
		System.out.println(ctx.newXmlParser().encodeResourceToString(nextPage));

	}
	
	public static void step3_create_patient() {
		// Create a patient
		Patient newPatient = new Patient();

		// Populate the patient with fake information
		newPatient
			.addName()
				.setFamily("DevDays2015")
				.addGiven("John")
				.addGiven("Q");
		newPatient
			.addIdentifier()
				.setSystem("http://acme.org/mrn")
				.setValue("1234567");
		newPatient.setGender(Enumerations.AdministrativeGender.MALE);
		newPatient.setBirthDateElement(new DateType("2015-11-18"));

		// Create a client
		FhirContext ctx = FhirContext.forDstu3();
		IGenericClient client = ctx.newRestfulGenericClient("http://fhirtest.uhn.ca/baseDstu3");

		// Create the resource on the server
		MethodOutcome outcome = client
			.create()
			.resource(newPatient)
			.execute();

		// Log the ID that the server assigned
		IIdType id = outcome.getId();
		System.out.println("Created patient, got ID: " + id);
	}

	private static void create_device()
   {
      Device newDevice = new Device();
      // Device.identifier - 0..* Identifier - instance identifier
      newDevice
         .addIdentifier()
         .setSystem("EUI-64")
         .setId("12345DEF");

      // Device.definition - 0..1 Reference(DeviceDefinition)
      //   not used in current PoCD use models

      Coding coding = new Coding();
      coding
         .setSystem("")
         .setCode("")
         .setVersion("")
         .setDisplay("");

      CodeableConcept cc = new CodeableConcept();
      cc.addCoding(coding);

      newDevice.addStatusReason(cc);

      // Device.udiCarrier 0..* BackboneElement
    // TODO: find problem in finding DeviceUdiComponent
     // DeviceUdiComponent udicomp = new DeviceUdiComponent();
//      udicomp.setCarrierHRF("HRFHRFHRF");
//
//      newDevice.setUdi(udicomp);

      // Device.status

      newDevice.setStatus( Device.FHIRDeviceStatus.ACTIVE);

      // Device.statusReason
      // TODO: needs to be CodeableConcept
      // newDevice.setStatusReason("statusreason");

      // Device.distinctIdentifier - appears not to be supported
      newDevice.setDistinctIdentifier("distinctidentifier");

      // Device.manufacturer

      newDevice.setManufacturer("Philips");

      // Device.manufactureDate
      newDevice.setManufactureDateElement(new DateTimeType("2015-04-05"));

      // Device.serialNumber
      // newDevice.

      // Device.deviceName
      newDevice.addDeviceName(new Device.DeviceDeviceNameComponent());


      // Device.modelNumber
      newDevice.setModelNumber("Model A");

      // Device.partNumber
      newDevice.setPartNumber("part23");

      CodeableConcept typeValue = new CodeableConcept();
      typeValue.addCoding(
         new Coding()
            .setCode("code")
            .setDisplay("display")
            .setVersion("version")
            .setSystem("system"));

      newDevice.setType(typeValue);

      // Device.specialization - not used in point-of-care (PoC) devices

      // Device.version
      // TODO: finish example
      Device.DeviceVersionComponent dvc = new Device.DeviceVersionComponent();
      CodeableConcept versionValue = new CodeableConcept();
      dvc.setType(versionValue);
      newDevice.addVersion();

      // Device.property - not used in point-of-care (PoC) devices
      // Device.patient 0..1 Reference(Patient)
      // Device.owner 0..1 Reference(Organization)
      // Device.contact 0..* ContactPoint
      // Device.location 0..1 Reference(Location)

      // newDevice.setLocation()
      // Device.url 0..1 uri
      newDevice.setUrl("deviceserver.example.net");
      // Device.note 0..* Annotation

      // Device.safety 0..* CodeableConcept
      // Device.parent 0..1 Reference(Device)
   }

   static void create_devicemetric()
   {
      DeviceMetric newMetric = new DeviceMetric();

//       <identifier><!-- 0..* Identifier Instance identifier --></identifier>
// <type><!-- 1..1 CodeableConcept Identity of metric, for example Heart Rate or PEEP Setting --></type>
// <unit><!-- 0..1 CodeableConcept Unit of Measure for the Metric --></unit>
// <source><!-- 0..1 Reference(Device) Describes the link to the source Device --></source>
// <parent><!-- 0..1 Reference(Device) Describes the link to the parent Device --></parent>
// <operationalStatus value="[code]"/><!-- 0..1 on | off | standby | entered-in-error -->
// <color value="[code]"/><!-- 0..1 black | red | green | yellow | blue | magenta | cyan | white -->
// <category value="[code]"/><!-- 1..1 measurement | setting | calculation | unspecified -->
// <measurementPeriod><!-- 0..1 Timing Describes the measurement repetition time --></measurementPeriod>
// <calibration>  <!-- 0..* Describes the calibrations that have been performed or that are required to be performed -->
//  <type value="[code]"/><!-- 0..1 unspecified | offset | gain | two-point -->
//  <state value="[code]"/><!-- 0..1 not-calibrated | calibration-required | calibrated | unspecified -->
//  <time value="[instant]"/><!-- 0..1 Describes the time last calibration has been performed -->
// </calibration>
//      
      DeviceMetric.DeviceMetricCalibrationComponent new_cc = new DeviceMetric.DeviceMetricCalibrationComponent();
//      DeviceMetric.DeviceMetricCalibrationState cc_state = new DeviceMetric.DeviceMetricCalibrationState();
//      DeviceMetric.DeviceMetricCalibrationType cc_type - new DeviceMetric.DeviceMetricCalibrationType();
//      new_cc.setState();
      newMetric.addCalibration(new_cc);
//      newMetric.setCategory();
//      newMetric.setColor(new Timing());


   }
	
}
