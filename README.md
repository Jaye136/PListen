# PListen
**PListen** is a music player program, which stores information about songs in its database. Users will be able to
 add new songs to the library, as well as select them to add into playlists.

### [Want a quick demo of the project without downloading it?](#quick-demo)
  
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
    ![mrresetti "Before you turn the power off, SAVE! You gotta SAVE! I KNOW you knew that!"](https://github.com/Jaye136/PListen/blob/main/data/WW_Resetti.png)

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
&nbsp;&nbsp; When working on my project, I already spent quite a bit of time refactoring things,
 since abstracting data is something I enjoy doing. However, due to the limited timespan of this project, I was unable
 to implement two types of data structures that I believe my project would have benefitted from, due to learning them
 later in the course.

&nbsp;&nbsp; One of these structures was observers. The way that I implemented updates and refreshes
 in the GUI was by putting a call to the refresh method in every button that changed anything that could show up in
 the user menu <i>(new song, queue options, like status switch button)</i>. This works, but when the number of JButtons
 started stacking up, one or two forgotten calls led into quite the confusing debugging section when unexpected
 behaviour started popping up.
 To avoid too many cross-dependencies, what I wanted was to assign a 'manager' to watch the whole project, which would
 solely handle the responsibility of calling updates and refreshes. Whenever a subject raised a flag, the manager would
 be notified that the display had changed <i>(like going from the library to the queue by pressing 'view queue')</i>,
 or that elements were added to the displayed list <i>(new song, add to queue)</i>. This would have contained the
 update/refresh call in a single location, making bug tracking much simpler.

&nbsp;&nbsp; Another thing was the singleton data structure. As my program is a song player program,
 it needs to run an instance of Library and PlayHandler <i>(queue)</i> concurrently to main. There is only ever going
 to be one copy of each, and any class that needs to access that single concurrent instance of the library/queue must
 call Main.getLibrary() or Main.PlayHandler(). This imported Main everywhere, when Main had nothing to do with the
 behaviours that Library and PlayHandler provided. I knew about the static keyword, but I just wasn't sure how I could
 make a whole class static. Singleton designing would have been perfect for my project, and I truly wish that I had
 known about it sooner.

&nbsp;&nbsp; While working out inter-class dependencies in order to mimic the behaviours of
 subject-observers and singleton class, I was constantly thinking of how convoluded the UML diagram must be getting.
 I was sure there was a better way to do things—I just didn't know how to go about it. It was slightly devastating
 to start learning the exact data structures I had been grasping for, right after the major code phase deadline.
 Still, I'm glad that I can now at least put a name to what I had been searching for. I'm looking forward to
 implementing these strategies in my next project.

----

## Quick Demo
Welcome to the opening screen!<br>
![the main menu of PListen](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/mainmenu.png)


A few sample tunes are included in your welcome package.<br>
Some songs belong to the same album, and some albums belong to the same artist.<br>
>  *This information is displayed above the song!*

![visualisation of song-album-artist relationships](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/libview.png)


Let's press the [New Song+] button! Here, catch! Here's a form to fill out!<br>

![song creation menu](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/songcreate.png)


We have to make sure users can't skip past this screen if they want to add a new song. This information is unique to 
each song, and it's the bare minimum for the app to function.<br>

![showing how users are blocked from creating songs with invalid titles or links](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/nullsongreject.png)


Anything here is additional information, which gets assigned a default value if we don't enter anything. Here, we 
encounter a potential problem that I couldn't overcome back then.<br>
<ins>Developing challenge 2:</ins> If you enter the name of an artist or album you already have in your library, your song 
will get adopted into that artist or album's repertoire automatically. An album and an artist can have the same name. 
But if two albums, or two artists have the same name... everything incorrectly gets attributed to the first artist when 
loading the save!<br>

> I couldn't figure out how to assign unique IDs back then. I have could given each object an ID based on order of 
creation, but I wanted to make sure curious users couldn't corrupt their save files by tampering with the JSON file.
<sup>(I'm guilty of doing that with other programs...)</sup><br>
If someone were to swap the unique ID of a song and album, then a song might try to refer to another song as its 
artist. Loading that save would get weird.<br>

> Of course, I could make a unique ID with two parts: the type, followed by its creation number. Like s0, for 
song 0. It would be easier to debug, since when loading the save file, I can check the type of object before assigning 
the relation, and throw accurate error signals. Unfortunately, I only thought of it after the project 
deadline.<sup>(darn!)</sup><br>

![song creation menu for additional information](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/additionalinfo.png)


Nice! Our new song is looking great. We can designate songs as the currently playing song using the ▶ symbol, or by 
clicking ⋮ to bring up their menu.<br>

![song options menu](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/songoptions.png)


We can also add songs to our queue through the menu. Here's mine!<br>
> *Queue puts things at the back of our queue, and next puts things at the front.
<sup>(I didn't know having both options had an effect on runtime back then :[ )</sup>*<br>

![example queue](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/queuemake.png)


How was the song?
> *Just for fun, and to keep things separated, BingBing!! is if the song's link starts with https://. BingBong!! 
is the message for all else (filepaths), in case the song is stored locally. Even if your song file is somehow(?) 
named https://, it won't get confused as a link, since it's not like your filepath itself (e.g. 
downloads/songs/"https://.mp3") starts with https://.*<br>

![playing a song on the queue](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/playsong.png)


Well, I suppose listening to it twice would be boring.<br>
![skipping a song on the queue](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/skipsong.png)


If you like a song, give it a favourite!<br>
<ins>Developing challenge 2:</ins> Keeping the favourite signs on the 'now playing' bar and on the 'view queue/library' 
panels synced was thought provoking. The 'now playing' bar auto refreshes if any changes are made to the currently made 
song in the libary or queue panels. That's not a very expensive operation, since the 'now playing' bar only displays one 
song at a time. But what if the song is favourited in the 'now playing bar'? Then the entire library or queue panel 
<sup>(depending on which you were on at the time)</sup> would have to auto refresh. What if your library or 
queue was really big though? What if you had to update 1000, 10000, or 100000 songs?<br>
I never figured out a solution, but if I did this project now, I'd maybe try rendering the library/queue in chunks, so 
that I would only have to refresh the chunk the affected song was in instead of the whole library.<br>

![favouriting a song](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/songfav.png)


All done for today? Don't forget to save the changes to your song library before you leave! Remember, your queue is 
temporary and tied to your session. Once you close the app, it won't save!<br>
<ins>Developing challenge 3:</ins> Everything in the project took a lot of time to implement, but was relatively easy 
otherwise. This was, however, not the case for user persistence. Each song holds a reference to an artist, while each 
artist has a collection (array) of songs. A user's library, and all objecct associations within are saved into a JSON 
file.<br>
So how do we preserve a cyclic relationship written in what is essentially a text file? We write down all of the 
information stored in object A, which includes a relationship to object B. Therefore, we should include the information 
for object B within object A. The information for object B includes a reference to object A. Therefore, we should 
include the information for object A within object B. The information for object A includes... uh oh. oh no.<br>
The solution that I came up for this is to only save the songs in the JSON file, only writing in the name of the artist 
and album, if applicable. Instead of also saving the artist and album, I reconstruct them based on the information that 
can be inferred from the saved songs.<br>
Let's take boomChaCha in the album wanting to MOVE! created by chachaBoomer as an example:<br>
> When loading, we reconstruct the song object using its name and link.<br>
> Then the next field we see is the name of the creator, chachaBoomer.<br>
> &nbsp;&nbsp;1. We look for an artist named chachaBoomer in our loaded library so far. We don't find anything, since 
we haven't loaded anything yet.
> &nbsp;&nbsp;2. We create an artist object named chachaBoomer, and make it note that boomChaCha is one of its 
creations.<br>
> &nbsp;&nbsp;3. We make the song note that chachaBoomer is its creator.<br>
> Then, we see the album, wanting to MOVE!.<br>
> &nbsp;&nbsp;1. We look for an album named wanting to MOVE! in our libary so far. We don't find anything.<br>
> &nbsp;&nbsp;2. We create an album object named wanting to MOVE! and make it note that boomChaCha belongs to it, as 
well as noting the reverse relationship in boomChaCha.<br>
> &nbsp;&nbsp;&nbsp;&nbsp;1. We know wanting to MOVE! has a creator.<br>
> &nbsp;&nbsp;&nbsp;&nbsp;2. From boomChaCha, we can infer that the creator is chachaBoomer.<br>
> &nbsp;&nbsp;&nbsp;&nbsp;3. We look for an artist named chachaBoomer in our loaded library so far. We have a match!<br>
> &nbsp;&nbsp;&nbsp;&nbsp;4. We connect wanting to MOVE! to chachaBoomer, and vice versa as well.<br>
> We then assign the remaining fields to boomChaCha, and we have a reconstructed song-album-artist doubly-linked 
relationship!<br>

![saving the library](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/savedata.png)


Let's make sure everything loads correctly.<br>

![fresh restart of application](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/mainmenu2.png)


Nice!<br>

![loading the library](https://github.com/Jaye136/PListen/blob/main/data/quickdemo/loaddata.png)