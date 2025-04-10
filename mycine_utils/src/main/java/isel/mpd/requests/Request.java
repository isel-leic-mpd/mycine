package isel.mpd.requests;

import java.io.Reader;

public interface Request {
	Reader get(String path);
}
