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
> Thanks (ENNASRI Mouad)
