# CS 320: Software Test, Automation, and Quality Assurance

This repository contains selected work from my CS 320 course at Southern New Hampshire University. The Contact Service files from Project One demonstrate my ability to develop Java classes and create JUnit tests based on software requirements. The Project Two summary and reflections report explains my testing approach, the techniques I used, and the importance of quality in software development.

## How can I ensure that my code, program, or software is functional and secure?

I can ensure that my software is functional by reviewing the requirements and creating tests for every expected behavior. In the Contact Service project, I tested valid information, null values, excessive lengths, duplicate IDs, updates, and deletion operations. I also used boundary testing to verify values at their exact limits and immediately beyond them. Passing tests and high code coverage provide evidence that the program works, but they should be combined with code reviews and additional security testing. To make software more secure, I should validate all inputs, handle errors properly, limit access to sensitive information, keep dependencies updated, and test how the program responds to invalid or unexpected data.

## How do I interpret user needs and incorporate them into a program?

I interpret user needs by turning each requirement into a specific behavior that the software must perform. I first identify the required fields, restrictions, operations, and expected responses to invalid input. I then use those details to design the program and its tests. For example, the Contact Service requirements stated that IDs must be unique and no longer than 10 characters, phone numbers must contain exactly 10 digits, and contacts must support specific updates. I incorporated those needs into the validation rules and created JUnit tests to prove that each requirement was followed. This process helps prevent assumptions and keeps the program focused on what the user actually requested.

## How do I approach designing software?

I approach software design by breaking a larger problem into smaller classes, responsibilities, and testable behaviors. I begin by reviewing the requirements and identifying the data the program must store and the operations it must perform. I then design classes with focused responsibilities, use clear method and variable names, and add validation where data enters the program. I also consider how different parts of the software interact because a change in one class can affect another class or service. Testing is part of my design process instead of something I wait to complete at the end. Writing focused tests while developing the software helps me find errors early, reduce technical debt, and create code that is easier to understand and maintain.

