# ListFilesFromUsbConnectedAndroidPhone
This project allows you to list the files inside your Android Phone connected via USB cable.

First of all, the **jmtpe.jar** inside this project was generated from the following project: **[https://github.com/mheinzerling/jMTPe](https://github.com/mheinzerling/jMTPe)**

Some observations:

\* I created this project because I needed to delete a list of folders inside my Android Phone MicroSD card. <br />
\* I was able to list the files, but the deletion only worked with one file. It deleted the first then the software froze. <br />
\* So, if you want for a similar purpose, it may not work. <br />
\* To solve my problem, I just removed the MicroSD card from the phone and connected directly to the notebook. Then Java could access it in a much easier way. <br />

I made this work on a **Windows OS** and on a **Eclipse IDE**.

In order to work, you have to do the following steps on Eclipse:
 
1 - Right Click on your project -> Properties <br />
2 - Java Build Path <br />
3 - Tab Source <br />
4 - Open the tree <br />
5 - Native Library Location -> Edit <br />
6 - Select 'dll' folder of the project <br />

![img](https://user-images.githubusercontent.com/4165936/231565876-ce8005a8-7521-45c0-98c4-d46eb1b0fb59.png)