package com.janek.restemplate.proxy.itunes;

import java.util.List;

public record ITunesResponse(Integer resultCount, List<ITunesResult> results) {
}
