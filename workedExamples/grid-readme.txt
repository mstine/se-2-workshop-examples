1) Open two terminal windows, and in both change to the directory in which you place the selenium server jar.

2) In the first window, start the hub:

java -jar selenium-server-standalone-2.13.0.jar -role hub

3) In the second window, start a node:

java -jar selenium-server-standalone-2.13.0.jar -role node  -hub http://localhost:4444/grid/register

4) Open a terminal window, and change to your project codebase.

To run in serial mode:

gradle seGridSerial

To run in parallel mode:

gradle seGridParallel