## Exception Handling

Arbeiten Sie die Kapitel zum Exception-Handling unter Java in der
Semesterliteratur durch.

<!-- XXX
[docs.oracle.com](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
-->

1)  Erklären Sie die Bedeutung und die Funktionsweise des `finally`-Blockes bei
    der Exception-Behandlung mit `try` und `catch`.

    Was bedeutet "try-with-resources", wie wird es angewendet?

    <!-- XXX
    > The finally block *always* executes when the try block exits.
    > This ensures that the finally block is executed even if an unexpected
    > exception occurs. But finally is useful for more than just exception
    > handling -- it allows the programmer to avoid having cleanup code
    > accidentally bypassed by a return, continue, or break. Putting cleanup
    > code in a finally block is always a good practice, even when no exceptions
    > are anticipated.
    >
    > -- [docs.oracle.com](https://docs.oracle.com/javase/tutorial/essential/exceptions/finally.html)
    -->

    <!-- XXX
    ab Java8 `try-with-resources` (Ressourcen müssen `AutoCloseable` implementieren, sonst `finally` nötig)
    https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

    statt
    ```java
    static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if (br != null) br.close();
        }
    }
    ```

    kann man nun direkt schreiben:
    ```java
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
    ```
    -->

2)  Worin liegt der Unterschied zwischen "Checked Exceptions" und
    "Unchecked Exceptions"? Geben Sie passende Beispiele an.

    <!-- XXX
    > The Three Kinds of Exceptions
    >
    > The first kind of exception is the **checked exception**. These are
    > exceptional conditions that a well-written application should anticipate
    > and recover from.
    > For example, suppose an application prompts a user for an input file name,
    > then opens the file by passing the name to the constructor for
    > `java.io.FileReader`. Normally, the user provides the name of an existing,
    > readable file, so the construction of the FileReader object succeeds, and
    > the execution of the application proceeds normally. But sometimes the user
    > supplies the name of a nonexistent file, and the constructor throws
    > `java.io.FileNotFoundException`. A well-written program will catch this
    > exception and notify the user of the mistake, possibly prompting for a
    > corrected file name.
    >
    > Checked exceptions are subject to the Catch or Specify Requirement. All
    > exceptions are checked exceptions, except for those indicated by Error,
    > RuntimeException, and their subclasses.
    >
    > The second kind of exception is the **error**. These are exceptional
    > conditions that are external to the application, and that the application
    > usually cannot anticipate or recover from. For example, suppose that an
    > application successfully opens a file for input, but is unable to read the
    > file because of a hardware or system malfunction. The unsuccessful read
    > will throw `java.io.IOError`. An application might choose to catch this
    > exception, in order to notify the user of the problem -- but it also might
    > make sense for the program to print a stack trace and exit.
    >
    >   Errors are not subject to the Catch or Specify Requirement. Errors are
    > those exceptions indicated by Error and its subclasses.
    >
    > The third kind of exception is the **runtime exception**. These are
    > exceptional conditions that are internal to the application, and that the
    > application usually cannot anticipate or recover from. These usually
    > indicate programming bugs, such as logic errors or improper use of an API.
    > For example, consider the application described previously that passes a
    > file name to the constructor for FileReader. If a logic error causes a
    > null to be passed to the constructor, the constructor will throw
    > NullPointerException. The application can catch this exception, but it
    > probably makes more sense to eliminate the bug that caused the exception
    > to occur.
    >
    > Runtime exceptions are not subject to the Catch or Specify Requirement.
    > Runtime exceptions are those indicated by RuntimeException and its subclasses.
    >
    > Errors and runtime exceptions are collectively known as unchecked exceptions.
    >
    > -- [docs.oracle.com](https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html)
    -->

    <!-- XXX
    *   Unchecked exceptions:

        represent defects in the program (bugs) - often invalid arguments passed
        to a non-private method. To quote from The Java Programming Language,
        by Gosling, Arnold, and Holmes: "Unchecked runtime exceptions represent
        conditions that, generally speaking, reflect errors in your program's
        logic and cannot be reasonably recovered from at run time."

        are subclasses of RuntimeException, and are usually implemented using
        IllegalArgumentException, NullPointerException, or IllegalStateException

        a method is not obliged to establish a policy for the unchecked exceptions
        thrown by its implementation (and they almost always do not do so)

    *   Checked exceptions:

        represent invalid conditions in areas outside the immediate control of
        the program (invalid user input, database problems, network outages,
        absent files)

        are subclasses of Exception

        a method is obliged to establish a policy for all checked exceptions
        thrown by its implementation (either pass the checked exception further
        up the stack, or handle it somehow)

    It's somewhat confusing, but note as well that RuntimeException (unchecked)
    is itself a subclass of Exception (checked).
    -->

    <!-- XXX
    > Unchecked Exceptions — The Controversy
    >
    > Because the Java programming language does not require methods to catch or
    > to specify unchecked exceptions (RuntimeException, Error, and their
    > subclasses), programmers may be tempted to write code that throws only
    > unchecked exceptions or to make all their exception subclasses inherit
    > from RuntimeException. Both of these shortcuts allow programmers to write
    > code without bothering with compiler errors and without bothering to
    > specify or to catch any exceptions. Although this may seem convenient to
    > the programmer, it sidesteps the intent of the catch or specify requirement
    > and can cause problems for others using your classes.
    >
    > Why did the designers decide to force a method to specify all uncaught
    > checked exceptions that can be thrown within its scope? Any Exception that
    > can be thrown by a method is part of the method's public programming interface.
    > Those who call a method must know about the exceptions that a method can
    > throw so that they can decide what to do about them. These exceptions are
    > as much a part of that method's programming interface as its parameters
    > and return value.
    >
    > The next question might be: "If it's so good to document a method's API,
    > including the exceptions it can throw, why not specify runtime exceptions
    > too?" Runtime exceptions represent problems that are the result of a
    > programming problem, and as such, the API client code cannot reasonably be
    > expected to recover from them or to handle them in any way. Such problems
    > include arithmetic exceptions, such as dividing by zero; pointer exceptions,
    > such as trying to access an object through a null reference; and indexing
    > exceptions, such as attempting to access an array element through an index
    > that is too large or too small.
    >
    > Runtime exceptions can occur anywhere in a program, and in a typical one
    > they can be very numerous. Having to add runtime exceptions in every method
    > declaration would reduce a program's clarity. Thus, the compiler does not
    > require that you catch or specify runtime exceptions (although you can).
    >
    > One case where it is common practice to throw a RuntimeException is when
    > the user calls a method incorrectly. For example, a method can check if
    > one of its arguments is incorrectly null. If an argument is null, the
    > method might throw a NullPointerException, which is an unchecked exception.
    >
    > Generally speaking, do not throw a RuntimeException or create a subclass
    > of RuntimeException simply because you don't want to be bothered with
    > specifying the exceptions your methods can throw.
    >
    > Here's the bottom line guideline: If a client can reasonably be expected
    > to recover from an exception, make it a checked exception. If a client
    > cannot do anything to recover from the exception, make it an unchecked
    >   exception.
    >
    > [docs.oracle.com](https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html)
    -->

3)  Erklären Sie den Umgang mit Exceptions: Wann sollte man Exceptions fangen
    und bearbeiten und wann sollte man Exceptions propagieren?

[Selbstständige Literaturrecherche, Umgang mit Exceptions in Java]{.thema}
