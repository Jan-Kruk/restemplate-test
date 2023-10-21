package com.janek.restemplate.proxy.itunes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ITunesResult(String trackName, String artistName) {
}
