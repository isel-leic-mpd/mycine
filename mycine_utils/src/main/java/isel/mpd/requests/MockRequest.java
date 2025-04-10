package isel.mpd.requests;

import isel.mpd.resources.ResourceUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class MockRequest implements Request{
	
	@Override
	public Reader get(String path) {
		return ResourceUtils.getFromCache(path);
	}
	
}
