# Camel Geocoder Component Example

This is a simple example of a Camel route based on the Camel-geocoder component.
This route will be deployed on Apache Servicemix or Karaf.

# Setting up Karaf

This example is based on Camel 2.17-SNAPSHOT version.

- You need to have a fresh Camel 2.17-SNAPSHOT in your local repository (compiled by yourself) or use Maven Central Snapshot repo.

- Download the Apache Karaf 3.0.5 package from: http://karaf.apache.org/index/community/download/karaf-3.0.5-release.html

- Unzip the package in a directory (we denote this folder with $KARAF_HOME)

- Execute $KARAF_HOME/bin/karaf

- I suppose you have Camel 2.17-SNAPSHOT in your local repository in these instructions

- Inside Karaf execute the following instructions:

```shell

karaf@root> feature:repo-add file:///<path_to_local_repo>/org/apache/camel/karaf/apache-camel/2.17-SNAPSHOT/apache-camel-2.17-SNAPSHOT-features.xml

```

- Now we need to install the features required by this bundle

```shell

karaf@root> feature:install camel-core
karaf@root> feature:install camel-spring
karaf@root> feature:install camel-geocoder

```

- We've almost done. We need to compile our project. In another terminal (and inside the project directory) executes the following command:

```shell

mvn clean package

```

- Now go back to Karaf and run

```shell

karaf@root> bundle:install -s file:///<project-directory>/target/camel-geocoder-example-1.0.0-SNAPSHOT.jar

karaf@root> log:tail

```

- In the log you should see

