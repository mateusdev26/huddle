# Huddle Chat API

A Spring Boot-based RESTful API for a simple chat application that enables messaging between users.

## Features

- **User Management**: Create, retrieve, and delete users
- **Message System**: Send, retrieve, edit, and delete messages
- **Conversation Management**: Retrieve messages between specific users
- **Read Status Tracking**: Mark messages as read/unread and filter by status
- **RESTful API**: Clean and consistent endpoint structure

## Technology Stack

- **Java 21+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL 17.5**
- **Lombok** - for reducing boilerplate code
- **Maven** - for dependency management

## Quick Start

### Prerequisites
- Java 17 or higher
- Git 2.34.1 or higher

 ***or***
 
- Docker 21.5.1

### Installation with Java and Git

1. Clone the repository:
```bash
git clone https://github.com/mateusdev26/huddle
cd huddle
```
3. Run the application:
```bash
java -jar target/*.jar
```
### Installation with Docker

1. Pull the docker image:
```bash
docker pull mateusdev26/huddle:latest
```
3. Run the application:
```bash
docker run -p 8080:8080 mateudev26/huddle
```

# Huddle Chat API - Usage Guide

## Base URL
All endpoints are relative to: `http://localhost:8080/`

## User Management Endpoints

| Method | Endpoint | Description | Parameters | Request Body |
|--------|----------|-------------|------------|--------------|
| **POST** | `/huddle/users` | Create a new user | None | `{"username": "string", "password": "string", "email": "string"}` |
| **GET** | `/huddle/users` | Get all users | None | None |
| **GET** | `/huddle/users/{id}` | Get user by ID | `id` (path) | None |
| **GET** | `/huddle/users/find/{name}` | Get user by username | `name` (path) | None |
| **DELETE** | `/huddle/users/{id}` | Delete user by ID | `id` (path) | None |

## Message Management Endpoints

| Method | Endpoint | Description | Parameters | Request Body |
|--------|----------|-------------|------------|--------------|
| **POST** | `/huddle/messages/send` | Send a new message | None | `{"content": "string", "sender_id": long, "recipient_id": long}` |
| **GET** | `/huddle/messages` | Get all messages | None | None |
| **GET** | `/huddle/messages/{id}` | Get message by ID | `id` (path) | None |
| **DELETE** | `/huddle/messages/{id}` | Delete message by ID | `id` (path) | None |
| **GET** | `/huddle/messages/getMessagesBetweenTwoUsers` | Get messages between users | `sender_id`, `recipient_id` (query) | None |
| **GET** | `/huddle/messages/getNotRead` | Get all unread messages | None | None |
| **GET** | `/huddle/messages/getRead` | Get all read messages | None | None |
| **GET** | `/huddle/messages/getNotReadBetweenTwoUsers` | Get unread messages between users | `sender_id`, `recipient_id` (query) | None |
| **GET** | `/huddle/messages/getReadBetweenTwoUsers` | Get read messages between users | `sender_id`, `recipient_id` (query) | None |
| **PATCH** | `/huddle/messages/{id}/markAsRead` | Mark message as read | `id` (path) | None |
| **PATCH** | `/huddle/messages/{id}` | Update message | `id` (path) | `{"id": long, "content": "string", "sender_id": long, "recipient_id": long, "sending_time": "datetime", "is_read": boolean}` |
| **PUT** | `/huddle/messages/edit` | Edit message content | `id`, `newContent` (query) | None |


## Authors

- [@mateusdev26](https://www.github.com/mateusdev26)

##
[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)
