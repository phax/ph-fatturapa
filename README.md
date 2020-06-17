# ph-fatturapa

Java library to easily read and write XML Schema compliant fatturaPA invoices.

Supported versions are:
* v1.2 (valid until 2020-12-31) 
* v1.2.1 (valid from 2020-10-01)

It is licensed under Apache 2.0 license.

It requires at least Java 8 to be used.

# Usage guide

All XML Schema files are converted using JAXB.
For version 1.2 the generated types are prefixed with "FPA120", for version 1.2.1 they are prefixed with "FPA121" for easy differentiation.

## Read and write fatturaPA invoices

Using the classes `FatturaPA120Marshaller` and `FatturaPA121Marshaller` you can read and write fatturaPA invoices.
Class `FatturaPA120Marshaller` handles version 1.2 and class `FatturaPA121Marshaller` handles version 1.2.1.

Reading an existing fattura PA 1.2 from an existing File is as easy as this:

```java
FPA120FatturaElettronicaType aInvoice = new FatturaPA120Marshaller ().read (new File ("invoice.xml"));
if (aInvoice != null) { 
  // Reading was successful
} else {
  // Error handling
}
```

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

* v1.0.0 - work in progress
    * Initial version

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
On Twitter: <a href="https://twitter.com/philiphelger">@philiphelger</a> |
Kindly supported by [YourKit Java Profiler](https://www.yourkit.com)