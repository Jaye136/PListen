# PROJECTNAME
**PROJECTNAME** is a music player program, which stores information about songs in its database. Users will be able to
 add new songs to the library, as well as select them to add into playlists.

## Navigation Guide
---
- [Storing Songs](#storing-songs)
- [Playlist Options](#playlist-options)
- [Queue Options](#queue-options)

**Task 2 and 3 (in short form, but also answered in the user mockumentation)**
- [Summary & Goals](#summary-and-goals)


## User (Mock)umentation
---
### Storing Songs
New songs can be added to the library by going to <u>*Library > New Song +*<u>. Users will be prompted to add the name
 of the song, and the file location or link in which it can be found<sup>1</sup>. Information about the song can be
 added or edited afterwards by going to <u>*Library > Songs > [Song title]*</u> and then clicking the three
 dots.</n>
The required information can be referenced below. Unentered non-necessary information will be displayed as 'unknown'.
 Songs cannot be searched for using unknown information.</n>

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
Playlists can be created by going to <u>*My Playlists > New Playlist +*</u>. After creating a playlist, users can
 then go to <u>*Library > Songs*</u> for a list of all songs in the library by the order that they were added, or
 <u>*Library > Search Library > Search by...*</u> to search using a specified genre, artist name, or duration
 *(truncated to the minute)*.</n>
Once the desired song is found, it can be added to the playlist by clicking the three dots, and then selecting <u>*Add
 *to Playlist > [Playlist name]*.</u>


### Queue Options
Songs can be played by clicking on them in the library, or by playing a playlist. When selecting songs not in a
 playlist, the next song will be picked randomly from the library. Users may also click on the three dots next to a
 song, then click <u>*Add to queue*</u>, which will put the song at the back of a temporary queue, or
 click <u>*Add to next*</u>, which will put the song at the front of a temporary queue.

> <sup>1</sup> As this is only a concept design where network calls are not to be used, this information will
only be linked to a *method stub* to show its purpose and theoretical implementation.</n>


### Summary and Goals
<u>What does this program do?</u>
- **PROJECTNAME** is a music player program, which stores information about songs in its database. Users will be able
 to add new songs to the library, as well as select them to add into playlists.

<u>Who will use it?</u>
- As mentioned, this program is intended to be used by users who wish to store and play music. There are functionalities
 for artists to add their songs into the library, but it is mainly designed for the listener.

<u>Why is this project of interest to you?</u>
- As my previous coding experience was in Racket, a LISP language, I wanted to work on a project that would connect
 both my LISP knowlege with Java's OOP design. This project allows me to work with lists, as well as do object
 operations by treating each song as their own object.