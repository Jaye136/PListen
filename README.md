# PListen
**PListen** is a music player program, which stores information about songs in its database. Users will be able to
 add new songs to the library, as well as select them to add into playlists.
  
## Navigation Guide
- [User Documentation](#user-mockumentation)
    - [Storing Songs](#storing-songs)
    - [Playlist Options](#playlist-options)
    - [Queue Options](#queue-options)
  
- [Summary & Goals](#summary-and-goals)<br>
    - [Interface Planning](#interface-planning)
    - [About the Program](#about-the-program)
    - [User Stories](#user-stories)
    - [TLDR; Instructions for End User](#tldr-instructions-for-end-user)
  
  
## User (Mock)umentation
### Storing Songs
New songs can be added to the library by going to <ins>*Library > New Song+*</ins>. Users will be prompted to add the
 name of the song, and the file location or link in which it can be found <sup>1</sup>. After clicking next, users are
 prompted to enter additional, non-required information about the song.<br>
The required information can be referenced below. Unentered non-necessary information will be displayed as 'unknown'.
 Songs cannot be searched for using unknown information.<br>

| Information  |  Required?     |  Default      |
|:-------------|:--------------:|:--------------|
| Song title   | ✓              | None          |
| Link/path    | ✓              | None          |
| Artist       | ✘              | Unknown       |
| Album        | ✘              | Unknown       |
| Genre        | ✘              | Unknown       |
| Duration     | ✘              | 0 seconds     |
| Cover colour | ✘              | #c3cdde     |
| Liked song?  | ✘              | False         |
  
  
### Playlist Options
Playlists can be created by going to <ins>*My Playlists > New Playlist+*</ins>. After creating a playlist, users can
 then go to <ins>*Library > Songs*</ins> for a list of all songs in the library by the order that they were added, or
 <ins>*Library > Search Library > Search by...*</ins> to search using a specified genre, artist name, title, etc.<br>
Once the desired song is found, it can be added to the playlist by clicking the three dots, and then selecting <ins>*Add
 to playlist > [Playlist name]*</ins>.
  
  
### Queue Options
Songs can be played by clicking on the play button while in the library, or by playing a playlist. When selecting
 songs not in a playlist, the queue will stop after playing the single selected song. Users may also click on the three
 dots next to a song, then click <ins>*Add to queue*</ins>, which will put the song at the back of a temporary
 queue <sup>2</sup>, or click <ins>*Add to next*</ins>, which will put the song at the front of a temporary
 queue <sup>2</sup>.
  
> <sup>1</sup> As this is only a concept design where network calls are not to be used, this information will
only be linked to a *method stub* to show its purpose and theoretical implementation.<br>
> <sup>2</sup> Queues are not saved like playlists are. They are cleared when the user closes the program.<br>
  
  
## Summary and Goals
### Interface Planning
> This section is outdated as of phase 3. It should now only be used as a feature checklist.

This is a preliminary, tentative plan for the user interface. This is not meant for visual design, but for the feature
 flow of the program. This 'call graph' style allows for a more guided exploration of new user stories, by being able
 to consider how it relates to the rest of the program, as well as what aspect *(such as songs, or playlists)* it would
 concern.

[Program entered]<br>
➥ [View library]<br>
&nbsp;&nbsp;&nbsp;&nbsp;➥ [New song+]<br>
&nbsp;&nbsp;&nbsp;&nbsp;➥ [Search library]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Search by...]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Song title]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Artists]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Name]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Albums]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Albums]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Genres]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Liked songs]<br>
&nbsp;&nbsp;&nbsp;&nbsp;➥ [List of songs]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Display of songs]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [⋮]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Like/unlike song]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Add to next]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Add to queue]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [Add to playlist]<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;➥ [List of playlists]<br>
➥ [View playlists]<br>
&nbsp;&nbsp;&nbsp;&nbsp;➥ [New playlist+]<br>
&nbsp;&nbsp;&nbsp;&nbsp;➥ [My playlists]<br>
➥ [Queue options]<br>
&nbsp;&nbsp;&nbsp;&nbsp;➥ [Play queue]<br>
&nbsp;&nbsp;&nbsp;&nbsp;➥ [View queue]<br>
➥ [Save/load data]<br>
&nbsp;&nbsp;&nbsp;&nbsp;➥ [Save library]<br>
&nbsp;&nbsp;&nbsp;&nbsp;➥ [Load library]<br>
➥ [Quit program]<br>
  
  
### About the Program
<ins>What does this program do?</ins>
- **PListen** is a music player program, which stores information about songs in its database. Users will be able
 to add new songs to the library, as well as select them to add into playlists.
  
<ins>Who will use it?</ins>
- As mentioned, this program is intended to be used by users who wish to store and play music. There are functionalities
 for artists to add their songs into the library, but it is mainly designed for the listener.
  
<ins>Why is this project of interest to you?</ins>
- As my previous coding experience was in Racket, a LISP language, I wanted to work on a project that would connect
 both my LISP knowlege with Java's OOP design. This project allows me to work with lists, as well as do object
 operations by treating each song as their own object.
  
  
### User Stories
*As a user, I would like to...*<br>
   
**Adding x to y:**
> Add existing *songs* to a *queue* (either using <ins>*Add to queue*</ins>, or
 <ins>*Add to next*</ins>. Please see [queue options](#queue-options) for further details.)<br>
  
**Viewing a <ins>list</ins>**
> See my *queue* of *listed songs* (please see [queue options](#queue-options), note 2.)<br>
> See the *default library* (without user modifications)<br>
  
**Other user stories (without data saving)**
> *Construct a new song* for this instance of the program (not saved to the library)<br>
> *View basic information* for any song (either user-added, or default.
 Includes some of the information listed [here](#storing-songs).)<br>
  
**User data saving**
> Save the state of the Library after it was user-modified (including any changed information of Songs,
  what songs are in the Library if any new Songs were added, etc.)<br>
> Restore/reload the state of a Library to the same save state that was loaded in<br>


### **TLDR; Instructions for End User**
<ins>How do I view the X's that were added to Y?</ins>
- This can be done immediately after opening the app and viewing the user library.<br>

<ins>What are the two additional required actions? How do I access them?</ins>
- Users can add a 'new X' by clicking the <ins>*New song+*</ins> button in the side menu panel.
- Users can view a subset of songs in the library satisfying the 'added to a queue' criterion by clicking the
 <ins>*View the queue...*</ins> button.
    - Songs can be added to the queue by clicking the three dots in their song display while viewing the library.

<ins>How do I find the required visual component?</ins>
- This can be done by clicking <ins>*New song+*</ins>, or clicking on the three dots beside a song while viewing the
 library.

<ins>How do I save?</ins>
- Saving can be done by clicking on the <ins>*Save/load data*</ins> button in the side menu panel, and then clicking
 <ins>*Save data*</ins>.
    - I exited without saving! What do I do?:&nbsp; sorry dear user, you cannot be saved. unfortunately this
     project is in its stone age era of only manual saving because i dislike autosaving. I leave you this image of
     mr. resetti from animal crossing for future reference:<br>
    ![mrresetti](https://github.students.cs.ubc.ca/CPSC210-2025W-T1/project-s5a4m/blob/main/data/WW_Resetti.png)

<ins>How do I load?</ins>
- Loading can be done by clicking on the <ins>*Save/load data*</ins> button in the side menu panel, and then clicking
 <ins>*Load data*</ins>.