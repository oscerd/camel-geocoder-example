package com.github.oscerd.camel.geocoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Usage example of Camel-geocoder Component
 */
public class CamelGeocoderRouteBuilder extends RouteBuilder {
    
    @Override
    public void configure() {
    	
        from("timer://timer?fixedRate=true&period=10000&repeatCount=1").to("geocoder:address:Rome, Italy").log("Processing ${body}");
    }

}
