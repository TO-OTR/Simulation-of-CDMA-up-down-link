# Simulation-of-CDMA-up-down-link
The objective is to simulate the CDMA downlink data sent by a single antenna to a set of user devices within one cell. Simulation should include the OVSF code allocation, the spreading procedure, the interference phenomena and finally the reception and un-spreading procedures.

USER.java
class of user, contains baisc data like ovsf code, information signal, methodes of channelization and unchannelization.

Main.java
class main, methodes of calculating the sum of information signal, instructions of how to use the program.


1. Choose the number of users, 1 or 2 or 4.
2. Enter the length of up link information signal.
3. Automaticly define the ovsf code and do the channelization.
4. Show the result of up link combination signal.

5. Enter the length of down link combination signal.
6. Automaticly do the unchannelization.
7. Show the result of information signaleach received by each user. 


P.S.
For now only support user-number no more than 4. 
Still working on automaticly calculating the Walsh function. 
