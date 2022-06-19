# Jumping Game in Java
### A game i did during my first year at the University 

## About
The game was created back in 2017 and was developed in Eclipse Oxygen. I thought it would be of more use in my University era projects here on GitHub than collecting bit-dust on some harddrive of mine.

## Screenshot
![Screenshot of the game in action](images/game.png?raw=true "Screenshot of the game in action")

## Java version
The Java version i used to compile this game was.
```
$ javac -version
javac 9.0.4

$ java -version
java 9.0.4
```
## Compiling
Both of the commands must be run from the src directory.

Compile the game. 
```
$ javac -d ../bin ./game/Jumper.java
```

Copy the images directory to the bin directory.
```
$ cp ./images/ ../bin/ -r
```

## Running
Run the program. Must be ran from the bin directory.
```
$ java ./game/Jumper
```

**Note** that you can't append .class to the Jumper-file when executing the game.

![Screenshot of the terminal](images/terminal.png?raw=true "Screenshot of the terminal")

## Author notes
One of the things i wanted to try out with this little game was to have the game be rendered using a sprite-array. The array is shifted in different speeds giving the illusion of horizontal movement.
```java
public void initMap() {    
     map = new char[mapHeight][mapWidth];

     map[0] = "----------------------------------------------------------------".toCharArray();
     map[1] = "----------------------------------------%!@@@-------------------".toCharArray();
     map[2] = "--------------------------------------%@@!!!@@------------------".toCharArray();
     map[3] = "------------------------------------%%%@@!!!%%@@----------------".toCharArray();
     map[4] = "-------------------!@-------------------------------------------".toCharArray();
     map[5] = "------------------%%@@---------------------------!!-------------".toCharArray();
     map[6] = "-----------------%!!@@@@-----------------------!!@@!------------".toCharArray();
     map[7] = "--------------@@!!%%@@@!!@@------------------%%%@!!!@@@!--------".toCharArray();
     map[8] = "-------------------------------------------@@%%!!@@!%%@@@-------".toCharArray();
     map[9] = "-----------------------------------------%%!!@@@@@@!!@@@@@------".toCharArray();
    map[10] = "----------!@----------------------------------------------------".toCharArray();
    map[11] = "-------%%!!!!@--------------------------------------------------".toCharArray();
    map[12] = "-----%%%@@@@!!@@@-----------------------------------------------".toCharArray();
    map[13] = "--@@@%%@@!!@@@@@@@@---------------------------------------------".toCharArray();
    map[14] = "----------------------------------------------------------------".toCharArray();
    map[15] = "----------------------------------------------------------------".toCharArray();
    map[16] = "----------------------------------------------------------------".toCharArray();
    map[17] = "----------------------------------------------------------------".toCharArray();
    map[18] = "----------------------------------------------------------------".toCharArray();
    map[19] = "----------------------------------------------------------------".toCharArray();
    map[20] = "----------------------------------------------------------------".toCharArray();
    map[21] = "----------------------------------------------------------------".toCharArray();
    map[22] = "----------------------------------------------------------------".toCharArray();
    map[23] = "----------------------------------------------------------------".toCharArray();
    map[24] = "----------------------------------------------------------------".toCharArray();
    map[25] = "----------------------------------------------------------------".toCharArray();
    map[26] = "5412234532312123356713523635245677532234566321134556556677334335".toCharArray();
    map[27] = "==223??1234+23==2??45+==?22323?++?45==233?==3+3+23=342573=+66=++".toCharArray();
    map[28] = "??=?3345?=+==+=???===++??+?676+=+++==+++=?????=??367++=+??=???=?".toCharArray();
    map[29] = "??=?++===??=?=??=?++?=?=?=+=+++=?+=+=+??==?=?=???==?=?=?=+??=?=+".toCharArray();
    map[30] = "?+++==+=+?===++=+=?=+?=?=+=?=+==?+=+=?==?==?++=?=+=?=?=?++=+=?==".toCharArray();
    map[31] = "=??+?=?=?=+??==?=?==?=?=???=?=+?=??=?=?=?=?=?++=++=+??+?=+?=?=?+".toCharArray();
}
```

## Author
[Qulle](https://github.com/qulle/)