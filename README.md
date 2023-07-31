# ph-fatturapa

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.helger/ph-fatturapa/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.helger/ph-fatturapa) 
[![javadoc](https://javadoc.io/badge2/com.helger/ph-fatturapa/javadoc.svg)](https://javadoc.io/doc/com.helger/ph-fatturapa)
[![CodeCov](https://codecov.io/gh/phax/ph-fatturapa/branch/master/graph/badge.svg)](https://codecov.io/gh/phax/ph-fatturapa)

Java library to easily read and write XML Schema compliant fatturaPA invoices.

Supported versions are:
* v1.2 (valid until 2020-12-31) 
* v1.2.1 (valid from 2020-10-01 to 2022-09-30)
* v1.2.2 (valid from 2022-10-01)

It is licensed under Apache 2.0 license.

It requires at least Java 11 to be used.

# Usage guide

All XML Schema files are converted using JAXB.
For version 1.2 the generated types are prefixed with "FPA120", for version 1.2.1 they are prefixed with "FPA121" for easy differentiation.

## Read and write fatturaPA invoices

Using the classes `FatturaPA120Marshaller` and `FatturaPA121Marshaller` you can read and write fatturaPA invoices.
Class `FatturaPA120Marshaller` handles version 1.2 and class `FatturaPA121Marshaller` handles version 1.2.1.

### Reading

Reading an existing fatturaPA 1.2 from an existing File is as easy as this:

```java
FPA120FatturaElettronicaType aInvoice = new FatturaPA120Marshaller ().read (new File ("invoice.xml"));
if (aInvoice != null) { 
  // Reading was successful
} else {
  // Error handling
}
```
There are several overloads of `read` to read from different kind of sources.

### Writing

Writing an existing `FPA120FatturaElettronicaType` is also very simple:

```java
FPA120FatturaElettronicaType aInvoice = ....;
if (new FatturaPA120Marshaller ().write (aInvoice, new File ("new-invoice.xml")).isSuccess ()) { 
  // Writing was successful
} else {
  // Error handling
}
```
There are several overloads of `write` to write from different kind of targets and `getAs...` methods to convert the invoice to different formats.

By default a namespace context is present that uses the "p" prefix for the main element. If you want to change that, see the method `setNamespaceContext` of the Marshaller classes. 

# Building from source

To build from source you need Apache Maven and Java 1.8 or later.
Just run this on the commandline:

```shell
mvn clean install
```

## Usage in an IDE

If you have build errors in your IDE, ensure that you once call `mvn process-sources` on the project. This will create the Java classes representing the XML schema objects.

Afterwards you might need to manually add the following folders to your buildpath:
* `target/generated-sources/fatturapa120`
* `target/generated-sources/fatturapa121`

# Maven usage

Add the following to your pom.xml to use this artifact, replacing `x.y.z` with the real version number:

```xml
<dependency>
  <groupId>com.helger</groupId>
  <artifactId>ph-fatturapa</artifactId>
  <version>x.y.z</version>
</dependency>
```

# References

* [Official fatturaPA format page]( https://www.fatturapa.gov.it/export/fatturazione/it/normativa/f-2.htm) - check the Italian version of the page; the English version is out of date

# News and noteworthy

* v2.0.3 - work in progress
    * Deprecated class `EFatturaPADocumentType`
* v2.0.2 - 2023-04-07
    * Added v1.2.2 to `EFatturaPADocumentType`
    * Moved XML Schemas and test files to a folder `external/...`
* v2.0.1 - 2023-03-22
    * Added support for fatturaPA 1.2.2
* v2.0.0 - 2023-01-08
    * Using Java 11 as the baseline
    * Updated to ph-commons 11
    * Using JAXB 4.0 as the baseline
* v1.2.0 - 2021-05-02
    * Updated to ph-commons 10.1
* v1.1.0 - 2021-03-21
    * Updated to ph-commons 10
* v1.0.3 - 2020-09-17
    * Updated to Jakarta JAXB 2.3.3
* v1.0.2 - 2020-08-28
    * Using Java 8 date and time classes for JAXB created classes
* v1.0.1 - 2020-06-30
    * Minor API extension
* v1.0.0 - 2020-06-17
    * Initial version

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
It is appreciated if you star the GitHub project if you like it.