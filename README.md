# Interview Coding Challenge
Coding challenge for a technology company I applied for in the past. 

Compile: javac *.java

Project Challenge

Java Coding Exercise
Prerequisites
Java 1.8 +
Eclipse or Maven project
The Problem
A number of robots are deployed by an oil company to a desert plateau for surveying the ground. This plateau, which is curiously rectangular, must be navigated by the robots so that their on-board cameras get a complete view of the surrounding terrain to send back to headquarters.
A robot’s location is represented by a combination of x and y co-ordinates and a bearing indicated by a letter ‘N’orth, ‘S’outh, ’E’ast or ‘W’est. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the robot is in the bottom left corner and facing North.
In order to control a robot, the oil company sends a simple string of letters. The possible letters are:  'L', 'R' and 'M'. 
'L' and 'R' makes the robot spin 90 degrees left or right respectively, without moving from its current spot. 
'M' means move forward one grid point, and maintain the same bearing.
Assume that the square directly North from (x, y) is (x, y+1).
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0. 
Each robot has two lines of input.
1.	The first line gives the robot's co-ordinates and bearing. 
2.	The second line is a series of instructions telling the robot how to explore the plateau.
The location is made up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the robot’s bearing.
The output for each robot should be its final co-ordinates and bearing.
Example Input Commands:
1	2	N
LMLMLMLM M


3	3	E
MMRMMRMRRM

Tasks
1)	Create a Java project to solve the problem.
2)	Read incoming commands from the command line
3)	Run your program with the following inputs:
10	20	N
LM LM LM LM M

 	13	23	E
MMRMMRMRRM

4)	Output to console the final position after the move operations have completed

5)	Provide unit tests

6)	If the project is built in Eclipse without Maven, then please ensure that any required Java dependency JARs are packaged up in the project.  

7)	Upload project to a GitHub  /BitBucket repo so that the project can be downloaded.
