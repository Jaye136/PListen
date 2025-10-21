package model.data.exceptions;

// CLASS DOCUMENTATION: an exception thrown when a song
// cannot be found in the Collection/Library(/PlayHandler
// too, but search is not meant to be used in it, even if
// it is accessible through PlayHandler being a subtype of
// Collection).

public class SongNotFoundException extends Exception {

}
