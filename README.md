# SimpleRMIChat

Simple chat application using Remote Method Call

**====== Features**

 1. Public Messages
 2. Direct Messages
 3. No special libraries

**====== Compilation**

 Java compilation:

 ```
	 javac chatrmi/*java chatrmi/server/*java chatrmi/client/*java
 ```
 Stub and Skeleton:

 ```
	 rmic chatrmi.server.ServerImp chatrmi.client.ClientImp
 ```
 RMI registry:

 ```
	 Linux:rmiregistry&
	 Windows:start rmiregistry
 ```

**====== Execution**

```
 Server:
	java java chatrmi.server.Server
 Clients:
	java chatrmi.client.Client CLIENT_NAME
```
**====== Usage**

```
 \help? for usage
 \ID@NAME retrieve the IS of the client with the name NAME
 \PRIVATE@ID send a direct message to client with ID
 \ONLINE@ list all online clients
```
**====== Sample**

![alt compilation and Stub Skeleton](https://raw.githubusercontent.com/DullBK201/SimpleRMIChat/master/images/compilationSS.png)

![alt Starting server](https://raw.githubusercontent.com/DullBK201/SimpleRMIChat/master/images/server.png)

![alt Starting client](https://raw.githubusercontent.com/DullBK201/SimpleRMIChat/master/images/client.png)

![alt Exchange messages](https://raw.githubusercontent.com/DullBK201/SimpleRMIChat/master/images/clientExc.png)

![alt List online clients](https://raw.githubusercontent.com/DullBK201/SimpleRMIChat/master/images/listOnline.png)

![alt Direct messages](https://raw.githubusercontent.com/DullBK201/SimpleRMIChat/master/images/dm.png)

![alt Recieved DM](https://raw.githubusercontent.com/DullBK201/SimpleRMIChat/master/images/dmr.png)

> Thanks (ENNASRI Mouad)
