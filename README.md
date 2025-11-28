# PListen
**PListen** is a music player program, which stores information about songs in its database. Users will be able to
 add new songs to the library, as well as select them to add into playlists.
  
## Navigation Guide
- [User Documentation](#user-mockumentation)
    - [Storing Songs](#storing-songs)
    - [Playlist Options](#playlist-options)
    - [Queue Options](#queue-options)

- [Summary & Goals](#summary-and-goals)
    - [Interface Planning](#interface-planning)
    - [About the Program](#about-the-program)
    - [User Stories](#user-stories)
    - [TLDR; Instructions for End User](#tldr-instructions-for-end-user)

- [Phase 4](#phase-4)
    - [Event Log Example (task 2)](#event-log-example-task-2)
    - [Refactoring (task 3)](#refactoring-task-3)

<br>

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

----

### Playlist Options
Playlists can be created by going to <ins>*My Playlists > New Playlist+*</ins>. After creating a playlist, users can
 then go to <ins>*Library > Songs*</ins> for a list of all songs in the library by the order that they were added, or
 <ins>*Library > Search Library > Search by...*</ins> to search using a specified genre, artist name, title, etc.<br>
Once the desired song is found, it can be added to the playlist by clicking the three dots, and then selecting <ins>*Add
 to playlist > [Playlist name]*</ins>.

----

### Queue Options
Songs can be played by clicking on the play button while in the library, or by playing a playlist. When selecting
 songs not in a playlist, the queue will stop after playing the single selected song. Users may also click on the three
 dots next to a song, then click <ins>*Add to queue*</ins>, which will put the song at the back of a temporary
 queue <sup>2</sup>, or click <ins>*Add to next*</ins>, which will put the song at the front of a temporary
 queue <sup>2</sup>.
  
> <sup>1</sup> As this is only a concept design where network calls are not to be used, this information will
only be linked to a *method stub* to show its purpose and theoretical implementation.<br>
> <sup>2</sup> Queues are not saved like playlists are. They are cleared when the user closes the program.<br>

<br>

## Summary and Goals
### Interface Planning
> This section is outdated as of phase 3. It should now only be used as a feature checklist.

This is a preliminary, tentative plan for the user interface. This is not meant for visual design, but for the feature
 flow of the program. This 'call graph' style allows for a more guided exploration of new user stories, by being able
 to consider how it relates to the rest of the program, as well as what aspect *(such as songs, or playlists)* it would
 concern.

<pre>
[Program entered]
    ➥ [View library]
        ➥ [New song+]
        ➥ [Search library]
            ➥ [Search by...]
                ➥ [Song title]
                ➥ [Artists]
                    ➥ [Name]
                    ➥ [Albums]
                ➥ [Albums]
                ➥ [Genres]
                ➥ [Liked songs]
    ➥ [List of songs]
        ➥ [Display of songs]
        ➥ [⋮]
            ➥ [Like/unlike song]
            ➥ [Add to next]
            ➥ [Add to queue]
            ➥ [Add to playlist]
                ➥ [List of playlists]
    ➥ [View playlists]
        ➥ [New playlist+]
        ➥ [My playlists]
    ➥ [Queue options]
        ➥ [Play queue]
        ➥ [View queue]
    ➥ [Save/load data]
        ➥ [Save library]
        ➥ [Load library]
    ➥ [Quit program]
</pre>

----

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

----

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

<br>

## TLDR; Instructions for End User
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
    - I exited without saving! What do I do?:&nbsp; sorry dear user, your disappointment cannot be saved, though your
     data certainly could have been before closing. unfortunately this project is in its stone age era of only manual
     saving. I leave you this image of mr. resetti from animal crossing for future reference:<br>
    ![mrresetti](https://github.students.cs.ubc.ca/CPSC210-2025W-T1/project-s5a4m/blob/main/data/WW_Resetti.png)

<ins>How do I load?</ins>
- Loading can be done by clicking on the <ins>*Save/load data*</ins> button in the side menu panel, and then clicking
 <ins>*Load data*</ins>.

<br>

## Phase 4
### Event Log Example (task 2)
Example console event log of the events that occur when program is run, and the default library is initialised.<br>
Printed to the console after closing the application.<br>
<pre>
Wed Nov 26 14:38:09 PST 2025
New song added to the library:boomChaCha
Wed Nov 26 14:38:09 PST 2025
New song added to the library:fresh beats
Wed Nov 26 14:38:09 PST 2025
New song added to the library:mysterious tunes
Wed Nov 26 14:38:09 PST 2025
New song added to the library:nice bars
Wed Nov 26 14:38:09 PST 2025
New song added to the library:jazzy jams
Wed Nov 26 14:38:09 PST 2025
   (1) New artist added to library: chachaBoomer
Wed Nov 26 14:38:09 PST 2025
   (2) Creator of boomChaCha changed to new artist: chachaBoomer
Wed Nov 26 14:38:09 PST 2025
   (1) New album added to library: wanting to MOVE!
Wed Nov 26 14:38:09 PST 2025
   (2) Successfully credited existing artist chachaBoomer as the contributor for wanting to MOVE!
Wed Nov 26 14:38:09 PST 2025
   (3) Album of boomChaCha changed to new album: wanting to MOVE!
Wed Nov 26 14:38:09 PST 2025
   (1) Creator of fresh beats changed to existing artist: chachaBoomer
Wed Nov 26 14:38:09 PST 2025
Genre of fresh beats changed to: HIPRAP
Wed Nov 26 14:38:09 PST 2025
Cover colour of fresh beats changed to: #000000
Wed Nov 26 14:38:09 PST 2025
   (1) New artist added to library: istArtist the trAtsi
Wed Nov 26 14:38:09 PST 2025
   (2) Creator of mysterious tunes changed to new artist: istArtist the trAtsi
Wed Nov 26 14:38:09 PST 2025
Duration of mysterious tunes changed to: 75 seconds
Wed Nov 26 14:38:09 PST 2025
Like status of mysterious tunes switched to: true
Wed Nov 26 14:38:09 PST 2025
   (1) Album of nice bars changed to existing album: wanting to MOVE!
Wed Nov 26 14:38:09 PST 2025
Genre of nice bars changed to: HIPRAP
Wed Nov 26 14:38:09 PST 2025
Cover colour of nice bars changed to: #FFFFFF
Wed Nov 26 14:38:09 PST 2025
   (1) New album added to library: feeling sleepy...
Wed Nov 26 14:38:09 PST 2025
   (2) Successfully credited existing artist istArtist the trAtsi as the contributor for feeling sleepy...
Wed Nov 26 14:38:09 PST 2025
   (3) Album of jazzy jams changed to new album: feeling sleepy...
Wed Nov 26 14:38:09 PST 2025
Genre of jazzy jams changed to: JAZZ
Wed Nov 26 14:38:09 PST 2025
Duration of jazzy jams changed to: 80 seconds
Wed Nov 26 14:38:09 PST 2025
5 songs successfully initialised in library
</pre>

----

### Refactoring (task 3)
<p style="text-indent:15px;">When working on my project, I already spent quite a bit of time refactoring things,
 since abstracting data is something I enjoy doing. However, due to the limited timespan of this project, I was unable
 to implement two types of data structures that I believe my project would have benefitted from, due to learning them
 later in the course.</p>

<p style="text-indent:15px;">One of these structures was observers. The way that I implemented updates and refreshes
 in the GUI was by putting a call to the refresh method in every button that changed anything that could show up in
 the user menu <i>(new song, queue options, like status switch button)</i>. This works, but when the number of JButtons
 started stacking up, one or two forgotten calls led into quite the confusing debugging section when unexpected
 behaviour started popping up.
 To avoid too many cross-dependencies, what I wanted was to assign a 'manager' to watch the whole project, which would
 solely handle the responsibility of calling updates and refreshes. Whenever a subject raised a flag, the manager would
 be notified that the display had changed <i>(like going from the library to the queue by pressing 'view queue')</i>,
 or that elements were added to the displayed list <i>(new song, add to queue)</i>. This would have contained the
 update/refresh call in a single location, making bug tracking much simpler.</p?

<p style="text-indent:15px;">Another thing was the singleton data structure. As my program is a song player program,
 it needs to run an instance of Library and PlayHandler <i>(queue)</i> concurrently to main. There is only ever going
 to be one copy of each, and any class that needs to access that single concurrent instance of the library/queue must
 call Main.getLibrary() or Main.PlayHandler(). This imported Main everywhere, when Main had nothing to do with the
 behaviours that Library and PlayHandler provided. I knew about the static keyword, but I just wasn't sure how I could
 make a whole class static. Singleton designing would have been perfect for my project, and I truly wish that I had
 known about it sooner.</p>

<p style="text-indent:15px;">While working out inter-class dependencies in order to mimic the behaviours of
 subject-observers and singleton class, I was constantly thinking of how convoluded the UML diagram must be getting.
 I was sure there was a better way to do things—I just didn't know how to go about it. It was slightly devastating
 to start learning the exact data structures I had been grasping for, right after the major code phase deadline.
 Still, I'm glad that I can now at least put a name to what I had been searching for. I'm looking forward to
 implementing these strategies in my next project.</p>