# Flight-Track-System
My Term project for OOP class, creating a flight booking/tracking system.

This program should simulate the flights between the major capitals, such as New York, Sydney, Paris, Tokyo, Istanbul etc. around the world. 


The user would also add new capitals as well as new destinations to the system. In addition to that, the user could delete and update existing destinations via the GUI. Besides, the user should declare the flight details, such as the weekdays, the departure and arrival times, the aircraft model, the flight number and the name of the airlines. All the information should be saved into the related files. 

System have a system date, and one second in system would represent one minute in the real life. You would be able to start, pause, resume and stop the time of your system. The scheduled flights would be simulated regarding to the system time.

Each capital would have a control tower to manage take offs and landings. For example, the tower manager would set some delay for a scheduled flight or she/he could cancel certain flights or even make the aircrafts, which are close to the related tower, wait in the air


The main activities are given as follows:

•	Add/Delete capitals.
•	Add/Delete/Update destinations and flight information.
•	Set some delay for a specific flight or cancel a certain flight in a given airport.
•	Make the flights, which are close enough to a given airport, wait and then give them permission for landing.
•	Report the information (scheduled arrival/departure time, take off and landing time, delay, date, flight number, the name of the airlines, the departure and the arrival city), for each taking off and landing into a file.
•	Start, pause, resume and stop the system time.

Once the program starts, the user would add new destinations. Then, the user would set and start the system time. Each flight would occur as a thread. The system would create a thread for each scheduled flight. After the completion of the landing, the system should kill the related thread. 

