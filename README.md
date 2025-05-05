# 💻 Java Socket Programming Examples

This project demonstrates a series of progressively enhanced **Java client-server socket programming** examples. Each version introduces a new concept or feature, making it ideal for learning how network communication works in Java using **TCP/IP sockets**.

---

## 🗂️ Project Structure

The project is organized into multiple folders, each representing a different version or concept:

- `version1_basic`
- `version2_multiple_message_from_client`
- `version3_user_defined_messages_from_client`
- `version4_send_messages_from_server`
- `version5_multiple_clients`
- `version6_threading`

---

## ✅ Version Descriptions

### 🔹 `version1_basic`

> A simple client connects to a server and sends a single message (`"Hello Server"`). The server receives and prints the message.

- **Client.java**: Connects to the server and sends a static message.
- **Server.java**: Listens for a connection, accepts it, and prints the message from the client.

---

### 🔹 `version2_multiple_message_from_client`

> The client sends multiple predefined messages to the server. Communication ends when the client sends `"stop"`.

- **Client.java**: Sends multiple hardcoded messages using `DataOutputStream`.
- **Server.java**: Continuously reads messages using a loop until `"stop"` is received.

---

### 🔹 `version3_user_defined_messages_from_client`

> User can input custom messages from the console which are then sent to the server. The session ends when the user types `"stop"`.

- **Client.java**: Uses `Scanner` to read user input and send messages to the server.
- **Server.java**: Listens and prints incoming messages until `"stop"` is received.

---

### 🔹 `version4_send_messages_from_server`

> Adds two-way communication where both client and server can send messages. After receiving each client message, the server replies with a user-defined response.

- **Client.java**: Sends user-defined messages and prints responses from the server.
- **Server.java**: Prints received messages from the client and allows the server user to reply via console input.

---

### 🔹 `version5_multiple_clients`

> Multiple clients can sequentially connect to the server. After each message from a client, the server sends two responses: a fixed message and a user-defined one.

- **Client.java / Client2.java**: Clients can send and receive messages to/from the server.
- **Server.java**: Handles up to 5 clients one after another. For each, the server interacts until `"stop"` is received.

---

### 🔹 `version6_threading`

> Supports handling multiple clients **simultaneously** using threads. Each client is managed by a separate thread.

- **Client.java / Client2.java**: Sends user-defined messages and prints responses from the server.
- **Server.java**: Accepts multiple connections and spawns a thread (`ServerClientThread`) for each client.
- **ServerClientThread.java**: Handles two-way communication in parallel with each client.

---

## ⚙️ Requirements

- ✅ Java Development Kit (**JDK 8** or above)
- ✅ A terminal or an IDE like **IntelliJ IDEA**, **Eclipse**, or **VS Code**

---

## 🚀 How to Run

### 🧩 Compile:
```bash
javac versionX_folder/*.java
```
```bash
### Run the Server:
java versionX_folder.Server
```
```bash
### Run the Client(s):
java versionX_folder.Client
```
# or for version5 and version6:
```bash
java versionX_folder.Client2
```
Replace versionX_folder with the specific version folder, e.g., version4_send_messages_from_server.
