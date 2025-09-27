# Kiwee User Guide

Kiwee is a **command-line task management application** that helps you organize your tasks efficiently.

- [Quick Start](#quick-start)
- [Features](#features)
  - [Adding Todo Tasks](#adding-todo-tasks)
  - [Adding Deadline Tasks](#adding-deadline-tasks)
  - [Adding Event Tasks](#adding-event-tasks)
  - [Listing All Tasks](#listing-all-tasks)
  - [Marking Tasks as Done](#marking-tasks-as-done)
  - [Unmarking Tasks](#unmarking-tasks)
  - [Deleting Tasks](#deleting-tasks)
  - [Finding Tasks](#finding-tasks)
  - [Exiting the Application](#exiting-the-application)
- [Data Storage](#data-storage)
- [Command Summary](#command-summary)

---
## Quick Start
1. Ensure you have Java 17 or above installed in your computer
2. Download the latest `.jar` from [here](https://github.com/fookang/ip/releases)
3. Open your terminal/command prompt
4. Navigate to the folder containing `ip.jar`
5. Run the command: `java -jar ip.jar`
6. You'll see Kiwee's welcome message and can start using commands!

```
    ____________________________________________________________
     _  __ ___ __        __ _____  _____
    | |/ /|_ _|\ \      / /| ____|| ____|
    | ' /  | |  \ \ /\ / / |  _|  |  _|
    | . \  | |   \ V  V /  | |___ | |___
    |_|\_\|___|   \_/\_/   |_____| |_____|
    
    Kiwee reporting for duty  
    How can I help you?
    ____________________________________________________________
```
---
## Features

### Adding Todo Tasks

Add simple tasks without any time constraints.

**Format:** `todo <description>`

**Example:**
```
todo Read a book
```

**Expected output:**
```
    ____________________________________________________________
    Another one? Fine... I've added this task:
    Added: [T][ ] Read a book
    Your list now has 1 tasks. Good luck surviving that.
    ____________________________________________________________
```

### Adding Deadline Tasks

Add tasks with a specific due date.

**Format:** `deadline <description> /by <date>`

**Supported date formats:**
- `yyyy-MM-dd` (e.g., 2025-12-25)
- `yyyy-MM-dd HH:mm` (e.g., 2025-12-25 14:30)
- `d/M/yyyy` (e.g., 25/12/2025)
- `HH:mm` (today's date, using computer's local timezone)

**Example:**
```
  deadline Submit CS2113 project /by 2025-10-03 23:59
```

**Expected output:**
```
    ____________________________________________________________
    Another one? Fine... I've added this task:
    Added: [D][ ] Submit CS2113 project (by: Oct 03 2025, 11:59pm)
    Your list now has 2 tasks. Good luck surviving that.
    ____________________________________________________________
```

### Adding Event Tasks

Add tasks that occur during a specific time period.

**Format:** `event <description> /from <start_time> /to <end_time>`

**Example:**
```
event Team meeting /from 2025-10-03 14:00 /to 2025-10-03 15:00
```

**Expected output:**
```
    ____________________________________________________________
    Another one? Fine... I've added this task:
    Added: [E][ ] Team meeting (from: Oct 03 2025, 2:00pm to: Oct 03 2025, 3:00pm)
    Your list now has 3 tasks. Good luck surviving that.
    ____________________________________________________________
```

### Listing All Tasks

View all your tasks at once.

**Format:** `list`

**Example:**
```
list
```

**Expected output:**
```
    ____________________________________________________________
    1.[T][ ] Read a book
    2.[D][ ] Submit CS2113 project (by: Oct 03 2025, 11:59pm)
    3.[E][ ] Team meeting (from: Oct 03 2025, 2:00pm to: Oct 03 2025, 3:00pm)
    ____________________________________________________________
```

### Marking Tasks as Done

Mark a task as completed.

**Format:** `mark <task_number>`

**Example:**
```
mark 1
```

**Expected output:**
```
    ____________________________________________________________
    Congrats, you finally achieved something!
    [T][X] Read a book
    ____________________________________________________________
```

### Unmarking Tasks

Mark a completed task as not done.

**Format:** `unmark <task_number>`

**Example:**
```
unmark 1
```

**Expected output:**
```
    ____________________________________________________________
    How did you manage to do reverse work??
    [T][ ] Read a book
    ____________________________________________________________
```

### Deleting Tasks

Remove a task from your list permanently.

**Format:** `delete <task_number>`

**Example:**
```
delete 2
```

**Expected output:**
```
    ____________________________________________________________
    Deleted. Because pretending it never existed totally helps productivity.
    [D][ ] Submit CS2113 project (by: Oct 03 2025, 11:59pm)
    You have 2 tasks in your list
    ____________________________________________________________
```

### Finding Tasks

Search for tasks containing specific keywords.

**Format:** `find <keyword>`

**Example:**
```
find meeting
```

**Expected output:**
```
    ____________________________________________________________
    Here you go!
    1.[E][ ] Team meeting (from: Oct 03 2025, 2:00pm to: Oct 03 2025, 3:00pm)
    ____________________________________________________________
```

### Exiting the Application

Save your tasks and exit Kiwee.

**Format:** `bye`

**Example:**
```
bye
```

**Expected output:**
```
    ____________________________________________________________
    Bye! Kiwee hopes you're leaving to actually finish your
    tasks, not procrastinate harder.
    ____________________________________________________________
```

## Data Storage

- Your tasks are automatically saved to `./data/Kiwee.txt`
- The file is created automatically when you first run the application
- Tasks are loaded when you start Kiwee and saved when you exit
- If the data file is corrupted, Kiwee will skip invalid entries and continue loading valid tasks

---

## Command Summary
| Action       | Command                                       |
|--------------|-----------------------------------------------|
| Add Todo     | `todo <description>`                          |
| Add Deadline | `deadline <description> /by <date/time>`      |
| Add Event    | `event <description> /from <start> /to <end>` |
| List         | `list`                                        |
| Mark         | `mark <ID>`                                   |
| Unmark       | `unmark <ID>`                                 |
| Delete       | `delete <ID>`                                 |
| Find         | `find <keyword>`                              |
| Exit         | `bye`                                         |