# Introduction

This Dropwizard + Kotlin example was developed to, demo the very basic skeleton version of dropwizard and kotlin. Basically, the abcs.

# Running The Application

To test the example application run the following commands.

* To package the example run the following from the root dropwizard directory.

        mvn clean install

* To run the server run (intelliJ).

        java -jar target/dropwizard-kotlin-abcs.jar server src/main/resources/config.yml
	
* To run the server run (intelliJ).

        Run AbcService using intelliJ with yml path

* To hit the ECHO ECHO example (hit refresh a few times).

	http://localhost:9090/echo

* Each of us should be able to build the following scenario (Write a test for the below case)

	curl -H "Content-Type: application/json" -X POST -d '{"name":"Person Name","team":"engineering"}' http://localhost:9090/people
	
	open *http://localhost:9090/people* in the browser and you should be able to retrieve the first person you entered.
