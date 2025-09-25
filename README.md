# PROJECTNAME
**PROJECTNAME** is a music player program, which stores information about songs in its database. Users will be able to
 add new songs to the library, as well as select them to add into playlists.

## Navigation Guide
- [User Documentation](#user-mockumentation)
    - [Storing Songs](#storing-songs)
    - [Playlist Options](#playlist-options)
    - [Queue Options](#queue-options)

- [Summary & Goals](#summary-and-goals)<br>
*Task 2 and 3 (in short form). Also answered in the user documentation.*
    - [About the Program](#about-the-program)
    - [User Stories](#user-stories)


## User (Mock)umentation
### Storing Songs
New songs can be added to the library by going to <ins>*Library > New Song+*<ins>. Users will be prompted to add the name
 of the song, and the file location or link in which it can be found<sup>1</sup>. Information about the song can be
 added or edited afterwards by going to <ins>*Library > Songs > [Song title]*</ins> and then clicking the three
 dots.<br>
The required information can be referenced below. Unentered non-necessary information will be displayed as 'unknown'.
 Songs cannot be searched for using unknown information.<br>

| Information  |  Required?     |
|:-------------|:--------------:|
| Song title   | ✓              |
| Link         | ✓              |
| Artist       | ✘              |
| Album        | ✘              |
| Genre        | ✘              |
| Duration     | ✘              |
| Cover colour | ✘              |


### Playlist Options
Playlists can be created by going to <ins>*My Playlists > New Playlist+*</ins>. After creating a playlist, users can
 then go to <ins>*Library > Songs*</ins> for a list of all songs in the library by the order that they were added, or
 <ins>*Library > Search Library > Search by...*</ins> to search using a specified genre, artist name, or duration
 *(truncated to the minute)*.<br>
Once the desired song is found, it can be added to the playlist by clicking the three dots, and then selecting <ins>*Add
 to Playlist > [Playlist name]*.</ins>


### Queue Options
Songs can be played by clicking on them in the library, or by playing a playlist. When selecting songs not in a
 playlist, the next song will be picked randomly from the library. Users may also click on the three dots next to a
 song, then click <ins>*Add to queue*</ins>, which will put the song at the back of a temporary queue, or
 click <ins>*Add to next*</ins>, which will put the song at the front of a temporary queue.

> <sup>1</sup> As this is only a concept design where network calls are not to be used, this information will
only be linked to a *method stub* to show its purpose and theoretical implementation.<br>


## Summary and Goals
### About the Program
<ins>What does this program do?</ins>
- **PROJECTNAME** is a music player program, which stores information about songs in its database. Users will be able
 to add new songs to the library, as well as select them to add into playlists.

<ins>Who will use it?</ins>
- As mentioned, this program is intended to be used by users who wish to store and play music. There are functionalities
 for artists to add their songs into the library, but it is mainly designed for the listener.

<ins>Why is this project of interest to you?</ins>
- As my previous coding experience was in Racket, a LISP language, I wanted to work on a project that would connect
 both my LISP knowlege with Java's OOP design. This project allows me to work with lists, as well as do object
 operations by treating each song as their own object.


 ### User Stories