```shell

015-12-23 13:56:31,555 | INFO  | l for user karaf | ultOsgiApplicationContextCreator | 84 - org.springframework.osgi.extender - 1.2.1 | Discovered configurations {osgibundle:/META-INF/spring/*.xml} in bundle [Camel Geocoder Route Example (com.github.oscerd.camel-geocoder-example)]
2015-12-23 13:56:31,565 | INFO  | ExtenderThread-1 | OsgiBundleXmlApplicationContext  | 79 - org.apache.servicemix.bundles.spring-context - 3.2.14.RELEASE_1 | Refreshing OsgiBundleXmlApplicationContext(bundle=com.github.oscerd.camel-geocoder-example, config=osgibundle:/META-INF/spring/*.xml): startup date [Wed Dec 23 13:56:31 CET 2015]; root of context hierarchy
2015-12-23 13:56:31,579 | INFO  | ExtenderThread-1 | OsgiBundleXmlApplicationContext  | 79 - org.apache.servicemix.bundles.spring-context - 3.2.14.RELEASE_1 | Application Context service already unpublished
2015-12-23 13:56:31,605 | INFO  | ExtenderThread-1 | XmlBeanDefinitionReader          | 77 - org.apache.servicemix.bundles.spring-beans - 3.2.14.RELEASE_1 | Loading XML bean definitions from URL [bundle://99.0:0/META-INF/spring/camel-context.xml]
2015-12-23 13:56:31,674 | INFO  | ExtenderThread-1 | CamelNamespaceHandler            | 89 - org.apache.camel.camel-spring - 2.17.0.SNAPSHOT | OSGi environment detected.
2015-12-23 13:56:32,149 | INFO  | ExtenderThread-1 | WaiterApplicationContextExecutor | 84 - org.springframework.osgi.extender - 1.2.1 | No outstanding OSGi service dependencies, completing initialization for OsgiBundleXmlApplicationContext(bundle=com.github.oscerd.camel-geocoder-example, config=osgibundle:/META-INF/spring/*.xml)
2015-12-23 13:56:32,176 | INFO  | ExtenderThread-2 | DefaultListableBeanFactory       | 77 - org.apache.servicemix.bundles.spring-beans - 3.2.14.RELEASE_1 | Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2d758bab: defining beans [template,consumerTemplate,camel1:beanPostProcessor,camel1,camelGeocoderBuilder]; root of factory hierarchy
2015-12-23 13:56:32,354 | INFO  | ExtenderThread-2 | OsgiSpringCamelContext           | 70 - org.apache.camel.camel-core - 2.17.0.SNAPSHOT | Apache Camel 2.17-SNAPSHOT (CamelContext: camel1) is starting
2015-12-23 13:56:32,355 | INFO  | ExtenderThread-2 | ManagedManagementStrategy        | 70 - org.apache.camel.camel-core - 2.17.0.SNAPSHOT | JMX is enabled
2015-12-23 13:56:32,452 | INFO  | ExtenderThread-2 | DefaultRuntimeEndpointRegistry   | 70 - org.apache.camel.camel-core - 2.17.0.SNAPSHOT | Runtime endpoint registry is in extended mode gathering usage statistics of all incoming and outgoing endpoints (cache limit: 1000)
2015-12-23 13:56:32,508 | INFO  | ExtenderThread-2 | OsgiSpringCamelContext           | 70 - org.apache.camel.camel-core - 2.17.0.SNAPSHOT | AllowUseOriginalMessage is enabled. If access to the original message is not needed, then its recommended to turn this option off as it may improve performance.
2015-12-23 13:56:32,508 | INFO  | ExtenderThread-2 | OsgiSpringCamelContext           | 70 - org.apache.camel.camel-core - 2.17.0.SNAPSHOT | StreamCaching is not in use. If using streams then its recommended to enable stream caching. See more details at http://camel.apache.org/stream-caching.html
2015-12-23 13:56:32,534 | INFO  | ExtenderThread-2 | OsgiSpringCamelContext           | 70 - org.apache.camel.camel-core - 2.17.0.SNAPSHOT | Route: route1 started and consuming from: Endpoint[timer://timer?fixedRate=true&period=10000&repeatCount=1]
2015-12-23 13:56:32,535 | INFO  | ExtenderThread-2 | OsgiSpringCamelContext           | 70 - org.apache.camel.camel-core - 2.17.0.SNAPSHOT | Total 1 routes, of which 1 is started.
2015-12-23 13:56:32,535 | INFO  | ExtenderThread-2 | OsgiSpringCamelContext           | 70 - org.apache.camel.camel-core - 2.17.0.SNAPSHOT | Apache Camel 2.17-SNAPSHOT (CamelContext: camel1) started in 0.181 seconds
2015-12-23 13:56:32,538 | INFO  | ExtenderThread-2 | OsgiBundleXmlApplicationContext  | 79 - org.apache.servicemix.bundles.spring-context - 3.2.14.RELEASE_1 | Publishing application context as OSGi service with properties {org.springframework.context.service.name=com.github.oscerd.camel-geocoder-example, Bundle-SymbolicName=com.github.oscerd.camel-geocoder-example, Bundle-Version=1.0.0.SNAPSHOT}
2015-12-23 13:56:32,545 | INFO  | ExtenderThread-2 | ContextLoaderListener            | 84 - org.springframework.osgi.extender - 1.2.1 | Application context successfully refreshed (OsgiBundleXmlApplicationContext(bundle=com.github.oscerd.camel-geocoder-example, config=osgibundle:/META-INF/spring/*.xml))
2015-12-23 13:56:33,758 | INFO  |  - timer://timer | route1                           | 70 - org.apache.camel.camel-core - 2.17.0.SNAPSHOT | Processing GeocodeResponse{status=OK, results=[GeocoderResult{types=[locality, political], formattedAddress='Rome, Italy', addressComponents=[GeocoderAddressComponent{longName='Rome', shortName='Rome', types=[locality, political]}, GeocoderAddressComponent{longName='Rome', shortName='Rome', types=[administrative_area_level_3, political]}, GeocoderAddressComponent{longName='Metropolitan City of Rome', shortName='RM', types=[administrative_area_level_2, political]}, GeocoderAddressComponent{longName='Lazio', shortName='Lazio', types=[administrative_area_level_1, political]}, GeocoderAddressComponent{longName='Italy', shortName='IT', types=[country, political]}], geometry=GeocoderGeometry{location=LatLng{lat=41.9027835, lng=12.4963655}, locationType=APPROXIMATE, viewport=LatLngBounds{southwest=LatLng{lat=41.769596, lng=12.341707}, northeast=LatLng{lat=42.0505462, lng=12.7302888}}, bounds=LatLngBounds{southwest=LatLng{lat=41.769596, lng=12.341707}, northeast=LatLng{lat=42.0505462, lng=12.7302888}}}, partialMatch=false}]}

```
