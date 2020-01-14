# Calculator

The Video Player consists of 5 Activities. Categories Activity, SubCategories Activity, List Activity, Video Activity and Information Activity. All work in portrait and landscape mode. FAB is implemented.

CustomListView Class:
=====================
This class takes text and image from files.xml and prints them in ListView. If image is null, it won't be printed (used in all activities).

Activities:
===========

* Main Activity: This is the launcher activity, it shows different categories: action, drama, comedy, and adventure. (From Category and Cat_Img in xml file)
* 2nd Activity: After picking a category, you get directed to this activity that shows the different sub categories and a small image beside them.
* 3rd Activity: Shows information about the sub category chosen and the list of videos available.
* 4th Activity: This is the video player that plays the video with full media control (pause, play,skip) and full screen if rotated to landscape.
* 5th Activity: If you click on the FAB appearing on 1st,2nd,and 3rd activity it will lead to this activity that shows developer's information and a back button to main activity.

Files.xml
==========
This file contains the categories,subcategories,information and list about the videos and images. Videos are called in Video Class using switch cases.

Folders
==========
* raw: Where the .mp4 videos are saved.
* drawables: Where the images are saved.


Issues:
=======
* All of the necessary data are stored in XML.
* I send the text printed in listView to the next activity to show what will be displayed using switch cases.
* All videos are called from the Video class and are not saved in XML.
* Pictures' ID are called using switch cases, but they are also available in the XML file.
